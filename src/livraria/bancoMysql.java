package livraria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class bancoMysql {
    public static Connection conectabanco(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/id_livraria?"+
                                   "user=root&password=root");
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ao conectar ao banco de dados!", ex);
        }
    
    }
    
}
