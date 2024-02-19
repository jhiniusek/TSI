public class ThreadSorting {
    static class NumberThread implements Runnable{
        private final int number;
        public NumberThread(int number) {
            this.number = number;
        }

        public void run(){
            try {
                Thread.sleep(number* 15L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        int[] listToSort = {9,3,10,2,4,6,7};
        for(int x : listToSort) {
            var myThread = new Thread(new NumberThread(x));
            myThread.start();
        }
    }
}
