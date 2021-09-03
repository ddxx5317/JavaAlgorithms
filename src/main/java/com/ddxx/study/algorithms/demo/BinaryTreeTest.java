package com.ddxx.study.algorithms.demo;

import java.util.Stack;
import java.util.concurrent.CountDownLatch;

public class BinaryTreeTest {
     public Node init() {
         // 注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，
         // 而初始化是按顺序初始化的，不逆序建立会报错
        Node J = new Node(8, null, null);
        Node H = new Node(4, null, null);
        Node G = new Node(2, null, null);
        Node F = new Node(7, null, J);
        Node E = new Node(5, H, null);
        Node D = new Node(1, null, G);
        Node C = new Node(9, F, null);
        Node B = new Node(3, D, E);
        Node A = new Node(6, B, C);
        return A;   //返回根节点
        } 
    
    public void printNode(Node node){  
        System.out.print(node.getData());  
    }

    /**
     * 先序遍历
     * @param root
     */
    public void theFirstTraversal_Stack(Node root) {
       Stack<Node> stack = new Stack<>();
       Node node = root;
       while (node != null && !stack.isEmpty()){
           if (node != null){
               printNode(node);
               stack.push(node);
               node=node.getLeftNode();
           }else {
               node = stack.pop();
               node = node.getRightNode();
           }
       }
    }

    /**
     *  中序遍历
     * @param root
     */
    public void theInOrderTraversal_Stack(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null && !stack.isEmpty()){
            if (node!=null){
                stack.push(node);
                node=node.getLeftNode();
            }else {
                node = stack.pop();
                printNode(node);
                node = node.getRightNode();
            }
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public void thePostOrderTraversal_Stack(Node root) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.countDown();

    }
    
    public static void main(String[] args) {  
        BinaryTreeTest tree = new BinaryTreeTest();
        Node root = tree.init();  
        System.out.println("先序遍历");  
        tree.theFirstTraversal_Stack(root);  
        System.out.println("");  
        System.out.println("中序遍历");  
        tree.theInOrderTraversal_Stack(root);  
        System.out.println("");  
        System.out.println("后序遍历");  
        tree.thePostOrderTraversal_Stack(root);  
        System.out.println("");  
    }
}
