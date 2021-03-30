package com.imooc.restful.controller;

import org.springframework.web.bind.annotation.*;
import com.imooc.restful.entity.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * restful风格
 */
@RestController
@RequestMapping("/restful")
public class RestfulController {
    @GetMapping("/request")
    public String doGetRequest(String name) {
        return "{\"message\":\"返回查询结果:" + name + "\"}";
    }

    //POST /article/1 1是变化的，下次可能是2，路径变量
    @PostMapping("/request/{rid}")
    public String doPostRequest(@PathVariable("rid") Integer requestId, Person person) {
        System.out.println(person.getName() + ":" + person.getAge());
        return "{\"message\":\"数据新建成功\",\"id\":" + requestId + "}";
    }

    @PutMapping("/request")

    public String doPutRequest(Person person) {
        System.out.println(person.getName() + ":" + person.getAge());
        return "{\"message\":\"数据更新成功\"}";
    }

    @DeleteMapping("/request")
    public String doDeleteRequest() {
        return "{\"message\":\"数据删除成功\"}";
    }

    @GetMapping("/person")
    public Person findByPersonId(Integer id) {
        Person person = new Person();
        if (id == 1) {
            person.setName("lily");
            person.setAge(23);
        } else if (id == 2) {
            person.setName("张三");
            person.setAge(18);
        }
        return person;
    }

    @GetMapping("/persons")
    public List<Person> findPersons() {
        List list = new ArrayList();
        Person person = new Person();
        person.setName("lily");
        person.setAge(23);
        person.setDate(new Date());
        Person person1 = new Person();

        person1.setName("张三");
        person1.setAge(18);
        person1.setDate(new Date());

        list.add(person);
        list.add(person1);
        System.out.println(list);

        return list;
    }

}
