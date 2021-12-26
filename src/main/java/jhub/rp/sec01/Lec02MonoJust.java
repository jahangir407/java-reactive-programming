package jhub.rp.sec01;

import reactor.core.publisher.Mono;


/**
 * Way of creating Mono
 *      - just
 *      - should use when already have the data. When you don't have to spend time to create the data. Otherwise, don't
 *      use Mono.just(). It will be done eagerly. But we want to do things lazily.
 *
 */
public class Lec02MonoJust {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("hello from Mono");

        /**
         * publisher will not emit any data since there is no subscription
         * will simply call the toString() method for object mono
         */
        System.out.println(mono);

        /**
         * Here we subscribed to the publisher and provided the consumer behavior
         */
        mono.subscribe(System.out::println);
        System.out.println("-------------END OF main()_______________");

    }
}
