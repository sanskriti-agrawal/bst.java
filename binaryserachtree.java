import java.util.*;
public class Binarysearchtree {
    Node root = null;

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(int  data)
    {
        Node node = new Node(data);
        if (root == null)
        {
            root = node;
        }
        else
        {
            Node temp = root;
            Node parent = null;
            while (temp != null)
            {
                parent=temp;
                if (data <= temp.data)
                {
                    temp = temp.left;
                }
                else {
                    temp = temp.right;
                }
            }
            if(data<=parent.data)
            {
                parent.left=node;
            }
            else
            {
                parent.right=node;
            }
        }
    }
    public Node minnode(Node root)
    {
        if(root.left!=null)
            return minnode(root.left);
        else
            return root;
    }

    public static  int heightoftree(Node root) {
        if (root== null) {
            return -1;
        } else {
            return 1 + Math.max(heightoftree(root.left), heightoftree(root.right));
        }
    }

    public Node deleteNode(Node node,int x) {
        if (node == null) {
            return null;
        }
        else {
            if (x < node.data)//the value is less then node's data
                node.left = deleteNode(node.left, x);

            else if (x > node.data)//value is greater than node's data
                node.right = deleteNode(node.right, x);

            else {//if there is no child node of the current node
                if (node.left == null && node.right == null)
                    node = null;

                else if (node.left == null)//if there is only one child of the current node
                {
                    node = node.right;
                }
                else if (node.right == null) {
                    node = node.left;
                }
                else {//if there is two child node of current node
                    Node temp = minnode(node.right);//find the minnode from the right subtree
                    node.data = temp.data;//exchange the data between node and temp
                    node.right = deleteNode(node.right, temp.data);//delete the node duplicate node from right subtree
                }
            }
            return node;
        }
    }
    public void postorder(Node node)
    {
        if(node==null)
        {
            return;
        }
        else{
            if(node.left!=null)
                postorder(node.left);
            if(node.right!=null)
                postorder(node.right);
            System.out.println(node.data+" ");
        }
    }
    public void preorder(Node node)
    {
        if (root == null)
        {
            return;
        }
        else{
            System.out.println(node.data+" " );
            if(node.left!=null)
                preorder(node.left);
            if(node.right!=null)
                preorder(node.right);
        }
    }

    public void inorder(Node node)
    {
        if (root == null)
        {
            return;
        }
        else
        {
            if(node.left!=null)
                inorder(node.left);
            System.out.println(node.data + " ");
            if(node.right!=null)
                inorder(node.right);
        }
    }

    public static void main(String[] args) {
        Binarysearchtree bt = new Binarysearchtree();
        bt.insert(50);
        bt.insert(25);
        bt.insert(75);
        bt.insert(10);
        bt.insert(35);
        bt.insert(45);

        System.out.println("Binary search tree after insetion");
        bt.inorder(bt.root);
        System.out.println("Binary serach tree after postorder");
        bt.postorder(bt.root);
        System.out.println("binary serach tree after preorder");
        bt.preorder(bt.root);

        Node deleteNode=null;
        deleteNode=bt.deleteNode(bt.root,10);
        System.out.println("Binary serach tree after deleting node 10");
        bt.inorder(bt.root);
        System.out.println("height of tree"+" " +bt.heightoftree(bt.root));
    }
}
