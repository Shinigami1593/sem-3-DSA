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
    Node get(Node root, int data){
        if(root==null){
            return root;
        }
        if(data<root.data){
            get(root.left, data);
        }
        else if(data>root.data){
            get(root.right, data);
        }
        return root;
    }

    void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data + " ");
        inorder(root.right);
    }
    void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data + " ");
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
    Node removeNode(Node root, int data){
        if(root==null){
            return null;
        }
        if(data<root.data){
            root.left = removeNode(root.left, data);
        }
        else if(data>root.data){
            root.right = removeNode(root.right, data);
        }
        else{
            if(root.left == null){
                return root.right;
            }   
            else if(root.right == null){
                return root.left;
            }
            else{
                root.data = minValue(root.right);
                root.right = removeNode(root.right, root.data);

            }
        }
        return root;
    }
    int minValue(Node root){
        int min = root.data;
        while(root.left!= null){
            min = root.left.data;
            root=root.left;
        }
        return min;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        Node root = bst.createBST(null, 11);
        root = bst.createBST(root, 6);
        root = bst.createBST(root, 8);

    }
}
