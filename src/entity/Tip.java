package entity;
//把相同的代码提取出来，需要时引用即可，优化代码
public class Tip {
	private String title;

	private String content;

	private String publishTime;

	private int uid;
	
	private String modifyTime;

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Tip() {

	}

	public Tip(String title, String content, String publishTime, int uid, String modifyTime) {
		super();
		this.title = title;
		this.content = content;
		this.publishTime = publishTime;
		this.uid = uid;
		this.modifyTime = modifyTime;
	}

	public void getInfo() {
		System.out.println("=======帖子信息=======");
		System.out.println("帖子标题：" + title);
		System.out.println("帖子内容：" + content);
		System.out.println("发表时间：" + publishTime);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
