package zhihui.xu.event;

/**
 * Created by zhihui.xu on 2017/9/8.
 */
public interface EventBus {

    void register(Object o);

    void unregister(Object o);

    void post(Object event);



}
