package DAO;
import conexao.BDFabricacaoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.FuncionarioAtendimento;

public class FuncionarioAtendimentoDAO {
    String cpf_funcionario;
    int id_atendimento;
    
    public void inserir(String cpf, int id) throws SQLException{
       Connection con = BDFabricacaoConexao.getConnection(1); 

       String sql = "INSERT INTO funcionario_atendimento (cpf_funcionario, id_atendimento) VALUES(?,?)";     
       PreparedStatement pstmt = con.prepareStatement(sql);     

       pstmt.setString(1,cpf);
       pstmt.setInt(2,id);

       pstmt.execute();
       pstmt.close();    
    }
    
    public ArrayList<FuncionarioAtendimento> consultar(String cpf) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM funcionario_atendimento WHERE cpf_funcionario=" + cpf + " order by cpf_funcionario";      
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        ArrayList<FuncionarioAtendimento> aFuncionarioAtendimento = new ArrayList<FuncionarioAtendimento>();
        while (rset.next()) {
            FuncionarioAtendimento funcionarioAtendimento = new FuncionarioAtendimento();
            funcionarioAtendimento.setCpf_funcionario(rset.getString("cpf_funcionario"));
            funcionarioAtendimento.setId_atendimento(rset.getInt("id_atendimento"));
            aFuncionarioAtendimento.add(funcionarioAtendimento);
        }   
        return aFuncionarioAtendimento; 
    }
}
