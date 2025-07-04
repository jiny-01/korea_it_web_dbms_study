package com.koreait.dbms_study.dto;

import com.koreait.dbms_study.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class AddUserReqDto {
    private String username;
    private String email;
    private Integer userId;

    public User toEntity() {
        return User.builder()
                .userId(this.userId)
                .username(this.username)
                .email(this.email)
                .build();
        //addUserReqDto 를 toEntity 로 받아 객체로 만듦

    }
}
