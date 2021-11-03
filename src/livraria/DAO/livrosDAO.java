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
import livraria.classes.autores;
import livraria.classes.editoras;
import livraria.classes.livros;


public class livrosDAO {
    
    public void cadastrarL (livros a){
        
        Connection conn = bancoMysql.conectabanco();
        
        PreparedStatement stmd = null;
        
        ResultSet rs = null;
        
        try{
            stmd = conn.prepareStatement("INSERT INTO livros (id_editora, id_autor, titulo, ano) VALUES (?, ?, ?, ?)");
            stmd.setInt(1, a.getEditora().getId());
            stmd.setInt(2, a.getAutor().getId());
            stmd.setString(3, a.getTitulo());
            stmd.setInt(4, a.getAno());
            stmd.executeUpdate();   
            
            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
                
        } catch(SQLException ex){   
            Logger.getLogger(livrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List <livros> pesquisarL (String texto){
        Connection conn = bancoMysql.conectabanco();
        
        PreparedStatement stmd = null; 
        
        ResultSet rs = null;
        
        List<livros> livros = new ArrayList<>();
        
        try {
            stmd = conn.prepareStatement("select livros.id_livro, editoras.nome as nome_editora, autores.nome as nome_autores, livros.titulo, livros.ano from livros \n" +
                                         "inner join editoras on (editoras.id_editora = livros.id_editora)\n" +
                                         "inner join autores on (autores.id_autor = livros.id_autor) where titulo like ?");
            stmd.setString(1, "%" + texto + "%");
            rs = stmd.executeQuery();
        
            while (rs.next()) {
                livros a = new livros();
                a.setId_livro(rs.getInt("id_livro"));
                a.setTitulo(rs.getString("titulo"));
                a.setAno(rs.getInt("ano"));

                editoras p = new editoras();
                p.setNome(rs.getString("nome_editora"));
                a.setEditora(p);
                
                autores e = new autores();
                e.setNome(rs.getString("nome_autores"));
                a.setAutor(e);
                
                livros.add(a);
        }        
        } catch (SQLException ex) {
            Logger.getLogger(editorasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return livros;
    }

    public List <livros> listarL (){
        Connection conn = bancoMysql.conectabanco();
        
        PreparedStatement stmd = null; //Prepara os dados e junta em uma variável, nesse caso o stmn
        
        ResultSet rs = null;
        
        List<livros> livros = new ArrayList<>();
        
        try {
            stmd = conn.prepareStatement("select livros.id_livro, editoras.nome as nome_editora, autores.nome as nome_autores, livros.titulo, livros.ano from livros \n" +
                                         "inner join editoras on (editoras.id_editora = livros.id_editora)\n" +
                                         "inner join autores on (autores.id_autor = livros.id_autor);");
            
            rs = stmd.executeQuery();
        
            while (rs.next()) {
                livros a = new livros();
                a.setId_livro(rs.getInt("id_livro"));
                a.setTitulo(rs.getString("titulo"));
                a.setAno(rs.getInt("ano"));

                editoras p = new editoras();
                p.setNome(rs.getString("nome_editora"));
                a.setEditora(p);
                
                autores e = new autores();
                e.setNome(rs.getString("nome_autores"));
                a.setAutor(e);
                
                livros.add(a);
        }        
        } catch (SQLException ex) {
            Logger.getLogger(livrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return livros;
    } 

    public void alterarL(livros a ){
        
        Connection conn = bancoMysql.conectabanco();
        
        PreparedStatement stmn = null; //Prepara os dados e junta em uma variável, nesse caso o stmn
        
        ResultSet rs = null;

        try{
            stmn = conn.prepareStatement("UPDATE livros SET id_editora = ?, id_autor = ?, titulo = ?, ano = ? WHERE id_livro = ?");
            stmn.setInt(1, a.getEditora().getId());
            stmn.setInt(2, a.getAutor().getId());
            stmn.setString(3, a.getTitulo());
            stmn.setInt(4, a.getAno());
            stmn.setInt(5, a.getId_livro());
            
            stmn.executeUpdate();   
            
            JOptionPane.showMessageDialog(null, "Livro alterado com sucesso!");
                
        } catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu!!");
            
        }
    
    }

    public void Excluir (livros a){
    
        Connection conn = bancoMysql.conectabanco();
        
        PreparedStatement stmd = null; 
        
        ResultSet rs = null;

        try{
            stmd = conn.prepareStatement("DELETE FROM livros WHERE id_livro = ?");
            stmd.setInt(1, a.getId_livro());
            
            stmd.executeUpdate();   
            
            JOptionPane.showMessageDialog(null, "Livro excluido com sucesso!");
                
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            Logger.getLogger(livrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    }

}



