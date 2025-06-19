package com.koreait.dbms_study.dto;

import com.koreait.dbms_study.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddPostReqDto {
    private int postId;
    private String title;
    private String content;
    private int userId;

    //dto -> entity 변환
    public Post toEntity() {
        return Post.builder()
                .postId(this.postId)
                .title(this.title)
                .content(this.content)
                .userId(this.userId)
                .build();

    }
}
