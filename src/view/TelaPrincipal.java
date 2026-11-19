/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.ContatoDAO;
import model.Contato;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



  

    public class TelaPrincipal extends javax.swing.JFrame {

        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPrincipal.class.getName());

        public TelaPrincipal() {
            initComponents();
            configurarTabela();
            carregarTabela();
        }

        private void configurarTabela() {
            DefaultTableModel modelo = new DefaultTableModel(
                    new Object[][]{},
                    new String[]{"ID", "Nome", "Telefone", "E-mail", "Categoria"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // a edição é feita pelos campos, não direto na tabela
                }
            };
            tblContatos.setModel(modelo);
        }

        private void carregarTabela() {
            DefaultTableModel modelo = (DefaultTableModel) tblContatos.getModel();
            modelo.setRowCount(0); // limpa as linhas antes de recarregar

            try {
                ContatoDAO dao = new ContatoDAO();
                List<Contato> lista = dao.listar();

                for (Contato c : lista) {
                    modelo.addRow(new Object[]{
                        c.getId(),
                        c.getNome(),
                        c.getTelefone(),
                        c.getEmail(),
                        c.getCategoria()
                    });
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erro ao carregar contatos: " + e.getMessage());
            }

        }

        private void preencherTabela(List<Contato> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tblContatos.getModel();
        modelo.setRowCount(0);
        for (Contato c : lista) {
            modelo.addRow(new Object[]{
                c.getId(), c.getNome(), c.getTelefone(), c.getEmail(), c.getCategoria()
            });
        }
    }
        private String texto(int linha, int coluna) {
        Object valor = tblContatos.getValueAt(linha, coluna);
        return valor != null ? valor.toString() : "";
    }

    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        cbCategoria.setSelectedIndex(0);
        tblContatos.clearSelection();
        txtNome.requestFocus();
    }

    private Contato lerFormulario() {
        Contato c = new Contato();
        if (!txtId.getText().trim().isEmpty()) {
            c.setId(Integer.parseInt(txtId.getText().trim()));
        }
        c.setNome(txtNome.getText().trim());
        c.setTelefone(txtTelefone.getText().trim());
        c.setEmail(txtEmail.getText().trim());
        c.setCategoria(cbCategoria.getSelectedItem().toString());
        return c;
    }

    private boolean camposValidos() {
        if (txtNome.getText().trim().isEmpty() || txtTelefone.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome e telefone são obrigatórios.");
            return false;
        }
        return true;
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBusca = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        cbCategoria = new javax.swing.JComboBox<>();
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContatos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnNovo1 = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtBusca.addActionListener(this::txtBuscaActionPerformed);
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });

        txtId.setEditable(false);
        txtId.addActionListener(this::txtIdActionPerformed);

        txtNome.addActionListener(this::txtNomeActionPerformed);

        txtTelefone.addActionListener(this::txtTelefoneActionPerformed);

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Família", "Trabalho", "Amigos", "Outros" }));

        txtEmail.addActionListener(this::txtEmailActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("AGENDA TELEFONICA");

        tblContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "TELEFONE", "EMAIL", "CATEGORIA"
            }
        ));
        tblContatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblContatos);

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        btnNovo1.setText("NOVO");
        btnNovo1.addActionListener(this::btnNovo1ActionPerformed);

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        jLabel2.setText("ID");

        jLabel3.setText("NOME");

        jLabel4.setText("TELEFONE");

        jLabel5.setText("EMAIL");

        jLabel6.setText("CATEGORIA");

        jLabel7.setText("BUSCAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(203, 203, 203)
                    .addComponent(btnNovo1)
                    .addContainerGap(566, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(4, 4, 4)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap(312, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(539, Short.MAX_VALUE)
                    .addComponent(btnNovo1)
                    .addGap(311, 311, 311)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        try {
            String termo = txtBusca.getText().trim();
            ContatoDAO dao = new ContatoDAO();
            preencherTabela(termo.isEmpty() ? dao.listar() : dao.pesquisar(termo));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro na busca: " + e.getMessage());
        }
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
         if (txtId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um contato na tabela para editar.");
            return;
        }
        if (!camposValidos()) {
            return;
        }
        try {
            new ContatoDAO().atualizar(lerFormulario());
            JOptionPane.showMessageDialog(this, "Contato atualizado!");
            carregarTabela();
            limparCampos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNovo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovo1ActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnNovo1ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (!camposValidos()) {
            return;
        }
        try {
            ContatoDAO dao = new ContatoDAO();
            if (txtId.getText().trim().isEmpty()) {
                dao.cadastrar(lerFormulario());
                JOptionPane.showMessageDialog(this, "Contato cadastrado!");
            } else {
                dao.atualizar(lerFormulario());
                JOptionPane.showMessageDialog(this, "Contato atualizado!");
            }
            carregarTabela();
            limparCampos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (txtId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um contato na tabela para excluir.");
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(this,
                "Deseja realmente excluir este contato?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (resposta != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            new ContatoDAO().excluir(Integer.parseInt(txtId.getText().trim()));
            carregarTabela();
            limparCampos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir: " + e.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tblContatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContatosMouseClicked
        int linha = tblContatos.getSelectedRow();

        if (linha >= 0) {
            txtId.setText(texto(linha, 0));
            txtNome.setText(texto(linha, 1));
            txtTelefone.setText(texto(linha, 2));
            txtEmail.setText(texto(linha, 3));
            cbCategoria.setSelectedItem(texto(linha, 4));
        }
        

    }//GEN-LAST:event_tblContatosMouseClicked

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        txtBuscaActionPerformed(null);
    }//GEN-LAST:event_txtBuscaKeyReleased

    /**
     * @param args the command line arguments
     */
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo1;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblContatos;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
