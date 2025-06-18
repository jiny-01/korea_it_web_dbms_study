package com.koreait.dbms_study.controller;

import com.koreait.dbms_study.dto.AddUserReqDto;
import com.koreait.dbms_study.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


//* mybatis
//SQL 중심의 데이터 접근 프레임워크
//-> 내가 직접 SQL문 작성하고 그 결과를 JAVA 객체로 매핑
//SQL 을 직접 짜기 때문에 완전히 통제 가능(자유도 높음),
// 대신에 코드 복잡하고 반복적


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //요청받기&처리 - JSON 데이터를 DTO로 변환받기
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody AddUserReqDto addUserReqDto) {
        return ResponseEntity.ok(userService.addUser(addUserReqDto));
        //ok 에 맵에서의 반환값(응답) return 하도록 넣음

    }

    //조회
    @GetMapping("/get/list")
    public ResponseEntity<?> getUserList() {
        return ResponseEntity.ok(userService.getUserList());
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUserByUserId(@RequestParam Integer userId) {
        return ResponseEntity.ok(userService.getUserByUserId(userId));
    }
}
