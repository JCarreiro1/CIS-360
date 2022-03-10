import java.util.*;

public class Main {
    public static void main(String[] args){
        Stack<BinaryNode> stack = new Stack<BinaryNode>();
        BinaryNode tree1 = createTree(stack, "abc+*");
        BinaryNode tree2 = createTree(stack, "abc*+de*f+g*+");

        System.out.print("Preorder traversal of defg++*c+ab*+: ");
        tree1.travPrefix(tree1);
        System.out.print("\nPostorder traversal of defg++*c+ab*+: ");
        tree1.travPostfix(tree1);
        System.out.print("\nInorder traversal of defg++*c+ab*+: ");
        tree1.travInfix(tree1);

        stack.empty();

        System.out.print("\n");
        System.out.print("\nPreorder traversal of abc*+de*f+g*+: ");
        tree2.travPrefix(tree2);
        System.out.print("\nPostorder traversal of abc*+de*f+g*+: ");
        tree2.travPostfix(tree2);
        System.out.print("\nInorder traversal of abc*+de*f+g*+: ");
        tree2.travInfix(tree2);
    }

    public static BinaryNode createTree(Stack<BinaryNode> stack, String expression){
        char[] postfix = expression.toCharArray();
        BinaryNode finalTree = new BinaryNode();

        for(int i = 0; i < postfix.length; i++){
            BinaryNode tree = new BinaryNode();
            if(postfix[i] >= 97 && postfix[i] <= 122){
                tree.setData(postfix[i]);
                stack.push(tree);
            } else{
                tree.setData(postfix[i]);
                tree.setRight(stack.pop());
                tree.setLeft(stack.pop());
                stack.push(tree);
            }
        }
        finalTree = stack.pop();

        return finalTree;
    }
}
