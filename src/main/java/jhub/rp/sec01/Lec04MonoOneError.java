package jhub.rp.sec01;

import jhub.rp.util.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoOneError {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("data")
                .map(String::length)
                .map(l -> l/0);

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
        System.out.println("-------------END OF main()_______________");

    }
}
