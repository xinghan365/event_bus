package zhihui.xu.event;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

/**
 * Created by zhihui.xu on 2017/9/8.
 */
public class TestEventBus {

    private static final Logger log = LoggerFactory.getLogger(TestEventBus.class);

    private com.google.common.eventbus.EventBus bus = new EventBus("EventBus");

    @BeforeClass
    public void beforeClass() {
        log.info("beforeClass");
    }


    @BeforeTest
    public void beforeTest() {
        log.info("BeforeTest");
        bus.register(new EventListener());
    }

    @Test
    public void test() {
        log.info("test");
        bus.post("hello world!");
    }

    @AfterTest
    public void afterTest() {
        log.info("AfterTest");
    }

    @AfterClass
    public void afterClass() {
        log.info("AfterClass");
    }

    public static class EventListener {

        @Subscribe
        public void pull(String message) {
            log.info("message={}", message);
        }
    }
}
