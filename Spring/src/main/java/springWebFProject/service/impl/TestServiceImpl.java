package springWebFProject.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springWebFProject.Test;
import springWebFProject.service.TestService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    List<Test> tests = new ArrayList<>();

    @Override
    public List<Test> getTest() {
        return tests;
    }

    @Override
    public void save(Test test) {
        tests.add(test);
    }
}
