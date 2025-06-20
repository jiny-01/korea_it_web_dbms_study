package com.koreait.dbms_study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto<T> {
    private String message; // 성공, 실패 메시지
    private T data;         // 실제 데이터 (유저, 게시물 등)
}
