import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    public static Connection conn;

    public DAO(){
        if( conn == null){
            String dbURL = "jdbc:sqlserver://localhost:1433;database=qlks;user=sa;password=abcd123456;encrypt=false;";
            try {
                conn = DriverManager.getConnection(dbURL);
            }catch (SQLException e){
                throw new Error(e);
            }
        }
    }
}
