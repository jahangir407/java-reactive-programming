package jhub.rp.sec02;

import jhub.rp.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class AssignmentStockPricePublisher {

    private static AtomicInteger initPrice = new AtomicInteger(100);

    public static Flux<Integer> getStockPriceUpdate(){
        return Flux.interval(Duration.ofSeconds(1))
                .map( i-> initPrice.getAndAccumulate(
                        Util.faker().random().nextInt(-5,5),
                        Integer::sum
                ));
    }
}
