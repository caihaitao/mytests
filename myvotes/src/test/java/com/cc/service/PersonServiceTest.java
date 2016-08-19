package com.cc.service;

import com.cc.BaseTest;
import com.cc.model.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */

public class PersonServiceTest extends BaseTest {
    @Autowired
    private PersonService personService;

    @Test
    public void testFindAll() {
        List<Person> personList = personService.findAll();
        personList.forEach(person -> System.err.println(person));
    }

    @Test
    public void testFindByPage() {
        int start = 2;
        int limit = 3;
        List<Person> personList = personService.findByPage(start, limit);
        personList.forEach(person -> System.err.println(person));
    }


    @Test
    public void testAdd() {
        Person p = new Person();
        p.setName("qinqin");
        p.setAge(22);
        p.setCountry("China");
        System.err.println(personService.addPerson(p));
    }

    @Test
    public void testUpdate() {
        Person p = new Person();
        p.setName("qinqin");
        p.setAge(25);
        p.setCountry("China");
        p.setId(3);
        System.err.println(personService.updatePerson(p));
    }

}
