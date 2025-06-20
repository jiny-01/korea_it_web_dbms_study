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
@RequestMapping("/post")
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
//    @GetMapping("/get")
//    public ResponseEntity<?> getPostByPostId(@RequestParam Integer postId) {
//        return ResponseEntity.ok(postService.getPostByPostId(postId));
//    }


    //게시물 단건 조회 (pathvariable방식)
    //예시 : localhost:8080/post/get/1  -->  요청할 때 바로 postId 받음
    @GetMapping("/get/{postId}")
    public ResponseEntity<?> getPostByPostId(@PathVariable Integer postId){
        return ResponseEntity.ok(postService.getPostByPostId(postId));
    }


    //게시물 수정
    @PostMapping("/edit")
    public ResponseEntity<?> editPost(@RequestBody EditPostReqDto editPostReqDto) {
        return ResponseEntity.ok(postService.editPost(editPostReqDto));
    }

    //게시물 삭제
    @GetMapping("/remove")
    public ResponseEntity<?> removePost(@RequestParam Integer postId) {
        return ResponseEntity.ok(postService.removePost(postId));
    }



}
