package ch9;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ReviewQuestions {

    public static void question1() {
        Path path = Paths.get("/user/.././root", "../kodiacbear.txt");
        path.normalize().relativize(Paths.get("/lion"));
        System.out.println(path);

    }

/*    public static void question3() {
        Path path = Paths.get("sloth.schedule");
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        if (attributes.size() > 0 && attributes.creationTime().toMillis() > 0) {
            attributes.setTimes(null, null, null);
        }
    }*/

    public static void main(String[] args) {
        question1();

    }
}
