package entity;

public class Topic extends Tip {
	int topicId;

	int boardId;

	public Topic() {
		
	}

	public Topic(String title, String content, String publishTime,  String modifyTime,int uid, int boardId) {
		super(title, content, publishTime, uid, modifyTime);
		// TODO Auto-generated constructor stub
		this.boardId = boardId;
	}

	public Topic(int topicId, int boardId) {
		super();
		this.topicId = topicId;
		this.boardId = boardId;
	}

	public Topic(int boardId) {
		super(); 
		this.boardId = boardId;
	}

	public int getTipId() {
		return boardId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public void setTipId(int tipId) {
		this.boardId = tipId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public void getInfo() {
		System.out.println("=======回复信息=======");
		System.out.println("帖子标题：" + getTitle());
		System.out.println("帖子内容：" + getContent());
		System.out.println("发表时间：" + getPublishTime());
	}

}
