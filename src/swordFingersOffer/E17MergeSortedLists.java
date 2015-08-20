package swordFingersOffer;

import utils.ListNodeUtils;
import model.ListNode;

public class E17MergeSortedLists {

/**
 * 递归方法
 * @param list1
 * @param list2
 * @return
 */
public ListNode merge(ListNode list1,ListNode list2){
	if(list1==null)
		return list2;
	if(list2==null)
		return list1;
	ListNode pMergedHead = null; 
	if(list1.data<list2.data){
		pMergedHead=list1;
		pMergedHead.next=merge(list1.next,list2);
		
	}
	else {
		pMergedHead=list2;
		pMergedHead.next=merge(list1,list2.next);
	}
	return pMergedHead;
}


public static void main(String[] args) {
	ListNode head1=ListNodeUtils.init1();
//	ListNode head2=ListNodeUtils.init2();
//	A_017 test=new A_017();
//	ListNodeUtils.print(test.merge(head1, head2));
	
	ListNodeUtils.print(ListNodeUtils.delete(head1, 3));
	
}

}
