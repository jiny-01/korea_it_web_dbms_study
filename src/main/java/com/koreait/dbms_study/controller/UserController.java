package com.koreait.dbms_study.controller;

import com.koreait.dbms_study.dto.AddUserReqDto;
import com.koreait.dbms_study.dto.EditUserReqDto;
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

    //추가 => 요청받기&처리 - JSON 데이터를 DTO로 변환받기
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody AddUserReqDto addUserReqDto) {
        return ResponseEntity.ok(userService.addUser(addUserReqDto));
    }
    //응답 상태 코드를 200 OK로 만들고,
    // 그 안에 userService.addUser(...)의 반환값을 넣음
    //userService.addUser(...)의 반환값을 그대로 응답에 실어서 클라이언트에 전달

    //조회
    @GetMapping("/get/list")
    public ResponseEntity<?> getUserList() {
        return ResponseEntity.ok(userService.getUserList());
    }

    //단건 조회
    @GetMapping("/get")
    public ResponseEntity<?> getUserByUserId(@RequestParam Integer userId) {
        return ResponseEntity.ok(userService.getUserByUserId(userId));
    }
    //user/get?userId=1

//    @GetMapping("/get/{userId}")
//    public ResponseEntity<?> getUserByUserId(@PathVariable Integer userId) {
//        return ResponseEntity.ok(userService.getUserByUserId(userId));
//    }
      //@PathVariable
//    //userId를 ?가 아니라 바로 /뒤에 적는 방법으로 요청 보낼 수 있음
//    //user/get/1 이런 형식

    //검색 기능 추가 키워드=입력값 형식을 requestparam 으로 받을 수 있음


    //요청 메소드 중 DELETE, PUT 이 있는데 POST 로
    //-> 조회(GET) 빼곤 가급적 POST
    //보안상 이유, 호환성 이유
    //일부 브라우저, 서버가 PUT, DELETE 를 완벽히 지원하지 않음
    //HTML <form>가 GET, POST 만 지원


    //post -> body, param 둘 다가능
    //하나만 받아올 땐 param
    //get -> param 만 가능


    //수정 -> post 로 받음
    @PostMapping("/edit")
    public ResponseEntity<?> editUser(@RequestBody EditUserReqDto editUserReqDto) {
        return ResponseEntity.ok(userService.editUser(editUserReqDto));
    }
    //editUser 의 반환(수정 성공/실패)을 ok로 사용자에게 표시함


    //유저 삭제
    @PostMapping("/remove")
    public ResponseEntity<?> removeUser(@RequestParam Integer userId) {
        return ResponseEntity.ok(userService.removeUser(userId));
    }


}
