package DAO;
import conexao.BDFabricacaoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Servico;

public class ServicoDAO {
    
    String descricao_servico, placa_carro;
    int id_servico, id_oficina, tempo_est_dias;
    Float preco_servico;
    
    public void inserir(Servico servico) throws SQLException{
       Connection con = BDFabricacaoConexao.getConnection(1); 

       preco_servico = servico.getPreco_servico();
       tempo_est_dias = servico.getTempo_est_dias();
       descricao_servico = servico.getDescricao_servico();
       id_oficina = servico.getId_oficina();
       placa_carro = servico.getPlaca_carro();

       String sql = "INSERT INTO servico (preco_servico, tempo_est_dias, descricao_servico, id_oficina, placa_carro) VALUES(?,?,?,?,?)";     
       PreparedStatement pstmt = con.prepareStatement(sql);     

       pstmt.setFloat(1,preco_servico);
       pstmt.setInt(2,tempo_est_dias);
       pstmt.setString(3,descricao_servico);
       pstmt.setInt(4,id_oficina);
       pstmt.setString(5,placa_carro);

       pstmt.execute();
       pstmt.close();    
    }
    
    public Servico consultarId(int id) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM servico WHERE id_servico=" + id;         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        Servico servico = null;
        if(rset.next()){
            servico = new Servico();
            servico.setId_servico(rset.getInt("id_servico"));
            servico.setPreco_servico(rset.getFloat("preco_servico"));
            servico.setTempo_est_dias(rset.getInt("tempo_est_dias"));
            servico.setDescricao_servico(rset.getString("descricao_servico"));
            servico.setId_oficina(rset.getInt("id_oficina"));
            servico.setPlaca_carro(rset.getString("placa_carro"));
        }   
        return servico; 
    }

    public Servico consultarPlaca(String placa) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM servico WHERE placa_carro='" + placa;   
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        Servico servico = null;
        if(rset.next()){
            servico = new Servico();
            servico.setId_servico(rset.getInt("id_servico"));
            servico.setPreco_servico(rset.getFloat("preco_servico"));
            servico.setTempo_est_dias(rset.getInt("tempo_est_dias"));
            servico.setDescricao_servico(rset.getString("descricao_servico"));
            servico.setId_oficina(rset.getInt("id_oficina"));
            servico.setPlaca_carro(rset.getString("placa_carro"));
        }   
        return servico;
    }
    
    public Servico consultarDescricao(String descricao) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM servico WHERE descricao_servico='" + descricao;   
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        Servico servico = null;
        if(rset.next()){
            servico = new Servico();
            servico.setId_servico(rset.getInt("id_servico"));
            servico.setPreco_servico(rset.getFloat("preco_servico"));
            servico.setTempo_est_dias(rset.getInt("tempo_est_dias"));
            servico.setDescricao_servico(rset.getString("descricao_servico"));
            servico.setId_oficina(rset.getInt("id_oficina"));
            servico.setPlaca_carro(rset.getString("placa_carro"));
        }   
        return servico;
    }
    
    public void alterarDados(Servico servico) throws SQLException {
        Connection con = BDFabricacaoConexao.getConnection(1);

        id_servico = servico.getId_servico();
        preco_servico = servico.getPreco_servico();
        tempo_est_dias = servico.getTempo_est_dias();
        descricao_servico = servico.getDescricao_servico();
        id_oficina = servico.getId_oficina();

        String sql = "UPDATE servico SET id_servico = '"+ id_servico +"', preco_servico = '"+ preco_servico +
                "', tempo_est_dias = '"+ tempo_est_dias + "', descricao_servico = '"+ descricao_servico + 
                "', id_oficina = '"+ id_oficina + "' WHERE id_servico = "+ servico.getId_servico();

        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
    }
    
    public void excluir(Servico servico) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "DELETE FROM servico WHERE id_servico=" + servico.getId_servico();
        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
    }
}
