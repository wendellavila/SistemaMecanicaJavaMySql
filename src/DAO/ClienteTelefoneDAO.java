package DAO;

import conexao.BDFabricacaoConexao;
import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.*;

public class ClienteTelefoneDAO {
    
    public void inserir(String cpf, String telefone) throws SQLException{
       Connection con = BDFabricacaoConexao.getConnection(1); 

       String sql = "INSERT INTO cliente_telefone (cpf_cliente, telefone) VALUES(?,?)";     
       PreparedStatement pstmt = con.prepareStatement(sql);     

       pstmt.setString(1,cpf);
       pstmt.setString(2,telefone);

       pstmt.execute();
       pstmt.close();    
    }
    
    public void remover(String cpf, String telefone) throws SQLException{
       Connection con = BDFabricacaoConexao.getConnection(1); 

       String sql = "DELETE FROM cliente_telefone WHERE cpf_cliente=" + cpf + " AND telefone=" + telefone;   
       PreparedStatement pstmt = con.prepareStatement(sql);
       pstmt.execute();
       pstmt.close();    
    }
    
    public ArrayList<ClienteTelefone> consultar(String cpf) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM cliente_telefone WHERE cpf_cliente=" + cpf + " order by cpf_cliente";         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        ArrayList<ClienteTelefone> aClienteTelefone = new ArrayList<ClienteTelefone>();
        while (rset.next()) {
            ClienteTelefone clienteTelefone = new ClienteTelefone();
            clienteTelefone.setCpf(rset.getString("cpf_cliente"));
            clienteTelefone.setTelefone(rset.getString("telefone"));
            aClienteTelefone.add(clienteTelefone);
        }   
        return aClienteTelefone; 
    }
    
    public ClienteTelefone consultar(String cpf, String telefone) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM cliente_telefone WHERE cpf_cliente=" + cpf + " AND telefone=" + telefone;         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        ClienteTelefone clienteTelefone = null;
        if(rset.next()){
            clienteTelefone = new ClienteTelefone();
            clienteTelefone.setCpf(rset.getString("cpf_cliente"));
            clienteTelefone.setTelefone(rset.getString("telefone"));
        }   
        return clienteTelefone; 
    }
}
