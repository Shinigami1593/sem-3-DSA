import java.util.ArrayList;
import java.util.List;

public class Queens {


    boolean isSafe(int row, int col, char[][] board){
        //chaecking horizontally
        for(int j=0; j<board.length; j++){
            if(board[row][j] == 'Q'){
                return false;
            }

        }
        //checking vertically
        for(int i=0; i<board.length; i++){
            if(board[i][col] == 'Q'){
                return false;
            }

        }
        //checking diagnolly upward left
        int i = row;
        for(int j = col; i>=0&&j>=0;j--,i-- ){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //checking diagnolly downward right
        i = row;
        for(int j = col; i<board.length&&j<board.length;j++,i++ ){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //checking diagnolly upward right
        i = row;
        for(int j = col; i>=0&&j<board.length;j++,i-- ){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //checking diagnolly downward left
        i = row;
        for(int j = col; i<board.length&&j>0;j--,i++ ){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;



    }
    void helper(char board[][], int col,List<List<String>> allboards){
        if(col == board.length){
            //write a function to save a board in allboards
            return;
        }
        for(int row=0;row<board.length;row++){
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                helper(board,col+1,allboards);
                board[row][col] = '.';
            }
        }
    }
    public static void main(String[] args) {
        Queens q = new Queens();
        char[][] board = new char[4][4];
        List<List<String>> allboard = new ArrayList<>();
        q.helper(board,0,allboard);
        

        // board[0][0] = 'Q';
    }
}
