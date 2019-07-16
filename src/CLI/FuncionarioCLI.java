package CLI;

import DAO.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Main;
import model.Funcionario;

public class FuncionarioCLI {
    Scanner scan;
    FuncionarioDAO funcionarioDAO;
    
    public FuncionarioCLI(){
        scan = new Scanner(System.in);
        funcionarioDAO = new FuncionarioDAO();
    }
    
    public void menuFuncionario(){
        System.out.println("============================ Funcionario ===========================");
        System.out.println(" 1 - Adicionar Funcionario");
        System.out.println(" 2 - Buscar Funcionario");
        System.out.println(" 3 - Voltar");
        System.out.println("====================================================================");
        
        scan = new Scanner(System.in);
        int input = scan.nextInt();
        switch(input){
            case 1:
                adicionarFuncionario();
                break;
            case 2:
                buscarFuncionario();
                break;
            case 3:
                Main.menuPrincipal();
                break;
            default:
                System.out.println("Entrada Inválida.");
                menuFuncionario();
                break;
        }
    }
    
    public void adicionarFuncionario(){
        scan = new Scanner(System.in);
        String cpf_funcionario, nome_funcionario;
        int id_oficina;
        cpf_funcionario = "";
        System.out.println("====================== Adicionar Funcionario ======================");
        System.out.print("cpf: ");
        while(!cpf_funcionario.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")){
            cpf_funcionario = scan.nextLine();
        }
        System.out.print("nome: ");
        nome_funcionario = scan.nextLine();
        System.out.print("id_oficina: ");
        id_oficina = scan.nextInt();
        Funcionario funcionario = new Funcionario(cpf_funcionario, nome_funcionario, id_oficina);
        try {
            funcionarioDAO.inserir(funcionario);
            exibirDadosFuncionario(funcionario);
        } catch (SQLException ex) {
            System.out.println("Dados Inválidos.");
            adicionarFuncionario();
        }
    }
    
    public void buscarFuncionario(){
        System.out.println("============================ Funcionario ===========================");
        System.out.println("========================= Buscar Funcionario =======================");
        System.out.println(" 1 - Buscar funcionario por nome");
        System.out.println(" 2 - Buscar funcionario por cpf");
        System.out.println(" 3 - Voltar");
        System.out.println("====================================================================");
        
        int input = scan.nextInt();
        switch(input){
            case 1:
                buscarFuncionarioNome();
                break;
            case 2:
                buscarFuncionarioCPF();
                break;
            case 3:
                menuFuncionario();
                break;
            default:
                System.out.println("Entrada Inválida.");
                buscarFuncionario();
                break;
        }
    }
        
    public void buscarFuncionarioNome(){
        scan = new Scanner(System.in);
        String nome = "";
        Funcionario funcionario = null;
        System.out.println("=================== Buscar Funcionario por nome ==================");
        while(nome.equals("")){
            System.out.print("nome: ");
            nome = scan.nextLine();
        }

        try {
            funcionario = funcionarioDAO.consultarNome(nome);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCLI.class.getName()).log(Level.SEVERE, null, ex);
            //buscarFuncionarioNome();
        }

        if(funcionario == null){
            System.out.println("Funcionario não encontrado.");
            buscarFuncionario();
        }
        else {
            exibirDadosFuncionario(funcionario);
        }
    }
    
    public void buscarFuncionarioCPF(){
        scan = new Scanner(System.in);
        String cpf = "";
        Funcionario funcionario = null;
        System.out.println("=================== Buscar Funcionario por cpf ===================");
        while(!cpf.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")){
            System.out.print("cpf: ");
            cpf = scan.nextLine();
        }
        try {
            funcionario = funcionarioDAO.consultarCpf(cpf);
        } catch (SQLException ex) {
            buscarFuncionarioCPF();
        }

        if(funcionario == null){
            System.out.println("Funcionario não encontrado.");
            buscarFuncionario();
        }
        else {
            exibirDadosFuncionario(funcionario);
        }
    }
    
    public void exibirDadosFuncionario(Funcionario funcionario){
        System.out.println("====================== Dados do Funcionario ======================");
        System.out.println("cpf: " + funcionario.getCpf_funcionario());
        System.out.println("nome: "  + funcionario.getNome_funcionario());
        System.out.println("id_oficina: " + funcionario.getId_oficina());
        
        alterarFuncionario(funcionario);
    }
    
    public void alterarFuncionario(Funcionario funcionario){
        scan = new Scanner(System.in);
        System.out.println("==================== Alterar Funcionario ===========================");
        System.out.println(" 1 - Editar dados");
        System.out.println(" 2 - Excluir");
        System.out.println(" 3 - Voltar");
        System.out.println("====================================================================");
        int input = scan.nextInt();
        switch(input){
            case 1:
                editarDadosFuncionario(funcionario);
                break;
            case 2:
                excluirFuncionario(funcionario);
                break;
            case 3:
                menuFuncionario();
                break;
            default:
                System.out.println("Entrada Inválida.");
                alterarFuncionario(funcionario);
                break;
        }
    }
    
    public void excluirFuncionario(Funcionario funcionario){
        try {
            funcionarioDAO.excluir(funcionario);
        } catch (SQLException ex) {
            Logger.getLogger(OficinaCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarDadosFuncionario(Funcionario funcionario){
        scan = new Scanner(System.in);
        String cpf_funcionario, nome_funcionario;
        int id_oficina;
        
        System.out.println("==================== Editar dados do Funcionario ===================");
        System.out.println("Digite -1 se não deseja alterar o campo atual");
        System.out.print("nome: ");
        nome_funcionario = scan.nextLine();
        if(!nome_funcionario.equals("-1")){
            funcionario.setNome_funcionario(nome_funcionario);
        }
        System.out.print("id_oficina: ");
        id_oficina = scan.nextInt();
        if(id_oficina != -1){
            funcionario.setId_oficina(id_oficina);
        }
        
        try {
            funcionarioDAO.alterarDados(funcionario);
            System.out.println("Dados atualizados com sucesso.");
            alterarFuncionario(funcionario);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
