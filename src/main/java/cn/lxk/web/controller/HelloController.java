package cn.lxk.web.controller;

import cn.lxk.domain.entity.Hello;
import cn.lxk.domain.entity.Hello2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Hello hello;

    @Autowired
    private Hello2 hello2;

    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    public String sayHello() {
        return "Hello SpringBoot 2";
    }

    @RequestMapping(value = "/testProperty",method = RequestMethod.GET )
    public String testProperty() {
        return hello.getToString();
    }

    @RequestMapping(value = "/testProperty2",method = RequestMethod.GET)
    public String testProperty2() {
        return hello2.getUsername();
    }

}
