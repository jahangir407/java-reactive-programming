package jhub.rp.sec02;

import jhub.rp.util.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDate;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class AssignmentStockPriceClient {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);

        AssignmentStockPricePublisher.getStockPriceUpdate()
                .subscribeWith(new Subscriber<Integer>() {
                    private Subscription subscription;
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        subscription.request(Long.MAX_VALUE);


                    }

                    @Override
                    public void onNext(Integer price) {

                        System.out.println(LocalDate.now() + " : Price:: " + price);

                        if(price<90 || price> 110){
                            subscription.cancel();
                            latch.countDown();
                        }


                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("ERROR:: " + throwable.getMessage());
                        latch.countDown();

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Data emitting is Completed");
                        latch.countDown();

                    }
                });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
