package com.cc.service;

import com.cc.mapper.PersonMapper;
import com.cc.model.Person;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
@Service
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
    @Autowired
    private PersonMapper personMapper;

    public List<Person> findAll() {
        logger.info("find all person begin...");
        List<Person> persons = personMapper.findAll();
        logger.info("find all person end,return {} items data", persons.size());
        return persons;
    }

    public List<Person> findByPage(int start, int limit) {
        logger.info("find findByPage person start-{},limit-{}", start, limit);
        PageHelper.startPage(start, limit);
        List<Person> persons = personMapper.findAll();
        logger.info("find findByPage end,return {} items data", persons.size());
        return persons;
    }

    public int addPerson(Person p) {
        logger.info("insert person : {}", p);
        return personMapper.add(p);
    }

    public int updatePerson(Person p) {
        logger.info("update person: {}",p);
        return personMapper.update(p);
    }
}
