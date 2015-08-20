package swordFingersOffer;
/**
 * 题目：实现函数double Power(double base,int exponent),求base的exponent次方。不得使用库函数，同时不需要考虑大数问题
 * 对于这道题，要考虑四种情况：
 * 1、底数为0，指数为负数的情况，无意义
 * 2、指数为0，返回1
 * 3、指数为负数，返回1.0/base,-exponent
 * 4、指数正数，base,exponent
 */
public class E11Power {
	

		
		public double power(double base,int exponent) throws Exception{
			double result = 0.0;
			if(equal(base,0.0) && exponent<0){
				throw new Exception("0的负数次幂无意义");
			}
			if(equal(exponent,0)){
				return 1.0;
			}
			if(exponent <0){
				result= powerWithExponent2(1.0/base, -exponent);
			}
			else{
				result = powerWithExponent2(base,exponent);
			}
			return result;
		}
		/**
		 * 按位计算 ，效率高
		 * @param base
		 * @param exponent
		 * @return
		 */
		private double powerWithExponent2(double base,int exponent){
			if(exponent == 0)
				return 1;
			if(exponent == 1)
				return base;
			double result = powerWithExponent2(base,exponent >>1);
			result *= result;
			if((exponent&0x1) == 1)
				result *=base;
			return result;
		}
		//判断两个double型数据，计算机有误差
		private boolean equal(double num1,double num2){
			if((num1-num2>-0.0000001) && (num1-num2<0.0000001)){
				return true;
			}else{
				return false;
			}
		}
		public static void main(String[] args) throws Exception{
			E11Power test = new E11Power();
			System.out.println(test.power(3, -1));
			
			System.out.println(3>>1);
		}

}
