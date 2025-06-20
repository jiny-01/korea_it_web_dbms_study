package com.koreait.dbms_study.repository;

import com.koreait.dbms_study.dto.AddUserReqDto;
import com.koreait.dbms_study.entity.User;
import com.koreait.dbms_study.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired      //UserMapper 에 @Mapper 있으므로 ioc 컨테이너에 있음 - 알아서 가져옴
    private UserMapper userMapper;

    public int addUser(User user) {

        return userMapper.insert(user);         //insert 실행한 결과물 바로 리턴
    }

    public List<User> getUserList() {

        return userMapper.getUserList();
    }

    public Optional<User> getUserByUserId(Integer userId) {

        return userMapper.getUserByUserId(userId);
    }


    public int editUser(User user) {

        return userMapper.editUser(user);        //mapper의 editUser 결과 -> int 리턴
    }

    public int removeUser(Integer userId) {

        return userMapper.removeUser(userId);
    }


}