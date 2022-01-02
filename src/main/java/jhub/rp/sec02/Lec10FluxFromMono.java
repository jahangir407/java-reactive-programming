package jhub.rp.sec02;

import jhub.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Ways of creation Flux
 *  - from Mono/another publisher
 */
public class Lec10FluxFromMono {

    public static void main(String[] args) {

        Mono<String> mono = Mono.just("data");

        Flux<String> flux = Flux.from(mono);

        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
