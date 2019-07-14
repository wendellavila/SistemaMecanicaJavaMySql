package CLI;

import main.*;
import DAO.*;
import main.*;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteCLI {
    Scanner scan;
    ClienteDAO clienteDAO;
    CarroDAO carroDAO;
    ClienteTelefoneDAO clienteTelefoneDAO;
    ClienteCarroDAO clienteCarroDAO;
    
    public ClienteCLI(){
        clienteDAO = new ClienteDAO();
        carroDAO = new CarroDAO();
        clienteTelefoneDAO = new ClienteTelefoneDAO();
        clienteCarroDAO = new ClienteCarroDAO();
    }
    public void menuCliente(){
        System.out.println("============================== Cliente =============================");
        System.out.println(" 1 - Adicionar Cliente");
        System.out.println(" 2 - Buscar Cliente");
        System.out.println(" 3 - Voltar");
        System.out.println("====================================================================");
        
        scan = new Scanner(System.in);
        int input = scan.nextInt();
        switch(input){
            case 1:
                adicionarCliente();
                break;
            case 2:
                buscarCliente();
                break;
            case 3:
                Main.menuPrincipal();
                break;
            default:
                System.out.println("Entrada Inválida.");
                menuCliente();
                break;
        }
    }
    
    public void adicionarCliente(){
        scan = new Scanner(System.in);
        String cpf, nome, rua, bairro, num_casa, cidade, estado;
        cpf = "";
        System.out.println("========================= Adicionar Cliente ========================");
        System.out.print("cpf: ");
        while(!cpf.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")){
            cpf = scan.nextLine();
        }
        System.out.print("nome: ");
        nome = scan.nextLine();
        System.out.print("rua: ");
        rua = scan.nextLine();
        System.out.print("bairro: ");
        bairro = scan.nextLine();
        System.out.print("num_casa: ");
        num_casa = scan.nextLine();
        System.out.print("cidade: ");
        cidade = scan.nextLine();
        System.out.print("estado: ");
        estado = scan.nextLine();

        try {
            clienteDAO.inserir(new Cliente(cpf, nome, rua, bairro, num_casa, cidade, estado));
        } catch (SQLException ex) {
            System.out.println("Dados Inválidos.");
            this.adicionarCliente();
        }
    }
    
    public void buscarCliente(){
        System.out.println("============================== Cliente =============================");
        System.out.println("=========================== Buscar Cliente =========================");
        System.out.println(" 1 - Buscar cliente por nome");
        System.out.println(" 2 - Buscar cliente por cpf");
        System.out.println(" 3 - Voltar");
        System.out.println("====================================================================");
        
        int input = scan.nextInt();
        switch(input){
            case 1:
                buscarClienteNome();
                break;
            case 2:
                buscarClienteCPF();
                break;
            case 3:
                this.menuCliente();
                break;
            default:
                System.out.println("Entrada Inválida.");
                this.menuCliente();
                break;
        }
    }
    
    public void buscarClienteNome(){
        scan = new Scanner(System.in);
        String nome = "";
        Cliente cliente = null;
        System.out.println("===================== Buscar cliente por nome ====================");
        while(nome.equals("")){
            System.out.print("nome: ");
            nome = scan.nextLine();
        }

        try {
            cliente = clienteDAO.consultarNome(nome);
        } catch (SQLException ex) {
            buscarClienteNome();
        }
        
        if(cliente == null){
            System.out.println("Cliente não encontrado.");
            buscarCliente();
        }
        else {
            exibirDadosCliente(cliente);
        }
    }
    
    public void buscarClienteCPF(){
        scan = new Scanner(System.in);
        String cpf = "";
        Cliente cliente = null;
        System.out.println("===================== Buscar cliente por cpf =====================");
        while(!cpf.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")){
            System.out.print("cpf: ");
            cpf = scan.nextLine();
        }
        try {
            cliente = clienteDAO.consultarCpf(cpf);
        } catch (SQLException ex) {
            buscarClienteCPF();
        }
        
        if(cliente == null){
            System.out.println("Cliente não encontrado.");
            buscarCliente();
        }
        else {
            exibirDadosCliente(cliente);
        }
    }
    
    public void exibirDadosCliente(Cliente cliente){
        System.out.println("======================== Dados do cliente ========================");
        System.out.println("cpf: " + cliente.getCpf());
        System.out.println("nome: "  + cliente.getNome());
        System.out.println("rua: " + cliente.getRua());
        System.out.println("bairro: " + cliente.getBairro());
        System.out.println("num_casa: " + cliente.getNum_casa());
        System.out.println("cidade: " + cliente.getCidade());
        System.out.println("estado: " + cliente.getEstado());
        
        try {
            ArrayList<ClienteTelefone> telefones = clienteTelefoneDAO.consultar(cliente.getCpf());
            ArrayList<ClienteCarros> listaCarros = clienteCarroDAO.consultar(cliente.getCpf());
            System.out.println("Telefones:");
            for(ClienteTelefone telefone : telefones){
                System.out.println(telefone.getTelefone());
            }
            System.out.println("Carros:");
            for(ClienteCarros itemCarro : listaCarros){
                Carro carro = carroDAO.consultarPlaca(itemCarro.getPlaca());
                System.out.println(carro.getMarca() + " " + carro.getModelo() + " " + carro.getAno() +
                        " Placa:" + carro.getPlaca() + " Chassi:" + carro.getChassi());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
        alterarCliente(cliente);
    }
    
    public void alterarCliente(Cliente cliente){
        scan = new Scanner(System.in);
        System.out.println("====================== Alterar Cliente =============================");
        System.out.println(" 1 - Editar dados");
        System.out.println(" 2 - Adicionar carro");
        System.out.println(" 3 - Voltar");
        System.out.println("====================================================================");
        int input = scan.nextInt();
        switch(input){
            case 1:
                editarDadosCliente(cliente);
                break;
            case 2:
                adicionarCarro(cliente);
                break;
            case 3:
                menuCliente();
                break;
            default:
                System.out.println("Entrada Inválida.");
                alterarCliente(cliente);
                break;
        }
    }
    
    public void adicionarCarro(Cliente cliente){
        
        scan = new Scanner(System.in);
        String chassi, ano, placa, modelo, marca;
        System.out.print("chassi: ");
        chassi = scan.nextLine();
        System.out.print("ano: ");
        ano = scan.nextLine();
        System.out.print("placa: ");
        placa = scan.nextLine();
        System.out.print("modelo: ");
        modelo = scan.nextLine();
        System.out.print("marca: ");
        marca = scan.nextLine();
        
        try {
            Carro carro = new Carro(chassi, ano, placa, modelo, marca);
            carroDAO.inserir(carro);
            clienteCarroDAO.inserir(cliente.getCpf(), placa);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarDadosCliente(Cliente cliente){
        scan = new Scanner(System.in);
        String cpf, nome, rua, bairro, num_casa, cidade, estado;
        System.out.println("====================== Editar dados do Cliente =====================");
        System.out.println("Digite - (hífen) se não deseja alterar o campo atual");
        System.out.print("nome: ");
        nome = scan.nextLine();
        if(!nome.equals("-")){
            cliente.setNome(nome);
        }
        System.out.print("rua: ");
        rua = scan.nextLine();
        if(!rua.equals("-")){
            cliente.setRua(rua);
        }
        System.out.print("bairro: ");
        bairro = scan.nextLine();
        if(!bairro.equals("-")){
            cliente.setBairro(bairro);
        }
        System.out.print("num_casa: ");
        num_casa = scan.nextLine();
        if(!num_casa.equals("-")){
            cliente.setNum_casa(num_casa);
        }
        System.out.print("cidade: ");
        cidade = scan.nextLine();
        if(!cidade.equals("-")){
            cliente.setCidade(cidade);
        }
        System.out.print("estado: ");
        estado = scan.nextLine();
        if(!estado.equals("-")){
            cliente.setEstado(estado);
        }
        
        try {
            clienteDAO.alterarDados(cliente);
            System.out.println("Dados atualizados com sucesso.");
            alterarCliente(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
