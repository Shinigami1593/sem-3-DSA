public class InfixToPostFix {
    static int precedence(char ch){
        if (ch =='+' || ch == '-'){
            return 1;
        }else if(ch== '*'|| ch == '/'){
            return 2;
        }else if(ch == '^'){
            return 3;
        }else{
            return -1;
        }
    }
    void convertInfixToPostFix(String exp){
        String postfixexp = "";
        Stacks stk = new Stacks(exp.length());
        for (int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(precedence(ch)>0){
                while (!stk.isEmpty() && precedence(ch)<=stk.peek()) {
                    postfixexp = postfixexp +stk.pop();
                    
                }
                stk.push(ch);
            }else if(ch == '('){
                stk.push(ch);
            }else if(ch == ')' ){
                char x = stk.pop();
                while (x!='('){
                    postfixexp += x;  
                    x = stk.pop();
                }
            }else{
                postfixexp+=ch;
            }
        }
        while(!stk.isEmpty()){
            postfixexp += stk.pop();
        }
        System.out.println("The Postfix expression is : "+postfixexp);
    }
}

//task:
//convert postfix expression to infix expression
//WAP to convert postfix expression to  infix expression. Use stack data structure.
//WAP to convert an infix expression into a prefix expression using stack data structure.