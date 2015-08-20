package swordFingersOffer;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import model.BinaryTreeNode;

/**
 * 从上往下打印二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 * @author mpj12875
 *
 */
public class E23PrintFromTopToBottom {
	/**
	 * 宽度优先搜索
	 * @param root
	 */
public void printFromTopToBottom(BinaryTreeNode root){
	if(root==null)
		return ;
	Queue<BinaryTreeNode>queue=new LinkedBlockingQueue<BinaryTreeNode>();
	queue.add(root);
	while(!queue.isEmpty()){
		BinaryTreeNode node=queue.remove();
		System.out.println(node.value);
		if(node.leftNode!=null)
		queue.add(node.leftNode);
		if(node.rightNode!=null)
		queue.add(node.rightNode);
	}
}
public static void main(String[] args) {
	BinaryTreeNode root=new BinaryTreeNode();
	root.value=8;
	BinaryTreeNode left01=new BinaryTreeNode();
	left01.value=6;
	root.leftNode=left01;
	BinaryTreeNode right01=new BinaryTreeNode();
	right01.value=10;
	root.rightNode=right01;
	E23PrintFromTopToBottom test=new E23PrintFromTopToBottom();
	test.printFromTopToBottom(root);
}
}
