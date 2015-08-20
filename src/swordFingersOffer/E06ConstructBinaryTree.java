package swordFingersOffer;

import model.BinaryTreeNode;

/**
 * 根据先序遍历和中序遍历生成二叉树
 * @author mpj12875
 *
 */
public class E06ConstructBinaryTree {
public static BinaryTreeNode ConstructCore(int[] preOrder,int startPreIndex, int endPreIndex,   
        int[] inOrder,int startInIndex, int endInIndex){
	int rootvalue=preOrder[startPreIndex];
	BinaryTreeNode root = new BinaryTreeNode(rootvalue);
//	System.out.print(rootvalue+" ");
	  // 只有一个元素  
    if (startPreIndex == endPreIndex) {  
        if (startInIndex == endInIndex  
                && preOrder[startPreIndex] == inOrder[startInIndex]) {  
            System.out.println("only one element");  
            return root;  
        } else {  
             
        }  
    }
	
	int rootInIndex=startInIndex;
	while(rootInIndex<endInIndex&&rootvalue!=inOrder[rootInIndex])
		rootInIndex++;
//	System.out.println("root:"+rootInIndex);
	int leftTreelength=rootInIndex-startInIndex;
	int leftTreeEnd=startPreIndex+leftTreelength;
	
	if(leftTreelength>0)
		root.leftNode=ConstructCore(preOrder, startPreIndex+1, leftTreeEnd, inOrder, startInIndex, rootInIndex-1);
	if(leftTreelength<endInIndex-startInIndex)
		root.rightNode=ConstructCore(preOrder, leftTreeEnd+1, endPreIndex, inOrder, rootInIndex+1, endInIndex);
	
	return root;
}
public static BinaryTreeNode Construct(int[] preOrder, int[] inOrder,int length){
    if (preOrder == null || inOrder == null || length <= 0) {  
        return null;  
    }  
        return ConstructCore(preOrder, 0, preOrder.length - 1, inOrder, 0,inOrder.length - 1); 
}
public static void printPreOrder(BinaryTreeNode root) {  
    if (root == null) {  
        return;  
    } else {  
        System.out.print(root.value + " ");  
    }  

    if (root.leftNode != null) {  
        printPreOrder(root.leftNode);  
    }  

    if (root.rightNode != null) {  
        printPreOrder(root.rightNode);  
    }  
}  
public static void main(String[] args) {
    int[] preOrder={1,2,4,7,3,5,6,8};  
    int[] inOrder={4,7,2,1,5,3,8,6};  
     printPreOrder(Construct(preOrder, inOrder, preOrder.length));  
}
}
