package swordFingersOffer;

import model.BinaryTreeNode;

/**
 * 判断是否是子树，记得判空
 * @author MPJ
 *
 */
public class A_018 {
	public boolean hasSubTree(BinaryTreeNode root1,BinaryTreeNode root2){  
        if(root2 == null)  
            return true;  
        if(root1 == null)  
            return false;  
        boolean result = false;  
          
        if(root1 != null && root2 != null){  
            if(root1.value == root2.value)  
                result = doesTree1HaveTree2(root1,root2);  
            if(!result)  
                result = hasSubTree(root1.leftNode,root2);  
            if(!result)  
                result = hasSubTree(root1.rightNode ,root2);  
        }  
        return result;  
    }  
    public boolean doesTree1HaveTree2(BinaryTreeNode root1,BinaryTreeNode root2){  
        if(root2 == null)  
            return true;  
        if(root1 == null)  
            return false;  
        if(root1.value != root2.value)  
            return false;  
        return doesTree1HaveTree2(root1.leftNode,root2.leftNode) && doesTree1HaveTree2(root1.rightNode,root2.rightNode);  
    }  
}
