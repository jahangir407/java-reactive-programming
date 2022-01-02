package jhub.rp.sec02;

import jhub.rp.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

/**
 * Ways of creating flux
 *      - from Stream
 */
public class Lec04FluxFromStream {

    public static void main(String[] args) {

        List<String> list = List.of("a", "b", "c", "d", "e");
        Stream<String> stream = list.stream();

        /**
         * As we know stream is one time operation.
         * Once we applied all our operations, we can not reuse the stream.
         * When closed, can not access the same stream again to connect another terminal operator.
         */
//        stream.forEach(System.out::println); //stream is closed
//        stream.forEach(System.out::println); //can not access the closed stream.

        //will get the data since stream is not used yet
        Flux.fromStream(stream)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        //will get exception since stream is already closed.
        //here stream object has the same reference
        Flux.fromStream(stream)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        /**
         * while using a stream it is better to supplier of stream to avoid this issue.
         */

        Flux.fromStream(() -> list.stream())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        //Alternative
        Flux.fromStream( list.stream())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );





    }
}
