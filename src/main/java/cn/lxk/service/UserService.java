package cn.lxk.service;

import cn.lxk.domain.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);
    List<User> getUserList();
    int add(User user);
    int update( int id, User user);
    int delete(int id);
}
