package DAO;

import conexao.BDFabricacaoConexao;
import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {
    
    private String cpf, nome, rua, bairro, num_casa, cidade, estado;
 
    public void inserir(Cliente cliente) throws SQLException{
       Connection con = BDFabricacaoConexao.getConnection(1); 

       cpf = cliente.getCpf();
       nome = cliente.getNome();
       rua = cliente.getRua();
       bairro = cliente.getBairro();
       num_casa = cliente.getNum_casa();
       cidade = cliente.getCidade();
       estado = cliente.getEstado();

       String sql = "INSERT INTO cliente (cpf_cliente, nome_cliente, rua_cliente, "+
       "bairro_cliente, num_casa_cliente, cidade_cliente, estado_cliente) VALUES(?,?,?,?,?,?,?)";     
       PreparedStatement pstmt = con.prepareStatement(sql);     

       pstmt.setString(1,cpf);
       pstmt.setString(2,nome);
       pstmt.setString(3,rua);
       pstmt.setString(4,bairro);
       pstmt.setString(5,num_casa);
       pstmt.setString(6,cidade);
       pstmt.setString(7,estado);

       pstmt.execute();
       pstmt.close();    
    }

    public ArrayList<Cliente> consultar() throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM cliente order by nome_cliente";         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        ArrayList<Cliente> aCliente = new ArrayList<Cliente>();
        while (rset.next()) {
            Cliente cliente = new Cliente();
            cliente.setCpf(rset.getString("cpf_cliente"));
            cliente.setNome(rset.getString("nome_cliente"));
            cliente.setRua(rset.getString("rua_cliente"));
            cliente.setBairro(rset.getString("bairro_cliente"));
            cliente.setNum_casa(rset.getString("num_casa_cliente"));
            cliente.setCidade(rset.getString("cidade_cliente"));
            cliente.setEstado(rset.getString("estado_cliente"));
            aCliente.add(cliente);
        }   
        return aCliente; 
    }

    public Cliente consultarCpf(String cpf) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM cliente WHERE cpf_cliente=" + cpf + " order by nome_cliente";         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        Cliente cliente = null;
        if(rset.next()){
            cliente = new Cliente();
            cliente.setCpf(rset.getString("cpf_cliente"));
            cliente.setNome(rset.getString("nome_cliente"));
            cliente.setRua(rset.getString("rua_cliente"));
            cliente.setBairro(rset.getString("bairro_cliente"));
            cliente.setNum_casa(rset.getString("num_casa_cliente"));
            cliente.setCidade(rset.getString("cidade_cliente"));
            cliente.setEstado(rset.getString("estado_cliente"));
        }   
        return cliente; 
    }

    public Cliente consultarNome(String nome) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM cliente WHERE nome_cliente='" + nome + "' order by nome_cliente";         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        Cliente cliente = null;
        if(rset.next()){
            cliente = new Cliente();
            cliente.setCpf(rset.getString("cpf_cliente"));
            cliente.setNome(rset.getString("nome_cliente"));
            cliente.setRua(rset.getString("rua_cliente"));
            cliente.setBairro(rset.getString("bairro_cliente"));
            cliente.setNum_casa(rset.getString("num_casa_cliente"));
            cliente.setCidade(rset.getString("cidade_cliente"));
            cliente.setEstado(rset.getString("estado_cliente"));
        }   
        return cliente; 
    }

    public void alterarDados(Cliente cliente) throws SQLException {
        Connection con = BDFabricacaoConexao.getConnection(1);

        rua = cliente.getRua();
        bairro = cliente.getBairro();
        num_casa = cliente.getNum_casa();
        cidade = cliente.getCidade();
        estado = cliente.getEstado();

        String sql = "UPDATE cliente SET rua_cliente = '"+ rua +"', bairro_cliente = '"+ bairro +
                "', num_casa_cliente = "+ num_casa +", cidade_cliente = '"+ cidade +"', estado_cliente = '"+ estado +
                "' WHERE cpf_cliente = "+ cliente.getCpf();

        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
    }
    
    public void excluir(Cliente cliente) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "DELETE FROM cliente WHERE cpf_cliente=" + cliente.getCpf();
        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
    }
}
