package fr.swiftfaze.brink;

import fr.swiftfaze.brink.rest.BeBrinkApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;



@SpringBootTest(classes = BeBrinkApplication.class)
public class SpringContextTest {

    @Test
    public void contextLoads() {
        System.out.println("Hello World");
        boolean bRes= true;
        assertTrue(bRes);
    }
}
