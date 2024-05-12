public class Fibonacci {
    int fibo(int n, int [] dp){
        if(n==0){
            return 0;
        }
        if (n==1) {
            return 1;
        }
        if(dp[n] != -1){

        }
        dp[n] =  fibo(n-1,dp) + fibo(n-2,dp);
        return dp[n];
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int n = 50;
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        System.out.println("Fibonacci numbers findings");
        System.out.println(f.fibo(n,dp));
    }
}