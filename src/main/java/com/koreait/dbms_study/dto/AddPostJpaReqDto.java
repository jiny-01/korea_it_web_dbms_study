package com.koreait.dbms_study.dto;

import com.koreait.dbms_study.entity.JpaPost;
import com.koreait.dbms_study.entity.Post;

import java.time.LocalDateTime;

public class AddPostJpaReqDto {

    private String title;
    private String content;
    private Integer userId;

    //dto -> entity 변환  =>Service 에서 Entity로 받기 위함
    public JpaPost toJpaEntity() {
        return JpaPost.builder()
                .title(this.title)
                .content(this.content)
                .userId(this.userId)
                .createDt(LocalDateTime.now())
                .build();
    }
}
