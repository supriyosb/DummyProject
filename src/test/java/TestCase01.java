import org.testng.annotations.Test;

public class TestCase01 extends TestBase{

    @Test
    public void readPropertyFromPom(){
        System.out.println(System.getProperty("propertyName"));
    }
}
