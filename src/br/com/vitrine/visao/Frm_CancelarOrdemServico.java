
package br.com.vitrine.visao;

import br.com.vitrine.DAO.ModuloConexao;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Gessione
 */
public class Frm_CancelarOrdemServico extends javax.swing.JFrame {
    
    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    private String tipo;

    /**
     * Creates new form Frm_OrdemServico
     */
    public Frm_CancelarOrdemServico() {
        initComponents();
        getContentPane().setBackground(Color.WHITE); // Mudar cor de fundo do Background tela Frm_CancelarOrdemServico
    }

    /**
     * Método responsável pela pesquisa de Ordem de Servico pela Os com filtro
     */
    private void PesquisarOS() {
        String sql = "select * from tbos where situacao = 'ABERTA' and os like?";
        try {
            conexao = ModuloConexao.conectar();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCodigo.getText() + "%");
            rs = pst.executeQuery();
            jTableOrdemServico.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    /**
     * Método responsável pelo cancelamento de uma Ordem de Serviço
     */
    private void CancelarOs() {
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma Cancelar esta Ordem de Serviço?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "update tbos set situacao = 'CANCELADA' where Os = ?";
            try {
                conexao = ModuloConexao.conectar();
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtCodigo.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ordem de Serviço Cancelada com sucesso!!");
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }

    /**
     * método usado para setar os campos de texto com o conteúdo da tabela Ordem
     * de Servico
     */
    private void setarCampos() {
        int setar = jTableOrdemServico.getSelectedRow();
        txtCodigo.setText(jTableOrdemServico.getModel().getValueAt(setar, 0).toString());

    }

    /**
     * método usado para limpar os campos da Tabela Ordem de Servico
     *
     */
    private void limpar() {

        ((DefaultTableModel) jTableOrdemServico.getModel()).setRowCount(0);
        txtCodigo.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOrdemServico = new javax.swing.JTable();
        jButtonCancelar = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();
        jButtonNovaOrdemServico = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jButtonLimpar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vitrine - Cancelar Ordem de Serviço ");
        setResizable(false);

        jTableOrdemServico = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTableOrdemServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Data", "Horario", "Cliente", "Total", "Status", "Tecnico", "Título 8", "Título 9", "Título 10"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOrdemServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOrdemServicoMouseClicked(evt);
            }
        });
        jTableOrdemServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableOrdemServicoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableOrdemServico);

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/fechar (2).png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/print.png"))); // NOI18N
        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        jButtonNovaOrdemServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/mais (5).png"))); // NOI18N
        jButtonNovaOrdemServico.setText("Nova Ordem");
        jButtonNovaOrdemServico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jButtonNovaOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaOrdemServicoActionPerformed(evt);
            }
        });

        jButtonConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/icons8-pesquisar-24.png"))); // NOI18N
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jLabel21.setText("N° Ordem:");

        txtCodigo.setBackground(new java.awt.Color(242, 253, 242));
        txtCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(153, 102, 0));

        jButtonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/fechar (2).png"))); // NOI18N
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setToolTipText("Limpar");
        jButtonLimpar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/pngwing.com .png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vitrine/icones/editar (2).png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNovaOrdemServico)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonImprimir))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancelar, jButtonImprimir, jButtonLimpar, jButtonNovaOrdemServico, jButtonSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonConsultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSair)
                        .addComponent(jButtonImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonNovaOrdemServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAlterar, jButtonCancelar, jButtonImprimir, jButtonLimpar, jButtonNovaOrdemServico, jButtonSair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableOrdemServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOrdemServicoMouseClicked
        // acao setar dados da tabela no campo código:
        setarCampos();
       
        
    }//GEN-LAST:event_jTableOrdemServicoMouseClicked

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // acao botao Cancelar Ordem de Serviço:
        CancelarOs();
        limpar();
        PesquisarOS();
       
        
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
       
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jButtonNovaOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaOrdemServicoActionPerformed
        // acao botao Nova Ordem Servico:
        Frm_Ordem_Servico ordem = new Frm_Ordem_Servico();
        ordem.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButtonNovaOrdemServicoActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        //acao botao pesquisar:
        PesquisarOS();
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        // acao botao Limpar:
        limpar();
       
       

    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // acao botao Sair:
        int sair = JOptionPane.showConfirmDialog(null, "Deseja sair da Consulta Ordem de Serviço ?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jTableOrdemServicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableOrdemServicoKeyReleased
        // acao setar campo conforme a selecao do teclado:
         setarCampos();
        
    }//GEN-LAST:event_jTableOrdemServicoKeyReleased

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // acao botão Alterar para chamar a tela Frm_Ordem_Servico:
        Frm_Ordem_Servico ordem = new Frm_Ordem_Servico();
        ordem.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButtonAlterarActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_CancelarOrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_CancelarOrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_CancelarOrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_CancelarOrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_CancelarOrdemServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonNovaOrdemServico;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableOrdemServico;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
