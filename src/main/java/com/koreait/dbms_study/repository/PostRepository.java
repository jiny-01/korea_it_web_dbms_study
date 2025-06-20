package com.koreait.dbms_study.repository;

import com.koreait.dbms_study.dto.PostRespDto;
import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.entity.User;
import com.koreait.dbms_study.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {

    @Autowired
    private PostMapper postMapper;

    //게시물 추가
    public int addPost(Post post) {
        int result = postMapper.addPost(post);
        return result;
    }

    //게시물 전체 조회
    public List<Post> getPostList() {
        List<Post> postList = postMapper.getPostList();
        return postList;
    }



    //게시물 단건 조회
    public Optional<Post> getPostByPostId(Integer postId) {

        return postMapper.getPostByPostId(postId);
    }

//    public Post getPostByPostId(Integer postId) {
//      Post post = postMapper.getPostByPostId(postId);
//      return post;
//
//    }

    //게시물 수정
    public int editPost(Post post) {
        return postMapper.editPost(post);
    }

    //게시물 삭제
    public int removePost(Integer postId) {
        int result = postMapper.removePost(postId);
        return result;
    }
}
