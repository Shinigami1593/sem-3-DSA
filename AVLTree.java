public class AVLTree {
    public static class Node{
        Node left;
        Node right;
        int height;
        int data;
        public Node(int data){
            this.data = data;
            this.left = this.right=null;
            this.height = 1;
        }
    }
    int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    public Node createBST(Node root, int data){
        if(root == null){
            return new Node(data);
        }
        else if(data<root.data){
            root.left = createBST(root.left, data);
        }
        else if(data>root.data){
            root.right = createBST(root.right, data);
        }else{
            return root;
        }
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balancefactor = getBalanceFactor(root);

        //LL
        if(balancefactor>1 && data>root.left.data){
            return rightRotation(root);
        }
        //LR
        else if(balancefactor>1 && data<root.left.data){
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
        //RR
        if(balancefactor<-1 && data>root.right.data){
            return leftRotation(root);
        }
        //RL
        if(balancefactor<-1 && data<root.right.data){
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        return root;
    }

    Node rightRotation(Node y){
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        
        return x;
        
        
    }
    Node leftRotation(Node x){
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    int getBalanceFactor(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }
}
