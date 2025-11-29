/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System_Files;

/**
 *
 * @author pc
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Book_type {

    public Book_type() {
        createTableIfNotExists();
    }

    // Create table if not exists (for convenience)
    private void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS bookinfo ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "Book VARCHAR(100) NOT NULL, "
                + "Author VARCHAR(100) NOT NULL, "
                + "Publisher VARCHAR(100) NOT NULL"
                + ")";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table 'bookinfo' checked/created.");
        } catch (SQLException e) {
        }
    }

    public List<Books_info> getAllBooks_info() {
        List<Books_info> list = new ArrayList<>();
        String sql = "SELECT id, Book, Author, Publisher FROM bookinfo ORDER BY id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Books_info s = new Books_info(
                        rs.getInt("id"),
                        rs.getString("Book"),
                        rs.getString("Author"),
                        rs.getString("Publisher")
                );
                list.add(s);
            }
        } catch (SQLException e) {
        }

        return list;
    }

    public boolean insertBook(Books_info s) {
        String sql = "INSERT INTO bookinfo (Book, Author, Publisher) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, s.getBook());
            pstmt.setString(2, s.getAuthor());
            pstmt.setString(3, s.getPublisher());

            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateBook(Books_info s) {
        String sql = "UPDATE bookinfo SET Book = ?, Author = ?, Publisher = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, s.getBook());
            pstmt.setString(2, s.getAuthor());
            pstmt.setString(3, s.getPublisher());
            pstmt.setInt(4, s.getId());

            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteBook(int id) {
        String sql = "DELETE FROM bookinfo WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            return false;
        }
    }


}
