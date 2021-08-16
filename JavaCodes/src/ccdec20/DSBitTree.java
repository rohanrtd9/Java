package ccdec20;

public class DSBitTree {

}

class Node
{
	Node[] parents;
	Node[] childrens;
	int val;
	boolean isAnd;
	boolean isOr;
	public Node(int n) {
		// TODO Auto-generated constructor stub
		val=n;
		isAnd=false;
		isOr=false;
	}
	
}