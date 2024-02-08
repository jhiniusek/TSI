package design_patterns.strategy_pattern_exercise;

public class Main {
    public static void main(String[] args) {
        CipherStrategy cipher = new CaeserCipher();

        System.out.println(Encoder.encodeMessage(cipher, "Testing abc Caeser xyz"));
    }
}
