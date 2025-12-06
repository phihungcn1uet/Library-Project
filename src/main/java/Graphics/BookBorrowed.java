package Graphics;

import Database.BookDAO;
import Database.LoanDAO;
import Model.Book;
import Model.Loan;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class BookBorrowed extends javax.swing.JFrame {
    Vector <String> tblTitle = new Vector<>();
    ArrayList<Loan> loan_list;

    /**
     *
     */
    public BookBorrowed() {
        initComponents();
        loan_list = LoanDAO.getLoanList(StartMenu.id);
        this.setVisible(true);
        setHoverButtonAndDesign();
        addTitle();
        loadBookArrayList();
        this.setLocationRelativeTo(null);
    }
    
    private void addTitle() {
        tblTitle.add("Mã giao dịch");
        tblTitle.add("Tên sách");
        tblTitle.add("Tác giả");
        tblTitle.add("Thời gian mượn");
        tblTitle.add("Số lượng mượn");
        tblTitle.add("Thời hạn");
        tblTitle.add("Trạng thái");


        // Khởi tạo DefaultTableModel với tiêu đề cột từ tblTitle và 0 dòng dữ liệu ban đầu
        DefaultTableModel model = new DefaultTableModel(tblTitle, 0);

        // Đặt mô hình này cho bảng BookList
        BookList.setModel(model);
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BookList = new javax.swing.JTable();
        key = new javax.swing.JTextField();
        searchType = new javax.swing.JComboBox<>();
        but_search = new javax.swing.JButton();
        bookType = new javax.swing.JComboBox<>();
        but_back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 64, 93));

        BookList.setModel(new javax.swing.table.DefaultTableModel(
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
        BookList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BookList);

        key.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyActionPerformed(evt);
            }
        });

        searchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo ngày mượn", "Theo tên sách" }));
        searchType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTypeActionPerformed(evt);
            }
        });

        but_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        but_search.setText("TÌM KIẾM");
        but_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_searchActionPerformed(evt);
            }
        });

        bookType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Sách đang mượn", "Sách đã trả", " ", " " }));

        but_back.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        but_back.setForeground(new java.awt.Color(255, 255, 255));
        but_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/back.png"))); // NOI18N
        but_back.setText("  Quay lại");
        but_back.setRequestFocusEnabled(false);
        but_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                but_backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(bookType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(but_search)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(but_back, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(but_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(but_back, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookListMouseClicked
        int selectedRow = BookList.getSelectedRow();
        int LoanId = Integer.parseInt(BookList.getValueAt(selectedRow, 0).toString()); // Giả sử cột đầu tiên là mã sách
        Loan loan = LoanDAO.getLoan(LoanId);
        EachBorrowedBookInfo bookBorrowed = new EachBorrowedBookInfo(loan);
        bookBorrowed.setVisible(true);
        bookBorrowed.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                loadBookArrayList(); // Gọi phương thức loadbookArrayList sau khi cửa sổ đóng
            }
        });

        bookBorrowed.setVisible(true);
    }//GEN-LAST:event_BookListMouseClicked

    private void keyActionPerformed(java.awt.event.ActionEvent evt) {
    }//GEN-LAST:event_keyActionPerformed

    private void but_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_searchActionPerformed
        // Thực hiện chức năng tìm kiếm sách
        String keyword = key.getText().trim();
        String SearchType = searchType.getSelectedItem().toString();
        String LoaiSach = bookType.getSelectedItem().toString();
        ArrayList<Loan> result = SearchLoan(SearchType, keyword, LoaiSach);
        
        // Hiển thị kết quả tìm kiếm trên bảng
        updateBookTable(result);
    }//GEN-LAST:event_but_searchActionPerformed

    private void but_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_but_backMouseClicked
        this.dispose();
        dispose();
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
    }//GEN-LAST:event_but_backMouseClicked

    private void searchTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTypeActionPerformed

    private ArrayList<Loan> SearchLoan(String searchType, String keyword, String loaiSach) {
        ArrayList<Loan> loans = new ArrayList<>();
        
        if (loaiSach.equals("Sách đang mượn")) {
            loan_list = LoanDAO.BookBorrowingList(StartMenu.id);
        } else if (loaiSach.equals("Sách đã trả")) {
            loan_list = LoanDAO.BookBorrowedList(StartMenu.id);
        } else if (loaiSach.equals("Tất cả")) {
            loan_list = LoanDAO.getLoanList(StartMenu.id);
        }

        keyword = keyword.trim();
        if (keyword == null || keyword.isEmpty()) return loan_list;

        for (Loan loan : loan_list) {
            if (searchType.equals("Theo ngày mượn")) {
                String date = loan.formatDate(loan.getBorrowDate());
                if (keyword.equals(date)) loans.add(loan);
            } else if (searchType.equals("Theo tên sách")) {
                keyword = keyword.toLowerCase();
                String name = BookDAO.getBookById(loan.getBookId()).getName();
                name = name.toLowerCase();
                if (name.contains(keyword)) {
                    loans.add(loan);
                }
            }
        }
        return loans;
    }

    private void loadBookArrayList() {
        loan_list = LoanDAO.getLoanList(StartMenu.id);
        updateBookTable(loan_list);
    }

    private void updateBookTable(ArrayList<Loan> bookArrayList) {
        DefaultTableModel model = (DefaultTableModel) BookList.getModel();
        model.setRowCount(0); // Xóa tất cả hàng hiện tại

        for (Loan loan : bookArrayList) {
            Book book = BookDAO.getBookById(loan.getBookId());
            String s = loan.getStatus();
            
            Object[] row = new Object[]{loan.getLoanID(), book.getName(), book.getAuthor(), 
                            loan.formatDateTime(loan.getBorrowDate()), loan.getQuantity(), loan.getLoanPeriod() + " ngày", s};
            model.addRow(row);
        }
    }

    private Color chooseColor = Color.decode("#006699");
    
    private void setHoverButtonAndDesign() {
        but_back.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        but_back.setOpaque(true);
        but_back.setBackground(Color.decode("#00405d"));
        but_back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!but_back.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_back.setBackground(chooseColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!but_back.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_back.setBackground(Color.decode("#00405d"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                but_back.setBackground(Color.decode("#99FFCC"));
                but_back.setBackground(Color.decode("#00405d"));
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BookList;
    private javax.swing.JComboBox<String> bookType;
    private javax.swing.JLabel but_back;
    private javax.swing.JButton but_search;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField key;
    private javax.swing.JComboBox<String> searchType;
    // End of variables declaration//GEN-END:variables
}
