package Graphics;

import Database.BookDAO;
import Database.UserDAO;
import Model.*;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author admin
 */
public class MainMenu extends javax.swing.JFrame {

    Vector <String> tblTitle = new Vector<>();
    ArrayList<Book> book_list;

    /**
     *
     */
    public static User user;

    /**
     *
     */
    public MainMenu() {
        user = UserDAO.getUserByID(StartMenu.id);
//        loadUserSteam();
        checkBookOverDue();
        initComponents();

        setHoverButtonAndDesign();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        addTitle();
//        loadBookArrayList();
        loadBookArrayListSteam();
        initBooks();

        if (StartMenu.role == 1) {
            but_bookBorrowed.setVisible(false);
            but_personalInfo.setVisible(false);
            but_message.setVisible(false);
        } else if (StartMenu.role == 0) {
            but_userManagement.setVisible(false);
            but_documentManagement.setVisible(false);
            but_statistic.setVisible(false);
        }

    }
    private final ExecutorService executor = Executors.newCachedThreadPool();

    private void loadUserSteam() {
        executor.submit(() -> {
            user = UserDAO.getUserByID(StartMenu.id);
        });
    }

    private void loadBookArrayListSteam() {
        executor.submit(this::loadBookArrayList);
    }

    private void checkBookOverDue() {
        int overDueBook = UserDAO.CheckBookOverDue(user.getIdUser());
        if (overDueBook > 0) {
            user = UserDAO.getUserByID(StartMenu.id);
            lblaccountName2.setText(StartMenu.role == 1 ? "" : "Uy tín: " + user.getPrestige());
            JOptionPane.showMessageDialog(this, "Bạn bị trừ " + overDueBook * 20 + " điểm uy tín do có " + overDueBook + " sách quá hạn !");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        but_statistic = new javax.swing.JLabel();
        but_userManagement = new javax.swing.JLabel();
        lblaccountName = new javax.swing.JLabel();
        but_back = new javax.swing.JLabel();
        but_bookBorrowed = new javax.swing.JLabel();
        but_personalInfo = new javax.swing.JLabel();
        but_changePass = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblaccountName2 = new javax.swing.JLabel();
        lblaccountName3 = new javax.swing.JLabel();
        but_documentManagement = new javax.swing.JLabel();
        but_message = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BookList = new javax.swing.JTable();
        bookWantSearch = new javax.swing.JTextField();
        but_search = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        searchType = new javax.swing.JComboBox<>();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        but_statistic.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        but_statistic.setForeground(new java.awt.Color(255, 255, 255));
        but_statistic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/analytics.png"))); // NOI18N
        but_statistic.setText("Thống kê");
        but_statistic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                but_statisticMouseClicked(evt);
            }
        });

        but_userManagement.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        but_userManagement.setForeground(new java.awt.Color(255, 255, 255));
        but_userManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/team.png"))); // NOI18N
        but_userManagement.setText("  Quản lý người dùng");
        but_userManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                but_userManagementMouseClicked(evt);
            }
        });

        lblaccountName.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblaccountName.setForeground(new java.awt.Color(255, 255, 255));
        lblaccountName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblaccountName.setText("Xin chào");

        but_back.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        but_back.setForeground(new java.awt.Color(255, 255, 255));
        but_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/emergency-exit.png"))); // NOI18N
        but_back.setText("  Thoát");
        but_back.setRequestFocusEnabled(false);
        but_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                but_backMouseClicked(evt);
            }
        });

        but_bookBorrowed.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        but_bookBorrowed.setForeground(new java.awt.Color(255, 255, 255));
        but_bookBorrowed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/borrow.png"))); // NOI18N
        but_bookBorrowed.setText("  Quản lí sách mượn");
        but_bookBorrowed.setRequestFocusEnabled(false);
        but_bookBorrowed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                but_bookBorrowedMouseClicked(evt);
            }
        });

        but_personalInfo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        but_personalInfo.setForeground(new java.awt.Color(255, 255, 255));
        but_personalInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/person.png"))); // NOI18N
        but_personalInfo.setText("  Thông tin người dùng");
        but_personalInfo.setRequestFocusEnabled(false);
        but_personalInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                but_personalInfoMouseClicked(evt);
            }
        });

        but_changePass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        but_changePass.setForeground(new java.awt.Color(255, 255, 255));
        but_changePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/lock.png"))); // NOI18N
        but_changePass.setText("  Đổi mật khẩu");
        but_changePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                but_changePassMouseClicked(evt);
            }
        });

        lblaccountName2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblaccountName2.setForeground(new java.awt.Color(255, 255, 255));
        lblaccountName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblaccountName2.setText(StartMenu.role == 1 ? "" : "Uy tín: " + user.getPrestige());

        lblaccountName3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblaccountName3.setForeground(new java.awt.Color(255, 255, 255));
        lblaccountName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblaccountName3.setText(user.getUserName());

        but_documentManagement.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        but_documentManagement.setForeground(new java.awt.Color(255, 255, 255));
        but_documentManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/briefcase.png"))); // NOI18N
        but_documentManagement.setText("  Quản lý tài liệu");
        but_documentManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                but_documentManagementMouseClicked(evt);
            }
        });

        but_message.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        but_message.setForeground(new java.awt.Color(255, 255, 255));
        but_message.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/comments.png"))); // NOI18N
        but_message.setText("Tin nhắn");
        but_message.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                but_messageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblaccountName, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblaccountName3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblaccountName2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(but_message, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(but_statistic, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(but_userManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(but_personalInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(but_bookBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(but_documentManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(but_changePass, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(but_back, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblaccountName)
                .addGap(8, 8, 8)
                .addComponent(lblaccountName3)
                .addGap(8, 8, 8)
                .addComponent(lblaccountName2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(but_message, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_statistic, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(but_userManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_personalInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(but_bookBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_documentManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(but_changePass, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(but_back, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setIcon(Function.loadUserImage(210, 260, user.getImage()));

        BookList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên Sách", "Thể Loại"
            }
        ));
        BookList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BookList);

        bookWantSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookWantSearchActionPerformed(evt);
            }
        });

        but_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        but_search.setText("TÌM KIẾM");
        but_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Top những sách được đánh giá cao nhất");

        searchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo tên sách", "Theo thể loại" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bookWantSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(but_search))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookWantSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void but_changePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_but_changePassMouseClicked
        ChangePassword changepassword = new ChangePassword();
        changepassword.setVisible(true);
    }//GEN-LAST:event_but_changePassMouseClicked

    private void initBooks() {
        jPanel5.setLayout(new FlowLayout()); // Đảm bảo layout ngang
        ArrayList<Book> topBooks = BookDAO.getTopSixMostRated();
        ImageIcon originalIcon = new ImageIcon(getClass().getClassLoader().getResource("Icon/bookRepresent.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(130, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        for (int i = 0; i < books.length; i++) {
            books[i] = new javax.swing.JLabel();
            books[i].setPreferredSize(new java.awt.Dimension(125, 100)); // Kích thước mỗi sao 130x100 pixel
            books[i].setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa icon
            if (topBooks.get(i).getImage() == null) {
                books[i].setIcon(resizedIcon);
            } else {
                ImageIcon originalIcon1 = new ImageIcon(topBooks.get(i).getImage());
                Image newImage1 = originalIcon1.getImage().getScaledInstance(130, 100, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon1 = new ImageIcon(newImage1);
                books[i].setIcon(resizedIcon1);
            }
            final int index = i;
            books[i].addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    // Gọi phương thức hiển thị thông tin cuốn sách khi nhấn vào
                    DisplaybookInfo bookInfo = new DisplaybookInfo(topBooks.get(index));
                    bookInfo.setVisible(true);
                    bookInfo.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent e) {
                            loadBookArrayList(); // Gọi phương thức loadbookArrayList sau khi cửa sổ đóng    
                            topBooks.set(index, BookDAO.getBookById(topBooks.get(index).getId()));
                        }
                    });
                }
            });
            jPanel5.add(books[i]); // Thêm sao vào panel
        }
    }

    private void but_personalInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_but_personalInfoMouseClicked
        dispose();
        new PersonalInfo().setVisible(true);
    }//GEN-LAST:event_but_personalInfoMouseClicked

    private void but_bookBorrowedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_but_bookBorrowedMouseClicked
        dispose();
        BookBorrowed bookBorrowed = new BookBorrowed();
        bookBorrowed.setVisible(true);
        bookBorrowed.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                loadBookArrayList(); // Gọi phương thức loadbookArrayList sau khi cửa sổ đóng
            }
        });

        bookBorrowed.setVisible(true);
    }//GEN-LAST:event_but_bookBorrowedMouseClicked

    private void but_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_but_backMouseClicked
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            dispose();
            StartMenu menu = new StartMenu();
            menu.setVisible(true);
        }
    }//GEN-LAST:event_but_backMouseClicked

    private void but_userManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_but_userManagementMouseClicked
        dispose();
        UserManagement management = new UserManagement();
        management.setVisible(true);
    }//GEN-LAST:event_but_userManagementMouseClicked

    private void but_statisticMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_but_statisticMouseClicked

        new Statistic().setVisible(true);
    }//GEN-LAST:event_but_statisticMouseClicked

    private void addTitle() {
        tblTitle.add("Mã sách");
        tblTitle.add("Tên sách");
        tblTitle.add("Tác giả");
        tblTitle.add("Thể loại");
        tblTitle.add("Số lượng");

        // Khởi tạo DefaultTableModel với tiêu đề cột từ tblTitle và 0 dòng dữ liệu ban đầu
        DefaultTableModel model = new DefaultTableModel(tblTitle, 0);

        // Đặt mô hình này cho bảng BookList
        BookList.setModel(model);
    }

    private void BookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookListMouseClicked
        int selectedRow = BookList.getSelectedRow();
        String bookId = BookList.getValueAt(selectedRow, 0).toString(); // Giả sử cột đầu tiên là mã sách
        Book b = BookDAO.getBookById(bookId);
        DisplaybookInfo displaybookInfo = new DisplaybookInfo(b);
        displaybookInfo.setVisible(true);
        displaybookInfo.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                loadBookArrayList(); // Gọi phương thức loadbookArrayList sau khi cửa sổ đóng
            }
        });

        displaybookInfo.setVisible(true);

    }//GEN-LAST:event_BookListMouseClicked

    private void bookWantSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookWantSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookWantSearchActionPerformed

    private void but_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_searchActionPerformed
        // Thực hiện chức năng tìm kiếm sách
        String keyword = bookWantSearch.getText().trim();
        String SearchType = searchType.getSelectedItem().toString();
        ArrayList<Book> result = null;

        if (keyword.isEmpty()) {
            result = BookDAO.getBookList();
        } else {
            result = BookDAO.searchBookList(SearchType, keyword);
        }

        // Hiển thị kết quả tìm kiếm trên bảng
        updateBookTable(result);
    }//GEN-LAST:event_but_searchActionPerformed

    private void searchTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTypeActionPerformed

    private void but_documentManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_but_documentManagementMouseClicked
        // TODO add your handling code here:
        dispose();
        new BookManagement().setVisible(true);
    }//GEN-LAST:event_but_documentManagementMouseClicked

    private void but_messageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_but_messageMouseClicked
        // TODO add your handling code here:
        new Message(StartMenu.id).setVisible(true);
    }//GEN-LAST:event_but_messageMouseClicked
    private void loadBookArrayList() {
        book_list = BookDAO.getBookList();
        updateBookTable(book_list);
    }

    private void updateBookTable(ArrayList<Book> bookArrayList) {
        DefaultTableModel model = (DefaultTableModel) BookList.getModel();
        model.setRowCount(0); // Xóa tất cả hàng hiện tại

        for (Book book : bookArrayList) {
            Object[] row = new Object[]{book.getId(), book.getName(), book.getAuthor(), book.getCategory(), book.getQuantity()};
            model.addRow(row);
        }
    }

    private final Color chooseColor = Color.decode("#006699");

    private void setHoverButtonAndDesign() {
        but_back.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        but_changePass.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        but_userManagement.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        but_statistic.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        but_bookBorrowed.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        but_personalInfo.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        but_documentManagement.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        but_message.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        but_statistic.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));

        but_changePass.setOpaque(true);
        but_changePass.setBackground(Color.decode("#006666"));
        but_changePass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!but_changePass.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_changePass.setBackground(chooseColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!but_changePass.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_changePass.setBackground(Color.decode("#006666"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                but_changePass.setBackground(Color.decode("#99FFCC"));
                but_changePass.setBackground(Color.decode("#006666"));
            }
        });
        //-------------------------------------------------------------------------------
        but_back.setOpaque(true);
        but_back.setBackground(Color.decode("#006666"));
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
                    but_back.setBackground(Color.decode("#006666"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                but_back.setBackground(Color.decode("#99FFCC"));
                but_back.setBackground(Color.decode("#006666"));
            }
        });
        //---------------------------------------------------------------------------
        but_userManagement.setOpaque(true);
        but_userManagement.setBackground(Color.decode("#006666"));
        but_userManagement.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!but_userManagement.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_userManagement.setBackground(chooseColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!but_userManagement.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_userManagement.setBackground(Color.decode("#006666"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                but_userManagement.setBackground(Color.decode("#99FFCC"));
                but_userManagement.setBackground(Color.decode("#006666"));
            }
        });
        //--------------------------------------------------------------------------
        but_bookBorrowed.setOpaque(true);
        but_bookBorrowed.setBackground(Color.decode("#006666"));
        but_bookBorrowed.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!but_bookBorrowed.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_bookBorrowed.setBackground(chooseColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!but_bookBorrowed.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_bookBorrowed.setBackground(Color.decode("#006666"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                but_bookBorrowed.setBackground(Color.decode("#99FFCC"));
                but_bookBorrowed.setBackground(Color.decode("#006666"));
            }
        });
        //----------------------------------------------------------------------------
        but_statistic.setOpaque(true);
        but_statistic.setBackground(Color.decode("#006666"));
        but_statistic.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!but_statistic.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_statistic.setBackground(chooseColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!but_statistic.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_statistic.setBackground(Color.decode("#006666"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                but_statistic.setBackground(Color.decode("#99FFCC"));
                but_statistic.setBackground(Color.decode("#006666"));
            }
        });
        //-------------------------------------------------------------------------------
        but_personalInfo.setOpaque(true);
        but_personalInfo.setBackground(Color.decode("#006666"));
        but_personalInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!but_personalInfo.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_personalInfo.setBackground(chooseColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!but_personalInfo.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_personalInfo.setBackground(Color.decode("#006666"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                but_personalInfo.setBackground(Color.decode("#99FFCC"));
                but_personalInfo.setBackground(Color.decode("#006666"));
            }
        });
        // Cấu hình cho but_message
        but_message.setOpaque(true);
        but_message.setBackground(Color.decode("#006666"));
        but_message.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!but_message.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_message.setBackground(chooseColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!but_message.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_message.setBackground(Color.decode("#006666"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                but_message.setBackground(Color.decode("#99FFCC"));
                but_message.setBackground(Color.decode("#006666"));
            }
        });
        //--------------------------------------------------------------------------
        but_documentManagement.setOpaque(true);
        but_documentManagement.setBackground(Color.decode("#006666"));
        but_documentManagement.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!but_documentManagement.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_documentManagement.setBackground(chooseColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!but_documentManagement.getBackground().equals(Color.decode("#99FFCC"))) {
                    but_documentManagement.setBackground(Color.decode("#006666"));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                but_documentManagement.setBackground(Color.decode("#99FFCC"));
                but_documentManagement.setBackground(Color.decode("#006666"));
            }
        });
    }

    private javax.swing.JLabel[] books = new javax.swing.JLabel[6];
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BookList;
    private javax.swing.JTextField bookWantSearch;
    private javax.swing.JLabel but_back;
    private javax.swing.JLabel but_bookBorrowed;
    private javax.swing.JLabel but_changePass;
    private javax.swing.JLabel but_documentManagement;
    private javax.swing.JLabel but_message;
    private javax.swing.JLabel but_personalInfo;
    private javax.swing.JButton but_search;
    private javax.swing.JLabel but_statistic;
    private javax.swing.JLabel but_userManagement;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblaccountName;
    private javax.swing.JLabel lblaccountName2;
    private javax.swing.JLabel lblaccountName3;
    private javax.swing.JComboBox<String> searchType;
    // End of variables declaration//GEN-END:variables
}
