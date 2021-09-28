 package dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.TopicDao;
import entity.Topic;
import entity.User;

public class TopicDaoImpl extends BaseDao implements TopicDao{
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	//查找某一板块下的帖子列表
	@Override
	public List findListTopic(int page, int boardId) {
		//page用来分页  
		// TODO Auto-generated method stub
        List list=new ArrayList();
		
		int rowBegin=0;
		if(page>1){
			rowBegin=20*(page-1);   
		}
		String sql= "select top 20 * from TBL_TOPIC where boardId=? and topicId not in(select top "+rowBegin+" topicId from TBL_TOPIC where boardId=? order by publishTime desc )order by publishTime desc";
		try {
			con=getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, boardId);			
			pstmt.setInt(2, boardId);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				Topic topic=new Topic();
				topic.setTopicId(rs.getInt("topicId"));
				topic.setTitle(rs.getString("title"));
				topic.setPublishTime(rs.getString("publishTime"));
				topic.setContent(rs.getString("content"));
				topic.setPublishTime(rs.getString("publishTime"));
				topic.setModifyTime(rs.getString("modifyTime"));
				topic.setUid(rs.getInt("uid"));
				list.add(topic);
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

	@Override
	public int addTopic(Topic topic) {
		int num=0;
		try {
			con=getConn();
			String sql="INSERT INTO TBL_TOPIC (title,content,publishtime,modifytime,uId,boardId)  VALUES (?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, topic.getTitle());
			pstmt.setString(2, topic.getContent());
			pstmt.setString(3, topic.getPublishTime());
			pstmt.setString(4, topic.getModifyTime());
			pstmt.setInt(5, topic.getUid());
			pstmt.setInt(6, topic.getBoardId());
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
	public int deleteTopic(int topicId) {
		int num=0;		
		try {
			con = getConn();
			String sql = " delete from TBL_TOPIC where topicId= ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1 , topicId);
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

	@Override//有问题
	public int updateTopic(Topic topic) {
		int num=0;		
		try {
			con=getConn();
			String sql="UPDATE TBL_TOPIC SET title = ?,content = ?,publishTime = ?,modifyTime = ?,uId =?,boardId=? WHERE topicId=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, topic.getTitle());
			pstmt.setString(2, topic.getContent());
			pstmt.setString(3, topic.getPublishTime());
			pstmt.setString(4, topic.getModifyTime());
			pstmt.setInt(5, topic.getUid());
			pstmt.setInt(6, topic.getBoardId());
			pstmt.setInt(7, topic.getTopicId());
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

	//查找不同的模块相关帖子数量 
	@Override
	public int findCountTopic(int boardId) {
		// TODO Auto-generated method stub
		int count=0;
		String sql="select count(*) from TBL_TOPIC where boardId=?";
		try {
			con=getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		}  catch (SQLException e) {			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(con,pstmt,rs);
		}
		
		return count;
	}

	@Override
	public Topic findTopic(int topicId) {
	Topic topic= null;	
		try {
			con=getConn();	
			String sql="select * from TBL_TOPIC where topicId=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, topicId);
			ResultSet rs=pstmt.executeQuery();			
			while(rs.next()){
				topic=new Topic();
				topic.setTopicId(rs.getInt("topicId"));
				topic.setTitle(rs.getString("title"));	
				topic.setContent(rs.getString("content"));
				topic.setPublishTime(rs.getString("publishTime"));
				topic.setModifyTime(rs.getString("modifyTime"));
				topic.setUid(rs.getInt("uId"));
				topic.setBoardId(rs.getInt("boardId"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(con,pstmt,rs);
		}
		return topic;
	}

	@Override
	public int findTopicIdByReplyId(int replyId) {
		Topic topic= null;	
		try {
			con=getConn();	
			String sql="select * from TBL_TOPIC where replyId=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, replyId);
			rs=pstmt.executeQuery();			
			while(rs.next()){
				topic=new Topic();
				topic.getTopicId();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(con,pstmt,rs);
		}
		return replyId;
	}

}
