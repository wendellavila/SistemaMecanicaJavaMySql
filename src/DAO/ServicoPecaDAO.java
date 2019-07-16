package DAO;
import conexao.BDFabricacaoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ServicoPeca;

public class ServicoPecaDAO {
    public void inserir(int id_servico, int id_peca, int quantidade) throws SQLException{
       Connection con = BDFabricacaoConexao.getConnection(1); 

       String sql = "INSERT INTO servico_peca (id_servico, id_peca, quantidade) VALUES(?,?,?)";     
       PreparedStatement pstmt = con.prepareStatement(sql);     

       pstmt.setInt(1,id_servico);
       pstmt.setInt(2,id_peca);
       pstmt.setInt(3,quantidade);

       pstmt.execute();
       pstmt.close();    
    }
    
    public ArrayList<ServicoPeca> consultarIdServico(int id_servico) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM servico_peca WHERE id_servico=" + id_servico;      
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        ArrayList<ServicoPeca> aServicoPeca = new ArrayList<ServicoPeca>();
        while (rset.next()) {
            ServicoPeca servicoPeca = new ServicoPeca();
            servicoPeca.setId_servico(rset.getInt("id_servico"));
            servicoPeca.setId_peca(rset.getInt("id_peca"));
            servicoPeca.setQuantidade(rset.getInt("quantidade"));
            aServicoPeca.add(servicoPeca);
        }   
        return aServicoPeca; 
    }
    
    public ArrayList<ServicoPeca> consultarIdPeca(int id_peca) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM servico_peca WHERE id_peca=" + id_peca;      
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        ArrayList<ServicoPeca> aServicoPeca = new ArrayList<ServicoPeca>();
        while (rset.next()) {
            ServicoPeca servicoPeca = new ServicoPeca();
            servicoPeca.setId_servico(rset.getInt("id_servico"));
            servicoPeca.setId_peca(rset.getInt("id_peca"));
            servicoPeca.setQuantidade(rset.getInt("quantidade"));
            aServicoPeca.add(servicoPeca);
        }   
        return aServicoPeca; 
    }
}
