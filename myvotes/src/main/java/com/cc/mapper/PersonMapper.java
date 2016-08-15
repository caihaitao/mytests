package com.cc.mapper;

import com.cc.model.Person;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public interface PersonMapper {
    List<Person> findAll();

    int add(Person person);

    int update(Person person);
}
