package com.cc.controller;

import com.cc.BaseTest;
import com.cc.model.Candidate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Administrator on 2016/8/17.
 */
@WebIntegrationTest("server.port:8080")
public class VoteContrllerTest extends BaseTest {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${local.server.port}")// 注入端口号
    private int port;

    @Test
    public void vote() {
        String url = "http://localhost:" + port + "/vote/candidates";

        List<Candidate> result = restTemplate.getForObject(url, List.class);
        System.out.println(result);

    }
}
