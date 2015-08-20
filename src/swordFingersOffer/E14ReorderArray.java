package swordFingersOffer;
/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有的偶数位于数组的后半部分
 */
public class E14ReorderArray {

	public void order(int[] arr){
		if(arr == null)
			return;
		int i = 0;
		int j = arr.length-1;
		while(i<j){
			if(isEven(arr[i]) && !isEven(arr[j])){
				int temp = arr[i];
				arr[i]= arr[j];
				arr[j] = temp;
			}
			else if(!isEven(arr[i]) && isEven(arr[j])){
				i++;
				j--;
			}
			else if(isEven(arr[i]) && isEven(arr[j])){
				j--;
			}else{
				i++;
			}
		}
	}
	public boolean isEven(int n){
		return (n & 1) == 0;
	}
	public static void main(String[] args){
		E14ReorderArray test = new E14ReorderArray();
		int[] arr= {1,2,3,4,5,6,12,7,8,9,10};
		test.order(arr);
		for(int i = 0;i<arr.length ;i++){
			System.out.print(arr[i]+",");
		}
	}
}
