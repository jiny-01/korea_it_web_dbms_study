package com.koreait.dbms_study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class User {
    // DB 에 넣은 테이블 칼럼 그대로 - 멤버변수로

    private Integer userId;    //user_id 로 되있어도 자바는 문법따름
    private String username;
    private String email;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;



}
