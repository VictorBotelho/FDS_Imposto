package Negocios;

import javax.swing.JOptionPane;

import Apresentacao.ListaContribuintes;
import DadosComuns.CadastroControlador;
import DadosComuns.CadastroException;


public class Viewer_Main extends javax.swing.JFrame{
	
	public Viewer_Main() throws CadastroException {
        controlador = new CadastroControlador();
        initComponents();
    }
	
	private void initComponents() {

        grupoSexo = new javax.swing.ButtonGroup();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        rdFeminino = new javax.swing.JRadioButton();
        rdMasculino = new javax.swing.JRadioButton();
        btAdicionar = new javax.swing.JButton();
        painelListagem = new javax.swing.JScrollPane();
        lstPessoas = new javax.swing.JList();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        barraMenu = new javax.swing.JMenuBar();
        menuListagens = new javax.swing.JMenu();
        itemHomens = new javax.swing.JMenuItem();
        itemMulheres = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Pessoas");

        lblNome.setText("Nome:");

        lblSexo.setText("Sexo:");

        grupoSexo.add(rdFeminino);
        rdFeminino.setSelected(true);
        rdFeminino.setText("F");

        grupoSexo.add(rdMasculino);
        rdMasculino.setText("M");

        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        lstPessoas.setModel(controlador.getListaPessoasModel());
        painelListagem.setViewportView(lstPessoas);

        lblTelefone.setText("Telefone:");

        menuListagens.setText("Listagens");

        itemHomens.setText("Homens");
        itemHomens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHomensActionPerformed(evt);
            }
        });
        menuListagens.add(itemHomens);

        itemMulheres.setText("Mulheres");
        itemMulheres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMulheresActionPerformed(evt);
            }
        });
        menuListagens.add(itemMulheres);

        barraMenu.add(menuListagens);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelListagem, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdFeminino)
                        .addGap(18, 18, 18)
                        .addComponent(rdMasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAdicionar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdicionar)
                    .addComponent(lblSexo)
                    .addComponent(rdFeminino)
                    .addComponent(rdMasculino))
                .addGap(18, 18, 18)
                .addComponent(painelListagem, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        try {
            if (controlador.adicionarPessoa(nome, telefone, rdMasculino.isSelected())) {
                JOptionPane.showMessageDialog(this, "Pessoa adicionada com sucesso.");
                txtNome.setText("");
                txtTelefone.setText("");
                rdFeminino.setSelected(true);
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível adicionar a pessoa ao cadsatro.");
            }
        } catch (CadastroException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void itemHomensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHomensActionPerformed
        try {
            ListaContribuintes janela = new ListaContribuintes(controlador.buscarHomens());
            janela.setVisible(true);
        } catch (CadastroException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_itemHomensActionPerformed

    private void itemMulheresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMulheresActionPerformed
        try {
            ListaContribuintes janela = new ListaContribuintes(controlador.buscarMulheres());
            janela.setVisible(true);
        } catch (CadastroException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_itemMulheresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Viewer_Main().setVisible(true);
                } catch (CadastroException ex) {
                    System.out.println("Erro fatal: " + ex.getMessage());
                    System.out.println(ex.toString());
                    System.exit(0);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btAdicionar;
    private javax.swing.ButtonGroup grupoSexo;
    private javax.swing.JMenuItem itemHomens;
    private javax.swing.JMenuItem itemMulheres;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JList lstPessoas;
    private javax.swing.JMenu menuListagens;
    private javax.swing.JScrollPane painelListagem;
    private javax.swing.JRadioButton rdFeminino;
    private javax.swing.JRadioButton rdMasculino;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
    private CadastroControlador controlador;

}
