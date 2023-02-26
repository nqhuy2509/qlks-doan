import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StaffDAO extends DAO{
    public StaffDAO(){
        super();
    }

    public boolean login(Staff staff){
        boolean result = false;
        String sql = "SELECT * FROM STAFF WHERE username = ? and password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, staff.getUsername());
            ps.setString(2, staff.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                staff.setName(rs.getString("name"));
                staff.setPosition(rs.getString("position"));
                result = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
