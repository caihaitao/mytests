package com.cc.mapper;

import com.cc.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
@Repository
public interface PersonMapper {
    List<Person> findAll();

    int add(Person person);

    int update(Person person);
}
