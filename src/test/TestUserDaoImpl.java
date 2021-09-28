package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;

public class TestUserDaoImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao ud=new UserDaoImpl();
		/*User user=ud.findUser("super");
		if(user!=null){
			System.out.println(user.getUPass());
		}
		else{
			System.out.println("µÇÂ½Ê§°Ü£¡");
		}*/
		/*User user=ud.findUser(64);
		if(user!=null){
			System.out.println(user.getUName());
		}
		else{
			System.out.println("µÇÂ½Ê§°Ü£¡");
		}*/
		
		/*User user=new User("ss","123",2,"5.gif","2018-07-27 00:00:00.000");
		int num=ud.addUser(user);
		if(num>0){
			System.out.println("×¢²á³É¹¦£¡");
		}
		else{
			System.out.println("×¢²áÊ§°Ü£¡");
		}*/
		User user=new User(98,"ss","ss",2,"1.gif","2018-07-27 00:00:00.000");
		int num=0;
		try {
			num = ud.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(num>0){
			System.out.println("ÐÞ¸Ä³É¹¦£¡");
		}
		else{
			System.out.println("ÐÞ¸ÄÊ§°Ü£¡");
		}
	}

}
