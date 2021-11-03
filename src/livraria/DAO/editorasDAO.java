package livraria.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import livraria.bancoMysql;
import livraria.classes.editoras;


public class editorasDAO {
    
    public void cadastrar(editoras p ){
        
        Connection conn = bancoMysql.conectabanco();
        
        PreparedStatement stmn = null; //Prepara os dados e junta em uma variável, nesse caso o stmn
        
        ResultSet rs = null;

        try{
            stmn = conn.prepareStatement("INSERT INTO editoras (nome) VALUES (?)");
            stmn.setString(1, p.getNome());
            
            stmn.executeUpdate();   
            
            JOptionPane.showMessageDialog(null, "Editora cadastrada com sucesso!");
                
        } catch(SQLException ex){              
        }
    } 
    
    public List <editoras> listar (){
        Connection conn = bancoMysql.conectabanco();
        
        PreparedStatement stmn = null; //Prepara os dados e junta em uma variável, nesse caso o stmn
        
        ResultSet rs = null;
        
        List<editoras> editoras = new ArrayList<>();
        
        try {
            stmn = conn.prepareStatement("SELECT * FROM  editoras");
            
            rs = stmn.executeQuery();
        
            while (rs.next()) {
                editoras e = new editoras();
                e.setId(rs.getInt("id_editora"));
                e.setNome(rs.getString("nome"));

                editoras.add(e);
        }        
        } catch (SQLException ex) {
            Logger.getLogger(editorasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return editoras;
    }   
          
    public void Excluir(editoras p ){
        
        Connection conn = bancoMysql.conectabanco();
        
        PreparedStatement stmn = null; //Prepara os dados e junta em uma variável, nesse caso o stmn
        
        ResultSet rs = null;

        try{
            stmn = conn.prepareStatement("DELETE FROM editoras WHERE id_editora = ?");
            stmn.setInt(1, p.getId());
            
            stmn.executeUpdate();   
            
            JOptionPane.showMessageDialog(null, "Editora excluida com sucesso!");
                
        } catch(SQLException ex){              
        }
    } 
    
    public List <editoras> pesquisar (String texto){
        Connection conn = bancoMysql.conectabanco();
        
        PreparedStatement stmn = null; //Prepara os dados e junta em uma variável, nesse caso o stmn
        
        ResultSet rs = null;
        
        List<editoras> editoras = new ArrayList<>();
        
        try {
            stmn = conn.prepareStatement("SELECT * FROM  editoras WHERE nome like ?");
            stmn.setString(1, "%" + texto + "%");
            rs = stmn.executeQuery();
        
            while (rs.next()) {
                editoras e = new editoras();
                e.setId(rs.getInt("id_editora"));
                e.setNome(rs.getString("nome"));

                editoras.add(e);
        }        
        } catch (SQLException ex) {
            Logger.getLogger(editorasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return editoras;
    }
      
    public void alterar(editoras p ){
        
        Connection conn = bancoMysql.conectabanco();
        
        PreparedStatement stmn = null; //Prepara os dados e junta em uma variável, nesse caso o stmn
        
        ResultSet rs = null;

        try{
            stmn = conn.prepareStatement("update editoras set nome = ? where id_editora = ?");
            stmn.setString(1, p.getNome());
            stmn.setInt(2, p.getId());
            
            stmn.executeUpdate();   
            
            JOptionPane.showMessageDialog(null, "Editora alterada com sucesso!");
                
        } catch(SQLException ex){              
        }
    } 
}
