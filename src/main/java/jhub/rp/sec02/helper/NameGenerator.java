package jhub.rp.sec02.helper;

import jhub.rp.util.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static List<String> getNames(int count){
        List<String> names = new ArrayList<>(5);
        for (int i = 0; i < count; i++) {
            names.add(getName());

        }

        return names;
    }

    public static Flux<String> getNamesPublisher(int count){
        return Flux.range(0, count)
                .map(i -> getName());
    }

    private static String getName(){
        Util.sleepForSeconds(1);
        return Util.faker().name().fullName();
    }
}
