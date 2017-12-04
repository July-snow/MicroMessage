package util;

import bean.Command;

import java.sql.*;

/**
 * @Author: Silence
 * @Date: Create in 18:11 2017/11/29
 * @Description:
 */
public class DbUtil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3309/micro_message?userUnicode=true&characterEncoding=utf-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "74645973";
    private static Connection conn = null;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private DbUtil(){}


    public static Connection getConnection() throws SQLException {
        if(conn == null)
            conn = DriverManager.getConnection(URL,USERNAME, PASSWORD);
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT a.id,a.name,a.description,b.id,b.content,b.command_id " +
                "FROM command a LEFT JOIN command_content b on a.id = b.command_id");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            Command command = new Command();
            command.setId(Integer.toString(rs.getInt("id")));
            command.setName(rs.getString("name"));
            command.setDescription(rs.getString("description"));
            System.out.println(command.getName()+" "+command.getDescription()+" "+rs.getString("content"));
        }
     //   System.out.println(rs.getMetaData());
    }
}
