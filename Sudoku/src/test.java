public class test {

    public static void main(String[] args) throws InterruptedException {

        while(true){
            int randomNums =  0 + (int)(Math.random() * ((81 - 0) + 1));
            System.out.println(randomNums);
            Thread.sleep(10);
        }

    }
}
