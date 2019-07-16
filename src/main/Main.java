package main;

import CLI.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        menuPrincipal();
    }
    
    public static void menuPrincipal(){
        Scanner scan = new Scanner(System.in);
        ClienteCLI clienteCLI = new ClienteCLI();
        FuncionarioCLI funcionarioCLI = new FuncionarioCLI();
        PecaCLI pecaCLI = new PecaCLI();
        OficinaCLI oficinaCLI = new OficinaCLI();
        AtendimentoCLI atendimentoCLI = new AtendimentoCLI();
        ViewCLI viewCLI = new ViewCLI();
        
        System.out.println("========================= Sistema Mecânica =========================");
        System.out.println();
        System.out.println(" 1 - Adicionar/Alterar Cliente");
        System.out.println(" 2 - Adicionar/Alterar Funcionario");
        System.out.println(" 3 - Adicionar/Alterar Oficina");
        System.out.println(" 4 - Adicionar/Alterar Peça");
        System.out.println(" 5 - Adicionar/Alterar Atendimento ou Serviço");
        System.out.println(" 6 - Visualizar prazos de entrega");
        System.out.println(" 7 - Sair");
        System.out.println("====================================================================");
        
        
        int input = scan.nextInt();
        switch(input){
            case 1:
                clienteCLI.menuCliente();
                break;
            case 2:
                funcionarioCLI.menuFuncionario();
                break;
            case 3:
                oficinaCLI.menuOficina();
                break;
            case 4:
                pecaCLI.menuPeca();
                break;
            case 5:
                atendimentoCLI.menuAtendimento();
                break;
            case 6:
                viewCLI.menuView();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Entrada Inválida.");
                menuPrincipal();
                break;
        }
    }
}
