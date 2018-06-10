import org.testng.annotations.Test;

import java.text.MessageFormat;

public class TestCase01 extends TestBase{

    @Test
    public void readPropertyFromPom(){
        System.out.println(System.getProperty("JiraIssueKey"));

        String message = "Hello {0} World {1}";
        String modifiedMessage = MessageFormat.format(message, "Supriyo", "Biswas");
        System.out.println(modifiedMessage);
    }
}
