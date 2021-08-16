package CodeChef;

public class AvlTree {
	Node root;
	void insert(int num)
	{
		Node n= new Node(num);
		if (root==null)
		{
			root=n;
		}
		else
		{
			Node ptr=root;
			Node pptr=ptr;
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
	void inorderTraversal(Node n)
	{
		if(n!=null)
		{
			inorderTraversal(n.left);
			System.out.println(n.value);
			inorderTraversal(n.right);
		}
	}

}
class Node {
	int value;
	Node left,right;
	public Node(int d) {
		value=d;
		//leaf node has height 0
		// TODO Auto-generated constructor stub
		}
}
