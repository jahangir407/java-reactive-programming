package jhub.rp.sec02;

import jhub.rp.util.Util;
import reactor.core.publisher.Flux;

/**
 * Ways of creation Flux
 *  - from range
 */
public class Lec05FluxFromRange {

    public static void main(String[] args) {

        /**
         *  - acting like a for loop.
         *  - a new way of creating loop.
         *  - take two parameters.
         *      - start -> from where the count will start.
         *      - count -> number of item to emit.
         *      - by default the increment will be one.
         */

        //Emitting from 1 to 10
        Flux.range(1,10)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );


        //Emitting 10 names
        Flux.range(1,10)
                .map(i -> Util.faker().name().fullName())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

    }
}
