package com.czy.myclass.service;

import java.util.List;

import com.czy.myclass.domain.Topic;
import com.czy.myclass.domain.TopicMenu;
import com.czy.myclass.dto.PageBean;

public interface TopicService extends BaseService {

	/**
	 * 获取所有的 板块信息
	 * 
	 * @return
	 */
	public List<TopicMenu> getAllTopicMenu();

	/**
	 * 根据id 获取当前板块
	 * 
	 * @param topicMenuId
	 * @return
	 */
	public TopicMenu getTopicMenu(Long topicMenuId);

	/**
	 * 根据 topicId 获取当前帖子
	 * 
	 * @param id
	 * @return
	 */
	public Topic getTopic(Long id);

	/**
	 * 回复
	 * 
	 * @param id
	 * @param topicId
	 * @param content
	 */
	public void replay(Long id, Long topicId, String content);

	/**
	 * 发表帖子
	 * 
	 * @param userId
	 * @param topicMenuId
	 * @param title
	 * @param content
	 * @return
	 */
	public Long postTopic(Long userId, Long topicMenuId, String title,
			String content);

	/**
	 * 获取 该用户的所有发表过的帖子
	 * 
	 * @param userId
	 * @param topicMenuId
	 * @return
	 */
	public List<Topic> getUserTopicList(Long userId, Long topicMenuId);

	/**
	 * 获取最新的 i 个帖子
	 * 
	 * @param i
	 * @return
	 */
	public List<Topic> getLastTopicList(int i);

	/**
	 * 获取分页信息 该板块下的
	 * 
	 * @param currentPage
	 * @param topicMenuId
	 * @return
	 */
	public PageBean getTopicPageBean(int currentPage, Long topicMenuId);

	/**
	 * 获取回复的分页信息
	 * 
	 * @param currentPage
	 * @param topicId
	 * @return
	 */
	public PageBean getAnswerPageBean(int currentPage, Long topicId);

	/**
	 * 删除板块 一个
	 * 
	 * @param menuId
	 */
	public void delMenu(Long menuId);

	/**
	 * 删除板块 多个
	 * 
	 * @param ids
	 */
	public void delMenu(String ids);

	/**
	 * 添加板块
	 * 
	 * @param menuName
	 */
	public void addMenu(String menuName);

	/**
	 * 编辑 更新板块 name
	 * 
	 * @param menuId
	 * @param menuName
	 */
	public void updata(Long menuId, String menuName);

	/**
	 * 获取帖子的分有信心，带有类型 及搜索系信息
	 * 
	 * @param currentPage
	 * @param menuId
	 * @param key
	 * @return
	 */
	public PageBean getTopciPageBean(int currentPage, Long menuId, String key);

	/**
	 * 删除帖子 一个
	 * 
	 * @param topicId
	 */
	public void delTopic(Long topicId);

	/**
	 * 删除帖子 多个
	 * 
	 * @param ids
	 */
	public void delTopic(String ids);

	/**
	 * 屏蔽该回复
	 * 
	 * @param topicAnswerId
	 */
	public void pingbiAnswer(Long topicAnswerId);

	/**
	 * 获取该用户发表的 帖子的分有信息
	 * @param userid
	 * @param topicMenuId
	 * @return
	 */
	public PageBean getMyPostTopic(Long userid, Long topicMenuId,int currentPage);

}
