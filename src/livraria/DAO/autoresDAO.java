/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.DAO;


import java.math.BigDecimal;
import java.math.BigInteger;
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


public class autoresDAO{
    
    public void cadastrar1(autores e ){
        
        Connection conn = bancoMysql.conectabanco();
        
        PreparedStatement stmt = null; //Prepara os dados e junta em uma variável, nesse caso o stmn
        
        ResultSet Ds = null;

        
        try {
            stmt = conn.prepareStatement("INSERT INTO autores (nome, endereço, numero, bairro, cidade, cpf) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getEndereço());
            stmt.setInt(3, e.getNumero());
            stmt.setString(4, e.getBairro());
            stmt.setString(5, e.getCidade());
            stmt.setBigDecimal(6, new BigDecimal(e.getCpf()));
            stmt.executeUpdate();   
            
            JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(autoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
                
        
    } 

    public List <autores> listarA (){
        Connection conn = bancoMysql.conectabanco();
        
        PreparedStatement stmt = null; //Prepara os dados e junta em uma variável, nesse caso o stmn
        
        ResultSet rs = null;
        
        List <autores> autores = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM  autores");
            
            rs = stmt.executeQuery();
        
            while (rs.next()) {
                autores e = new autores();
                e.setId(rs.getInt("id_autor"));
                e.setNome(rs.getString("nome"));
                e.setEndereço(rs.getString("endereço"));
                e.setNumero(rs.getInt("numero"));
                e.setBairro(rs.getString("bairro"));
                e.setCidade(rs.getString("cidade"));
                e.setCpf(new BigInteger(rs.getString("cpf")));

                autores.add(e);
        }        
        } catch (SQLException ex) {
            Logger.getLogger(autoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return autores;
    }   






}


