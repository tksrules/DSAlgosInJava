package DataStructures;

import java.util.Stack;

public class BinaryTree {
    static TreeNode tn;

    public void createTree() {
        tn = new TreeNode(6);
        tn.left = new TreeNode(2);
        tn.left.left = new TreeNode(1);
        tn.left.right = new TreeNode(4);
        tn.left.right.left = new TreeNode(3);
        tn.left.right.right = new TreeNode(5);
        tn.right = new TreeNode(7);
        tn.right.right = new TreeNode(9);
        tn.right.right.left = new TreeNode(8);
    }

    public void createTree1() {
        tn = new TreeNode(-10);
        final TreeNode left1 = new TreeNode(-15);
        final TreeNode left2 = new TreeNode(-25);
        final TreeNode right1 = new TreeNode(-5);
        final TreeNode right2 = new TreeNode(-3);

        tn.left = left1;
        left1.left = left2;
        tn.right = right1;
        right1.right = right2;
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

    // if only positive no.s in tree
    public int getMaxSum(final TreeNode tn) {
        if (tn == null) {
            return 0;
        } else {
            return tn.val + Math.max(getMaxSum(tn.left), getMaxSum(tn.right));
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

        final BinaryTree tree1 = new BinaryTree();
        tree1.createTree1();
        System.out.println();
        tree1.InOrderRecursive(tn);
        System.out.println("\nMax sum: " + tree1.getMaxSum(tn));

    }
}
