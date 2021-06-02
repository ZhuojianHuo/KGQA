package com.imploded.controller;

import com.imploded.model.Person;
import com.imploded.respository.PersonRepository;
import com.imploded.result.ResponseMessage;
import com.imploded.result.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/imploded/person")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    /**
     * 根据人名查询Person实体
     *
     * @param name 姓名
     * @return
     */
    @RequestMapping("/get")
    public List<Person> getPersons(@RequestParam(value = "name") String name) {
        return personRepository.findByName(name);
    }

    /**
     * 创建一个person节点
     *
     * @param person 业务模型
     * @return
     */
    @PostMapping("/save")
    public ResponseResult savePerson(@RequestBody Person person) {
        personRepository.save(person);
        return new ResponseResult(ResponseMessage.OK);
    }
}
