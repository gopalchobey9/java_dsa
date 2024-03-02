package TreeQsns;

public class PathSum{


		// TODO Auto-generated method stub

	public class TreeNode {
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
	 public boolean hasPathSum(TreeNode root, int targetSum) {
		 if(root==null) return false ;
		 if(root.right==null&& root.left==null) {
			 return targetSum-root.val==0;
			 
		 }
		 Boolean lf = hasPathSum(root.left,targetSum-root.val);
		 Boolean rf = hasPathSum(root.right,targetSum-root.val);
	        return lf||rf;
	    }
	 public static void main(String[] args) {
		
	}

}
