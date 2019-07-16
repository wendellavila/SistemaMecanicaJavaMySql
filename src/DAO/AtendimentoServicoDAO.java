package DAO;
import conexao.BDFabricacaoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.AtendimentoServico;

public class AtendimentoServicoDAO {
    
    public void inserir(int id_atendimento, int id_servico) throws SQLException{
       Connection con = BDFabricacaoConexao.getConnection(1); 

       String sql = "INSERT INTO atendimento_servico (id_atendimento, id_servico) VALUES(?,?)";     
       PreparedStatement pstmt = con.prepareStatement(sql);     

       pstmt.setInt(1,id_atendimento);
       pstmt.setInt(2,id_servico);

       pstmt.execute();
       pstmt.close();    
    }
    
    public ArrayList<AtendimentoServico> consultarIdAtendimento(int id_atendimento) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM atendimento_servico WHERE id_atendimento=" + id_atendimento;      
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        ArrayList<AtendimentoServico> aAtendimentoServico = new ArrayList<AtendimentoServico>();
        while (rset.next()) {
            AtendimentoServico atendimentoServico = new AtendimentoServico();
            atendimentoServico.setId_atendimento(rset.getInt("id_atendimento"));
            atendimentoServico.setId_servico(rset.getInt("id_servico"));
            aAtendimentoServico.add(atendimentoServico);
        }   
        return aAtendimentoServico; 
    }
    
    public AtendimentoServico consultarIdServico(int id_servico) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM atendimento_servico WHERE id_servico=" + id_servico;      
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        AtendimentoServico atendimentoServico = null;
        if(rset.next()){
            atendimentoServico = new AtendimentoServico();
            atendimentoServico.setId_atendimento(rset.getInt("id_atendimento"));
            atendimentoServico.setId_servico(rset.getInt("id_servico"));
        }   
        return atendimentoServico; 
    }
}
