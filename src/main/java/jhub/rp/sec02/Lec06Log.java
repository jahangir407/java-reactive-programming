package jhub.rp.sec02;

import jhub.rp.util.Util;
import reactor.core.publisher.Flux;

/**
 * log usually helps to investigate what is happening behind the scene.
 */

public class Lec06Log {

    public static void main(String[] args) {

        Flux.range(1,10)
                .log() //logs what happening between range() and map. Here range() is a publisher and map is the subscriber.
                .map(i -> Util.faker().name().fullName())
                .log() // logs what happening between map() and subscribe(). Here map() is the publisher and subscribe() is the subscriber.
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

    }

}
