package Master;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class MasterDAO {
    // ��� ��ü ��ȸ�� �޼ҵ�
    public void testJDBC() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        // ctrl + shift + O �� ������ import �ؾ��ϴ� �׸��� ����.
         
        // 1. �ش� ������ ���̽��� ���� ���̺귯�� ��� �۾�
        // Class.forName("Ŭ������"); // ClassNotFoundException ó���� �ؾ� ��
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
             
            // 2.�����ͺ��̽��� ������  // SQLException ó���� �ؾ��Ѵ�.
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
             
            System.out.println(conn);
             
            // 3. ������ �ۼ� �� DB���� ������ �����Ű�� ����� ������ ��
            String query = "SELECT * FROM MASTER_TABLE";
             
            stmt = conn.createStatement();
             
            rset = stmt.executeQuery(query);
             
            while (rset.next()) {
                System.out.println(rset.getString("S_NAME") + ", " +
                                    rset.getString("S_ID") + ", " +
                                    rset.getString("S_PW") + ", " +
                                    rset.getString("S_SECURITY")
                        );
                 
            }
 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // 4. DB�� ���õ� ��ü�� �ݵ�� close �ؾ� ��
                rset.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}