package dao;

import entity.User;

public interface UserDao {
	public static final int FEMALE=1;	
	
	public static final int MALE=2;
	//�����û�������
	public User findUser(String uName);
	
	public User findUser(int uId);
	//ע��ģ��
	public int addUser(User user);

	public int updateUser(User user) throws Exception;

}
