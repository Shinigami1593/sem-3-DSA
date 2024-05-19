public class Permutation {
    void printpermutation(String str, String perm){
        if (str.length()==0){
            System.out.println(perm);
            return;
        }
    }
    public static void main(String[] args) {
        Permutation p = new Permutation();
        String str = "ABC";
        p.printpermutation(str, "");
    }
    
}
