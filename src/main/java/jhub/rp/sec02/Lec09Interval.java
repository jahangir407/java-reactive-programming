package jhub.rp.sec02;


import jhub.rp.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * Ways of creation Flux
 *  - from interval
 */
public class Lec09Interval {

    public static void main(String[] args) {

        /**
         *      - published item periodically.
         *      - it happens in non-blocking asynchronous way.
         *      - use a different thread pool.
         *      - use case: if we want to send anything to the end user periodically.
         */

        Flux.interval(Duration.ofSeconds(1))
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        Util.sleepForSeconds(10);
    }
}
