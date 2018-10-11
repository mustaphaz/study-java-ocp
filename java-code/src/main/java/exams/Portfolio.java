package exams;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Bond {
    String ticker = "bac"; double coupon = 8.3;
}

public class Portfolio implements Serializable {
    String accountName; transient Bond bond = new Bond();

    private void writeObject(ObjectOutputStream os) throws Exception{
        os.defaultWriteObject();
        os.writeObject(bond.ticker);
        os.writeObject(bond.coupon);
    }

    private void readObject(ObjectInputStream is) throws Exception {
        is.defaultReadObject();
        this.bond = new Bond();
        bond.ticker = (String) is.readObject();
        bond.coupon = is.readDouble();
    }
}
