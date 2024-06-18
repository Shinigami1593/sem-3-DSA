import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompleTableFutureExample {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        CompletableFuture<Integer> sumfuture = CompletableFuture.supplyAsync(
            ()-> sum(numList)
        );
        CompletableFuture<Integer> squarefuture = sumfuture.thenApplyAsync((result->result*result));
        CompletableFuture<Void> future = sumfuture.thenAcceptAsync(
            result->System.out.println(result)
            );
    }
    static int sum(List<Integer> numList){
        int sum = 0;
        for(int num : numList){
            sum += num;
        }
        try{
            Thread.sleep(8000);
        }
        catch(Exception ee){
            ee.printStackTrace();
        }
        return sum;
    }

}
