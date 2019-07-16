package DAO;
import java.sql.CallableStatement;
import conexao.BDFabricacaoConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.lang.model.util.Types;
import model.*;

public class ProcedureDAO {
    
    public void darDesconto(int id_atendimento) throws SQLException {
        Connection con = BDFabricacaoConexao.getConnection(1);


        String sql = "{ call desconto(?) }";
        CallableStatement cs = con.prepareCall(sql);
        cs.setInt(1, id_atendimento);
        cs.execute();
    }
    
    public Float precoTotal(int id_atendimento) throws SQLException {
        Connection con = BDFabricacaoConexao.getConnection(1);
        
        Float preco = 0.0f;
        String sql = "{ call calcular_preco_total(?, ?) }";
        CallableStatement cs = con.prepareCall(sql);
        cs.setInt(1, id_atendimento);
        cs.registerOutParameter(2, java.sql.Types.FLOAT);
        cs.execute();
        preco = cs.getFloat(2);
        return preco;
    }
}
