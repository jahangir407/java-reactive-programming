package jhub.rp.sec01;

import jhub.rp.util.Util;
import reactor.core.publisher.Mono;


/**
 * Way of creating Mono
 *      - from Runnable
 *      - use when want to notify the subscriber when some operation is done.
 *      - basically we don't have anything to return. Simply want to tell the user that the operation is completed.
 */
public class Lec09MonoFromRunnable {

    public static void main(String[] args) {

        /**
         * sometime there will be some time-consuming operation we want to be notified when the operation is completed.
         * That is when it will be very useful.
         * Here onComplete() is also a Runnable which depends on timeConsumingProcess Runnable.
         */
         Mono.fromRunnable(timeConsumingProcess())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }


    public static Runnable timeConsumingProcess(){
        return () -> {
            Util.sleepForSeconds(3);
            System.out.println("Operation completed");
        };
    }
}
