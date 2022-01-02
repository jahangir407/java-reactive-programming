package jhub.rp.sec02;

import jhub.rp.util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

/**
 * Ways of creating flux
 *      - from Array or List
 */
public class Lec03FluxFromListOrArray {

    public static void main(String[] args) {

        //Creating Flux from List
        List<String> strings = Arrays.asList(
                "a",  "b", "c", "d"
        );
        Flux.fromIterable(strings)
                .subscribe(
                    Util.onNext(),
                    Util.onError(),
                    Util.onComplete()
        );

        //Creating Flux from Array
        Integer[] arr = { 1, 2, 3, 4, 5 };
        Flux.fromArray(arr)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

    }
}
