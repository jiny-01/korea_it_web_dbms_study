package com.koreait.dbms_study.mapper;

import com.koreait.dbms_study.entity.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {

    //post 추가
    int insert (Post post);

}
