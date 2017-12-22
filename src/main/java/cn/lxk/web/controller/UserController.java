package cn.lxk.web.controller;

import cn.lxk.domain.entity.User;
import cn.lxk.service.UserService;
import cn.lxk.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserById(@PathVariable(value = "id") Integer id) {

        JsonResult result = new JsonResult();
        try{
            User user = userService.getUserById(id);
            result.setStatus("ok");
            result.setResult(user);
        }catch (Exception e) {
            e.printStackTrace();
            result.setStatus("error");
            result.setResult(e.getClass().getName()+":"+e.getMessage());
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserList() {
        JsonResult result = new JsonResult();
        try{
            List<User> users =  userService.getUserList();
            result.setStatus("ok");
            result.setResult(users);
        }catch(Exception e) {
            e.printStackTrace();
            result.setStatus("error");
            result.setResult(e.getClass().getName()+":"+e.getMessage());
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add(User user) {
        JsonResult result = new JsonResult();
        try{
            int i = userService.add(user);
            if (i < 0) {
                result.setStatus("failed");
                result.setResult(i);
            }else {
                result.setStatus("ok");
                result.setResult(i);
            }
        }catch(Exception e) {
            e.printStackTrace();
            result.setStatus("error");
            result.setResult(e.getClass().getName()+":"+e.getMessage());
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update(Integer id,User user) {
        JsonResult result = new JsonResult();
        try{
            int i = userService.update(id,user);
            if (i < 0) {
                result.setStatus("failed");
                result.setResult(i);
            }else {
                result.setStatus("ok");
                result.setResult(i);
            }
        }catch(Exception e) {
            e.printStackTrace();
            result.setStatus("error");
            result.setResult(e.getClass().getName()+":"+e.getMessage());
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(Integer id) {
        JsonResult result = new JsonResult();
        try{
            int i = userService.delete(id);
            if (i < 0) {
                result.setStatus("failed");
                result.setResult(i);
            }else {
                result.setStatus("ok");
                result.setResult(i);
            }
        }catch(Exception e) {
            e.printStackTrace();
            result.setStatus("error");
            result.setResult(e.getClass().getName()+":"+e.getMessage());
        }
        return ResponseEntity.ok(result);
    }
}
