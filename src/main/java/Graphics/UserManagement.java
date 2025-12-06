package Graphics;

import Database.UserDAO;
import Model.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;

/**
 *
 * @author admin
 */
public class UserManagement extends javax.swing.JFrame {

    static ArrayList<User> userList;

    Vector tblData = new Vector();
    Vector<String> tblTitle = new Vector<>();
    DefaultTableModel tblModel;
    ButtonGroup groupsex = new ButtonGroup();

    private void setSex() {
        groupsex.add(rdb_nam);
        groupsex.add(rdb_nu);
    }

    /**
     *
     */
    public UserManagement() {
        userList = UserDAO.getUserList();
        initComponents();
        setSex();
        this.setLocationRelativeTo(null);
        addTitle();
        loadDataUser(userList);
    }

    private void addTitle() {
        tblTitle.add("ID Khách Hàng");
        tblTitle.add("Tên Khách Hàng");
        tblTitle.add("Ngày Sinh");
        tblTitle.add("Địa Chỉ");
        tblTitle.add("Số Điện Thoại");
        tblTitle.add("CCCD");
        tblTitle.add("Giới Tính");
    }

    private void loadDataUser(ArrayList<User> ds) {
        tblData.removeAllElements();
        for (User n : ds) {
            Vector v = new Vector();
            v.add(n.getIdUser());
            v.add(n.getUserName());
            v.add(n.getBirthday());
            v.add(n.getAddress());
            v.add(n.getPhoneNumber());
            v.add(n.getIdentityNumber());
            v.add(n.getSex());
            tblData.add(v);
        }
        UserList.setModel(new DefaultTableModel(tblData, tblTitle));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        a2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_idUser = new javax.swing.JTextField();
        txt_userName = new javax.swing.JTextField();
        txt_birthday = new javax.swing.JTextField();
        txt_address = new javax.swing.JTextField();
        txt_phoneNumber = new javax.swing.JTextField();
        txt_identityNumber = new javax.swing.JTextField();
        rdb_nam = new javax.swing.JRadioButton();
        rdb_nu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserList = new javax.swing.JTable();
        but_erase = new javax.swing.JButton();
        but_repair = new javax.swing.JButton();
        but_back = new javax.swing.JButton();
        txt_keyword = new javax.swing.JTextField();
        searchType = new javax.swing.JComboBox<>();
        but_search = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        a2.setBackground(new java.awt.Color(0, 64, 93));
        a2.setForeground(new java.awt.Color(0, 64, 93));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ID Khách Hàng");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Tên Khách Hàng");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Ngày Sinh");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Địa Chỉ");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Số Điện Thoại");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("CCCD");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Giới Tính");

        txt_idUser.setEditable(false);
        txt_idUser.setEnabled(false);
        txt_idUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idUserActionPerformed(evt);
            }
        });

        txt_birthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_birthdayActionPerformed(evt);
            }
        });

        txt_phoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_phoneNumberActionPerformed(evt);
            }
        });
        txt_phoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_phoneNumberKeyTyped(evt);
            }
        });

        txt_identityNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_identityNumberKeyTyped(evt);
            }
        });

        rdb_nam.setBackground(new java.awt.Color(204, 0, 204));
        rdb_nam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdb_nam.setForeground(new java.awt.Color(255, 255, 255));
        rdb_nam.setText("NAM");
        rdb_nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_namActionPerformed(evt);
            }
        });

        rdb_nu.setBackground(new java.awt.Color(204, 0, 204));
        rdb_nu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdb_nu.setForeground(new java.awt.Color(255, 255, 255));
        rdb_nu.setText("NỮ");

        UserList.setModel(new javax.swing.table.DefaultTableModel(
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
        UserList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(UserList);

        but_erase.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        but_erase.setForeground(new java.awt.Color(255, 0, 0));
        but_erase.setText("XÓA");
        but_erase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_eraseActionPerformed(evt);
            }
        });

        but_repair.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        but_repair.setForeground(new java.awt.Color(255, 51, 0));
        but_repair.setText("SỬA");
        but_repair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_repairActionPerformed(evt);
            }
        });

        but_back.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        but_back.setForeground(new java.awt.Color(255, 0, 0));
        but_back.setText("QUAY LẠI");
        but_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_backActionPerformed(evt);
            }
        });

        txt_keyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_keywordActionPerformed(evt);
            }
        });

        searchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo tên", "Theo mã" }));

        but_search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        but_search.setForeground(new java.awt.Color(255, 0, 51));
        but_search.setText("TÌM KIẾM");
        but_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_searchActionPerformed(evt);
            }
        });

        jButton1.setText("Xem những sách mà người đó mượn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout a2Layout = new javax.swing.GroupLayout(a2);
        a2.setLayout(a2Layout);
        a2Layout.setHorizontalGroup(
            a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1084, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(a2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(but_back)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(a2Layout.createSequentialGroup()
                .addGroup(a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(a2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_idUser, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_userName, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(a2Layout.createSequentialGroup()
                        .addComponent(but_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(but_repair, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(but_erase, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(a2Layout.createSequentialGroup()
                        .addGroup(a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(txt_identityNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(149, 149, 149)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdb_nam)
                        .addGap(33, 33, 33)
                        .addComponent(rdb_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        a2Layout.setVerticalGroup(
            a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_idUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(rdb_nam)
                    .addComponent(rdb_nu))
                .addGap(49, 49, 49)
                .addGroup(a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txt_phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txt_identityNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a2Layout.createSequentialGroup()
                        .addGroup(a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(but_search))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a2Layout.createSequentialGroup()
                        .addGroup(a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(but_repair)
                            .addComponent(but_erase))
                        .addGap(12, 12, 12)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_back)
                    .addComponent(jButton1))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_phoneNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_phoneNumberKeyTyped
        if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9')
            evt.consume();
    }//GEN-LAST:event_txt_phoneNumberKeyTyped

    private void txt_identityNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_identityNumberKeyTyped
        if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9')
            evt.consume();
    }//GEN-LAST:event_txt_identityNumberKeyTyped

    private void UserListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserListMouseClicked
        int selectedRow = UserList.getSelectedRow();
        String userId = UserList.getValueAt(selectedRow, 0).toString();
        User user = UserDAO.getUserByID(userId);
        txt_idUser.setText(user.getIdUser());
        txt_userName.setText(user.getUserName());
        txt_birthday.setText(user.getBirthday());
        txt_address.setText(user.getAddress());
        txt_phoneNumber.setText(user.getPhoneNumber());
        txt_identityNumber.setText(user.getIdentityNumber());
        idOfChoosenUser = user.getIdUser();
        String sex = user.getSex();
        if ("Nam".equals(sex)) {
            rdb_nam.setSelected(true);
        } else {
            rdb_nu.setSelected(true);
        }
    }//GEN-LAST:event_UserListMouseClicked

    private boolean checkphoneNumber() {
        String phoneNumber = txt_phoneNumber.getText().trim();
        if (phoneNumber.matches(".*[a-zA-Z].*")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không chứa ký tự");
            return false;
        } else if (phoneNumber.length() != 10) {
            JOptionPane.showMessageDialog(this, "Số điện thoại chỉ được 10 số");
            return false;
        }
        return true;
    }

    private boolean checkInfo() {
        if (txt_idUser.getText().isEmpty() && txt_userName.getText().isEmpty() && txt_birthday.getText().isEmpty() && txt_address.getText().isEmpty()
                && txt_phoneNumber.getText().isEmpty() && txt_identityNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phải nhập đầy đủ thông tin !", "Thông báo", 2);
            return false;
        }
        return true;
    }

    private boolean checksex() {
        if (!rdb_nam.isSelected() && !rdb_nu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void but_eraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_eraseActionPerformed
        UserDAO.deleteUser(idOfChoosenUser);
        JOptionPane.showMessageDialog(this, "Xóa Thành Công");
        userList = UserDAO.getUserList();
        loadDataUser(userList);

        txt_idUser.setText("");
        txt_userName.setText("");
        txt_birthday.setText("");
        txt_address.setText("");
        txt_phoneNumber.setText("");
        txt_identityNumber.setText("");
        rdb_nam.setSelected(true);
    }//GEN-LAST:event_but_eraseActionPerformed

    private void but_repairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_repairActionPerformed
        if (checkInfo() && checksex() && checkphoneNumber()) {
            User user = UserDAO.getUserByID(idOfChoosenUser);
            user.setUserName(txt_userName.getText());
            user.setBirthday(txt_birthday.getText());
            user.setAddress(txt_address.getText());
            user.setPhoneNumber(txt_phoneNumber.getText());
            user.setIdentityNumber(txt_identityNumber.getText());
            if (rdb_nam.isSelected()) {
                user.setSex("Nam");
            } else if (rdb_nu.isSelected()) {
                user.setSex("Nữ");
            }
            UserDAO.repairUser(user);
            JOptionPane.showMessageDialog(this, "Sửa Thành Công");
            loadTableUser();
        }
    }//GEN-LAST:event_but_repairActionPerformed

    private void but_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_backActionPerformed
        dispose();
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
    }//GEN-LAST:event_but_backActionPerformed

    private void but_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_searchActionPerformed
        String keyword = txt_keyword.getText().trim();
        String SearchType = searchType.getSelectedItem().toString();
        if (keyword.isEmpty()) {
            userList = UserDAO.getUserList();
        } else {
            userList = UserDAO.searchUserList(SearchType, keyword);
        }
        loadDataUser(userList);
    }//GEN-LAST:event_but_searchActionPerformed

    private void txt_phoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_phoneNumberActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_phoneNumberActionPerformed

    private void txt_birthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_birthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_birthdayActionPerformed

    private void txt_idUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idUserActionPerformed

    private void rdb_namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_namActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_namActionPerformed

    private void txt_keywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_keywordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_keywordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (txt_userName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            new BookWhichBorrowedByUser(idOfChoosenUser).setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean checkDate() {
        String dateStr = txt_birthday.getText().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Không cho phép ngày không hợp lệ (như 30/02/2024)
        try {
            Date date = sdf.parse(dateStr); // Thử chuyển đổi chuỗi thành ngày
            return true; // Ngày hợp lệ
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không đúng định dạng dd/MM/yyyy hoặc không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            txt_birthday.setText(""); // Xóa nội dung trường nhập ngày
            return false;
        }
    }

    private void loadTableUser() {
        DefaultTableModel model = (DefaultTableModel) UserList.getModel();
        model.setRowCount(0);
        for (User us : UserDAO.getUserList()) {
            Object[] row = new Object[]{us.getIdUser(), us.getUserName(), us.getBirthday(), us.getAddress(), us.getPhoneNumber(), us.getIdentityNumber(), us.getSex()};
            model.addRow(row);
        }
        UserList.setModel(model);
        UserList.updateUI();
    }
    private String idOfChoosenUser = "";

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable UserList;
    private javax.swing.JPanel a2;
    private javax.swing.JButton but_back;
    private javax.swing.JButton but_erase;
    private javax.swing.JButton but_repair;
    private javax.swing.JButton but_search;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdb_nam;
    private javax.swing.JRadioButton rdb_nu;
    private javax.swing.JComboBox<String> searchType;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_birthday;
    private javax.swing.JTextField txt_idUser;
    private javax.swing.JTextField txt_identityNumber;
    private javax.swing.JTextField txt_keyword;
    private javax.swing.JTextField txt_phoneNumber;
    private javax.swing.JTextField txt_userName;
    // End of variables declaration//GEN-END:variables

}
