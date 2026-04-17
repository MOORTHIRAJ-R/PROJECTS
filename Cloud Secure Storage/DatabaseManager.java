package cloudSecureStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.DBConnection;

public class DatabaseManager {

    public static void saveData(String filename, List<String> parts) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO storage_parts (filename, part_number, data_block) VALUES (?, ?, ?)");
        int i = 1;
        for (String part : parts) {
            ps.setString(1, filename);
            ps.setInt(2, i++);
            ps.setString(3, part);
            ps.executeUpdate();
        }
        con.close();
    }

    public static List<String> retrieveData(String filename) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT data_block FROM storage_parts WHERE filename=? ORDER BY part_number");
        ps.setString(1, filename);
        ResultSet rs = ps.executeQuery();
        List<String> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        con.close();
        return list;
    }
}
