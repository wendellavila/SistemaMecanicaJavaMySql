/*
 * BDConexaoMySQL.java
 *
 * Created on 15 de Novembro de 2007, 17:40
 */
/*
 * @author NARIL
 */

//@Override //redefinir o corpo de um método implementado na superclasse

package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BDConexaoMySQL extends BDConexao {
    
    /** Creates a new instance of BDConexaoMySQL */
    public BDConexaoMySQL(String servidor, String bd, String usuario, String senha ) {
        
        this.driver = "com.mysql.jdbc.Driver";
        this.servidor = servidor;  //localhost:3306
        this.bd = bd;              //mecanica
        this.usuario = usuario;    //root
        this.senha = senha;        //root
        this.con = null;
    }
    
    public String getURL() {
        return "jdbc:mysql://" + this.servidor + "/" + this.bd;
    }         //jdbc:mysql://localhost:3306/JDBCDemo", "root", "password"    
    public Connection getConnection() {         
        try {
            //registrar o driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //conectar com o BD    
            con = DriverManager.getConnection(getURL(),usuario,senha);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao carregar o driver!!!");
            e.printStackTrace();
        }
        return this.con;
    }
}
