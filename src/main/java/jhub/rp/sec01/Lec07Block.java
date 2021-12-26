package jhub.rp.sec01;

import jhub.rp.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Lec07Block {
    /**
     * By default, whatever we are doing, everything are executing in the main thread / current thread.
     * This is the default behavior.
     *
     * When things are getting executed asynchronously, in order to see the output we have to block the main thread.
     * In real world we don't block. We will get the output whenever everything are done.
     *
     * block() ->
     *      - blocking subscriber
     *      - instead of you providing the consumer, it will actually block and will wait for the result.
     *      - it will give you the actual result and also block the current thread until get the result (even if the
     *          pipeline is executing in non-blocking asynchronous way).
     *      - useful for testing purpose but not suppose to use it while building the application.
     */


    public static void main(String[] args) {
        getName();
        String name = getName().subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(name);
        getName();
    }
    public static Mono<String> getName(){
        System.out.println("Entered getName() method....");
        return Mono.fromSupplier(()->{
            System.out.println("Generating name...");

            Util.sleepForSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }

}
