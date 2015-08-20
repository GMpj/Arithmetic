package swordFingersOffer;

/**
 * 将一个数字转换成2进制，统计1的个数
 * @author mpj12875
 *
 */
public class E10NumberOf1InBinary {

	/**
	 * 把一个整数减去1，再和原整数做与运算，会把该整数最右边的一个1变成0.那么一个整数的二进制表示中有多少个1，就可以进行多少次运算。
	 * @param num
	 * @return
	 */
	public int count(int num){
		int count=0;
		while(num!=0){
			count++;
			num=num&(num-1);
		}
		return count;
	}
	/**
	 * 移位，按位比
	 * @param n
	 * @return
	 */
	public int count1(int n){
		int count = 0;
		while(n!=0){
		int flag=n&1;
		if(flag!=0)
		count++;
		n = n>>1;
		}
		return count;
	}
	public static void main(String[] args) {
		E10NumberOf1InBinary test=new E10NumberOf1InBinary();
		System.out.println(test.count(9));
		System.out.println(test.count1(9));
	}
}
