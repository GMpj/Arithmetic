package swordFingersOffer;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * @author MPJ
 *
 */
public class E28StringPermutation {
	/**
	 * 数组元素交换
	 * @param arr
	 * @param idx1
	 * @param idx2
	 */
	public void swap(String[] arr,int idx1,int idx2){  
        String temp = arr[idx1];  
        arr[idx1] = arr[idx2];  
        arr[idx2] = temp;  
    }
	/**
	 * 递归算法
	 * @param array
	 * @param start
	 */
	public void permutation(String []array,int start){
		
		if(start==array.length-1){
			for(int i=0;i<array.length;i++)
				System.out.print(array[i]);
			System.out.println();
				
		}
		/**
		 * 交换两次，使元素置为原始位置，方式出现重复交换的情况
		 */
		for(int i=start;i<array.length;i++){
			swap(array, start, i);
			permutation(array, start+1);
			swap(array, start, i);

		}
	}
	
	public static void main(String[] args) {
		String input="a,b,c,d";
		String array[]=input.split(",");
		E28StringPermutation test=new E28StringPermutation();
//		for(int i=0;i<array.length;i++)
		test.permutation(array, 0);
	}
	
}
