package jhub.rp.sec01;

import jhub.rp.util.Util;
import reactor.core.publisher.Mono;

public class Lec06RefactoringSupplier {

    public static void main(String[] args) {
        /**
         * ---------------- Pipeline vs Executing Pipeline--------------------
         * Pretend that when we are building the pipeline, we are not spending time.
         * ( The time Java spend for building a pipeline is negligible.)
         *
         * Executing the pipeline is time-consuming where actual business logic will be executed.
         * Whatever the business logic we want to execute, put it in a way that it will get execute lazily.
         */

        //This method invoke will only build the pipeline. Will not execute the pipeline.
        getName();

        //When ever we will subscribe to a publisher, the pipeline will be executed.
        //This method call will execute the pipeline since we subscribed to the publisher.
        getName().subscribe(
                Util.onNext()
        );

        //This method invoke will only build the pipeline. Will not execute the pipeline.
        getName();

    }

    /**
     * Part of Method vs Part of Pipeline
     * Statements which are part of the method will be executed whenever the method is invoked.
     * Statements which are part of the pipeline will be executed whenever we will subscribe to the Publisher.
     * @return
     */

    public static Mono<String> getName(){
        System.out.println("Entered getName() method....");
        return Mono.fromSupplier(()->{
            System.out.println("Generating name...");

            Util.sleepForSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
