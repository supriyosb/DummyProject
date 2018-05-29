import org.testng.annotations.BeforeClass;

public class TestBase {

    @BeforeClass
    public void prepareBase(){
        System.out.println("Before Class");
    }
}
