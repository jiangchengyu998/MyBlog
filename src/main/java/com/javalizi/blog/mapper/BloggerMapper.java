package com.javalizi.blog.mapper;

import com.javalizi.blog.pojo.Blogger;
import com.javalizi.blog.pojo.BloggerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BloggerMapper {
    int countByExample(BloggerExample example);

    int deleteByExample(BloggerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Blogger record);

    int insertSelective(Blogger record);

    List<Blogger> selectByExampleWithBLOBs(BloggerExample example);

    List<Blogger> selectByExample(BloggerExample example);

    Blogger selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Blogger record, @Param("example") BloggerExample example);

    int updateByExampleWithBLOBs(@Param("record") Blogger record, @Param("example") BloggerExample example);

    int updateByExample(@Param("record") Blogger record, @Param("example") BloggerExample example);

    int updateByPrimaryKeySelective(Blogger record);

    int updateByPrimaryKeyWithBLOBs(Blogger record);

    int updateByPrimaryKey(Blogger record);
}