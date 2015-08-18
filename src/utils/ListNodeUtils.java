package utils;

import model.ListNode;

public class ListNodeUtils {

	/**
	 * 添加节点
	 * @param head
	 * @param node
	 * @return
	 */
	public static ListNode append(ListNode head,ListNode node){
		if(head==null)
			return node;
		ListNode temp=head;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=node;
		return head;
	}
	
	/**
	 * 根据节点删除节点 时间复杂度o（1）
	 * @param head
	 * @param node
	 * @return
	 */
	public static ListNode delete(ListNode head,ListNode node){
		if(head==null){
			System.out.println("链表为空，无法删除");
			return null;
		}
		if(node.next==null){
			ListNode temp=head;
			while(temp.next!=node){
				temp=temp.next;
			}
			temp.next=null;
			return head;
		}
		ListNode temp=node.next;
		node.data=temp.data;
		node.next=temp.next;
			
		return head;
	}
	
	/**
	 * 根据节点值删除节点
	 * @param head
	 * @param data
	 * @return
	 */
	public static ListNode delete(ListNode head,int data){
		if(head==null){
			System.out.println("链表为空，无法删除");
			return null;
		}
		ListNode temp=head;
		
		while(temp.next!=null){
			if(temp.next.data==data){
				temp.next=temp.next.next;
				return head;
			}
			temp=temp.next;
		}
		
		System.out.println("没有这个节点");
		return head;
	}
	
	public static void print(ListNode head){
		ListNode temp=head;
		while(temp!=null){
			if(temp.next==null){
				System.out.println(temp.data);
				return ;
			}
				
		  System.out.print(temp.data+"->");
		  temp=temp.next;
		}
	}
	public static ListNode init1(){
		ListNode head=new ListNode(0);
		for(int i=1;i<10;i=i+2){
			ListNode node=new ListNode(i);
			append(head,node);
		}
		return head;
	}
	public static ListNode init2(){
		ListNode head=new ListNode(0);
		for(int i=2;i<10;i=i+2){
			ListNode node=new ListNode(i);
			append(head,node);
		}
		return head;
	}
}
