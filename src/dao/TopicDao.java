package dao;

import java.util.List;

import entity.Topic;

public interface TopicDao {
	public List findListTopic(int page,int boardId);

	public int addTopic(Topic topic);

	public int deleteTopic(int topicId);

	public int updateTopic(Topic topic);
	
	public int findCountTopic(int boardId);
	
	public Topic findTopic(int topicId);
	
	public int findTopicIdByReplyId(int replyId);

}
