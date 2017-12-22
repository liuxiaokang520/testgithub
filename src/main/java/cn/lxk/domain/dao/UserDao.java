package cn.lxk.domain.dao;

import cn.lxk.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserDao {
    //@Select("SELECT id,username,age,ctm FROM tb_user WHERE id = #{id}")
    User getUserById(int id);
    //@Select("SELECT id,username,age,ctm FROM tb_user")
    List<User> getUserList();
    int add(User user);
    int update(@Param(value = "id") int id,@Param(value = "user") User user);
    int delete(int id);
}
