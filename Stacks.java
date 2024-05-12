
public class Stacks{
    char stk[];
    int top = -1;
    int size;
    Stacks(int size){
        this.size=size;
        stk=new char[size];
        
    }   
    boolean isFull(){
        return top == stk.length-1;
    }  
    boolean isEmpty(){
        return top == stk.length;
    }  
    void push(char data){
        if(isFull()){
            System.out.println("Stack overflow");
            
        }else{
            // top++; 
            stk[++top] = data; // When the ++ is in prefix, the value of top is increased first. When in suffix, data is inserted first.
        }
    }
    char pop(){
        if (isEmpty()){
            System.out.println("Stack underflow");
            return 'f';   
        }
        return stk[top--];
    }
    char peek(){
        return stk[top];
    }

}