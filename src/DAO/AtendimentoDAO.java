package DAO;
import conexao.BDFabricacaoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Atendimento;

public class AtendimentoDAO {
    String horario_atendimento, descricao_atendimento, data_atendimento, placa_carro;
    int id_atendimento, id_oficina;
    
    public void inserir(Atendimento atendimento) throws SQLException{
       Connection con = BDFabricacaoConexao.getConnection(1);

       id_atendimento = atendimento.getId_atendimento();
       horario_atendimento = atendimento.getHorario_atendimento();
       data_atendimento = atendimento.getData_atendimento();
       descricao_atendimento = atendimento.getDescricao_atendimento();
       id_oficina = atendimento.getId_oficina();
       placa_carro = atendimento.getPlaca_carro();

       String sql = "INSERT INTO atendimento (horario_atendimento, data_atendimento, descricao_atendimento, id_oficina, placa_carro) VALUES(?,?,?,?,?)";     
       PreparedStatement pstmt = con.prepareStatement(sql);     

       pstmt.setString(1,horario_atendimento);
       pstmt.setString(2,data_atendimento);
       pstmt.setString(3,descricao_atendimento);
       pstmt.setInt(4,id_oficina);
       pstmt.setString(5,placa_carro);

       pstmt.execute();
       pstmt.close();    
    }
    
    public Atendimento consultarId(int id) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM atendimento WHERE id_atendimento=" + id;         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        Atendimento atendimento = null;
        if(rset.next()){
            atendimento = new Atendimento();
            atendimento.setId_atendimento(rset.getInt("id_atendimento"));
            atendimento.setHorario_atendimento(rset.getString("horario_atendimento"));
            atendimento.setData_atendimento(rset.getString("data_atendimento"));
            atendimento.setDescricao_atendimento(rset.getString("descricao_atendimento"));
            atendimento.setId_oficina(rset.getInt("id_oficina"));
            atendimento.setPlaca_carro(rset.getString("placa_carro"));
        }   
        return atendimento; 
    }

    public Atendimento consultarPlaca(String placa) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM servico WHERE placa_carro='" + placa;   
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        Atendimento atendimento = null;
        if(rset.next()){
            atendimento = new Atendimento();
            atendimento.setId_atendimento(rset.getInt("id_atendimento"));
            atendimento.setHorario_atendimento(rset.getString("horario_atendimento"));
            atendimento.setData_atendimento(rset.getString("data_atendimento"));
            atendimento.setDescricao_atendimento(rset.getString("descricao_atendimento"));
            atendimento.setId_oficina(rset.getInt("id_oficina"));
            atendimento.setPlaca_carro(rset.getString("placa_carro"));
        }   
        return atendimento; 
    }
    
    public void alterarDados(Atendimento atendimento) throws SQLException {
        Connection con = BDFabricacaoConexao.getConnection(1);

        id_atendimento = atendimento.getId_atendimento();
        horario_atendimento = atendimento.getHorario_atendimento();
        data_atendimento = atendimento.getData_atendimento();
        descricao_atendimento = atendimento.getDescricao_atendimento();
        id_oficina = atendimento.getId_oficina();

        String sql = "UPDATE atendimento SET id_atendimento = '"+ id_atendimento +"', horario_atendimento = '"+ horario_atendimento +
                "', data_atendimento = '"+ data_atendimento + "', descricao_atendimento = '"+ descricao_atendimento + 
                "', id_oficina = '"+ id_oficina + "' WHERE id_atendimento = "+ atendimento.getId_atendimento();

        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
    }
    
    public void excluir(Atendimento atendimento) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "DELETE FROM atendimento WHERE id_atendimento=" + atendimento.getId_atendimento();
        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
    }
}
