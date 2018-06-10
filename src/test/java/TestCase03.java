import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jira.resource.ExecutionBean;
import jira.resource.TestBean;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase03 extends TestBase{

    @Test
    public void readPropertyFromPom(){
        System.out.println("This is TestCase03");

        String jsonString = "[{\"id\":3,\"status\":\"TODO\",\"key\":\"FMP-4\",\"rank\":1},{\"id\":4,\"status\":\"TODO\",\"key\":\"FMP-5\",\"rank\":2}]";
        Gson gson = new Gson();
        List<TestBean> testBeanList = gson.fromJson(jsonString, new TypeToken<List<TestBean>>(){}.getType());
        System.out.println(testBeanList.get(0).getKey());
        //ExecutionBean executionBean = gson.fromJson(jsonString, ExecutionBean.class);
        //System.out.println(executionBean.getTestBeans().get(0).getKey());
    }
}
