package com.koreait.dbms_study.dto;

import com.koreait.dbms_study.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.swing.*;

@Data
@AllArgsConstructor
@Builder

//응답 DTO
// Post 데이터만 담는 응답용 DTO -> Post 엔티티 데이터를 담는 DTO
public class PostRespDto<T> {
    private Integer postId;
    private String message;
    private T data;


}
