/*
 * BDConexao.java
 *
 * Created on 15 de Novembro de 2007, 17:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/*
 * @author NARIL
 */
package conexao;
import java.sql.Connection;

public abstract class BDConexao {
    
    protected Connection con;    
    protected String servidor;
    protected String bd;
    protected String usuario;
    protected String senha;
    protected String driver;
    protected int porta;
    
    //porque declarar aki??
    public abstract Connection getConnection();    //vou estar sobrescrevendo o m�todo 
    public abstract String getURL();
    
}

