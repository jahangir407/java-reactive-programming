package jhub.rp.sec02;

import jhub.rp.sec02.helper.NameGenerator;
import jhub.rp.util.Util;

import java.util.List;

public class Lec08FluxVsList {

    public static void main(String[] args) {

        //we will get the name list whenever number of required names are ready.
        //List is a Data structure.
        List<String> names = NameGenerator.getNames(5);
        System.out.println(names);




        //Since this is a publisher, it will emit name whenever one is ready. We do not have to wait till all the
        //names need to be prepared.
        NameGenerator.getNamesPublisher(5)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }
}
