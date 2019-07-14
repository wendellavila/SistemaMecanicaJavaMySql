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
        
        System.out.println("========================= Sistema Mecânica =========================");
        System.out.println();
        System.out.println(" 1 - Adicionar/Alterar Cliente");
        System.out.println(" 2 - Adicionar/Alterar Funcionario");
        System.out.println(" 3 - Sair");
        System.out.println("====================================================================");
        
        
        int input = scan.nextInt();
        switch(input){
            case 1:
                clienteCLI.menuCliente();
                break;
            case 2:
                
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Entrada Inválida.");
                menuPrincipal();
                break;
        }
    }
}
