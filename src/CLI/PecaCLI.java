package CLI;

import DAO.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Main;
import model.Peca;

public class PecaCLI {
    Scanner scan;
    PecaDAO pecaDAO;
    
    public PecaCLI(){
        scan = new Scanner(System.in);
        pecaDAO = new PecaDAO();
    }
    
    public void menuPeca(){
        System.out.println("================================ Peca ==============================");
        System.out.println(" 1 - Adicionar Peca");
        System.out.println(" 2 - Buscar Peca");
        System.out.println(" 3 - Voltar");
        System.out.println("====================================================================");
        
        scan = new Scanner(System.in);
        int input = scan.nextInt();
        switch(input){
            case 1:
                adicionarPeca();
                break;
            case 2:
                buscarPeca();
                break;
            case 3:
                Main.menuPrincipal();
                break;
            default:
                System.out.println("Entrada Inválida.");
                menuPeca();
                break;
        }
        
        
    }
    public void adicionarPeca(){
        scan = new Scanner(System.in);
        String nome_peca;
        Float preco_peca;
        
        System.out.println("========================== Adicionar Peca =========================");

        System.out.print("nome: ");
        nome_peca = scan.nextLine();
        System.out.print("preco_peca: ");
        preco_peca = scan.nextFloat();
        Peca peca = new Peca(-1, nome_peca, preco_peca);
        try {
            pecaDAO.inserir(peca);
            exibirDadosPeca(pecaDAO.consultarNome(peca.getNome_peca()));
        } catch (SQLException ex) {
            System.out.println("Dados Inválidos.");
            adicionarPeca();
        }
    }
    public void buscarPeca(){
        scan = new Scanner(System.in);
        int id;
        Peca peca = null;
        System.out.println("======================= Buscar Peca por Id ======================");
        id = scan.nextInt();
        try {
            peca = pecaDAO.consultarId(id);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCLI.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(peca == null){
            System.out.println("Funcionario não encontrado.");
            buscarPeca();
        }
        else {
            exibirDadosPeca(peca);
        }
    }
    public void exibirDadosPeca(Peca peca){
        System.out.println("========================= Dados da Peca =========================");
        System.out.println("id_peca: " + peca.getId_peca());
        System.out.println("nome_peca: "  + peca.getNome_peca());
        System.out.println("preco_peca: R$" + peca.getId_peca());
        
        alterarPrecoPeca(peca);
    }
    
    public void editarPeca(Peca peca){
        scan = new Scanner(System.in);
        System.out.println("======================== Alterar Peça ==============================");
        System.out.println(" 1 - Editar preço");
        System.out.println(" 2 - Excluir");
        System.out.println(" 3 - Voltar");
        System.out.println("====================================================================");
        int input = scan.nextInt();
        switch(input){
            case 1:
                alterarPrecoPeca(peca);
                break;
            case 2:
                excluirPeca(peca);
                break;
            case 3:
                menuPeca();
                break;
            default:
                System.out.println("Entrada Inválida.");
                editarPeca(peca);
                break;
        }
    }
    
    public void excluirPeca(Peca peca){
        try {
            pecaDAO.excluir(peca);
        } catch (SQLException ex) {
            Logger.getLogger(OficinaCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alterarPrecoPeca(Peca peca){
        scan = new Scanner(System.in);
        int id_peca;
        String nome_peca;
        Float preco_peca;
        
        System.out.println("===================== Editar preço da peça ========================");
        System.out.print("preço: ");
        preco_peca = scan.nextFloat();
        peca.setPreco_peca(preco_peca);
        
        try {
            pecaDAO.alterarDados(peca);
            System.out.println("Dados atualizados com sucesso.");
            editarPeca(peca);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
