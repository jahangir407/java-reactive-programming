package jhub.rp.sec02.helper;

import jhub.rp.util.Util;
import reactor.core.publisher.Flux;

/**
 * Creating mono from Flux
 */
public class Lec11FluxToMono {

    public static void main(String[] args) {

        Flux.range(1,10)
                .filter(i -> i > 5) //optional. will help to filter the item.
                .next() // will pick the first item from the pipeline and convert it into Mono and pass it.
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }
}
