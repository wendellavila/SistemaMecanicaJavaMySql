import model.*;
import DAO.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
       CidadeDAO cidadeDAO = new CidadeDAO();
       ArrayList<Cidade> teste = cidadeDAO.consultar();
       System.out.println(teste.get(0).getNome());
    }
}
