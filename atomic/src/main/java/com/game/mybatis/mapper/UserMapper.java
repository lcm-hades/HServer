package com.game.mybatis.mapper;

import com.game.mybatis.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> getAllUser();
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUserByID(int id);
}
