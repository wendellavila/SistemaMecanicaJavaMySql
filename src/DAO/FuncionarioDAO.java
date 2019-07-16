package DAO;

import conexao.BDFabricacaoConexao;
import model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FuncionarioDAO {
    String cpf_funcionario, nome_funcionario;
    int id_oficina;
    
    public void inserir(Funcionario funcionario) throws SQLException{
       Connection con = BDFabricacaoConexao.getConnection(1); 

       cpf_funcionario = funcionario.getCpf_funcionario();
       nome_funcionario = funcionario.getNome_funcionario();
       id_oficina = funcionario.getId_oficina();

       String sql = "INSERT INTO funcionario (cpf_funcionario, nome_funcionario, id_oficina) VALUES(?,?,?)";     
       PreparedStatement pstmt = con.prepareStatement(sql);     

       pstmt.setString(1,cpf_funcionario);
       pstmt.setString(2,nome_funcionario);
       pstmt.setInt(3,id_oficina);

       pstmt.execute();
       pstmt.close();    
    }
    
    public Funcionario consultarCpf(String cpf) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM funcionario WHERE cpf_funcionario=" + cpf + " order by nome_funcionario";         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        Funcionario funcionario = null;
        if(rset.next()){
            funcionario = new Funcionario();
            funcionario.setCpf_funcionario(rset.getString("cpf_funcionario"));
            funcionario.setNome_funcionario(rset.getString("nome_funcionario"));
            funcionario.setId_oficina(rset.getInt("id_oficina"));
        }   
        return funcionario; 
    }

    public Funcionario consultarNome(String nome) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM funcionario WHERE nome_funcionario='" + nome + "' order by nome_funcionario";   
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        Funcionario funcionario = null;
        if(rset.next()){
            funcionario = new Funcionario();
            funcionario.setCpf_funcionario(rset.getString("cpf_funcionario"));
            funcionario.setNome_funcionario(rset.getString("nome_funcionario"));
            funcionario.setId_oficina(rset.getInt("id_oficina"));
        }   
        return funcionario; 
    }
    
    public void alterarDados(Funcionario funcionario) throws SQLException {
        Connection con = BDFabricacaoConexao.getConnection(1);

        cpf_funcionario = funcionario.getCpf_funcionario();
        nome_funcionario = funcionario.getNome_funcionario();
        id_oficina = funcionario.getId_oficina();

        String sql = "UPDATE funcionario SET cpf_funcionario = '"+ cpf_funcionario +"', nome_funcionario = '"+ nome_funcionario +
                "', id_oficina = "+ id_oficina + " WHERE cpf_funcionario = "+ funcionario.getCpf_funcionario();

        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
    }
    
    public void excluir(Funcionario funcionario) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "DELETE FROM funcionario WHERE cpf_funcionario=" + funcionario.getCpf_funcionario();
        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
    }
}
