package jhub.rp.sec02;

import jhub.rp.util.Util;
import reactor.core.publisher.Flux;

/**
 * Way of creating Flux
 *      - just
 *      - should use when already have the data. When you don't have to spend time to create the data. Otherwise, don't
 *      use Flux.just(). It will be done eagerly. But we want to do things lazily.
 *
 */
public class Lec01FluxIntro {
    public static void main(String[] args) {

        Flux<Object> flux = Flux.just(1,2,3,'A', Util.faker().funnyName().name());

        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );


    }
}
