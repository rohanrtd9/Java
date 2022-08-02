package leetCode;

public class MergeKSortedLists {
	public static void main(String[] args) {
		MergeKSortedLists mk=new MergeKSortedLists();
		int l1[]= {1,4,5};
		int l2[]= {1,3,4};
		int l3[]= {2,6};
		ListNode ll1=mk.arrayToLL(l1);
	}
	private ListNode arrayToLL(int arr[])
	{
		ListNode l=new ListNode();
		ListNode curr=l;
		ListNode prev=curr;
		int i=0;
		while(i<arr.length)
		{
			
			curr.val=arr[i++];
			curr.next=new ListNode();
			prev=curr;
			curr=curr.next;
		}
		prev.next=null;
		return l;
	}
	 public ListNode mergeKLists(ListNode[] lists) {
	        ListNode list1=lists[0];
	        if(lists.length==1)
	        {}
	        else
	        {
	            
	            int listsCount=lists.length;
	            while(--listsCount>0)
	            {
	                ListNode list2=lists[listsCount];
	                list1=this.mergeTwoLists(list1,list2);
	            }
	            
	        }
	        return list1;
	        
	    }
	    private ListNode mergeTwoLists(ListNode  list1, ListNode list2)
	    {
	        //this function returns the merged linked list in sorted order
	        ListNode retList= new ListNode();
	        ListNode cur=retList;
	        ListNode prev=cur;
	        while(list1 != null && list2 != null)
	        {
	            
	            if(list1.val>list2.val)
	            {
	                
	                cur.val=list2.val;
	                list2=list2.next;
	            }
	            else
	            {
	                cur.val=list1.val;
	                list1=list1.next;
	            }
	        
	            cur.next=new ListNode();
	            prev=cur;
	            cur=cur.next;
	        }
	        prev.next=null;
	        if(list1!=null)
	        {
	            cur=list1;
	        }
	        if(list2!=null)
	        {
	            cur=list2;
	        }
	        return retList;
	    }
	}
class ListNode {
	    int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }