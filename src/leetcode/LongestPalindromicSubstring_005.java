package leetcode;

import java.util.Scanner;
/**
 * 原题

　　Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring. 

题目大意

　　给定一个字符串S，找出它的最大的回文子串，你可以假设字符串的最大长度是1000，而且存在唯一的最长回文子串 

解题思路

　　动态规划法， 
　　假设dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串。那么可以推出： 
　　dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]。 
　　这是一般的情况，由于需要依靠i+1, j -1，所以有可能 i + 1 = j -1, i +1 = (j - 1) -1，
因此需要求出基准情况才能套用以上的公式： 
　　a. i + 1 = j -1，即回文长度为1时，dp[ i ][ i ] = true; 
　　b. i +1 = (j - 1) -1，即回文长度为2时，dp[ i ][ i + 1] = （s[ i ] == s[ i + 1]）。 
　　有了以上分析就可以写出代码了。需要注意的是动态规划需要额外的O(n^2)的空间。
 * @author MPJ
 *
 */
public class LongestPalindromicSubstring_005 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
//		String str="abcabcdcdfghhgfdcdeer";
		
		int length=str.length();
		String longest="";
		int maxlen=0;
		boolean stateTable[][]=new boolean [length][length];
		//构建一个状态表，dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串
		
		//填充状态表，单字符全是回文串
		for(int i=0;i<length;i++){
			stateTable[i][i]=true;
			longest=str.substring(i, i+1);
			maxlen=1;
		}
		
		//判断两个字符是否是回文串
		for(int i=0;i<length-1;i++){
			if(str.charAt(i)==str.charAt(i+1)){
				stateTable[i][i+1]=true;
				longest=str.substring(i, i+2);
				maxlen=2;
			}
			else {
				stateTable[i][i+1]=false;
			}
		}
		
		//判断多字符
		//从长度为3开始，从第一个字符开始遍历
		for(int len=3;len<length;len++){
			for(int i=0,j;(j=i+len-1)<length-1;i++){
				//使用上述公式，并将最长子串记录下来
				if(str.charAt(i)==str.charAt(j)){
					stateTable[i][j]=stateTable[i+1][j-1];
					if(stateTable[i][j]){
					longest=str.substring(i, j+1);
					maxlen=len;
					}
				}
				else stateTable[i][j]=false;
			}
		}
		System.out.println(longest+":"+maxlen);
	}
	
}
