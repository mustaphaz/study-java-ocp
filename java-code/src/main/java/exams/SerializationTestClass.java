package exams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Boo implements Serializable {
    transient int ti = 10;
    static int si = 20;
}

public class SerializationTestClass {
    public static void main(String[] args) throws Exception {
        Boo boo = new Boo();
        boo.si++;
        System.out.println(boo.ti + " " + boo.si);
        FileOutputStream fos = new FileOutputStream("c:\\temp\\boo.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(boo);
        os.close();

        FileInputStream fis = new FileInputStream("c:\\temp\\boo.ser");
        ObjectInputStream is = new ObjectInputStream(fis);
        boo = (Boo) is.readObject();
        is.close();
        System.out.println(boo.ti + " " + boo.si);
    }
}
