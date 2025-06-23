package com.koreait.dbms_study.controller;

//JPA
//객체 중심의 ORM(Object Relational Mapping)
//객체 지향 언어(JAVA)의 객체와 관계형 데이터베이스의 테이블 간의 매핑을 자동으로 처리
//-> SQL 을 직접 쓰지 않고 자바 객체 중심으로 DB 를 다룸
//Hibernate 는 JPA 의 구현체다
//JPA: 자바에서 ORM을 사용할 수 있게 만든 인터페이스 -> 추상메소드

//장점 => SQL 없이 빠르게 CRUD 가능, 코드량 감소
//단점 => 복잡한 쿼리는 어렵고 추적/디버깅이 까다롭다.
//        가져다 쓰는 거라 에러 찾아낼 수 없음

import com.koreait.dbms_study.dto.AddPostJpaReqDto;
import com.koreait.dbms_study.dto.AddPostReqDto;
import com.koreait.dbms_study.dto.EditPostReqDto;
import com.koreait.dbms_study.service.PostJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jpa/post")
//@PostMapping("/jpa/post")

public class PostJpaController {

    @Autowired
    private PostJpaService postJpaService;

    @PostMapping("/add")
    public ResponseEntity<?> addPost(@RequestBody AddPostJpaReqDto addPostJpaReqDto) {
        return ResponseEntity.ok(postJpaService.addPost(addPostJpaReqDto));
    }

    @GetMapping("/get/list")
    public ResponseEntity<?> getPostList() {
        return ResponseEntity.ok(postJpaService.getPostList());
    }

    //게시물 수정
    @PostMapping("/edit")
    public ResponseEntity<?> editPost(@RequestBody EditPostReqDto editPostReqDto) {
        return ResponseEntity.ok(postJpaService.editPost(editPostReqDto));
    }


    //게시물 삭제
    @PostMapping("/remove")
    public ResponseEntity<?> removePost(@RequestParam Integer postId) {
        return ResponseEntity.ok(postJpaService.removePost(postId));
    }
}
