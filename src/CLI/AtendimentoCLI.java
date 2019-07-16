package CLI;

import main.*;
import DAO.*;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtendimentoCLI {
    Scanner scan;
    ServicoDAO servicoDAO;
    AtendimentoDAO atendimentoDAO;
    AtendimentoServicoDAO atendimentoServicoDAO;
    ViewDAO viewDAO;
    ProcedureDAO procedureDAO;
    
    public AtendimentoCLI(){
        servicoDAO = new ServicoDAO();
        atendimentoDAO = new AtendimentoDAO();
        atendimentoServicoDAO = new AtendimentoServicoDAO();
        viewDAO = new ViewDAO();
        procedureDAO = new ProcedureDAO();
    }
    
    public void menuAtendimento(){
        System.out.println("============================ Atendimento ===========================");
        System.out.println(" 1 - Adicionar Atendimento");
        System.out.println(" 2 - Buscar Atendimento");
        System.out.println(" 3 - Voltar");
        System.out.println("====================================================================");
        
        scan = new Scanner(System.in);
        int input = scan.nextInt();
        switch(input){
            case 1:
                adicionarAtendimento();
                break;
            case 2:
                buscarAtendimento();
                break;
            case 3:
                Main.menuPrincipal();
                break;
            default:
                System.out.println("Entrada Inválida.");
                menuAtendimento();
                break;
        }
    }
    
    public void adicionarAtendimento(){
        scan = new Scanner(System.in);
        String horario_atendimento, descricao_atendimento, placa_carro, data_atendimento = "";
        int id_atendimento, id_oficina;
        
        System.out.println("========================= Adicionar Atendimento ========================");

        System.out.print("horario_atendimento: ");
        horario_atendimento = scan.nextLine();
        System.out.print("data_atendimento: ");
        while(!data_atendimento.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d")){
            data_atendimento = scan.nextLine();
        }
        
        System.out.print("descricao_atendimento: ");
        descricao_atendimento = scan.nextLine();
        System.out.print("id_oficina: ");
        id_oficina = scan.nextInt();
        System.out.print("placa_carro: ");
        placa_carro = scan.nextLine();

        try {
            Atendimento atendimento = new Atendimento(-1, horario_atendimento, data_atendimento, descricao_atendimento, id_oficina, placa_carro);
            atendimentoDAO.inserir(atendimento);
            System.out.println("Atendimento adicionado com sucesso.");
            exibirDadosAtendimento(atendimentoDAO.consultarPlaca(atendimento.getPlaca_carro()));
        } catch (SQLException ex) {
            System.out.println("Dados Inválidos.");
            adicionarAtendimento();
        }
    }
    
    public void buscarAtendimento(){
        System.out.println("========================= Buscar Atendimento =======================");
        System.out.println(" 1 - Buscar Atendimento por placa");
        System.out.println(" 2 - Buscar Atendimento por id");
        System.out.println(" 3 - Voltar");
        System.out.println("====================================================================");
        
        int input = scan.nextInt();
        switch(input){
            case 1:
                buscarAtendimentoPlaca();
                break;
            case 2:
                buscarAtendimentoId();
                break;
            case 3:
                menuAtendimento();
                break;
            default:
                System.out.println("Entrada Inválida.");
                buscarAtendimento();
                break;
        }
    }
    
    public void buscarAtendimentoPlaca(){
        scan = new Scanner(System.in);
        String placa;
        Atendimento atendimento = null;
        System.out.println("================== Buscar Atendimento por placa =================");
        System.out.print("placa: ");
        placa = scan.nextLine();
        try {
            atendimento = atendimentoDAO.consultarPlaca(placa);
        } catch (SQLException ex) {
            buscarAtendimentoPlaca();
        }

        if(atendimento == null){
            System.out.println("Atendimento não encontrado.");
            buscarAtendimento();
        }
        else {
            exibirDadosAtendimento(atendimento);
        }
    }
    
    public void buscarAtendimentoId(){
        scan = new Scanner(System.in);
        int id;
        Atendimento atendimento = null;
        System.out.println("==================== Buscar Atendimento por id ===================");
        System.out.print("id: ");
        id = scan.nextInt();
        try {
            atendimento = atendimentoDAO.consultarId(id);
        } catch (SQLException ex) {
            buscarAtendimentoId();
        }

        if(atendimento == null){
            System.out.println("Atendimento não encontrado.");
            buscarAtendimento();
        }
        else {
            exibirDadosAtendimento(atendimento);
        }
    }
    
    public void exibirDadosAtendimento(Atendimento atendimento){
        System.out.println("===================== Dados do Atendimento ======================");
        System.out.println("id_atendimento: " + atendimento.getId_atendimento());
        System.out.println("horario_atendimento: " + atendimento.getHorario_atendimento());
        System.out.println("data_atendimento: " + atendimento.getData_atendimento());
        System.out.println("descricao_atendimento: " + atendimento.getDescricao_atendimento());
        System.out.println("id_oficina: " + atendimento.getId_oficina());
        System.out.println("placa_carro: " + atendimento.getPlaca_carro());
        
        try {
            PrecoTotalPecasView preco_pecas = viewDAO.consultarPrecoPecas(atendimento.getId_atendimento());
            Float preco_total = procedureDAO.precoTotal(atendimento.getId_atendimento());
            if(preco_pecas != null){
                System.out.println("preço total em peças: R$" + preco_pecas.getPreco_total_pecas());
            }
            System.out.println("preço total do atendimento: R$" + preco_total);
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println("===================== Servicos relacionados ======================");
        try {
            ArrayList<AtendimentoServico> aAtendimentoServico =
            atendimentoServicoDAO.consultarIdAtendimento(atendimento.getId_atendimento());
            for(AtendimentoServico atendimentoServico : aAtendimentoServico){
                Servico servico = servicoDAO.consultarId(atendimentoServico.getId_servico());
                System.out.println("===================== Servico ======================");
                System.out.println("id_servico: " + servico.getId_servico());
                System.out.println("horario_atendimento: " + servico.getPreco_servico());
                System.out.println("data_atendimento: " + servico.getTempo_est_dias());
                System.out.println("descricao_atendimento: " + servico.getDescricao_servico());
                System.out.println("id_oficina: " + servico.getId_oficina());
                System.out.println("placa_carro: " + servico.getPlaca_carro());
                System.out.println("====================================================");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        alterarAtendimento(atendimento);
    }
    
    public void alterarAtendimento(Atendimento atendimento){
        scan = new Scanner(System.in);
        System.out.println("====================== Alterar Atendimento =========================");
        System.out.println(" 1 - Editar Dados");
        System.out.println(" 2 - Excluir");
        System.out.println(" 3 - Adicionar Servico");
        System.out.println(" 4 - Alterar Servico");
        System.out.println(" 5 - Dar desconto de 20%");
        System.out.println(" 6 - Voltar");
        System.out.println("====================================================================");
        int input = scan.nextInt();
        switch(input){
            case 1:
                editarAtendimento(atendimento);
                break;
            case 2:
                excluirAtendimento(atendimento);
                break;
            case 3:
                adicionarServico(atendimento);
                break;
            case 4:
                alterarServico(atendimento);
                break;
            case 5:
                darDesconto(atendimento);
                break;
            case 6:
                menuAtendimento();
                break;
            default:
                System.out.println("Entrada Inválida.");
                alterarAtendimento(atendimento);
                break;
        }
    }
    
    public void darDesconto(Atendimento atendimento){
        try {
            procedureDAO.darDesconto(atendimento.getId_atendimento());
            System.out.println("Desconto concedido com sucesso.");
            alterarAtendimento(atendimento);
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alterarServico(Atendimento atendimento){
        scan = new Scanner(System.in);
        String descricao_servico, placa_carro;
        int id_servico, id_oficina, tempo_est_dias;
        Float preco_servico;
        
        System.out.println("============================ Alterar Servico ==========================");
        System.out.print("id_servico: ");
        id_servico = scan.nextInt();
        try {
            Servico servico = servicoDAO.consultarId(id_servico);
            System.out.println("Digite -1 se não deseja alterar o campo atual");
            
            System.out.print("horario_atendimento: ");
            preco_servico = scan.nextFloat();
            if(preco_servico != -1){
                servico.setPreco_servico(preco_servico);
            }
            System.out.print("tempo_est_dias: ");
            tempo_est_dias = scan.nextInt();
            if(tempo_est_dias != -1){
                servico.setTempo_est_dias(tempo_est_dias);
            }

            System.out.print("descricao_atendimento: ");
            descricao_servico = scan.nextLine();
            if(!descricao_servico.equals("-1")){
                servico.setDescricao_servico(descricao_servico);
            }

            System.out.print("id_oficina: ");
            id_oficina = scan.nextInt();
            if(id_oficina != -1){
                servico.setId_oficina(id_oficina);
            }

            servicoDAO.alterarDados(servico);
            System.out.println("Dados atualizados com sucesso.");
            exibirDadosAtendimento(atendimento);
            
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void adicionarServico(Atendimento atendimento){
        scan = new Scanner(System.in);
        String descricao_servico, placa_carro;
        int id_servico, id_oficina, tempo_est_dias;
        Float preco_servico;
        
        System.out.println("========================= Adicionar Atendimento ========================");

        System.out.print("preco_servico: ");
        preco_servico = scan.nextFloat();
        System.out.print("tempo_est_dias: ");
        tempo_est_dias = scan.nextInt();
        System.out.print("descricao_servico: ");
        descricao_servico = scan.nextLine();
        System.out.print("id_oficina: ");
        id_oficina = scan.nextInt();
        System.out.print("placa_carro: ");
        placa_carro = scan.nextLine();

        try {
            Servico servico = new Servico(-1, preco_servico, tempo_est_dias, descricao_servico, id_oficina, placa_carro);
            servicoDAO.inserir(servico);
            id_servico = servicoDAO.consultarDescricao(descricao_servico).getId_servico();
            atendimentoServicoDAO.inserir(atendimento.getId_atendimento(), id_servico);
            System.out.println("Atendimento adicionado com sucesso.");
            exibirDadosAtendimento(atendimentoDAO.consultarPlaca(atendimento.getPlaca_carro()));
        } catch (SQLException ex) {
            System.out.println("Dados Inválidos.");
            adicionarAtendimento();
        }
    }
    
    public void editarAtendimento(Atendimento atendimento){
        scan = new Scanner(System.in);
        String horario_atendimento, descricao_atendimento, placa_carro, data_atendimento = "";
        int id_atendimento, id_oficina;

        System.out.println("==================== Editar dados do atendimento ===================");
        System.out.println("Digite -1 se não deseja alterar o campo atual");
        System.out.print("horario_atendimento: ");
        horario_atendimento = scan.nextLine();
        if(!horario_atendimento.equals("-1")){
            atendimento.setHorario_atendimento(horario_atendimento);
        }
        while(!data_atendimento.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d") && !data_atendimento.equals("-1")){
            System.out.print("data_atendimento: ");
            data_atendimento = scan.nextLine();
        }
        
        if(!data_atendimento.equals("-1")){
            atendimento.setData_atendimento(data_atendimento);
        }
        scan = new Scanner(System.in);
        System.out.print("descricao_atendimento: ");
        descricao_atendimento = scan.nextLine();
        if(!descricao_atendimento.equals("-1")){
            atendimento.setDescricao_atendimento(descricao_atendimento);
        }

        System.out.print("id_oficina: ");
        id_oficina = scan.nextInt();
        if(id_oficina != -1){
            atendimento.setId_oficina(id_oficina);
        }

        try {
            atendimentoDAO.alterarDados(atendimento);
            System.out.println("Dados atualizados com sucesso.");
            alterarAtendimento(atendimento);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluirAtendimento(Atendimento atendimento){
        try {
            atendimentoDAO.excluir(atendimento);
        } catch (SQLException ex) {
            Logger.getLogger(OficinaCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
