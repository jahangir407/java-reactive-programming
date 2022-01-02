package jhub.rp.sec02;


import jhub.rp.util.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Usually requesting for data or canceling the subscription all those things are taken care internally by reactor.
 * Here is a custom implementation of the subscriber, where we can control those things by ourselves.
 */


public class Lec07Subscription {

    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1,20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received Sub:: " +subscription);
                        atomicReference.set(subscription);

                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("Received:: " + integer);

                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("ERROR:: " + throwable.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Data emitting is completed. ");

                    }
                });

        Util.sleepForSeconds(3);
        atomicReference.get().request(3);
        Util.sleepForSeconds(3);
        atomicReference.get().request(3);
        Util.sleepForSeconds(3);
        atomicReference.get().request(3);
        Util.sleepForSeconds(3);

        /**
         * whenever subscriber cancel the subscription or onError()/OnComplete() triggered, publisher will stop emitting
         * data.
         */
        atomicReference.get().cancel();
        Util.sleepForSeconds(4);
        //here we won't receive any data.
        atomicReference.get().request(3);
    }
}
