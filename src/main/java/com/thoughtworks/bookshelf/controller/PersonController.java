package com.thoughtworks.bookshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.thoughtworks.bookshelf.model.Person;

@Controller
public class PersonController {

    /**
     * 查询个人信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/person/profile/{id}/{name}/{status}", method = RequestMethod.GET)
    public @ResponseBody
    Person porfile(@PathVariable int id, @PathVariable String name,
                   @PathVariable boolean status) {
        return new Person(id, name, status);
    }

    /**
     * 登录
     *
     * @param person
     * @return
     */
    @RequestMapping(value = "/person/login", method = RequestMethod.POST)
    public @ResponseBody
    Person login(@RequestBody Person person) {
        return person;
    }
}
