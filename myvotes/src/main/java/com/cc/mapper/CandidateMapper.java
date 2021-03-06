package com.cc.mapper;

import com.cc.model.Candidate;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public interface CandidateMapper {
    List<Candidate> findAll();

    Candidate selectByPrimaryKey(Integer id);

    int insert(Candidate candidate);

    int update(Candidate candidate);

    Candidate selectByPrimaryKeyForlock(Integer id);

    int deleteCandidateById(Integer candidateId);
}
