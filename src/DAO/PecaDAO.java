package DAO;
import conexao.BDFabricacaoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Peca;

public class PecaDAO {
    int id_peca;
    String nome_peca;
    Float preco_peca;
    
    public void inserir(Peca peca) throws SQLException{
       Connection con = BDFabricacaoConexao.getConnection(1); 

       nome_peca = peca.getNome_peca();
       preco_peca = peca.getPreco_peca();

       String sql = "INSERT INTO peca (nome_peca, preco_peca) VALUES(?,?)";     
       PreparedStatement pstmt = con.prepareStatement(sql);     

       pstmt.setString(1,nome_peca);
       pstmt.setFloat(2,preco_peca);

       pstmt.execute();
       pstmt.close();    
    }
    
    public Peca consultarId(int id) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM peca WHERE id_peca=" + id + " order by nome_peca";         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        Peca peca = null;
        if(rset.next()){
            peca = new Peca();
            peca.setId_peca(rset.getInt("id_peca"));
            peca.setNome_peca(rset.getString("nome_peca"));
            peca.setPreco_peca(rset.getFloat("preco_peca"));
        }   
        return peca; 
    }

    public Peca consultarNome(String nome) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM peca WHERE nome_peca='" + nome + "' order by nome_peca";   
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        Peca peca = null;
        if(rset.next()){
            peca = new Peca();
            peca.setId_peca(rset.getInt("id_peca"));
            peca.setNome_peca(rset.getString("nome_peca"));
            peca.setPreco_peca(rset.getFloat("preco_peca"));
        }   
        return peca; 
    }
    
    public void alterarDados(Peca peca) throws SQLException {
        Connection con = BDFabricacaoConexao.getConnection(1);

        id_peca = peca.getId_peca();
        nome_peca = peca.getNome_peca();
        preco_peca = peca.getPreco_peca();

        String sql = "UPDATE peca SET id_peca = '"+ id_peca +"', nome_peca = '"+ nome_peca +
                "', preco_peca = "+ preco_peca + " WHERE id_peca = "+ peca.getId_peca();

        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
    }
    
    public void excluir(Peca peca) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "DELETE FROM peca WHERE id_peca=" + peca.getId_peca();
        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
    }
}
