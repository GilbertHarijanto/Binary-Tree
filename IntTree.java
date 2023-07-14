// An IntTree object represents an entire binary tree of ints.
public class IntTree {
	IntTreeNode overallRoot;
   
	// Constructs an empty binary tree
	public IntTree() {
		overallRoot = null;
	}

	// Constructs a binary tree with the given node as its root.
	public IntTree(IntTreeNode overallRoot) {
		this.overallRoot = overallRoot;
	}
   
   public IntTree (int max) {
      overallRoot = buildTree(1, max);
   }
   
      
   private IntTreeNode buildTree (int n, int max) {
      if (n>max) return null;
      else return new IntTreeNode(n, buildTree(2*n, max), buildTree(2*n+1, max));
   }
   
  public void printSideWays() {
      printSideWays (overallRoot, 0);
   }
   
   private void printSideWays (IntTreeNode root, int level) {
      if (root != null) {
         printSideWays (root.right, level+1);
         for (int i=0; i<level; i++) 
            System.out.print ('\t');
         System.out.println (root.data);
         printSideWays (root.left, level+1);
      }
   }
   
   public void printInOrder() {
      printInOrder (overallRoot);
   }
   
   private void printInOrder (int TreeNode root) {
      if (root == null) {
      } else {
         printInOrder(root.left);
         system.out.println(root.data);
         printInOrder(root.right);
      }
   }
}