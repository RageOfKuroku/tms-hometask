package springWebFProject.service;

import springWebFProject.Test;

import java.util.List;

public interface TestService {

    public List<Test> getTest();

    void save(Test test);
}
