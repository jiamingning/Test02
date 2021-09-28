package dao;

import entity.User;

public interface UserDao {
	public static final int FEMALE=1;	
	
	public static final int MALE=2;
	//返回用户名对象
	public User findUser(String uName);
	
	public User findUser(int uId);
	//注册模块
	public int addUser(User user);

	public int updateUser(User user) throws Exception;

}
