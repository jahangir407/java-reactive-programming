package jhub.rp.sec01;

import java.util.stream.Stream;

public class Lec01StreamLazyBehavior {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(5)
                .map(i -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i * 2;
                });

        /**
         * because of lazy loading behavior, this stream won't be executed until we connect a terminal operator with the stream.
         */
        System.out.println(stream);

        /**
         * Since forEach is a terminal operator, it will trigger the stream to flow.
         */
        stream.forEach(System.out::println);

        System.out.println("-------------END OF main()_______________");

    }
}
