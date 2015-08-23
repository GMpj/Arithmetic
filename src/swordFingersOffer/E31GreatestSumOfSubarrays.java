package swordFingersOffer;

/**
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。
            求所有子数组的和的最大值。要求时间复杂度为O(n)
 * @author MPJ
 *
 */
public class E31GreatestSumOfSubarrays {

	/**
	 * 如果连续几个元素的和小于0，那么说明这几个元素起到的反作用，应该被抛弃
	 * 将和重新置0，即重新开始一个子数组，记录起到正作用的数据和的最大值
	 * @param array
	 * @return
	 */
	public int findGreatestSum(int array[]){
		if(array.length==0)
			return 0;
		int max=0;
		int sum=0;
		for(int i=0;i<array.length;i++){
			sum=sum+array[i];
			if(sum<0)sum=0;
			if(max<sum)max=sum;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr={1,-2,3,10,-4,7,2,-5};  
        E31GreatestSumOfSubarrays test = new E31GreatestSumOfSubarrays();  
        System.out.println(test.findGreatestSum(arr));  
	}
}
