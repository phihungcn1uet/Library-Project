# 📚 Library Management System (Phần mềm Quản Lý Thư Viện)

![Java](https://img.shields.io/badge/Java-22-orange) ![Maven](https://img.shields.io/badge/Maven-3.8-blue) ![Database](https://img.shields.io/badge/SQL_Server-2019-red)

Dự án quản lý thư viện được xây dựng bằng Java, sử dụng Maven để quản lý thư viện và kết nối với SQL Server. Phần mềm hỗ trợ các chức năng: Đăng nhập, Quản lý sách, Quản lý người dùng, Thống kê biểu đồ.

## 🚀 Tính năng chính
* **Quản lý sách:** Thêm, sửa, xóa, tìm kiếm sách, đánh giá sách dự trên đánh giá trung bình.
* **Quản lý người dùng:** Xem thời hạn mượn,xóa,thêm và thu hồi sách.
* **Giao diện người dùng:** Đăng ký mượn sách trực tuyến, trao đổi với admin, đánh giá sách được mượn.
* **Mượn/Trả:** Quản lý phiếu mượn trả, tính hạn trả.
* **Thống kê:** Biểu đồ số lượng sách, người dùng (sử dụng JFreeChart).
* **Bảo mật:** Đăng nhập, phân quyền Admin/User, mã hóa mật khẩu.

## 🛠️ Công nghệ sử dụng
* **Ngôn ngữ:** Java (JDK 22)
* **Quản lý dự án:** Maven
* **Giao diện:** Java Swing
* **Database:** Microsoft SQL Server
* **Thư viện:**
    * `mssql-jdbc`: Kết nối Database.
    * `jfreechart`: Vẽ biểu đồ.
    * `jcalendar`: Hiển thị lịch.
