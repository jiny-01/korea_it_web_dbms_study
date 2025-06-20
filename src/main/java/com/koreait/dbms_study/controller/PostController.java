package com.koreait.dbms_study.controller;

import com.koreait.dbms_study.dto.AddPostReqDto;
import com.koreait.dbms_study.dto.EditPostReqDto;
import com.koreait.dbms_study.dto.EditUserReqDto;
import com.koreait.dbms_study.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    //게시물 추가
    @PostMapping("/add")
    public ResponseEntity<?> addPost(@RequestBody AddPostReqDto addPostReqDto) {
        return ResponseEntity.ok(postService.addPost(addPostReqDto));
    }


    //게시물 조회
    // 게시물 전체 조회
    @GetMapping("/get/list")
    public ResponseEntity<?> getPostList() {

        return ResponseEntity.ok(postService.getPostList());
    }

    // 게시물 단건 조회 (쿼리스트링 방식)
    @GetMapping("/get")
    public ResponseEntity<?> getPostByPostId(@RequestParam Integer postId) {
        return ResponseEntity.ok(postService.getPostByPostId(postId));
    }

    //게시물 수정
    @PostMapping("/edit")
    public ResponseEntity<?> editPost(@RequestBody EditPostReqDto editPostReqDto) {
        return ResponseEntity.ok(postService.editPost(editPostReqDto));
    }
}
