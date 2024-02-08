package design_patterns.strategy_pattern_exercise;

public class CaeserCipher implements CipherStrategy {

    @Override
    public String encode(String input) {
        String returnString = "";
        int offset = 6;

        for(char a : input.toCharArray()) {
            if((int)a >= 65 && (int)a <= 90){
                int newChar = (int)a+offset;
                if(newChar > 90){
                    newChar -= 26;
                }
                returnString += (char)newChar;
            }
            else if((int)a >= 97 && (int)a <= 122){
                int newChar = (int)a+offset;
                if(newChar > 122){
                    newChar -= 26;
                }
                returnString += (char)newChar;
            }
            else{
                returnString += a;
            }
        }
        return returnString;
    }
}
