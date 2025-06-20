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

    public int addPost(Post post) {

        return postMapper.insert(post);
    }

    public List<Post> getPostList() {
        return postMapper.getPostList();
    }


    public Optional<Post> getPostByPostId(Integer postId) {
        return postMapper.getPostByPostId(postId);
    }
}
