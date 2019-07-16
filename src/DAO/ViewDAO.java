package DAO;
import conexao.BDFabricacaoConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.*;

public class ViewDAO {
    
    public PrecoTotalPecasView consultarPrecoPecas(int id_atendimento) throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM preco_total_pecas WHERE id_atendimento=" + id_atendimento;         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        PrecoTotalPecasView precoTotalPecasView = null;
        if(rset.next()){
            precoTotalPecasView = new PrecoTotalPecasView();
            precoTotalPecasView.setId_atendimento(rset.getInt("id_atendimento"));
            precoTotalPecasView.setPlaca_carro(rset.getString("placa_carro"));
            precoTotalPecasView.setPreco_total_pecas(rset.getFloat("preco_total_pecas"));
        }   
        return precoTotalPecasView; 
    }
    
    public ArrayList<EntregasSemanaView> consultar7() throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM entregas_semana_7";         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        ArrayList<EntregasSemanaView> aEntregasSemanaView = new ArrayList<EntregasSemanaView>();
        while(rset.next()){
            EntregasSemanaView entregasSemanaView = new EntregasSemanaView();
            entregasSemanaView.setPlaca_carro(rset.getString("placa_carro"));
            entregasSemanaView.setData_atendimento(rset.getString("data_atendimento"));
            entregasSemanaView.setTempo_est_total(rset.getInt("tempo_est_total"));
            entregasSemanaView.setData_entrega(rset.getString("data_entrega"));
            aEntregasSemanaView.add(entregasSemanaView);
        }   
        return aEntregasSemanaView; 
    }
    
    public ArrayList<EntregasSemanaView> consultar30() throws SQLException{
        Connection con = BDFabricacaoConexao.getConnection(1);
        String sql = "SELECT * FROM entregas_semana_30";         
        Statement stm =  con.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        ArrayList<EntregasSemanaView> aEntregasSemanaView = new ArrayList<EntregasSemanaView>();
        while(rset.next()){
            EntregasSemanaView entregasSemanaView = new EntregasSemanaView();
            entregasSemanaView.setPlaca_carro(rset.getString("placa_carro"));
            entregasSemanaView.setData_atendimento(rset.getString("data_atendimento"));
            entregasSemanaView.setTempo_est_total(rset.getInt("tempo_est_total"));
            entregasSemanaView.setData_entrega(rset.getString("data_entrega"));
            aEntregasSemanaView.add(entregasSemanaView);
        }   
        return aEntregasSemanaView; 
    }
}
