package jhub.rp.sec01;

import jhub.rp.util.Util;

public class FileServiceClient {

    public static void main(String[] args) {

        //Creating file;
        FileService.writeFile("file1.txt","This is some dummy content for file1")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        //Creating file;
        FileService.writeFile("file2.txt","This is some dummy content for file2")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        //Reading file
        FileService.readFile("file2.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
        //Reading file
        FileService.readFile("file3.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        //Deleting file
        FileService.deleteFile("file1.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        //Deleting file
        FileService.deleteFile("file2.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        //Deleting file
        FileService.deleteFile("file3.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

    }
}
