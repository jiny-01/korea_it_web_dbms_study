package com.koreait.dbms_study.service;

import com.koreait.dbms_study.dto.*;
import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Map<String, String> addPost(AddPostReqDto addPostReqDto) {
        Map<String, String> addResult = new HashMap<>();
        int result = postRepository.addPost(addPostReqDto.toEntity());
        if(result == 0) {
            addResult.put("status", "게시물 추가성공");
            return addResult;
        }
        addResult.put("message", "게시물 추가 실패");
        return addResult;
    }

    //게시물 전체 조회
    public List<Post> getPostList() {
        return postRepository.getPostList();
    }

    //게시물 단건 조회
    public Map<String, Object> getPostByPostId(Integer postId) {
        Map<String, Object> response = new HashMap<>();

        Optional<Post> post = postRepository.getPostByPostId(postId);

        if (post.isEmpty()) {
            response.put("message", "게시물을 찾을 수 없습니다.");
        }
        response.put("post", post);
        return response;
    }

    //게시물 수정
    public ResponseDto<Post> editPost(EditPostReqDto editPostReqDto) {

        Optional<Post> post = postRepository.getPostByPostId(editPostReqDto.getPostId());

        if (post.isEmpty()) {
            return new ResponseDto<>("게시물을 찾을 수 없음", null);
        }
        postRepository.editPost(editPostReqDto.toEntity());

        return new ResponseDto<>("게시물 수정 성공", null);

    }






    }

