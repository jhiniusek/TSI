public class InputValidation {
    public int checkInt(String input){
        try{
            int i = Integer.parseInt(input);
            return i;
        }
        catch (Exception e){
        }
        return 0;
    }
}
