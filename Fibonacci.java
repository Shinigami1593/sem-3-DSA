public class Fibonacci{
    int fibo(int n){
        if(n==0){
            return 0;
        }
        if (n==1) {
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println("Fibonacci numbers findings");
        System.out.println(f.fibo(6));
    }
}