package zhihui.xu.event;

import org.testng.annotations.Test;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by zhihui.xu on 2017/9/8.
 */
public class TestHelloWorld {

    @Test
    public void test(){
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("Hello, world!");
                        sub.onCompleted();
                    }
                }
        );
        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) { System.out.println(s); }

            @Override
            public void onCompleted() { }

            @Override
            public void onError(Throwable e) { }
        };
        myObservable.subscribe(mySubscriber);
    }
}
