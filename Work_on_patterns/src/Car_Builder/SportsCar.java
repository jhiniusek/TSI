package Car_Builder;

public class SportsCar extends CarBuilder{
    @Override
    public void installEngine(){
        car.setEngine("V10");
    }
    @Override
    public void installBrakes(){
        car.setBrakes("rear disc brakes");
    }
    @Override
    public void installTires(){
        car.setTires("sports tires");
    }
    @Override
    public Car getCarInfo(){
        return car;
    }

}
