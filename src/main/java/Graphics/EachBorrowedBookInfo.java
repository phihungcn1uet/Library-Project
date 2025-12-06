package Graphics;

import Database.BookDAO;
import Database.LoanDAO;
import Model.*;
import java.awt.FlowLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author admin
 */
public class EachBorrowedBookInfo extends javax.swing.JFrame {

    private Loan loan;
    private Book book;
    private String returnDate;
    private String borrowingPeriod;

    /**
     * Creates new form EachBorrowedBookInfo
     * @param l
     */
    public EachBorrowedBookInfo(Loan l) {
        loan = l;
        book = BookDAO.getBookById(l.getBookId());
        if (loan.getReturnDate() == null) {
            returnDate = loan.formatDateTime(LocalDateTime.now());
            borrowingPeriod = ChronoUnit.DAYS.between(loan.getBorrowDate(), LocalDateTime.now()) + " ngày";
        } else {
            returnDate = loan.formatDateTime(loan.getReturnDate());
            borrowingPeriod = ChronoUnit.DAYS.between(loan.getBorrowDate(), loan.getReturnDate()) + " ngày";
        }
        // star set
        starFilled = new ImageIcon(getClass().getClassLoader().getResource("Icon/FilledStar.jpg"));
        starEmpty = new ImageIcon(getClass().getClassLoader().getResource("Icon/EmptyStar.jpg"));

        initComponents();
        initStars();
        this.setLocationRelativeTo(null);
    }

    private int selectedStars = -1; // Lưu trạng thái ngôi sao đã chọn (-1 = chưa chọn)

    private void initStars() {
        jPanel5.setLayout(new FlowLayout()); // Đảm bảo layout ngang
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new javax.swing.JLabel();
            stars[i].setIcon(starEmpty); // Mặc định: Biểu tượng sao trống
            stars[i].setPreferredSize(new java.awt.Dimension(50, 50)); // Kích thước mỗi sao 50x50 pixel
            stars[i].setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa icon

            final int index = i; // Biến cục bộ để xác định sao hiện tại
            stars[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Hiển thị các sao đã được chọn khi chuột đi qua
                    for (int j = 0; j <= index; j++) {
                        stars[j].setIcon(starFilled); // Đổi icon cho các sao được highlight
                    }
                    for (int j = index + 1; j < stars.length; j++) {
                        stars[j].setIcon(starEmpty); // Các sao sau index không được chọn
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Trở lại trạng thái theo số sao đã chọn
                    for (int j = 0; j < stars.length; j++) {
                        if (j <= selectedStars) {
                            stars[j].setIcon(starFilled); // Hiển thị các sao đã chọn
                        } else {
                            stars[j].setIcon(starEmpty); // Các sao còn lại là trống
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    // Ghi nhận số sao đã chọn
                    selectedStars = index;
                    for (int j = 0; j <= selectedStars; j++) {
                        stars[j].setIcon(starFilled); // Giữ nguyên icon sao được chọn
                    }
                    for (int j = selectedStars + 1; j < stars.length; j++) {
                        stars[j].setIcon(starEmpty); // Các sao sau đó sẽ là trống
                    }
                }
            });

            jPanel5.add(stars[i]); // Thêm sao vào panel
        }

        jPanel5.revalidate(); // Làm mới panel để cập nhật giao diện
        jPanel5.repaint();    // Vẽ lại giao diện
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_tacGia = new javax.swing.JLabel();
        txt_theLoai = new javax.swing.JLabel();
        btn_bookBack = new javax.swing.JButton();
        but_cancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_tenSach = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_thoiGianMuon = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_ngayTra = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_ngayMuon = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_soLuong = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Trả Sách");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Thể Loại");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tác giả");

        txt_tacGia.setText(book.getAuthor());

        txt_theLoai.setText(book.getCategory());

        btn_bookBack.setText("Trả");
        btn_bookBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bookBackActionPerformed(evt);
            }
        });

        but_cancel.setText("Hủy");
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

        txt_tenSach.setText(book.getName());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Thời gian đã mượn");

        txt_thoiGianMuon.setText(this.borrowingPeriod);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Ngày trả");

        txt_ngayTra.setText(this.returnDate);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Ngày mượn");

        txt_ngayMuon.setText(loan.formatDateTime(loan.getBorrowDate()));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Số lượng");

        txt_soLuong.setText(loan.getQuantity() + "");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Đánh giá");

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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        if(book.getImage() == null){
            jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/bookRepresentMini.png"))); // NOI18N
        }else{
            jLabel8.setIcon(Function.loadBookImage(195, 170, book.getImage()));
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_tacGia, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_theLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_tenSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_thoiGianMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel2)
                                                .addComponent(txt_soLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                                .addComponent(txt_ngayMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_ngayTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel8))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btn_bookBack, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(but_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_soLuong)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_ngayMuon)
                                    .addComponent(jLabel13))
                                .addGap(13, 13, 13)
                                .addComponent(txt_ngayTra))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_thoiGianMuon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_tenSach))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_theLoai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_tacGia)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_cancel)
                    .addComponent(btn_bookBack))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void but_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_but_cancelActionPerformed

    private void btn_bookBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bookBackActionPerformed
        if (loan.getReturnDate() == null) {
            book.setQuantity(book.getQuantity() + Integer.parseInt(txt_soLuong.getText())); // tang so luong sach sua khi tra
            loan.setReturnDate(LocalDateTime.now());
            BookDAO.borrowBook(book, -Integer.parseInt(txt_soLuong.getText()));
            boolean kq = LoanDAO.returnBook(loan);
            LoanDAO.rateBook(loan.getLoanID(), (float) 1.0 * (selectedStars + 1));
            BookDAO.updateStar(book);
            if (kq == true) {
                JOptionPane.showMessageDialog(this, "Trả sách thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Trả sách không thành công");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sách đã được trả trước đó!");
        }
    }//GEN-LAST:event_btn_bookBackActionPerformed

    private javax.swing.JLabel[] stars = new javax.swing.JLabel[5];
    private ImageIcon starFilled;
    private ImageIcon starEmpty;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bookBack;
    private javax.swing.JButton but_cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel txt_ngayMuon;
    private javax.swing.JLabel txt_ngayTra;
    private javax.swing.JLabel txt_soLuong;
    private javax.swing.JLabel txt_tacGia;
    private javax.swing.JLabel txt_tenSach;
    private javax.swing.JLabel txt_theLoai;
    private javax.swing.JLabel txt_thoiGianMuon;
    // End of variables declaration//GEN-END:variables
}
