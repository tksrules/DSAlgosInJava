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

    public void InOrderRecursive(final TreeNode x) {
        if (x == null) {
            return;
        }
        InOrderRecursive(x.left);
        System.out.print(x.val + "->");
        InOrderRecursive(x.right);
    }

    public void preOrderIterative() {
        final Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(tn);

        while (!stack.isEmpty()) {
            final TreeNode x = stack.pop();
            System.out.print(x.val + "->");
            if (x.right != null) {
                stack.push(x.right);
            }
            if (x.left != null) {
                stack.push(x.left);
            }
        }
    }

    public void InOrderIterative() {
        final Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(tn);

        while (!stack.isEmpty()) {
            final TreeNode x = stack.pop();
            System.out.print(x.val + "->");
            if (x.right != null) {
                stack.push(x.right);
            }
            if (x.left != null) {
                stack.push(x.left);
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
    }
}
