package jhub.rp.sec01;

import jhub.rp.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;


/**
 * Way of creating Mono
 *      - from Supplier
 *      - from Callable
 *      - use when Data need to be calculated. If we want to do things lazily, then we can use Mono.fromSupplier() or
 *      Mono.Callable()
 */
public class Lec06MonoFromSupplier {

    public static void main(String[] args) {

        /**
         * Though there is no subscriber, It will invoke the getName() method. (not a good way)
         * Use just only when you have data already.
         */
        Mono<String> mono = Mono.just(getName());

        /**
         * supplier -> supplier is Java interface (functional interface), which will not be accepting any input
         * parameter, but it supposes to give you an output.
         *
         * fromSupplier() -> if somebody invokes this publisher, then we will be invoking this fromSupplier() method.
         *
         * purposes are ->
         *      1. we want to do the work only there is a request.
         *      2. For example if there is no subscriber then the getName() method should not invoke.
         *      3. Idea is thing should be lazy. Do thing only when required.
         */

        Supplier<String> stringSupplier = () -> getName();
        Mono<String> mono2 = Mono.fromSupplier(stringSupplier);

        mono2.subscribe(
                Util.onNext()
        );

        /**
         * Similar to Supplier but Callable is introduced before java 8.
         */

        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext()
                );

    }

    private static String getName(){
        System.out.println("Generating name......");
        return Util.faker().name().fullName();
    }
}
