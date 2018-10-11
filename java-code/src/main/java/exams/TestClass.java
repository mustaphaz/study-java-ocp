package exams;

interface House {
    public default String getAddress() {
        return "101 Main Str";
    }
}

interface Office {
    public default String getAddress() {
        return "101 Smart Str";
    }
}

class HomeOffice implements House, Office {
    public String getAddress() {
        return "R No 1, Home";
    }
}

public class TestClass {
    public static void main(String[] args) {
        House h = new HomeOffice();  //1
        System.out.println(h.getAddress()); //2
    }
}
