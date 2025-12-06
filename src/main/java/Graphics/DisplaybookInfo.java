package Graphics;

import Database.BookDAO;
import Database.LoanDAO;
import Model.*;
import java.awt.FlowLayout;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author admin
 */
public class DisplaybookInfo extends javax.swing.JFrame {

    private Book book;

    /**
     *
     * @param b
     */
    public DisplaybookInfo(Book b) {
        book = b;
        initComponents();
        this.setLocationRelativeTo(null);
        // star set
        starFilled = new ImageIcon(getClass().getClassLoader().getResource("Icon/FilledStar.jpg"));
        starEmpty = new ImageIcon(getClass().getClassLoader().getResource("Icon/EmptyStar.jpg"));
        initStars();
        if (StartMenu.role == 1) {
            txt_quantity.setVisible(false);
            txt_period.setVisible(false);
            but_borrow.setVisible(false);
        }
        if (StartMenu.role == 0) {
            txt_quantity.setVisible(true);
            txt_period.setVisible(true);
            but_borrow.setVisible(true);
        }
        this.setLocationRelativeTo(null);
    }

    private void initStars() {
        int StarRated = (int) book.getStars();
        jPanel5.setLayout(new FlowLayout()); // Đảm bảo layout ngang
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new javax.swing.JLabel();
            stars[i].setPreferredSize(new java.awt.Dimension(60, 50)); // Kích thước mỗi sao 50x50 pixel
            stars[i].setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa icon
            if (i < StarRated) {
                stars[i].setIcon(starFilled);
            } else {
                stars[i].setIcon(starEmpty);
            }
            jPanel5.add(stars[i]); // Thêm sao vào panel
        }

        jPanel5.revalidate(); // Làm mới panel để cập nhật giao diện
        jPanel5.repaint();    // Vẽ lại giao diện
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        but_borrow = new javax.swing.JButton();
        but_cancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbidphong = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_period = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Bookimage = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/bookRepresent.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(StartMenu.role == 0 ? "Mượn Sách" : "Thông Tin Sách");

        if(StartMenu.role ==0 ){
            jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jLabel2.setText("Bạn muốn mượn bao nhiêu quyển sách?");
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Thể Loại");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tác giả");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Số lượng trong kho");

        jLabel6.setText(book.getQuantity() + "");

        jLabel7.setText(book.getAuthor());

        jLabel8.setText(book.getCategory());

        but_borrow.setText("Mượn");
        but_borrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_borrowActionPerformed(evt);
            }
        });

        but_cancel.setText(StartMenu.role == 0 ? "Hủy" : "Thoát");
        but_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_cancelActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 64, 93));
        jPanel2.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Tên sách");

        lbidphong.setText(book.getName());

        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });

        if(StartMenu.role ==0 ){
            jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jLabel10.setText("Bạn muốn mượn trong bao lâu? (ngày)");
        }

        txt_period.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_periodActionPerformed(evt);
            }
        });

        if(StartMenu.role ==0 ){
            jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jLabel11.setText("Chú ý: Hãy trả sách đúng hoặc trước thời hạn");
        }

        if(book.getImage() == null){
            Bookimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/bookRepresentMini.png"))); // NOI18N
        }else{
            Bookimage.setIcon(Function.loadBookImage(195, 170, book.getImage()));
        }

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(250, 50));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbidphong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(218, 218, 218))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(but_borrow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(but_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Bookimage, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50)
                                .addComponent(txt_period, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50)
                                .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_period, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lbidphong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bookimage, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_borrow)
                    .addComponent(but_cancel))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        if (StartMenu.role == 0) {
            txt_quantity.setVisible(false);
            txt_period.setVisible(false);
        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean checkSoLuongConLai() {
        if (book.getQuantity() == 0 || (book.getQuantity() - Integer.parseInt(txt_quantity.getText())) < 0) {
            JOptionPane.showMessageDialog(this, "Số lượng trong kho không đủ !");
            return false;
        }
        return true;
    }

    private void but_borrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_borrowActionPerformed
        if (checkFormatQuantity() && checkPeriod() && checkSoLuongConLai()) {
            LocalDateTime localDate = LocalDateTime.now();

            Loan l = new Loan();
            l.setBookId(book.getId());
            l.setUserId(StartMenu.id);
            l.setBorrowDate(localDate);
            l.setQuantity(Integer.parseInt(txt_quantity.getText().trim()));
            l.setLoanPeriod(Integer.parseInt(txt_period.getText().trim()));

            boolean c = LoanDAO.addLoan(l);

            if (c == true) {
                BookDAO.borrowBook(book, l.getQuantity());
                book = BookDAO.getBookById(book.getId());
                JOptionPane.showMessageDialog(this, "Mượn sách thành công !");
                System.out.println("Mượn thành công");
                this.dispose(); // Đóng cửa sổ sau khi mượn thành công
            } else {
                JOptionPane.showMessageDialog(this, "Mượn sách không thành công !");
                System.out.println("Lỗi khi lấy danh sách sách đang mượn: ");
            }
        }
    }//GEN-LAST:event_but_borrowActionPerformed

    private boolean checkFormatQuantity() {
        String quantity = txt_quantity.getText().trim();
        String message = quantity.isEmpty()
                ? "Số lượng không được để trống!"
                : (quantity.matches(".*[a-zA-Z].*")
                ? "Số lượng không được chứa ký tự chữ!"
                : (Integer.parseInt(quantity) > 10
                ? "Số lượng không được lớn hơn 10!"
                : null));

        if (message != null) {
            JOptionPane.showMessageDialog(this, message);
            return false;
        }
        return true;
    }

    private boolean checkPeriod() {
        String period = txt_period.getText().trim();
        String message = period.isEmpty()
                ? "Thời hạn không được để trống!"
                : (period.matches(".*[a-zA-Z].*")
                ? "Thời hạn không được chứa ký tự chữ!"
                : (Integer.parseInt(period) > 50
                ? "Thời hạn không được lớn hơn 50!"
                : null));

        if (message != null) {
            JOptionPane.showMessageDialog(this, message);
            return false;
        }
        return true;
    }

//    private boolean checkNull() {
//        if (txt_quantity.getText().trim().isEmpty() || txt_period.getText().trim().isEmpty()) {
//            String message
//            JOptionPane.showMessageDialog(this, message);
//            return false;
//        }
//    }
    private void but_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_but_cancelActionPerformed

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        checkFormatQuantity();
    }//GEN-LAST:event_txt_quantityActionPerformed

    private void txt_periodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_periodActionPerformed
        // TODO add your handling code here:
        checkPeriod();
    }//GEN-LAST:event_txt_periodActionPerformed

    private final JLabel[] stars = new javax.swing.JLabel[5];
    private final ImageIcon starFilled;
    private final ImageIcon starEmpty;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bookimage;
    private javax.swing.JButton but_borrow;
    private javax.swing.JButton but_cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbidphong;
    private javax.swing.JTextField txt_period;
    private javax.swing.JTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
