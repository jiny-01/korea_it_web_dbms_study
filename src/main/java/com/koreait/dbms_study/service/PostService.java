package com.koreait.dbms_study.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.koreait.dbms_study.dto.*;
import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.entity.User;
import com.koreait.dbms_study.repository.PostRepository;
import com.koreait.dbms_study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    //게시물 추가 - 내가 한 거
//    public Map<String, String> addPost(AddPostReqDto addPostReqDto) {
//        Map<String, String> addResult = new HashMap<>();
//        int result = postRepository.addPost(addPostReqDto.toEntity());
//        if(result == 0) {
//            addResult.put("status", "게시물 추가실패- 다시 시도");
//            return addResult;
//        }
//        addResult.put("message", "게시물 추가 성공");
//        return addResult;
//    }

    //풀이
    public ApiResDto<?> addPost(AddPostReqDto addPostReqDto) {
      try {

          Optional<User> optionalUser = userRepository.getUserByUserId(addPostReqDto.getUserId());
          if (optionalUser.isEmpty()) {
              return new ApiResDto<>("존재하지 않는 유저", null);
          }
          int result = postRepository.addPost(addPostReqDto.toEntity());

          if(result == 0) {
              return new ApiResDto<>("문제 발생함", null);
          }
          return new ApiResDto<>("정상적으로 게시 완료", null);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }

      }

    //게시물 전체 조회 - 내가 한 거
//    public List<Post> getPostList() {
//
//        return postRepository.getPostList();
//    }

    //게시물 전체 조회 - 풀이
    public ApiResDto<?> getPostList() {
        try {
            List<Post> postList = postRepository.getPostList();
            return new ApiResDto<>("조회 완료", postList);
        } catch (Exception e) {
            return new ApiResDto<>("문제 발생", e.getMessage());
        }
    }

    //게시물 단건 조회 - 내가 한 거
//    public Map<String, Object> getPostByPostId(Integer postId) {
//        Map<String, Object> response = new HashMap<>();
//
//        Optional<Post> post = postRepository.getPostByPostId(postId);
//
//        if (post.isEmpty()) {
//            response.put("message", "게시물을 찾을 수 없습니다.");
//        }
//        response.put("post", post);
//        return response;
//    }



    //게시물 단건 조회 - 풀이
    public ApiResDto<Object> getPostByPostId(Integer postId) {
        try{
            Optional<Post> optionalPost = postRepository.getPostByPostId(postId);
            if(optionalPost.isEmpty()) {
                return new ApiResDto<>("해당 게시물 없음", null);
            }
            return new ApiResDto<>("조회 성공", optionalPost.get());
        } catch (Exception e) {
            return new ApiResDto<>("문제 발생", e.getMessage());
//            return optionalPost;
        }

    }

    //게시물 수정
    public ApiResDto<Post> editPost(EditPostReqDto editPostReqDto) {
        try {
            Optional<Post> post = postRepository.getPostByPostId(editPostReqDto.getPostId());

            if (post.isEmpty()) {
                return new ApiResDto<>("게시물을 찾을 수 없음", null);
            }
            int result = postRepository.editPost(editPostReqDto.toEntity());
            if (result != 1) {
                return new ApiResDto<>("문제발생함", null);
            }
            return new ApiResDto<>("게시물 수정완료", null);
        }catch (Exception e) {
            return new ApiResDto<>("수정 실패: " + e.getMessage(), null);
        }

    }


    //게시물 삭제
    public ApiResDto<?> removePost(Integer postId) {
        try {
            Optional<Post> optionalPost = postRepository.getPostByPostId(postId);
            if(optionalPost.isEmpty()) {
                return new ApiResDto<>("삭제할 게시물을 찾을 수 없음", null);
            }
            int result = postRepository.removePost(postId); // 실제 삭제 실행
            if (result != 1) {
                return new ApiResDto<>("문제발생함", null);
            }
            return new ApiResDto<>("게시물 삭제완료", null);
        }catch (Exception e) {
            return new ApiResDto<>("삭제 실패: " + e.getMessage(), null);
        }


    }





    }

