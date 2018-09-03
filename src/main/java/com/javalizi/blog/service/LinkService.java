package com.javalizi.blog.service;


import com.javalizi.blog.pojo.Link;

import java.util.List;
import java.util.Map;

/**
 * ��������Service�ӿ�
 * @author Administrator
 *
 */
public interface LinkService {

	/**
	 * ��������������Ϣ
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String, Object> map);

	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * �������������Ϣ
	 * @param link
	 * @return
	 */
	public Integer add(Link link);
	
	/**
	 * �޸�����������Ϣ
	 * @param link
	 * @return
	 */
	public Integer update(Link link);
	
	/**
	 * ɾ������������Ϣ
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
}
