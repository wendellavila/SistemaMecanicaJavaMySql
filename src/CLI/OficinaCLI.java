package CLI;

import DAO.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Main;
import model.Oficina;

public class OficinaCLI {
    
    Scanner scan;
    OficinaDAO oficinaDAO;
    
    public OficinaCLI(){
        scan = new Scanner(System.in);
        oficinaDAO = new OficinaDAO();
    }
    
    public void menuOficina(){
        System.out.println("=============================== Oficina ============================");
        System.out.println(" 1 - Adicionar Filial");
        System.out.println(" 2 - Buscar Oficina");
        System.out.println(" 3 - Voltar");
        System.out.println("====================================================================");
        
        scan = new Scanner(System.in);
        int input = scan.nextInt();
        switch(input){
            case 1:
                adicionarOficina();
                break;
            case 2:
                buscarOficina();
                break;
            case 3:
                Main.menuPrincipal();
                break;
            default:
                System.out.println("Entrada Inválida.");
                menuOficina();
                break;
        }
    }
    public void adicionarOficina(){
        scan = new Scanner(System.in);
        int id_oficina;
        String rua_oficina, bairro_oficina, num_casa_oficina, cidade_oficina, estado_oficina;
        
        System.out.println("========================= Adicionar Oficina ========================");

        System.out.print("rua_oficina: ");
        rua_oficina = scan.nextLine();
        System.out.print("bairro_oficina: ");
        bairro_oficina = scan.nextLine();
        System.out.print("num_casa_oficina: ");
        num_casa_oficina = scan.nextLine();
        System.out.print("cidade_oficina: ");
        cidade_oficina = scan.nextLine();
        System.out.print("estado_oficina: ");
        estado_oficina = scan.nextLine();
        
        Oficina oficina = new Oficina(-1, rua_oficina, bairro_oficina, num_casa_oficina, cidade_oficina, estado_oficina);
        try {
            oficinaDAO.inserir(oficina);
            exibirDadosOficina(oficinaDAO.consultarCidade(oficina.getCidade_oficina()));
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCLI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Dados Inválidos.");
            adicionarOficina();
        }
    }
    public void buscarOficina(){
        System.out.println("=========================== Buscar Oficina =========================");
        System.out.println(" 1 - Buscar Oficina por cidade");
        System.out.println(" 2 - Buscar Oficina por id");
        System.out.println(" 3 - Voltar");
        System.out.println("====================================================================");
        
        int input = scan.nextInt();
        switch(input){
            case 1:
                buscarOficinaCidade();
                break;
            case 2:
                buscarOficinaId();
                break;
            case 3:
                menuOficina();
                break;
            default:
                System.out.println("Entrada Inválida.");
                buscarOficina();
                break;
        }
    }
    
    public void buscarOficinaCidade(){
        scan = new Scanner(System.in);
        String cidade = "";
        Oficina oficina = null;
        System.out.println("=================== Buscar Oficina por cidade ==================");
        while(cidade.equals("")){
            System.out.print("nome: ");
            cidade = scan.nextLine();
        }

        try {
            oficina = oficinaDAO.consultarCidade(cidade);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCLI.class.getName()).log(Level.SEVERE, null, ex);
            buscarOficinaCidade();
        }

        if(oficina == null){
            System.out.println("Oficina não encontrado.");
            buscarOficina();
        }
        else {
            exibirDadosOficina(oficina);
        }
    }
    
    public void buscarOficinaId(){
        scan = new Scanner(System.in);
        int id;
        Oficina oficina = null;
        System.out.println("====================== Buscar Oficina por id =====================");
        System.out.print("id: ");
        id = scan.nextInt();
        try {
            oficina = oficinaDAO.consultarId(id);
        } catch (SQLException ex) {
            buscarOficinaId();
        }

        if(oficina == null){
            System.out.println("Funcionario não encontrado.");
            buscarOficina();
        }
        else {
            exibirDadosOficina(oficina);
        }
    }
    
    public void exibirDadosOficina(Oficina oficina){
        System.out.println("======================== Dados da Oficina =========================");
        System.out.println("id_oficina: " + oficina.getId_oficina());
        System.out.println("rua_oficina: "  + oficina.getRua_oficina());
        System.out.println("bairro_oficina: " + oficina.getBairro_oficina());
        System.out.println("num_casa_oficina: " + oficina.getNum_casa_oficina());
        System.out.println("cidade_oficina: " + oficina.getCidade_oficina());
        System.out.println("estado_oficina: " + oficina.getEstado_oficina());
        
        alterarOficina(oficina);
    }
    
    public void alterarOficina(Oficina oficina){
        scan = new Scanner(System.in);
        System.out.println("====================== Alterar Oficina =============================");
        System.out.println(" 1 - Editar Dados");
        System.out.println(" 2 - Excluir");
        System.out.println(" 3 - Voltar");
        System.out.println("====================================================================");
        int input = scan.nextInt();
        switch(input){
            case 1:
                editarOficina(oficina);
                break;
            case 2:
                excluirOficina(oficina);
                break;
            case 3:
                menuOficina();
                break;
            default:
                System.out.println("Entrada Inválida.");
                alterarOficina(oficina);
                break;
        }
    }
    
    public void editarOficina(Oficina oficina){
        scan = new Scanner(System.in);
        int id_oficina;
        String rua_oficina, bairro_oficina, num_casa_oficina, cidade_oficina, estado_oficina;

        System.out.println("====================== Editar dados da Oficina =====================");
        System.out.println("Digite -1 se não deseja alterar o campo atual");
        System.out.print("rua_oficina: ");
        rua_oficina = scan.nextLine();
        if(!rua_oficina.equals("-")){
            oficina.setRua_oficina(rua_oficina);
        }
        System.out.print("bairro_oficina: ");
        bairro_oficina = scan.nextLine();
        if(!bairro_oficina.equals("-")){
            oficina.setBairro_oficina(bairro_oficina);
        }

        System.out.print("num_casa_oficina: ");
        num_casa_oficina = scan.nextLine();
        if(!num_casa_oficina.equals("-")){
            oficina.setNum_casa_oficina(num_casa_oficina);
        }

        System.out.print("cidade_oficina: ");
        cidade_oficina = scan.nextLine();
        if(!cidade_oficina.equals("-")){
            oficina.setCidade_oficina(cidade_oficina);
        }

        System.out.print("estado_oficina: ");
        estado_oficina = scan.nextLine();
        if(!estado_oficina.equals("-")){
            oficina.setEstado_oficina(estado_oficina);
        }

        try {
            oficinaDAO.alterarDados(oficina);
            System.out.println("Dados atualizados com sucesso.");
            alterarOficina(oficina);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluirOficina(Oficina oficina){
        try {
            oficinaDAO.excluir(oficina);
        } catch (SQLException ex) {
            Logger.getLogger(OficinaCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
