package Car_Builder;

import java.util.Scanner;

public class CarDirector {

    public void construct(CarBuilder builder){
        builder.installEngine();
        builder.installBrakes();
        builder.installTires();
    }
}
