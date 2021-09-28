package test;

import java.util.List;

import dao.ReplyDao;
import dao.TopicDao;
import dao.impl.ReplyDaoImpl;
import dao.impl.TopicDaoImpl;
import entity.Reply;
import entity.Topic;

public class TestReplyDaoImpl {
	public static void main(String[] args) {
	ReplyDao rd = new ReplyDaoImpl();
	//String sql="INSERT INTO TBL_REPLY (title,content,publishTime,modifyTime,uId,topicId)  VALUES (?,?,?,?,?,?)";
	//Reply reply = new Reply("ccc","qweqwe","2007-07-25 00:00:00.000","2007-07-25 00:00:00.000",1,3);
	
	/*Reply r=new Reply("aa", "dd", "2007-07-25 00:00:00.000", "2007-07-25 00:00:00.000", 1, 3);
	int num=rd.addReply(r);
	if(num>0){
		System.out.println("Ìí¼Ó³É¹¦£¡");
	}
	else{
		System.out.println("Ìí¼ÓÊ§°Ü£¡");
	}*/
	/*int num = rd.deleteReply(1);
	System.out.println(num);*/
	//String sql = "UPDATE TBL_REPLY set title = ?,content = ?,publishTime = ?,modifyTime = ?,uid = ? ,topicId = ? WHERE replyId=?";
	/*Reply reply = new Reply(2,"12312e","qweqwe","2007-07-25 00:00:00.000","2007-07-25 00:00:00.000",1,3);
	int num=rd.updateReply(reply);
	if(num>0){
		System.out.println("ÐÞ¸Ä³É¹¦£¡");
	}
	else{
		System.out.println("ÐÞ¸ÄÊ§°Ü£¡");
	}*/
	//error
	/*Reply reply = rd.findReply(2);
	if(reply!=null){
		System.out.println(reply.getContent());
		
	}else{
		System.out.println("Ê§°Ü£¡");
	}*/
	/*int num = rd.findCountReply(5);
	System.out.println(num);*/
	TopicDao td=new TopicDaoImpl();
	ReplyDao replyDao=new ReplyDaoImpl();
	List list=rd.findListReply(2, 81);
	for(int i=0;i<list.size();i++){
		Reply reply= (Reply)list.get(i);
		   System.out.println(reply.getTitle());
	}
	}
}
	
