public class ThreadExample extends Thread {
    @Override
    public void run(){
        for(int i =0;i<10;i++){
            System.out.println("executing task2 job" + i);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("app started");
        for (int i = 0;i<10;i++){
            System.out.println("executing task1 job" + i);
        }
        ThreadExample t1 = new ThreadExample();
        t1.start();
        System.out.println("app finished");
    }
}
