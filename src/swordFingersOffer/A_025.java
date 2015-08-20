package swordFingersOffer;

import java.util.Stack;

import model.BinaryTreeNode;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶结点所经过的所有的结点形成一条路径。
 * @author mpj12875
 *
 */
public class A_025 {
	/**
	 * 深度优先搜索，非递归方式
	 * @param root
	 * @param k
	 */
public void deepFindPath(BinaryTreeNode  root,int k){
	Stack<BinaryTreeNode>stack=new Stack<BinaryTreeNode>();
	stack.push(root);
	int sum=root.value;
	while(!stack.isEmpty()){
		if(sum==k&&stack.peek().leftNode==null&&stack.peek().rightNode==null)
			break;
		//如果当前节点为叶子节点
		if(stack.peek().leftNode==null){
			
			BinaryTreeNode node=stack.pop();
			System.out.println("peek"+node.value);
			sum=sum-node.value;
			root =stack.peek();
			System.out.println("node"+root.value);
			//如果当前节点是左儿子，那么下次节点肯定为右儿子
			if(node.value==root.leftNode.value){
				stack.push(root.rightNode);
				sum=sum+root.rightNode.value;
				if(sum==k)
					break;
			}
			//如果是右儿子的话，回溯
			else if(node.value==root.rightNode.value){
				stack.pop();
			}
		}
		//如果节点不是叶子节点，那么继续深入查询
		else {
			BinaryTreeNode node=stack.peek();
			stack.push(node.leftNode);
			sum=sum+node.leftNode.value;
		}
	}
	if(sum==k){
		System.out.println("find the path");
		while(!stack.isEmpty())
			System.out.println(stack.pop().value);
	}
		
	else System.out.println("no the path");
}

public void findPath(BinaryTreeNode root,int k){  
    if(root == null)  
        return;  
    Stack<Integer> stack = new Stack<Integer>();  
    findPath(root,k,stack);  
} 
/**
 * 递归方法进行深搜
 * @param root
 * @param k
 * @param path
 */
public void findPath(BinaryTreeNode root,int k,Stack<Integer> path){  
    if(root == null)  
        return;  
    //如果是符合的叶子节点
    if(root.leftNode == null && root.rightNode == null){  
        if(root.value == k){  
            System.out.println("路径开始");  
            for(int i :path)  
                System.out.print(i+",");  
            System.out.print(root.value);  
        }  
    }  
    //否则继续遍历
    else{  
        path.push(root.value);  
        findPath(root.leftNode,k-root.value,path);  
        findPath(root.rightNode,k-root.value,path);  
        path.pop();  
    }  
}  
public static void main(String[] args){  
    BinaryTreeNode root1 = new BinaryTreeNode();  
    BinaryTreeNode node1 = new BinaryTreeNode();  
    BinaryTreeNode node2 = new BinaryTreeNode();  
    BinaryTreeNode node3 = new BinaryTreeNode();  
    BinaryTreeNode node4 = new BinaryTreeNode();  
    BinaryTreeNode node5 = new BinaryTreeNode();  
    BinaryTreeNode node6 = new BinaryTreeNode();  
    root1.leftNode = node1;  
    root1.rightNode = node2;  
    node1.leftNode = node3;  
    node1.rightNode = node4;  
    node4.leftNode = node5;  
    node4.rightNode = node6;  
    root1.value = 8;  
    node1.value = 8;  
    node2.value = 7;  
    node3.value = 9;  
    node4.value = 2;  
    node5.value = 4;  
    node6.value = 7;  
    A_025 test = new A_025();  
    test.findPath(root1, 25);  
    
  
}  
}
