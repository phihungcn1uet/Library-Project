package Graphics;

import Database.BookDAO;
import Database.LoanDAO;
import Model.Book;
import Model.BookFactory;
import Model.Function;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author admin
 */
public class BookManagement extends javax.swing.JFrame {

    Vector<String> tblTitle = new Vector<>();
    ArrayList<Book> book_list = BookDAO.getBookList();

    public BookManagement() {
        initComponents();
        this.setVisible(true);//make frame visible
        addTitle();
//        loadBookArrayList();
        loadBookArrayListSteam();
        this.setLocationRelativeTo(null);
    }

    private final ExecutorService executor = Executors.newCachedThreadPool();

    private void loadBookArrayListSteam() {
        executor.submit(this::loadBookArrayList);
    }

    private void addTitle() {
        tblTitle.add("Mã Sách");
        tblTitle.add("Tên sách");
        tblTitle.add("Tác giả");
        tblTitle.add("Thể loại");
        tblTitle.add("Số lượng");

        // Khởi tạo DefaultTableModel với tiêu đề cột từ tblTitle và 0 dòng dữ liệu ban đầu
        DefaultTableModel model = new DefaultTableModel(tblTitle, 0);

        // Đặt mô hình này cho bảng BookList
        BookList.setModel(model);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BookList = new javax.swing.JTable();
        txt_bookName = new javax.swing.JTextField();
        txt_quantity = new javax.swing.JTextField();
        txt_authorName = new javax.swing.JTextField();
        but_erase = new javax.swing.JButton();
        but_repair = new javax.swing.JButton();
        but_addBook = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_bookType = new javax.swing.JComboBox<>();
        but_back = new javax.swing.JButton();
        bookWantSearch = new javax.swing.JTextField();
        searchType = new javax.swing.JComboBox<>();
        but_search = new javax.swing.JButton();
        but_importImage = new javax.swing.JButton();
        label_Image = new javax.swing.JLabel();
        label_Image1 = new javax.swing.JLabel();
        but_userWhoBorrowBook = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 64, 94));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên Sách");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Số lượng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên Tác Giả");

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

        txt_bookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookNameActionPerformed(evt);
            }
        });

        txt_authorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_authorNameActionPerformed(evt);
            }
        });

        but_erase.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        but_erase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/trash.png"))); // NOI18N
        but_erase.setText("XÓA");
        but_erase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_eraseActionPerformed(evt);
            }
        });

        but_repair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        but_repair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/update.png"))); // NOI18N
        but_repair.setText("SỬA");
        but_repair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_repairActionPerformed(evt);
            }
        });

        but_addBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        but_addBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/add.png"))); // NOI18N
        but_addBook.setText("THÊM");
        but_addBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_addBookActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Loại sách");

        txt_bookType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sách giáo trình", "Sách tham khảo", "Sách Lịch Sử", "Truyện", "Văn học", " " }));
        txt_bookType.setToolTipText("");
        txt_bookType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookTypeActionPerformed(evt);
            }
        });

        but_back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        but_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout.png"))); // NOI18N
        but_back.setText("QUAY LẠI");
        but_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_backActionPerformed(evt);
            }
        });

        bookWantSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookWantSearchActionPerformed(evt);
            }
        });

        searchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo mã sách", "Theo tên sách" }));

        but_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        but_search.setText("TÌM KIẾM");
        but_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_searchActionPerformed(evt);
            }
        });

        but_importImage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        but_importImage.setForeground(new java.awt.Color(255, 0, 0));
        but_importImage.setText("NHẬP ẢNH");
        but_importImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_importImageActionPerformed(evt);
            }
        });

        label_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/bookRepresentMini.png"))); // NOI18N

        but_userWhoBorrowBook.setText("Xem người đã mượn");
        but_userWhoBorrowBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_userWhoBorrowBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(bookWantSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_bookType, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_bookName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(84, 84, 84)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)))
                            .addComponent(but_userWhoBorrowBook, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(but_search)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(but_addBook, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(but_repair, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(but_erase, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(but_back))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_authorName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(but_importImage, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(label_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(463, Short.MAX_VALUE)
                    .addComponent(label_Image1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(443, 443, 443)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(txt_bookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_authorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_bookType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(but_importImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookWantSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_addBook)
                    .addComponent(but_erase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(but_repair, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_back)
                    .addComponent(but_userWhoBorrowBook))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(228, Short.MAX_VALUE)
                    .addComponent(label_Image1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(209, 209, 209)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void but_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_backActionPerformed
        dispose();
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
    }//GEN-LAST:event_but_backActionPerformed

    private void txt_bookTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookTypeActionPerformed

    }//GEN-LAST:event_txt_bookTypeActionPerformed

    private void but_addBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_addBookActionPerformed
        String bookName = txt_bookName.getText();
        String authorName = txt_authorName.getText();
        int quantity = Integer.parseInt(txt_quantity.getText());
        String bookType = txt_bookType.getSelectedItem().toString();

        // Gọi hàm trong lớp BookDAO để thêm sách vào cơ sở dữ liệu
        Book book = BookFactory.getBook(bookType);
        book.setName(bookName);
        book.setAuthor(authorName);
        book.setQuantity(quantity);
        book.setImage(imageBytes);
        boolean success = BookDAO.addBook(book);

        if (success) {
            JOptionPane.showMessageDialog(this, "Thêm sách thành công!");
            loadBookArrayList(); // Tải lại danh sách sách
        } else {
            JOptionPane.showMessageDialog(this, "Thêm sách thất bại!");
        }
        txt_bookName.setText("");
        txt_authorName.setText("");
        txt_quantity.setText("");
        txt_bookType.setSelectedItem("");
        imageBytes = null;
        ImageIcon iconRepresent = new ImageIcon(getClass().getClassLoader().getResource("Icon/bookRepresentMini.png"));
        label_Image.setIcon(iconRepresent);

    }//GEN-LAST:event_but_addBookActionPerformed

    private void but_repairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_repairActionPerformed
        int selectedRow = BookList.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần sửa!");
            return;
        }

        String bookName = txt_bookName.getText();
        String authorName = txt_authorName.getText();
        int quantity = Integer.parseInt(txt_quantity.getText());
        String bookType = txt_bookType.getSelectedItem().toString();
        String bookId = BookList.getValueAt(selectedRow, 0).toString(); // Giả sử cột đầu tiên là mã sách

        // Gọi hàm trong lớp BookDAO để sửa sách trong cơ sở dữ liệu
        Book book = BookFactory.getBook(bookType);
        book.setId(bookId);
        book.setName(bookName);
        book.setAuthor(authorName);
        book.setQuantity(quantity);
        book.setImage(imageBytes);
        boolean success = BookDAO.repairBook(book);

        if (success) {
            JOptionPane.showMessageDialog(this, "Sửa sách thành công!");
            loadBookArrayList(); // Tải lại danh sách sách   
        } else {
            JOptionPane.showMessageDialog(this, "Sửa sách thất bại!");
        }
        txt_bookName.setText("");
        txt_authorName.setText("");
        txt_quantity.setText("");
        txt_bookType.setSelectedItem("");
        imageBytes = null;
        ImageIcon iconRepresent = new ImageIcon(getClass().getClassLoader().getResource("Icon/bookRepresentMini.png"));
        label_Image.setIcon(iconRepresent);
    }//GEN-LAST:event_but_repairActionPerformed

    private void but_eraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_eraseActionPerformed
        int selectedRow = BookList.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần xóa!");
            return;
        }

        String bookId = BookList.getValueAt(selectedRow, 0).toString(); // Giả sử cột đầu tiên là mã sách

        // Gọi hàm trong lớp BookDAO để xóa sách khỏi cơ sở dữ liệu
        if (!LoanDAO.borrowingUserList(bookId).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sách không thể xóa do có người đang mượn!");
        } else {
            boolean success = BookDAO.removeBook(bookId);

            if (success) {
                JOptionPane.showMessageDialog(this, "Xóa sách thành công!");
                loadBookArrayList(); // Tải lại danh sách sách
            } else {
                JOptionPane.showMessageDialog(this, "Xóa sách thất bại!");
            }
            txt_bookName.setText("");
            txt_authorName.setText("");
            txt_quantity.setText("");
            txt_bookType.setSelectedItem("");
            imageBytes = null;
            ImageIcon iconRepresent = new ImageIcon(getClass().getClassLoader().getResource("Icon/bookRepresentMini.png"));
            label_Image.setIcon(iconRepresent);
        }
    }//GEN-LAST:event_but_eraseActionPerformed

    private void BookListMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = BookList.getSelectedRow();

        if (selectedRow != -1) {
            String bookId = BookList.getValueAt(selectedRow, 0).toString();
            Book b = BookDAO.getBookById(bookId);

            if (b != null) {
                txt_bookName.setText(b.getName());
                txt_authorName.setText(b.getAuthor());
                txt_quantity.setText(String.valueOf(b.getQuantity()));
                txt_bookType.setSelectedItem(b.getCategory());
                idOfChoosenBook = b.getId();
                imageBytes = b.getImage();
                ImageIcon bookImage = Function.loadBookImage(220, 220, imageBytes);
                label_Image.setIcon(bookImage);
            }
        }
    }

    private void txt_bookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookNameActionPerformed

    private void bookWantSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookWantSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookWantSearchActionPerformed

    private void txt_authorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_authorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authorNameActionPerformed

    private void but_importImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_importImageActionPerformed
        // Mở hộp thoại chọn file
        final JFileChooser fileDialog = new JFileChooser();
        fileDialog.setDialogTitle("Select an Image File");

        // Chỉ cho phép chọn các file ảnh
        fileDialog.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));

        int returnVal = fileDialog.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            java.io.File file = fileDialog.getSelectedFile();

            // Kiểm tra file có hợp lệ hay không
            if (file != null && file.getName().matches(".*\\.(jpg|png|jpeg)$")) {
                try {
                    // Lấy đường dẫn file
                    String url = file.getAbsolutePath();

                    // Đọc file ảnh thành mảng byte
                    FileInputStream fileInputStream = new FileInputStream(file);
                    imageBytes = new byte[(int) file.length()];
                    fileInputStream.read(imageBytes);
                    fileInputStream.close();
                    // Tạo ImageIcon và chỉnh kích thước ảnh
                    ImageIcon imageIcon = new ImageIcon(url);
                    Image image = imageIcon.getImage();
                    Image newimg = image.getScaledInstance(220, 220, java.awt.Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(newimg);

                    // Hiển thị ảnh trên label
                    label_Image.setIcon(imageIcon);
                } catch (Exception e) {
                    // Thông báo lỗi nếu không thể tải ảnh
                    JOptionPane.showMessageDialog(this, "Failed to load the image. Please try again!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Thông báo nếu file không hợp lệ
                JOptionPane.showMessageDialog(this, "Please select a valid image file (jpg, png, jpeg)!", "Invalid File", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_but_importImageActionPerformed

    private void but_userWhoBorrowBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_userWhoBorrowBookActionPerformed
        // TODO add your handling code here:
        if (txt_bookName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            new UserWhoBorrowBook(idOfChoosenBook).setVisible(true);
        }
    }//GEN-LAST:event_but_userWhoBorrowBookActionPerformed

    private void loadBookArrayList() {
        ArrayList<Book> bookArrayList = BookDAO.getBookList();
        updateBookTable(bookArrayList);
    }

    private void updateBookTable(ArrayList<Book> bookArrayList) {
        DefaultTableModel model = (DefaultTableModel) BookList.getModel();
        model.setRowCount(0); // Xóa tất cả hàng hiện tại

        for (Book book : bookArrayList) {
            Object[] row = new Object[]{book.getId(), book.getName(), book.getAuthor(), book.getCategory(), book.getQuantity()};
            model.addRow(row);
        }
    }

    /**
     *
     * @param imageData
     * @return
     */
    public ImageIcon byteArrayToImageIcon(byte[] imageData) {
        if (imageData == null || imageData.length == 0) {
            return null; // Nếu mảng byte rỗng hoặc null, trả về null
        }

        // Chuyển mảng byte thành InputStream
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageData);
        // Tạo ImageIcon từ InputStream
        ImageIcon imageIcon = new ImageIcon(byteArrayInputStream.readAllBytes());
        return imageIcon;
    }
    private byte[] imageBytes;
    private String idOfChoosenBook = "";

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BookList;
    private javax.swing.JTextField bookWantSearch;
    private javax.swing.JButton but_addBook;
    private javax.swing.JButton but_back;
    private javax.swing.JButton but_erase;
    private javax.swing.JButton but_importImage;
    private javax.swing.JButton but_repair;
    private javax.swing.JButton but_search;
    private javax.swing.JButton but_userWhoBorrowBook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_Image;
    private javax.swing.JLabel label_Image1;
    private javax.swing.JComboBox<String> searchType;
    private javax.swing.JTextField txt_authorName;
    private javax.swing.JTextField txt_bookName;
    private javax.swing.JComboBox<String> txt_bookType;
    private javax.swing.JTextField txt_quantity;
    // End of variables declaration//GEN-END:variables

}
