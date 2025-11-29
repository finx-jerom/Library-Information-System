
package System_Files;

/**
 *
 * @author pc
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Borrow_type {

    public Borrow_type() {
        createTableIfNotExists();
    }

    // Create table if not exists (for convenience)
    private void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS borrow ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "Student_id VARCHAR(100) NOT NULL, "
                + "Name VARCHAR(100) NOT NULL, "
                + "Book VARCHAR(100) NOT NULL"
                + ")";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table 'borrow' checked/created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Borrow_info> getAllBorrow_info() {
        List<Borrow_info> list = new ArrayList<>();
        String sql = "SELECT id, Student_id, Name, Book FROM borrow ORDER BY id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Borrow_info s = new Borrow_info(
                        rs.getInt("id"),
                        rs.getString("Student_id"),
                        rs.getString("Name"),
                        rs.getString("Book")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean insertStudent(Borrow_info s) {
        String sql = "INSERT INTO borrow (Student_id, Name, Book) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, s.getStudent_id());
            pstmt.setString(2, s.getName());
            pstmt.setString(3, s.getBook());

            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStudent(Borrow_info s) {
        String sql = "UPDATE borrow SET Student_id = ?, Name = ?, Book = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, s.getStudent_id());
            pstmt.setString(2, s.getName());
            pstmt.setString(3, s.getBook());
            pstmt.setInt(4, s.getId());

            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM borrow WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
