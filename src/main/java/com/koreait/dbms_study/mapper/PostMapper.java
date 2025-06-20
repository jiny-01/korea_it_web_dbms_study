package com.koreait.dbms_study.mapper;

import com.koreait.dbms_study.dto.AddPostReqDto;
import com.koreait.dbms_study.dto.EditPostReqDto;
import com.koreait.dbms_study.dto.PostRespDto;
import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {

    //post 추가 -> int: 성공한 행의 개수
    int insert (Post post);

    //post 추가 -> 전달받은 AddPostReqDto DTO를 받아서 DB에 게시물을 추가
    int addPost(AddPostReqDto addPostReqDto);

    //게시물 전체 조회 -> PostResponseDto 타입 객체를 여러 개 담은 리스트
    List<Post> getPostList();

    //게시물 단건 조회 (postId 이용)
    Optional<Post> getPostByPostId(Integer postId);

    int editPost(Post post);
}
