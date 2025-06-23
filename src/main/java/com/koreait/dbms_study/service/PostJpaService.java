package com.koreait.dbms_study.service;

import com.koreait.dbms_study.dto.AddPostJpaReqDto;
import com.koreait.dbms_study.dto.AddPostReqDto;
import com.koreait.dbms_study.dto.ApiResDto;
import com.koreait.dbms_study.dto.EditPostReqDto;
import com.koreait.dbms_study.entity.JpaPost;
import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.repository.PostJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostJpaService {

    @Autowired
    private PostJpaRepository postJpaRepository;

    //게시물 추가
    public JpaPost addPost(AddPostJpaReqDto addPostJpaReqDto) {
        return postJpaRepository.save(addPostJpaReqDto.toJpaEntity());
    }

    //게시물 전체 조회
    public List<JpaPost> getPostList() {
        return postJpaRepository.findAll();
    }

    //게시물 수정
    public ApiResDto<?> editPost(EditPostReqDto editPostReqDto) {
        Optional<JpaPost> optionalPost = postJpaRepository.findById(editPostReqDto.getPostId());
        if (optionalPost.isEmpty()) {
            return new ApiResDto<>("해당 게시물이 존재하지 않습니다.", null);
        }
        try {
            JpaPost jpaPost = optionalPost.get();
            jpaPost.setTitle(editPostReqDto.getTitle());
            jpaPost.setContent(editPostReqDto.getContent());
            jpaPost.setUpdateDt(LocalDateTime.now());
            postJpaRepository.save(jpaPost);
            return new ApiResDto<>("수정완료", jpaPost);
        } catch (Exception e) {
            return new ApiResDto<>("문제가 발생했습니다.", e.getMessage());
        }
    }

    //게시물 삭제
    public ApiResDto<?> removePost(Integer postId) {
        Optional<JpaPost> optionalPost = postJpaRepository.findById(postId);
        if(optionalPost.isEmpty()) {
            return new ApiResDto<>("해당 게시물이 존재하지 않습니다.", null);
        }
        try {
            postJpaRepository.deleteById(postId);
        } catch (Exception e) {
            return new ApiResDto<>("문제가 발생함", e.getMessage());
        }
        return new ApiResDto<>("게시물 삭제완료", null);
    }



    }

