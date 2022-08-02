package leetCode;

import java.util.HashSet;
import java.util.Set;

public class TreeLEaves {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Set<Integer> leaves1= getLeaves(root1);
        Set <Integer> leaves2= getLeaves(root2);
        return leaves1.equals(leaves2);
    }
    private Set<Integer> getLeaves(TreeNode root)
    {
        Set <Integer> leaves=new HashSet<>();
        if( root.left==null )
            if( root.right==null)
                return leaves;
            else return (getLeaves(root.right));
        else
            if( root.right==null)
                return (getLeaves(root.left));
        
        leaves.addAll(getLeaves(root.left));
        leaves.addAll(getLeaves(root.right));
            
            
        return leaves;
    }
}
class TreeNode {
	     int val;
	     TreeNode left;
	    TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	         this.left = left;
	          this.right = right;
	     }
	  }