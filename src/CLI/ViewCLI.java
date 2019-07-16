package CLI;

import DAO.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Main;
import model.EntregasSemanaView;

public class ViewCLI {
    Scanner scan;
    ViewDAO entregasSemanaViewDAO;
    
    public ViewCLI(){
        scan = new Scanner(System.in);
        entregasSemanaViewDAO = new ViewDAO();
    }
    
    public void menuView(){
        System.out.println("=============================== Views ==============================");
        System.out.println(" 1 - Carros a serem entregues nos próximos 7 dias");
        System.out.println(" 2 - Carros a serem entregues nos próximos 30 dias");
        System.out.println(" 3 - Voltar");
        System.out.println("====================================================================");
        
        scan = new Scanner(System.in);
        int input = scan.nextInt();
        switch(input){
            case 1:
                entregasSemana7();
                break;
            case 2:
                entregasSemana30();
                break;
            case 3:
                Main.menuPrincipal();
                break;
            default:
                System.out.println("Entrada Inválida.");
                menuView();
                break;
        }
    }
    
    public void entregasSemana7(){
        System.out.println("===================== Entregas dos próx. 7 dias ====================");
        try {
            ArrayList<EntregasSemanaView> aEntregasSemanaView = entregasSemanaViewDAO.consultar7();
            for(EntregasSemanaView entregas : aEntregasSemanaView){
                System.out.println("Placa do carro: " + entregas.getPlaca_carro());
                System.out.println("Data de atendimento: " + entregas.getData_atendimento());
                System.out.println("Data estimada de entrega: " + entregas.getData_entrega());
                System.out.println("Tempo total estimado de serviços : " + entregas.getTempo_est_total());
                System.out.println();
            }
            System.out.println("=====================================================================");
        } catch (SQLException ex) {
            Logger.getLogger(ViewCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
        menuView();
    }
    
    public void entregasSemana30(){
        System.out.println("===================== Entregas dos próx. 30 dias ====================");
        try {
            ArrayList<EntregasSemanaView> aEntregasSemanaView = entregasSemanaViewDAO.consultar30();
            for(EntregasSemanaView entregas : aEntregasSemanaView){
                System.out.println("Placa do carro: " + entregas.getPlaca_carro());
                System.out.println("Data de atendimento: " + entregas.getData_atendimento());
                System.out.println("Data estimada de entrega: " + entregas.getData_entrega());
                System.out.println("Tempo total estimado de serviços : " + entregas.getTempo_est_total());
                System.out.println();
            }
            System.out.println("=====================================================================");
        } catch (SQLException ex) {
            Logger.getLogger(ViewCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
        menuView();
    }
}
