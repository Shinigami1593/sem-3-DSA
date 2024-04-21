public class CheckParanthesis {
    boolean isBalanced(String exp) {
        String openbraces = "[{(";
        String closebraces = "]})";
        Stacks stk = new Stacks(exp.length());
        for(int i=0;i<exp.length();i++){
            char bracket = exp.charAt(i);
            if(bracket == '[' || bracket=='{' || bracket=='('){
                stk.push(bracket);
            }else{
                int indx=closebraces.indexOf(bracket);
                int crossopenbracket = openbraces.charAt(indx);
                if (stk.isEmpty()){
                    return false;
                }
                if(crossopenbracket != stk.pop()){
                    return false;
                }
            }
        }
        if (stk.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        CheckParanthesis check = new CheckParanthesis();
        System.out.println(check.isBalanced("{]}"));
    }
}
