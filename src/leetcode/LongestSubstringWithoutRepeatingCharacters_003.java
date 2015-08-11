package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 原题

　　Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for “abcabcbb” is “abc”, 
which the length is 3. For “bbbbb” the longest substring is “b”, with the length of 1. 

题目大意

　　给定一个字符串，找字符中的最大非重复子串 

解题思路

　　循环以每个字母为开头往后遍历，当当前字母没有出现过时，放入到一个list里面，如果出现过说明字符串结束，
将list的长度保存起来，如果字符串遍历结束，也将list的长度进行保存，然后进行下一轮遍历。
然后比较保存起来的list长度，取出其中长度最长的。
 * @author mpj12875
 *
 */
public class LongestSubstringWithoutRepeatingCharacters_003 {
public static void main(String[] args) {
	String str="abcabcbb";
	List<Integer>intlist=new ArrayList<Integer>();//保存遍历出来字符串的长度
	
	//对每个字母开头都进行一次遍历
	for(int i=0;i<str.length();i++){
		List<String>strlist=new ArrayList<String>();
		for(int j=i;j<str.length();j++){
			String temp=str.substring(j, j+1);
//			System.out.print(temp);
			//判断该字符是否出现过，出现说说明这个非重复串结束，将长度进行保存，结束这次遍历
			if(strlist.contains(temp)){
				intlist.add(strlist.size());
				break;
			}
			//否则将该字符加入队列中，继续遍历
			else strlist.add(temp);
		}
		//当字符串遍历结束，非重复串也结束，保存长度
		intlist.add(strlist.size());
	}
	int result=0;
	//找出最长的字符串长度
	for(int k:intlist){
//		System.out.print(k);
		if(result<k)
			result=k;
	}
	System.out.println(result);
}
}
