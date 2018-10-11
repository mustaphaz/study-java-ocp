package ch8;

import java.io.File;

public class FileSample {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        File file1 = new File(currentDir + "/java-ocp/src/main/java/ch8/zoo.txt");

        File parent = new File(System.getProperty("user.dir"));
        File file2 = new File(parent + "/java-ocp/src/main/java/ch8/zoo.txt");

        System.out.println("File1 exist : " + file1.exists() + " Path: " + file1.getAbsolutePath());
        System.out.println("File2 exist : " + file2.exists() + " Path: " + file2.getAbsolutePath());
    }
}
