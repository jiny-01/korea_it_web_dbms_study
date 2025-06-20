package com.koreait.dbms_study.service;

import com.koreait.dbms_study.dto.AddUserReqDto;
import com.koreait.dbms_study.dto.ApiResDto;
import com.koreait.dbms_study.dto.EditUserReqDto;
import com.koreait.dbms_study.entity.User;
import com.koreait.dbms_study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Map<String, String> addUser(AddUserReqDto addUserReqDto) {
        Map<String, String> response = new HashMap<>();
        int result = userRepository.addUser(addUserReqDto.toEntity());
        if (result == 1) {
            response.put("status", "success");
            response.put("message", "추가성공");
            return response;
        }
        response.put("status", "failed");
        response.put("message", "추가실패");
        return response;
    }

    public List<User> getUserList() {

        return userRepository.getUserList();
    }

    public Map<String, Object> getUserByUserId(Integer userId) {
        Map<String, Object> response = new HashMap<>();

        Optional<User> user = userRepository.getUserByUserId(userId);
        if (user.isEmpty()) {
            response.put("message", "회원정보가 없습니다.");
            return response;
        }
        response.put("user", user);
        return response;
    }

    public ApiResDto<User> editUser(EditUserReqDto editUserReqDto) {
        //유효성 검사 => 해당 userId 가 존재하는지 확인
        // (is.Empty 사용하기 위해 Optional)
        //Optional<T>는 null이 올 수 있는 값을 넣는 Wrapper 클래스

        Optional<User> user = userRepository.getUserByUserId(editUserReqDto.getUserId());
        if(user.isEmpty()) {
            return new ApiResDto<>("해당 유저가 존재하지 않음", null);
        }
        userRepository.editUser(editUserReqDto.toEntity());
        //DTO 객체인 editUserReqDto를 User (엔티티 객체)로 변환하기
        return new ApiResDto<>("성공적으로 수정이 완료됨", null);
                //editUserReqDto의 내용을 Entity로 만들어 editUser 에 담음

//        int result = userRepository.editUser(editUserReqDto.toEntity());
//        if(result == 0) {
//            return new ApiResDto<>("성공적으로 수정이 완료됨", null);
//        }
//        return new ApiResDto<>("성공적으로 수정이 완료됨", null);
    }

    //게시물 삭제
    public ApiResDto<Integer> removeUser(Integer userId) {
        Optional<User> user = userRepository.getUserByUserId(userId);
        if(user.isEmpty()) {
            return new ApiResDto<>("해당 유저가 존재하지 않습니다.", null);
        }
        int result = userRepository.removeUser(userId);
        //삭제 성공한 행의 개수(?)
        if(result == 0) {
            return new ApiResDto<>("문제가 발생했습니다.", result);
        }
        return new ApiResDto<>("성공적으로 삭제되었습니다", result);


    }
}
