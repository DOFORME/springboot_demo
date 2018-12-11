import com.lc.springboot.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
// 不在Application类的子包下，需要指定
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration
public class BaseTest {

    @Test
    public void base() {
        System.err.println(" ==========test is running=========");
    }
}
