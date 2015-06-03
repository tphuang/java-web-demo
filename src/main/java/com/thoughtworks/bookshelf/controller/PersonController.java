package com.thoughtworks.bookshelf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.thoughtworks.bookshelf.entity.Person;

@Controller
@RequestMapping("/person/")
public class PersonController {

    /**
     * 查询个人信息, RESTful风格。
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "myprofile/{id}/{name}/{status}", method = RequestMethod.GET)
    public @ResponseBody Person profile(@PathVariable int id, @PathVariable String name,
                   @PathVariable boolean status) {
        Person person = new Person(id, name, status);
        return person;
    }

    /**
     * 查询个人信息，传统风格
     * @param request
     * @return
     */
    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public @ResponseBody String getProfile(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        Person person = new Person(id, name, status);
        return JSON.toJSONString(person);
    }

    /**
     * 登录
     *
     * @param person
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody Person login(@RequestBody Person person) {
        return person;
    }
}
