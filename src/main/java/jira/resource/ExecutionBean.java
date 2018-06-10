package jira.resource;

import java.util.List;

public class ExecutionBean {
    private List<TestBean> testBeans;

    public List<TestBean> getTestBeans() {
        return testBeans;
    }

    public void setTestBeans(List<TestBean> testBeans) {
        this.testBeans = testBeans;
    }
}
