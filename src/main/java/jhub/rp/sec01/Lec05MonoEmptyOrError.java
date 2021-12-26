package jhub.rp.sec01;

import jhub.rp.util.Util;
import reactor.core.publisher.Mono;

/**
 * Assume that a function accept Mono<Address>. But don't have data. Usually in traditional programming if we don't have
 * data we will be passing null. But in Reactive programming there is no null. We don't check like if not null all those
 * stuffs. In that case we simply pass Mono.empty().
 * If we don't  have data, always pass Mono.empty().
 */

public class Lec05MonoEmptyOrError {
    public static void main(String[] args) {

        /**
         * onNext() then onComplete() signal will be invoked
         */

        userRepository(1)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        /**
         * when empty, will only invoke the onComplete() signal
         */
        userRepository(2)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        /**
         * Assume we create a function which has to return a Mono. If we have some exceptions, simply use Mono.error().
         * If we throw some exceptions, the supplier itself that will kind of handle everything internally, simply can
         * Mono.error().
         * onError() will be triggered. then onComplete() will be invoked.
         * ###End of the day we have to return a Mono. So there are many way we can return a Mono various way####
         */
        userRepository(3)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        System.out.println("-------------END OF main()_______________");

    }

    private static Mono<String> userRepository(int userId){
        if (userId == 1){
            return Mono.just(Util.faker().name().fullName());
        }
        else if(userId == 2){
            /**
             * Mono.empty will act as null.
             */
            return Mono.empty();
        }else
            return Mono.error(new RuntimeException("Not in the allowed range"));
    }
}
