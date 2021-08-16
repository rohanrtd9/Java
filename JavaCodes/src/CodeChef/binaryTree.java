package CodeChef;

public class binaryTree {
Node root;
void insertNode(Node newNode,Node ptr)
	{
		if(ptr==null)
		{
			ptr=newNode;
		}
		else{
			while (ptr!=null)
			{
				Node ptrT=ptr;
				if(ptr.value>=newNode.value)
					ptr=ptr.left;
				else
					ptr=ptr.right;
			}
		}
	}

}
