
package Graphics;
import java.awt.BorderLayout;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import Database.*;
import java.awt.Color;
import java.awt.Font;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;

/**
 *
 * @author admin
 */
public class Statistic extends javax.swing.JFrame {
    
    /**
     *
     */
    public Statistic() { 
        initComponents();
        this.setLocationRelativeTo(null);
        this.categoryPieChart(jPanel3);
        mostBorrowedBook(jPanel_2);
        mostBorrowingUser(jPanel1);
    }
    private void categoryPieChart(JPanel panel) {
        // Tạo dữ liệu cho Pie Chart
        Map<String, Integer> mp = BookDAO.calculateCategoryPercentage();
        DefaultPieDataset dataset = new DefaultPieDataset();

        // Thêm dữ liệu vào dataset
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        // Tạo biểu đồ Pie Chart
        JFreeChart chart = ChartFactory.createPieChart(
                "Category Statistics",  // Tiêu đề biểu đồ
                dataset,                // Dữ liệu
                true,                   // Hiển thị chú thích (legend)
                true,                   // Tooltips
                false                   // URLs
        );

        // Tùy chỉnh hiển thị số lượng trên từng phần của Pie Chart
        PiePlot plot = (PiePlot) chart.getPlot();

        // Sử dụng StandardPieSectionLabelGenerator để hiển thị tên và số lượng sách
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})"));

        // Căn chỉnh văn bản label tại vị trí giữa phần của Pie
        plot.setLabelGap(0.02);  // Điều chỉnh khoảng cách giữa label và phần của Pie

        // Tùy chỉnh cách hiển thị số lượng
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setLabelPaint(Color.BLACK);
        plot.setLabelBackgroundPaint(Color.WHITE);
        plot.setLabelOutlinePaint(Color.GRAY);
        plot.setLabelShadowPaint(Color.GRAY);

        // Hiển thị biểu đồ trong ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(420, 300));

        // Thêm ChartPanel vào JPanel
        panel.setLayout(new BorderLayout());  // Sử dụng BorderLayout để tối ưu hóa không gian
        panel.add(chartPanel, BorderLayout.CENTER);
    }
    
    private void mostBorrowedBook(JPanel panel) {
        // Tạo dữ liệu cho Pie Chart
        Map<String, Integer> mp = LoanDAO.calculateHowManyUserBorrowThisBookPercentage();
        DefaultPieDataset dataset = new DefaultPieDataset();

        // Thêm dữ liệu vào dataset
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        // Tạo biểu đồ Pie Chart
        JFreeChart chart = ChartFactory.createPieChart(
                "Most Borrowed Book Statistics",  // Tiêu đề biểu đồ
                dataset,                // Dữ liệu
                true,                   // Hiển thị chú thích (legend)
                true,                   // Tooltips
                false                   // URLs
        );

        // Tùy chỉnh hiển thị số lượng trên từng phần của Pie Chart
        PiePlot plot = (PiePlot) chart.getPlot();

        // Sử dụng StandardPieSectionLabelGenerator để hiển thị tên và số lượng sách
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})"));

        // Căn chỉnh văn bản label tại vị trí giữa phần của Pie
        plot.setLabelGap(0.02);  // Điều chỉnh khoảng cách giữa label và phần của Pie

        // Tùy chỉnh cách hiển thị số lượng
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setLabelPaint(Color.BLACK);
        plot.setLabelBackgroundPaint(Color.WHITE);
        plot.setLabelOutlinePaint(Color.GRAY);
        plot.setLabelShadowPaint(Color.GRAY);

        // Hiển thị biểu đồ trong ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(490, 350));

        // Thêm ChartPanel vào JPanel
        panel.setLayout(new BorderLayout());  // Sử dụng BorderLayout để tối ưu hóa không gian
        panel.add(chartPanel, BorderLayout.CENTER);
    }
    
    private void mostBorrowingUser(JPanel panel) {
        // Tạo dữ liệu cho Pie Chart
        Map<String, Integer> mp = LoanDAO.calculateEachUserBorrowHowManyBookPercentage();
        DefaultPieDataset dataset = new DefaultPieDataset();

        // Thêm dữ liệu vào dataset
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        // Tạo biểu đồ Pie Chart
        JFreeChart chart = ChartFactory.createPieChart(
                "Most Borrowing User Statistics",  // Tiêu đề biểu đồ
                dataset,                // Dữ liệu
                true,                   // Hiển thị chú thích (legend)
                true,                   // Tooltips
                false                   // URLs
        );

        // Tùy chỉnh hiển thị số lượng trên từng phần của Pie Chart
        PiePlot plot = (PiePlot) chart.getPlot();

        // Sử dụng StandardPieSectionLabelGenerator để hiển thị tên và số lượng sách
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})"));

        // Căn chỉnh văn bản label tại vị trí giữa phần của Pie
        plot.setLabelGap(0.02);  // Điều chỉnh khoảng cách giữa label và phần của Pie

        // Tùy chỉnh cách hiển thị số lượng
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setLabelPaint(Color.BLACK);
        plot.setLabelBackgroundPaint(Color.WHITE);
        plot.setLabelOutlinePaint(Color.GRAY);
        plot.setLabelShadowPaint(Color.GRAY);

        // Hiển thị biểu đồ trong ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(420, 300));

        // Thêm ChartPanel vào JPanel
        panel.setLayout(new BorderLayout());  // Sử dụng BorderLayout để tối ưu hóa không gian
        panel.add(chartPanel, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel_2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel_2Layout = new javax.swing.GroupLayout(jPanel_2);
        jPanel_2.setLayout(jPanel_2Layout);
        jPanel_2Layout.setHorizontalGroup(
            jPanel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel_2Layout.setVerticalGroup(
            jPanel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 504, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jPanel_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(646, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(654, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(394, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jPanel_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(384, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(318, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_2;
    // End of variables declaration//GEN-END:variables
}
