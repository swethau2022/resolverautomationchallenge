import org.testng.annotations.Test;
import pages.HomePage;
import utilities.BaseTest;

public class Test1 extends BaseTest {

    @Test
    public void testOne(){
        HomePage page = new HomePage();
        page.enterEmailAddress("email@email");
        page.enterPassword("123445");
    }

}
