package DAO;

import conexao.BDFabricacaoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.*;

public class CarroDAO {
    private String chassi, ano, placa, modelo, marca;
    
    public void inserir(Carro carro) throws SQLException{
       Connection con = BDFabricacaoConexao.getConnection(1); 

       chassi = carro.getChassi();
       ano = carro.getAno();
       placa = carro.getPlaca();
       modelo = carro.getModelo();
       marca = carro.getMarca();

       String sql = "INSERT INTO carro (chassi, ano, placa, modelo, marca) VALUES(?,?,?,?,?)";     
       PreparedStatement pstmt = con.prepareStatement(sql);

       pstmt.setString(1,chassi);
       pstmt.setString(2,ano);
       pstmt.setString(3,placa);
       pstmt.setString(4,modelo);
       pstmt.setString(5,marca);

       pstmt.execute();
       pstmt.close();    
    }
    
    public ArrayList<Carro> consultar() throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM carro order by nome_cliente";        
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        ArrayList<Carro> aCarro = new ArrayList<Carro>();
        while (rset.next()) {
            Carro carro = new Carro();
            carro.setChassi(rset.getString("chassi"));
            carro.setAno(rset.getString("ano"));
            carro.setPlaca(rset.getString("placa"));
            carro.setModelo(rset.getString("modelo"));
            carro.setMarca(rset.getString("marca"));
            aCarro.add(carro);
        }   
        return aCarro; 
    }
    
    public Carro consultarPlaca(String placa) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM carro WHERE placa='" + placa + "'";         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        Carro carro = null;
        if(rset.next()) {
            carro = new Carro();
            carro.setChassi(rset.getString("chassi"));
            carro.setAno(rset.getString("ano"));
            carro.setPlaca(rset.getString("placa"));
            carro.setModelo(rset.getString("modelo"));
            carro.setMarca(rset.getString("marca"));
        }   
        return carro; 
    }
}
