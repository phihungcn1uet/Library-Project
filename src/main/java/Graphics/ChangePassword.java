
package Graphics;
import Database.LoginDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class ChangePassword extends javax.swing.JFrame {

    /**
     * Creates new form ChangeInfomation
     */
    public ChangePassword() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        but_save = new javax.swing.JButton();
        but_cancel = new javax.swing.JButton();
        txt_currentPass = new javax.swing.JPasswordField();
        txt_newPass = new javax.swing.JPasswordField();
        txt_retypeNewPass = new javax.swing.JPasswordField();
        but_showPass = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 64, 93));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đổi mật khẩu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mật khẩu hiện tại");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mật khẩu mới");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Nhập lại mật khẩu mới");

        but_save.setBackground(new java.awt.Color(0, 64, 93));
        but_save.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        but_save.setForeground(new java.awt.Color(255, 255, 255));
        but_save.setText("Save");
        but_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_saveActionPerformed(evt);
            }
        });

        but_cancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        but_cancel.setText("Cancel");
        but_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_cancelActionPerformed(evt);
            }
        });

        txt_currentPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_currentPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_currentPassActionPerformed(evt);
            }
        });

        txt_newPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_retypeNewPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        but_showPass.setText("Hiện mật khẩu");
        but_showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_showPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(but_save, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(but_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txt_currentPass)
                        .addComponent(txt_newPass)
                        .addComponent(txt_retypeNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(but_showPass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_currentPass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_newPass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_retypeNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(but_showPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_save)
                    .addComponent(but_cancel))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void but_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_saveActionPerformed
        if (txt_currentPass.getText().isEmpty() || txt_newPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mật khẩu !", "Warning", 2);
        } else {
            if (!txt_currentPass.getText().equals(LoginDAO.getPasswordFromID(StartMenu.id)))
                JOptionPane.showMessageDialog(this, "Mật khẩu hiện tại không đúng !", "Warning", 2);
            else {
                if (!txt_newPass.getText().equals(txt_retypeNewPass.getText())) {
                    JOptionPane.showMessageDialog(this, "Mật khẩu mới không khớp !", "Warning", 2);
                } else {
                    char[] strPassword = txt_retypeNewPass.getPassword();
                    String input = String.valueOf(strPassword);
                    String sql = "update [User] set password = '" + input + "' where userId = '" + StartMenu.id + "'";
                    LoginDAO.excuteSQL(sql);
                    JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công !", "Thông báo", 1);
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_but_saveActionPerformed

    private void but_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_but_cancelActionPerformed

    private void but_showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_showPassActionPerformed
        if (but_showPass.isSelected()) {
            txt_newPass.setEchoChar((char) 0);
            txt_retypeNewPass.setEchoChar((char) 0);
            txt_currentPass.setEchoChar((char) 0);
            but_showPass.setText("Hide password");
        } else {
            txt_newPass.setEchoChar((char) 42);
            txt_retypeNewPass.setEchoChar((char) 42);
            txt_currentPass.setEchoChar((char) 42);
            but_showPass.setText("Show password");
        }
    }//GEN-LAST:event_but_showPassActionPerformed

    private void txt_currentPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_currentPassActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_currentPassActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_cancel;
    private javax.swing.JButton but_save;
    private javax.swing.JCheckBox but_showPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txt_currentPass;
    private javax.swing.JPasswordField txt_newPass;
    private javax.swing.JPasswordField txt_retypeNewPass;
    // End of variables declaration//GEN-END:variables
}
