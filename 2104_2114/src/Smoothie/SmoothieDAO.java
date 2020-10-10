package Smoothie;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class SmoothieDAO {
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
            String query = "SELECT * FROM MENU_SMOOTHIE";
            
            stmt = conn.createStatement();
             
            rset = stmt.executeQuery(query);
             
            while (rset.next()) {
                System.out.println(rset.getString("BNAME") + ", " +
                                    rset.getInt("ORANGE_D") + ", " +
                                    rset.getInt("ORANGE_M") + ", " +
                                    rset.getInt("ORANGE_S") + ", " +
                                    rset.getInt("KIWI_D") + ", " +
                                    rset.getInt("KIWI_M") + ", " +
                                    rset.getInt("KIWI_S") + ", " +
                                    rset.getInt("GRAPE_D") + ", " +
                                    rset.getInt("GRAPE_M") + ", " +
                                    rset.getInt("GRAPE_S") + ", " +
                                    rset.getInt("STRAW_D") + ", " +
                                    rset.getInt("STRAW_M") + ", " +
                                    rset.getInt("STRAW_S") + ", " +
                                    rset.getInt("WATER_D") + ", " +
                                    rset.getInt("WATER_M") + ", " +
                                    rset.getInt("WATER_S")
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