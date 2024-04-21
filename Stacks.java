public class Stacks{
        int stk[];
        int top = -1;
        int size;
        Stacks(int size){
            this.size=size;
            stk=new int[size];
            
        }   
        boolean inFull(){
            return top == stk.length-1;
        }  
        boolean isEmpty(){
            return top == stk.length;
        }  
        void push(int data){
            if(isFUll()){
                System.out.println("Stack overflow");
                
            }else{
                // top++;
                stk[++top] = data;
            }
        }
    }
    int pop(){
        if (isEmpty){
            System.out.println("Stack underflow");
            return -1;   
        }
        return stk[top--];
}