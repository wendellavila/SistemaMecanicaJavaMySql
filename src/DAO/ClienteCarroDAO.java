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

public class ClienteCarroDAO {
    
    public void inserir(String cpf, String placa) throws SQLException{
       Connection con = BDFabricacaoConexao.getConnection(1); 

       String sql = "INSERT INTO cliente_carros (cpf_cliente, placa_carro) VALUES(?,?)";     
       PreparedStatement pstmt = con.prepareStatement(sql);     

       pstmt.setString(1,cpf);
       pstmt.setString(2,placa);

       pstmt.execute();
       pstmt.close();    
    }
    
    public ArrayList<ClienteCarros> consultar(String cpf) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM cliente_carros WHERE cpf_cliente=" + cpf + " order by cpf_cliente";      
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        ArrayList<ClienteCarros> aClienteCarros = new ArrayList<ClienteCarros>();
        while (rset.next()) {
            ClienteCarros clienteCarros = new ClienteCarros();
            clienteCarros.setCpf(rset.getString("cpf_cliente"));
            clienteCarros.setPlaca(rset.getString("placa_carro"));
            aClienteCarros.add(clienteCarros);
        }   
        return aClienteCarros; 
    }
}
