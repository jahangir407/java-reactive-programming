package jhub.rp.sec02;

import jhub.rp.util.Util;
import reactor.core.publisher.Flux;

/**
 *
 */
public class Lec02MultipleSubscribers {

    public static void main(String[] args) {

        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5, 6);

        /**
         * we can create another flux from existing one by chaining operators.
         *
         */
        Flux<Integer> eventFlux = integerFlux.filter(i -> i % 2 == 0);

        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        eventFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

    }
}
