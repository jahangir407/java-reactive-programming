package jhub.rp.sec01;

import jhub.rp.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;


/**
 * Way of creating Mono
 *      - from Future
 *      - use when data is coming from async completableFuture.
 *      - use when you have some Future.
 */
public class Lec08MonoFromFuture {
    public static void main(String[] args) {

        Mono.fromFuture(getName())
                .subscribe(
                        Util.onNext()
                );

        Util.sleepForSeconds(1);

    }

    /**
     * CompletableFuture
     *      - is a Future.
     *      - introduced in as part of Java 8
     *      - basically java equivalent of JavaScript promises.
     * @return
     */

    public static CompletableFuture<String> getName(){
        // supplyAsync() -> will be executed asynchronously  as part of ForkJoinPool.
        //ForkJoinPool -> http://tutorials.jenkov.com/java-util-concurrent/java-fork-and-join-forkjoinpool.html
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }
}
