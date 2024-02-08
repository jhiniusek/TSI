package Car_Builder;

public class FamilyCar extends CarBuilder{

    @Override
    public void installEngine(){
        car.setEngine("1.6 tdi");
    }
    @Override
    public void installBrakes(){
        car.setBrakes("four abs");
    }
    @Override
    public void installTires(){
        car.setTires("winter tires");
    }
    @Override
    public Car getCarInfo(){
        return car;
    }

}
