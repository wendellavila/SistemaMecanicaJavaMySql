/*
 * BDFabricacaoConexao.java
 *
 * Created on 15 de Novembro de 2007, 17:39
 */
/*
 * @author NARIL
 */

package conexao;
import java.sql.Connection;

public abstract class BDFabricacaoConexao {    
    public static Connection getConnection(int codigo) {        
        switch(codigo) {            
            default:
                return null;                
            case 1:
                return new BDConexaoMySQL("localhost:3306", "mecanica", "root", "root").getConnection();
        }
    }
    
}
