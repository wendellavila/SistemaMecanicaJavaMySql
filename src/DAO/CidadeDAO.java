/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import conexao.BDFabricacaoConexao;
import model.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Theodoro
 */
public class CidadeDAO {
    
    private int idCidade;
    private String nome;
    private String estado;

    public CidadeDAO(){}

        
     public void inserir(Cidade city) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1); 
        
        nome = city.getNome();
        estado = city.getEstado();
        
        String sql = "INSERT INTO cidade (nomeCidade, estado) VALUES(?,?)";     
        PreparedStatement pstmt = con.prepareStatement(sql);     
        
        pstmt.setString(1,nome);
        pstmt.setString(2,estado);
                
        pstmt.execute();
        pstmt.close();    
    }
     
    public ArrayList<Cidade> consultar() throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM cliente order by nome_cliente";         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        ArrayList<Cidade> aCity = new ArrayList<Cidade>();
        while (rset.next()) {
            Cidade city = new Cidade();
            city.setIdCidade(rset.getInt("num_casa_cliente"));
            city.setNome(rset.getString("nome_cliente"));
            city.setEstado(rset.getString("rua_cliente"));
            
            
            aCity.add(city);
        }   
        return aCity;
        
    }
    
    public ArrayList<Cidade> consultar(String estado) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM cidades"+estado+" order by nomeCidade";         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        ArrayList<Cidade> aCity = new ArrayList<Cidade>();
        while (rset.next()) {
            Cidade city = new Cidade();
            city.setIdCidade(rset.getInt("idCidade"));
            city.setNome(rset.getString("nomeCidade"));
            city.setEstado(rset.getString("estado"));
            
            
            aCity.add(city);
        }   
        return aCity;
        
    }
    
    public String consultarEstadoDaCidade(int idCidade) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT estado FROM cidade where idCidade="+idCidade;         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        rset.next();
        String est = rset.getString("estado");    
        
        return est;
        
    }
    
    public void alterar(Cidade city) throws SQLException {
        Connection con = BDFabricacaoConexao.getConnection(1);
        
        idCidade = city.getIdCidade();
        nome = city.getNome();
        estado = city.getEstado();
      
              
        String sql = "UPDATE cidade SET nomeCidade = '"+nome+"', estado = '"+estado+"'"+
                " WHERE idCidade = '"+city.getIdCidade()+"'";
        
        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
    }
    
    public int buscaCidadeDaRodoviaria(int idRodoviaria){
        try {
            Connection con = BDFabricacaoConexao.getConnection(1);

            String sql = "SELECT rodoviariaCidade("+idRodoviaria+")";

            Statement stm = con.createStatement();
            
            ResultSet rset = stm.executeQuery(sql);
            rset.next();
            int est = rset.getInt("rodoviariaCidade("+idRodoviaria+")");
            
            return est;
            
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

}
