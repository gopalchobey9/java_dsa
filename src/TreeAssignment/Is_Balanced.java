package TreeAssignment;

import java.util.Scanner;
public class Is_Balanced {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Is_Balanced  m = new Is_Balanced ();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.isBalanced());
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public boolean isBalanced() {
			return this.isBalanced(this.root).isBalanced;
		}

		private BalancedPair isBalanced(Node node) {
			// write your code here
			if(node==null){
				return new BalancedPair();
			}
			BalancedPair lbp = isBalanced( node.left);
			BalancedPair rbp = isBalanced( node.right);
			BalancedPair sbp = new BalancedPair();
			sbp.height = Math.max(lbp.height,rbp.height)+1;
			int dif = Math.abs(rbp.height=lbp.height);
			sbp.isBalanced= rbp.isBalanced==true && lbp.isBalanced==true && dif<=1;
			return sbp;
			
		}

		private class BalancedPair {
			int height =-1;
			boolean isBalanced =true;;
		}

	}
}
