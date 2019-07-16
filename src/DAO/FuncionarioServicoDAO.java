package DAO;
import conexao.BDFabricacaoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.FuncionarioServico;

public class FuncionarioServicoDAO {
    String cpf_funcionario;
    int id_servico;
    
    public void inserir(String cpf, int id) throws SQLException{
       Connection con = BDFabricacaoConexao.getConnection(1); 

       String sql = "INSERT INTO funcionario_atendimento (cpf_funcionario, id_servico) VALUES(?,?)";     
       PreparedStatement pstmt = con.prepareStatement(sql);     

       pstmt.setString(1,cpf);
       pstmt.setInt(2,id);

       pstmt.execute();
       pstmt.close();    
    }
    
    public ArrayList<FuncionarioServico> consultar(String cpf) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM funcionario_atendimento WHERE cpf_funcionario=" + cpf + " order by cpf_funcionario";      
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        ArrayList<FuncionarioServico> aFuncionarioServico = new ArrayList<FuncionarioServico>();
        while (rset.next()) {
            FuncionarioServico funcionarioServico = new FuncionarioServico();
            funcionarioServico.setCpf_funcionario(rset.getString("cpf_funcionario"));
            funcionarioServico.setId_servico(rset.getInt("id_servico"));
            aFuncionarioServico.add(funcionarioServico);
        }   
        return aFuncionarioServico; 
    }
}
