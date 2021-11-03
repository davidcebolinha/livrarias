/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

import javax.swing.table.DefaultTableModel;
import livraria.DAO.autoresDAO;
import livraria.DAO.editorasDAO;
import livraria.DAO.livrosDAO;
import livraria.classes.autores;
import livraria.classes.editoras;
import livraria.classes.livros;

public class formlivros extends javax.swing.JFrame {

    public formlivros() {
        initComponents();
        carregaDadosA();

        editorasDAO dao = new editorasDAO();
        this.setLocationRelativeTo(null);

        for (editoras e : dao.listar()) {
            cbEditora.addItem(e);
        }

        autoresDAO a = new autoresDAO();

        for (autores aa : a.listarA()) {
            cbautor.addItem(aa);
        }
    }

    public void carregaDadosA() {
        DefaultTableModel tabela = (DefaultTableModel) tLivros.getModel();
        livrosDAO dao = new livrosDAO();
        tabela.setNumRows(0);

        for (livros a : dao.listarL()) {
            tabela.addRow(new Object[]{
                a.getId_livro(),
                a.getEditora().getNome(),
                a.getAutor().getNome(),
                a.getTitulo(),
                a.getAno()
                    
            });
        }
    }

    public void pesquisaDadosL() {
        DefaultTableModel tabela = (DefaultTableModel) tLivros.getModel();
        livrosDAO dao = new livrosDAO();
        tabela.setNumRows(0);

        for (livros a : dao.pesquisarL(jTextField4.getText())) {
            tabela.addRow(new Object[]{
                a.getId_livro(),
                a.getEditora().getNome(),
                a.getAutor().getNome(),
                a.getTitulo(),
                a.getAno()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfcodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbEditora = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbautor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tftitulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfano = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        tfalterar = new javax.swing.JButton();
        tfexcluir = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tLivros = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Livros"));

        jLabel1.setText("Código:");

        jLabel2.setText("Editora:");

        cbEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEditoraActionPerformed(evt);
            }
        });

        jLabel3.setText("Autor:");

        jLabel4.setText("Título:");

        jLabel5.setText("Ano:");

        tfano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfanoActionPerformed(evt);
            }
        });

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfalterar.setText("Alterar");
        tfalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfalterarActionPerformed(evt);
            }
        });

        tfexcluir.setText("Excluir");
        tfexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfexcluirActionPerformed(evt);
            }
        });

        tLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Editora", "Autor", "Título", "Ano"
            }
        ));
        tLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tLivrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tLivros);

        jButton4.setText("Pesquisar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfalterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfexcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEditora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tftitulo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbautor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfano, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbautor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tftitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(tfalterar)
                    .addComponent(tfexcluir))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfanoActionPerformed

    }//GEN-LAST:event_tfanoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        livros a = new livros();
        livrosDAO DAO = new livrosDAO();

        editoras editora = (editoras) cbEditora.getSelectedItem();
        autores autor = (autores) cbautor.getSelectedItem();

        a.setEditora(editora);
        a.setAutor(autor);
        a.setTitulo(tftitulo.getText());
        a.setAno(Integer.parseInt(tfano.getText()));

        DAO.cadastrarL(a);
        carregaDadosA();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        pesquisaDadosL();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEditoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEditoraActionPerformed

    private void tfalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfalterarActionPerformed
        livros a = new livros();
        livrosDAO DAO = new livrosDAO();
        
        editoras editora = (editoras) cbEditora.getSelectedItem();
        autores autor = (autores) cbautor.getSelectedItem();
        
        a.setEditora(editora);
        a.setAutor(autor);
        a.setTitulo(tftitulo.getText());
        a.setAno(Integer.parseInt(tfano.getText()));
        a.setId_livro(Integer.parseInt(tfcodigo.getText()));
        DAO.alterarL(a);
        carregaDadosA();
    }//GEN-LAST:event_tfalterarActionPerformed

    private void tLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tLivrosMouseClicked
        //DELL
        String comboEditora = tLivros.getValueAt(tLivros.getSelectedRow(), 1).toString();
        for (int i = 0; i < cbEditora.getItemCount(); i++){
            if(cbEditora.getItemAt(i).toString().equalsIgnoreCase(comboEditora) ){
                cbEditora.setSelectedIndex(i);
            }
        }

        String comboAutor = tLivros.getValueAt(tLivros.getSelectedRow(), 2).toString();
        for (int i = 0; i < cbautor.getItemCount(); i++){
            if(cbautor.getItemAt(i).toString().equalsIgnoreCase(comboAutor) ){
                cbautor.setSelectedIndex(i);
            }
        }
        
        tfcodigo.setText(tLivros.getValueAt(tLivros.getSelectedRow(), 0).toString());
        tftitulo.setText(tLivros.getValueAt(tLivros.getSelectedRow(), 3).toString());
        tfano.setText(tLivros.getValueAt(tLivros.getSelectedRow(),4).toString());
        
    }//GEN-LAST:event_tLivrosMouseClicked

    private void tfexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfexcluirActionPerformed
        livros a = new livros();
        livrosDAO DAO = new livrosDAO(); 
        
        a.setId_livro(Integer.parseInt(tfcodigo.getText()));          
        DAO.Excluir(a);          
        carregaDadosA();
    }//GEN-LAST:event_tfexcluirActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formlivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formlivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formlivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formlivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formlivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> cbEditora;
    private javax.swing.JComboBox<Object> cbautor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tLivros;
    private javax.swing.JButton tfalterar;
    private javax.swing.JTextField tfano;
    private javax.swing.JTextField tfcodigo;
    private javax.swing.JButton tfexcluir;
    private javax.swing.JTextField tftitulo;
    // End of variables declaration//GEN-END:variables

    private void carregaDados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
