package com.koreait.dbms_study.mapper;

import com.koreait.dbms_study.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    //유저 정보 입력- 유저 추가
    int insert(User user);                  //insert 성공여부-> 0, 1로 반환

    //리스트로 전체 조회
    List<User> getUserList();

    //유저 단건 조회
    Optional<User> getUserByUserId(Integer UserId);    //Integer - null은 null로 표기
    //Optional - 안에 있는지 없는지 유무 확인

    //유저 객체 수정
    int editUser(User user);

    //유저 삭제
    int removeUser(Integer userId);

}
