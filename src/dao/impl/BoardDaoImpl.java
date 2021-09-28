package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.BaseDao;
import dao.BoardDao;
import entity.Board;
import entity.Topic;

public class BoardDaoImpl extends BaseDao implements BoardDao{
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	@Override
	public Map findBoard() {
		// TODO Auto-generated method stub
		Map map=new HashMap();		
		int parentId=0;		//从第一行开始取值
		List sonList=null;
		String sql="select * from TBL_BOARD order by parentId,boardId";
		try {
			con=getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			sonList=new ArrayList();
			
			while(rs.next()){
				if(parentId!=rs.getInt("parentId")){
					map.put(new Integer(parentId), sonList);
					sonList=new ArrayList();
					parentId=rs.getInt("parentId");
				}
				Board board=new Board();
				board.setBoardName(rs.getString("boardName"));
				board.setBoardId(rs.getInt("boardId"));
				sonList.add(board);
			}
			map.put(new Integer(parentId), sonList);
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(con,pstmt,rs);
		}
		return map;
	}

	@Override
	public Board findBoard(int boardId) {
		Board board= null;	
		try {
			con=getConn();	
			String sql="select * from TBL_BOARD where boardId=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			ResultSet rs=pstmt.executeQuery();			
			while(rs.next()){
				board=new Board();
				board.setBoardName(rs.getString("boardName"));	
				board.setParentId(rs.getInt("parentId"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(con,pstmt,rs);
		}
		return board;
	}

}
