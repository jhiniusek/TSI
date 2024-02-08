package Car_Builder;

abstract public class CarBuilder {
    protected Car car = new Car();

    public abstract void installEngine();
    public abstract void installBrakes();
    public abstract void installTires();
    public abstract Car getCarInfo();

}
