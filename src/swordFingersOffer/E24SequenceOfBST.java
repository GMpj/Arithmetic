package swordFingersOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * @author mpj12875
 *
 */
public class E24SequenceOfBST {
	/**
	 * 使用递归方法进行判断，左节点数据都比根节点小，右节点都比根节点大
	 * @param array 树
	 * @param start 开始节点
	 * @param end 结束节点
	 * @return
	 * @throws Exception
	 */
public boolean verifySequence(int[]array,int start,int end)throws Exception{
	//做好判断
	if(array==null||array.length<2)
		return false;
	if(start < 0){  
        throw  new Exception("first can't be less than 0");  
    }  
    if(end > array.length){  
        throw new Exception("last can't be greater than the count of the element.");  
    }  
	int i=start;
	int root=array[end];
	//判断比根节点小的部分，左节点
	for(;i<end;i++)
		if(array[i]>root)
			break;
	int j=i;
	//查看右节点部分是否比根节点大，满足说明符合
	for(;j<end;j++)
		if(array[i]<root)
			return false;
	//判断左子树和右子树是否满足，如果没有子树说明递归结束，并且满足
	boolean left=true,right=true;
	if(i >start)  
	 left=verifySequence(array, start, i-1);
	if(i < end)  
	 right=verifySequence(array, i, end-1);
	
	return (left&&right);
}
public static void main(String[] args) throws Exception {
	int[] array={5,7,6,9,11,10,8};  
	E24SequenceOfBST test=new E24SequenceOfBST();
	boolean flag=test.verifySequence(array, 0, array.length-1);
	System.out.println(flag);
}
}
