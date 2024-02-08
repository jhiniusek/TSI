package Car_Builder;

public class Car {
    private String engine;
    private String brakes;
    private String tires;

    public Car() {}

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setBrakes(String brakes) {
        this.brakes = brakes;
    }

    public void setTires(String tires) {
        this.tires = tires;
    }

    public void getInfo(){
        String toPrint = "Engine: " + this.engine;
        toPrint += "\nBrakes: " + this.brakes;
        toPrint += "\nTires: " + this.tires;

        System.out.println(toPrint);
    }
}
