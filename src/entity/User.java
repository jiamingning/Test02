package entity;

public class User {
	//名称要和数据库一致
	int uID;
	String uName;
	String uPass;	
	int gender;	
	String head;	
	String regTime;
	//生成相应的get set方法、构造方法
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getUserInfo() {
		System.out.println("=====用户信息=====");
		System.out.println("用户名：" + uName);
		System.out.println("用户密码：" + uPass);
		char sex=gender==1?'女':'男';
		System.out.println("性别："+sex);
	}

	public User(int uid, String name, String pass) {
		super();
		uID = uid;
		uName = name;
		uPass = pass;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User user = new User(23, "accp", "accp");
		user.getUserInfo();

	}

	public int getUID() {
		return uID;
	}

	public void setUID(int uid) {
		uID = uid;
	}

	public String getUName() {
		return uName;
	}

	public void setUName(String name) {
		uName = name;
	}

	public String getUPass() {
		return uPass;
	}

	public void setUPass(String pass) {
		uPass = pass;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public User( String uName, String uPass, int gender, String head,
			String regTime) {
		super();
	
		this.uName = uName;
		this.uPass = uPass;
		this.gender = gender;
		this.head = head;
		this.regTime = regTime;
	}

	public User(int uID, String uName, String uPass, int gender, String head,
			String regTime) {
		super();
		this.uID = uID;
		this.uName = uName;
		this.uPass = uPass;
		this.gender = gender;
		this.head = head;
		this.regTime = regTime;
	}
	

}
