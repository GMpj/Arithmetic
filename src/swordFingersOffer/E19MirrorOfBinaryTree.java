package swordFingersOffer;

import model.BinaryTreeNode;

/**
 * 二叉树的镜像
 * @author MPJ
 *
 */
public class E19MirrorOfBinaryTree {
	/**
	 * 先求根节点，然后递归求子节点
	 * @param node
	 */
	public void MirrorRecursively(BinaryTreeNode node){  
        if(node == null)  
            return;  
        if(node.leftNode == null && node.rightNode == null)  
            return;  
        BinaryTreeNode temp = node.leftNode;  
        node.leftNode = node.rightNode;  
        node.rightNode = temp;  
        if(node.leftNode != null)  
            MirrorRecursively(node.leftNode);  
        if(node.rightNode != null)  
            MirrorRecursively(node.rightNode);  
    }  
}
