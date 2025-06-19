package com.koreait.dbms_study.service;

import com.koreait.dbms_study.dto.AddPostReqDto;
import com.koreait.dbms_study.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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


}
