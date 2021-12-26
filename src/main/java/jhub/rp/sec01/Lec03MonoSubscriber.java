package jhub.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec03MonoSubscriber {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("data");

        /**
         * option 1: using the subscribe() method -> It will make the publisher to emit data.
         * Since we are not providing any consumer behavior, we won't able to see the data.
         */
        mono.subscribe();

        /**
         * option 2: to providing the behavior for the onNext() method
         */
        mono.subscribe(str -> System.out.println("option 2: " +str));

        /**
         * option 3: providing the behavior for onNext() and onError()
         */

        mono.subscribe( str -> System.out.println("option 3: " + str),
                err -> err.printStackTrace());

        /**
         * option 4: providing the behavior for onNext(), onError() and onComplete()
         */

        mono.subscribe( str -> System.out.println("option 4: " + str),
                err -> err.printStackTrace(),
                () -> System.out.println("option 4: completed"));
        System.out.println("-------------END OF main()_______________");
    }
}
