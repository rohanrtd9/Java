package CodeChef;
import java.util.Scanner;


public class Testing {
public static void main(String[] args) {
	Scanner scanner= new Scanner(System.in);
	AvlTree avl = new AvlTree();
	int a=scanner.nextInt();
	while(a>0)
	{
		avl.insert(scanner.nextInt());
		a--;
	}
	avl.inorderTraversal(avl.root);
	scanner.close();
}
}
