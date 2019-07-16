package DAO;
import conexao.BDFabricacaoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Oficina;

public class OficinaDAO {
    int id_oficina;
    String rua_oficina, bairro_oficina, num_casa_oficina, cidade_oficina, estado_oficina;
    
    public void inserir(Oficina oficina) throws SQLException{
       Connection con = BDFabricacaoConexao.getConnection(1); 

       rua_oficina = oficina.getRua_oficina();
       bairro_oficina = oficina.getBairro_oficina();
       num_casa_oficina = oficina.getNum_casa_oficina();
       cidade_oficina = oficina.getCidade_oficina();
       estado_oficina = oficina.getEstado_oficina();

       String sql = "INSERT INTO oficina (rua_oficina, bairro_oficina, num_casa_oficina, cidade_oficina, estado_oficina) VALUES(?,?,?,?,?)";     
       PreparedStatement pstmt = con.prepareStatement(sql);     

       pstmt.setString(1,rua_oficina);
       pstmt.setString(2,bairro_oficina);
       pstmt.setString(3,num_casa_oficina);
       pstmt.setString(4,cidade_oficina);
       pstmt.setString(5,estado_oficina);

       pstmt.execute();
       pstmt.close();    
    }
    public Oficina consultarId(int id) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM oficina WHERE id_oficina=" + id;         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        Oficina oficina = null;
        if(rset.next()){
            oficina = new Oficina();
            oficina.setId_oficina(rset.getInt("id_oficina"));
            oficina.setRua_oficina(rset.getString("rua_oficina"));
            oficina.setBairro_oficina(rset.getString("bairro_oficina"));
            oficina.setNum_casa_oficina(rset.getString("num_casa_oficina"));
            oficina.setCidade_oficina(rset.getString("cidade_oficina"));
            oficina.setEstado_oficina(rset.getString("estado_oficina"));
        }   
        return oficina; 
    }

    public Oficina consultarCidade(String cidade) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM oficina WHERE cidade_oficina='" + cidade;   
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        Oficina oficina = null;
        if(rset.next()){
            oficina = new Oficina();
            oficina.setId_oficina(rset.getInt("id_oficina"));
            oficina.setRua_oficina(rset.getString("rua_oficina"));
            oficina.setBairro_oficina(rset.getString("bairro_oficina"));
            oficina.setNum_casa_oficina(rset.getString("num_casa_oficina"));
            oficina.setCidade_oficina(rset.getString("cidade_oficina"));
            oficina.setEstado_oficina(rset.getString("estado_oficina"));
        }   
        return oficina; 
    }
    
    public void alterarDados(Oficina oficina) throws SQLException {
        Connection con = BDFabricacaoConexao.getConnection(1);

        id_oficina = oficina.getId_oficina();
        rua_oficina = oficina.getRua_oficina();
        bairro_oficina = oficina.getBairro_oficina();
        num_casa_oficina = oficina.getNum_casa_oficina();
        cidade_oficina = oficina.getCidade_oficina();
        estado_oficina = oficina.getEstado_oficina();

        String sql = "UPDATE oficina SET id_oficina = '"+ id_oficina +"', rua_oficina = '"+ rua_oficina +
                "', bairro_oficina = '"+ bairro_oficina + "', num_casa_oficina = '"+ num_casa_oficina + 
                "', cidade_oficina = '"+ cidade_oficina + "', estado_oficina = '"+ estado_oficina
                + "' WHERE id_oficina = "+ oficina.getId_oficina();

        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
    }
    
    public void excluir(Oficina oficina) throws SQLException{
        if(oficina.getId_oficina() > 1){
            Connection con = BDFabricacaoConexao.getConnection(1);
            String sql = "DELETE FROM oficina WHERE id_oficina=" + oficina.getId_oficina();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
        }
        else {
            System.out.println("A oficina matriz não pode ser deletada.");
        }
        
    }
}
