package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.ReplyDao;
import entity.Reply;
import entity.Topic;
import entity.User;

public class ReplyDaoImpl extends BaseDao implements ReplyDao{
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	public int addReply(Reply reply) {
		int num=0;
		try {
			con=getConn();
			String sql="INSERT INTO TBL_REPLY (title,content,publishTime,modifyTime,uId,topicId)  VALUES (?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, reply.getTitle());
			pstmt.setString(2, reply.getContent());
			pstmt.setString(3, reply.getPublishTime());
			pstmt.setString(4, reply.getModifyTime());
			pstmt.setInt(5, reply.getUid());
			pstmt.setInt(6, reply.getTopicId());
	  
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

	public int deleteReply(int replyId) {
		int num=0;		
		try {
			con = getConn();
			String sql = " delete from TBL_REPLY where replyId= ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1 , replyId);
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
	

	public int updateReply(Reply reply) {
		int num = 0;
		try {
			con=getConn();
			String sql = "UPDATE TBL_REPLY set title = ?,content = ?,publishTime = ?,modifyTime = ?,uid = ? ,topicId = ? WHERE replyId=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reply.getTitle());
			pstmt.setString(2, reply.getContent());
			pstmt.setString(3, reply.getPublishTime());
			pstmt.setString(4, reply.getModifyTime());
			pstmt.setInt(5, reply.getUid());
			pstmt.setInt(6, reply.getTopicId());
			pstmt.setInt(7, reply.getReplyId());
			num=pstmt.executeUpdate();	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(con,pstmt,rs);
		}
		return num;
	}
	
	public List findListReply(int page,int topicId) {
		List list=new ArrayList();
		
		int rowBegin=0;
		if(page>1){
			rowBegin=10*(page-1);
		}
		String sql= "select top 10 * from TBL_REPLY where topicId=" + topicId + " and replyId not in(select top "+ rowBegin + " replyId from TBL_REPLY where topicId=" + topicId + " order by publishTime asc)order by publishTime asc";
		try {
			con=getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				Reply reply=new Reply();
				reply.setReplyId(rs.getInt("replyId"));
				reply.setTitle(rs.getString("title"));
				reply.setPublishTime(rs.getString("publishTime"));
				reply.setContent(rs.getString("content"));
				reply.setPublishTime(rs.getString("publishTime"));
				reply.setModifyTime(rs.getString("modifyTime"));
				reply.setUid(rs.getInt("uid"));
				list.add(reply);
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(con,pstmt,rs);
		}
		return list;
	}
	
	public Reply findReply(int replyId) {
		Reply reply=null;
		try {
			con=getConn();	
			String sql="select * from TBL_REPLY where replyId=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,replyId);
			ResultSet rs=pstmt.executeQuery();			
			while(rs.next()){
				reply=new Reply();
				reply.setReplyId(rs.getInt("replyId"));
				reply.setTitle(rs.getString("title"));				
				reply.setContent(rs.getString("content"));
				reply.setPublishTime(rs.getString("publishTime"));
				reply.setModifyTime(rs.getString("modifyTime"));
				reply.setUid(rs.getInt("uId"));
				reply.setTopicId(rs.getInt("replyId"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(con,pstmt,rs);
		}
		return reply;
	}
	
	//查找得到回复数
	public int findCountReply(int topicId) {
		
		int num = 0;
		try {
			con=getConn();	
			String sql="select count(*) from TBL_REPLY where topicId=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,topicId);
			rs=pstmt.executeQuery();			
			while(rs.next()){
				num=rs.getInt(1);
			}
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
