import org.testng.annotations.Test;

public class TestCase02 extends TestBase{

    @Test
    public void readPropertyFromPom(){
        System.out.println(System.getProperty("Browser"));
        System.out.println("This is TestCase02");
    }
}
