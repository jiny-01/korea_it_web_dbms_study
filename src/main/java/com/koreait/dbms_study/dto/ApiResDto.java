package com.koreait.dbms_study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//공통 dto
@Data
@AllArgsConstructor
public class ApiResDto<T> {
    private String message;   //성공, 실패 표시하는 메시지
    private T data;    //유저 객체, 포스트 객체

}
