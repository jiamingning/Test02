package entity;

public class Board {

	int boardId;

	String boardName;

	int parentId;

	public void getBoardInfo() {
		System.out.println("=====°æ¿éÐÅÏ¢=====");
		System.out.println("°æ¿éÃû³Æ£º" + boardName);
	}

	public Board(int boardId, String boardName, int parentId) {
		super();
		this.boardId = boardId;
		this.boardName = boardName;
		this.parentId = parentId;
	}

	public Board() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Board board = new Board(4, "Jsp", 0);
		board.getBoardInfo();

	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
