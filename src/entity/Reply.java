package entity;

public class Reply extends Tip {
	int replyId;
	int topicId;
	public Reply(String title, String content, String publishTime,  String modifyTime,int uid, int topicId) {
		super(title,  content,  publishTime,  uid,  modifyTime);
		this.topicId = topicId;
	}

	
	public Reply(int replyId, String title, String content, String publishTime,  String modifyTime,int uid, int topicId) {
		super(title,  content,  publishTime,  uid,  modifyTime);
		this.replyId = replyId;
		this.topicId = topicId;
	}


	public Reply(int topicId) {
		super();
		this.topicId = topicId;
	}

	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public void getInfo(){
		System.out.println("=======������Ϣ=======");
		System.out.println("���ӱ��⣺" + getTitle());
		System.out.println("�������ݣ�" + getContent());
		System.out.println("����ʱ�䣺" + getPublishTime());
	}
	/**
	 * @param args
	 */

}
