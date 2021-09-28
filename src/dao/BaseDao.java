package dao;

import java.sql.*;


public class BaseDao {
	public static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public static final String url="jdbc:sqlserver://localhost:1433; DatabaseName=bbs";
		
    public static final String dbName="sa";
    	
    public static final String dbPass="123456";
    
    //建立数据库连接
    public Connection getConn() throws SQLException{
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Connection conn=DriverManager.getConnection(url,dbName,dbPass);
    	return conn;
    }
	
    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs){
    	if(rs!=null){
    		try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(pstmt!=null){
    		try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(conn!=null){
    		try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    } 
  

}
