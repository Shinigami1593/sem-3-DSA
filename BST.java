public class BST {
    public class Node{
        Node left;
        Node right;
        int data;
        public Node(int data){
            this.data = data;
            this.left=this.right=null;
        }
    }
    Node createBST(Node root, int data){
        if(root==null){
            return new Node(data);

        }
        if(root.data>data){
            root.left = createBST(root.left, data);
        }
        else if(root.data<data){
            root.right = createBST(root.right, data);
        }
        return root;

    }
    public static void main(String[] args) {
        BST bst = new BST();
        Node root = bst.createBST(null, 11);
        root = bst.createBST(root, 6);
        root = bst.createBST(root, 8);

    }
}
