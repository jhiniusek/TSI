package design_patterns.adapter_exercise;

public class Adapter implements Target{
    private Pensioner pensionee;

    public Adapter(Pensioner pensionee){
        this.pensionee = pensionee;
    }
    @Override
    public String toString() {
        return pensionee.getInfo();
    }

}
