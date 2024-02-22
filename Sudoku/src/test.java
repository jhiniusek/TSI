public class test {

    public static void main(String[] args) throws InterruptedException {

        while(true){
            int randomNums = (int) (Math.random() * ((81) + 1));
            System.out.println(randomNums);
            Thread.sleep(10);
        }

    }
}
