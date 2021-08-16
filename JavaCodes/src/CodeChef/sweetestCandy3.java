package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class sweetestCandy3 {

	public static void main(String[] args)
	{
		sweetestCandy3 s = new sweetestCandy3();
		s.function();
	}
	public void function()
	{
		AvlTree1 avl= new AvlTree1();
		Scanner scanner= new Scanner(System.in);
		int tc=scanner.nextInt();
		while(tc>0)
		{
			int n=scanner.nextInt();
			int max=0;
			long sum=0;
			while(n>0)
			{n--;
			int arr=scanner.nextInt();
			avl.insert(arr);
			max=max>arr?max:arr;
			sum+=arr;
			}
			System.out.print(sum);
			avl.inorderTraversal(avl.root, sum, max);
			tc--;
		}
		scanner.close();
}
}

class AvlTree1 {
	Node1 root;
	void insert(int num)
	{
		Node1 n= new Node1(num);
		if (root==null)
		{
			root=n;
		}
		else
		{
			Node1 ptr=root;
			Node1 pptr=ptr;
			while(ptr!=null)
			{
				pptr=ptr;
				if (ptr.value>=n.value)
				{
					ptr=ptr.left;
				}
				else
				{
					ptr=ptr.right;
				}
			}
			if(pptr.value>=n.value)
				pptr.left=n;
			else
				pptr.right=n;
		}
	}
	void inorderTraversal(Node1 n, long sum,int max)
	{
		if(n!=null)
		{
			inorderTraversal(n.left, sum,max);
			sum+=(max-n.value);
			if(max==n.value)
				return;
			System.out.print(" "+sum);
			inorderTraversal(n.right, sum,max);
		}
	}

}
class Node1 {
	int value;
	Node1 left,right;
	public Node1(int d) {
		value=d;
		//leaf node has height 0
		// TODO Auto-generated constructor stub
		}
}