package Base;

import java.util.Random;

public class BaseLib {
    Random random = new Random();

    public int rondomNumber(){
        return random.nextInt(10000000);
    }
}
