package jhub.rp.sec01;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;

public class FileService {
    private static final Path PATH = Paths.get("src/main/resources/assignment/sec01");

    public static Mono<String> readFile(String fileName){
        return Mono.fromSupplier(fileReadHelper(fileName));
    }

    /**
     * Mono<Void> -> we are not returning anything here (as part of this write file). Basically this is just an
     * operation we want to notify the subscriber. So we used here Mono<Void>. We are not want to return null or
     * anything. Even void should be treated as Mono<Void>.
     * we use Mono.fromRunnable() to simply notify the subscriber/user when things are done.
     * @param fileName
     * @param content
     * @return
     */
    public static Mono<Void> writeFile(String fileName, String content){
        return Mono.fromRunnable(fileWriteHelper(fileName, content));

    }

    public static Mono<Void> deleteFile(String fileName){
        return Mono.fromRunnable(fileDeletionHelper(fileName));
    }

    private static Supplier<String> fileReadHelper(String fileName){
        return () -> {
            //File read operation
            try {
                System.out.println("Reading file : " + fileName);
                return Files.readString(PATH.resolve(fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private static Runnable fileWriteHelper(String fileName, String content){
        return () -> {
            //File write operation
            try {
                Files.writeString(PATH.resolve(fileName),content);
                System.out.println("Write operation is completed.");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }




    public static Runnable fileDeletionHelper(String fileName){
        return () -> {
            //File delete operation
            try {
                System.out.println("Deleting file: " + fileName);
                Files.delete(PATH.resolve(fileName));
                System.out.println("Delete Operation is completed.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }


}
