package DataStructures;

import java.util.Stack;

public class BinaryTree {
    static TreeNode tn;

    public void createTree() {
        tn = new TreeNode('F');
        tn.left = new TreeNode('B');
        tn.left.left = new TreeNode('A');
        tn.left.right = new TreeNode('D');
        tn.left.right.left = new TreeNode('C');
        tn.left.right.right = new TreeNode('E');
        tn.right = new TreeNode('G');
        tn.right.right = new TreeNode('I');
        tn.right.right.left = new TreeNode('H');
    }

    public void preOrderRecursive(final TreeNode x) {
        if (x == null) {
            return;
        }
        System.out.print(x.val + "->");
        preOrderRecursive(x.left);
        preOrderRecursive(x.right);
    }

    public void preOrderIterative() {
        final Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode x = tn;

        while (x != null || !stack.isEmpty()) {
            if (x != null) {
                System.out.print(x.val + "->");
                if (x.right != null) {
                    stack.push(x.right);
                }
                x = x.left;
            } else {
                x = stack.pop();
            }
        }
    }

    public void InOrderRecursive(final TreeNode x) {
        if (x == null) {
            return;
        }
        InOrderRecursive(x.left);
        System.out.print(x.val + "->");
        InOrderRecursive(x.right);
    }

    public void InOrderIterative() {
        final Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode x = tn;

        while (x != null || !stack.isEmpty()) {
            if (x != null) {
                stack.push(x);
                x = x.left;
            } else {
                x = stack.pop();
                System.out.print(x.val + "->");
                x = x.right;
            }
        }
    }

    public void PostOrderRecursive(final TreeNode x) {
        if (x == null) {
            return;
        }
        PostOrderRecursive(x.left);
        PostOrderRecursive(x.right);
        System.out.print(x.val + "->");
    }

    public void PostOrderIterative() {
        final Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode x = tn;

        while (x != null || !stack.isEmpty()) {
            if (x != null) {
                stack.push(x);
                if (x.right != null) {
                    stack.push(x.right);
                }
                x = x.left;
            } else {
                x = stack.peek();
                if (x.right == null) {
                    x = stack.pop();
                    System.out.print(x.val + "->");
                    x = x.right;
                } else {

                }
            }
        }
    }

    public static void main(final String[] args) {
        final BinaryTree tree = new BinaryTree();
        tree.createTree();
        tree.preOrderRecursive(tn);
        System.out.println();
        tree.preOrderIterative();
        System.out.println();
        tree.InOrderRecursive(tn);
        System.out.println();
        tree.InOrderIterative();
        System.out.println();
        tree.PostOrderRecursive(tn);
    }
}
