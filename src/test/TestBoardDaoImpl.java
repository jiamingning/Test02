package test;

import java.util.List;
import java.util.Map;

import dao.BoardDao;
import dao.impl.BoardDaoImpl;
import entity.Board;

public class TestBoardDaoImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDao boardDao=new BoardDaoImpl();
		Map mapBoard=boardDao.findBoard();
		List listMainBoard=(List) mapBoard.get(new Integer(0));
		for (int i = 0; i < listMainBoard.size(); i++) {
			Board mainBoard=(Board) listMainBoard.get(i);
			System.out.println(mainBoard.getBoardName());
			
			List listSonBoard=(List) mapBoard.get(new Integer(mainBoard.getBoardId()));
			for (int j = 0; j < listSonBoard.size(); j++) {
				Board board=(Board) listSonBoard.get(j);
				System.out.println("\t"+board.getBoardName());
			}
			
		}
		/*BoardDaoImpl bd = new BoardDaoImpl();
		Board board = bd.findBoard(3);
		System.out.println(board.getBoardName());*/
		

	}

}
