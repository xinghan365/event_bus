package zhihui.xu.event;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by zhihui.xu on 2017/9/8.
 */
public class TestEsper {

    private static final Logger log = LoggerFactory.getLogger(TestEsper.class);

    @Test
    public void up() {

    }

    public static class TestEvent {
        public String ename;


        public TestEvent(String ename) {
            this.ename = ename;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }
    }

    public static class TestListener implements UpdateListener {

        @Override
        public void update(EventBean[] newEvents, EventBean[] oldEvents) {
            EventBean event = newEvents[0];
            log.info("ename={}", event);
        }
    }
}
