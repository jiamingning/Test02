package dao.impl;

import java.sql.*;

import dao.BaseDao;
import dao.UserDao;
import entity.User;
//实现UserDao接口
public class UserDaoImpl  extends BaseDao implements UserDao{
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	//查找功能 
	@Override
	public User findUser(String uName) {
		// TODO Auto-generated method stub
		User user=null;		
		try {			
			con=getConn();			
			String sql="select * from TBL_USER where uName=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, uName);
			ResultSet rs=pstmt.executeQuery();			
			while(rs.next()){
				System.out.println("sss");
				user=new User();
				//读取UID封装到 User
				user.setUID(rs.getInt("uId"));
				user.setUName(rs.getString("uName"));				
				user.setUPass(rs.getString("uPass"));
				user.setGender(rs.getInt("gender"));
				user.setHead(rs.getString("head"));
				user.setRegTime(rs.getString("regTime"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(con,pstmt,rs);
		}
		return user;
	}

	@Override
	public User findUser(int uId) {
		// TODO Auto-generated method stub
		User user=null;
		
		try {
			con=getConn();	
			String sql="select * from TBL_USER where uId=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, uId);
			ResultSet rs=pstmt.executeQuery();			
			while(rs.next()){
				user=new User();
				user.setUID(rs.getInt("uId"));
				user.setUName(rs.getString("uName"));				
				user.setUPass(rs.getString("uPass"));
				user.setGender(rs.getInt("gender"));
				user.setHead(rs.getString("head"));
				user.setRegTime(rs.getString("regTime"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(con,pstmt,rs);
		}
		return user;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
	
		int num=0;//没有成功
		try {
			con=getConn();
			String sql="INSERT INTO TBL_USER (uName,uPass,head,regTime,gender)  VALUES (?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user.getUName());
			pstmt.setString(2, user.getUPass());
			pstmt.setString(3, user.getHead());
			pstmt.setString(4, user.getRegTime());
			pstmt.setInt(5, user.getGender());
			num=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(con,pstmt,rs);
		}
		return num;
	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		int num=0;		
		try {
			con=getConn();
			String sql="UPDATE TBL_USER SET uName = ?,uPass = ?,head = ?,regTime = ?,gender =? WHERE uId=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user.getUName());
			pstmt.setString(2, user.getUPass());
			pstmt.setString(3, user.getHead());
			pstmt.setString(4, user.getRegTime());
			pstmt.setInt(5, user.getGender());
			pstmt.setInt(6, user.getUID());
			num=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(con,pstmt,rs);
		}
		return num;
	}

}
