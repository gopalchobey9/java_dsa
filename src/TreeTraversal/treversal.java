package TreeTraversal;

import java.util.LinkedList;
import java.util.Scanner;

public class treversal {
	Scanner sc = new Scanner (System.in);
	public class Node{
		int data;
		Node left;
		Node right;
		
		
	}
	   private Node root;
	public treversal() {
		this.root=CreateTree();
	}
	private Node CreateTree() {
		// TODO Auto-generated method stub
		
		int item = sc.nextInt();
		Node nn = new Node();
		nn.data= item ;
		boolean hlc = sc.nextBoolean();
		if(hlc == true) {
			nn.left=CreateTree();
		}
		boolean hlr = sc.nextBoolean();
		if(hlr ==true) {
			nn.right=CreateTree();
		}
		return nn;
		
		
	}
	public void PreOrder() {
		PreOrder(this.root);
		System.out.println();
	}
	private void PreOrder(Node nn) {
		// TODO Auto-generated method stub
		if(nn==null) {
			return ;
			
		}
		System.out.print(nn.data+"   ");
		PreOrder(nn.left);
		PreOrder(nn.right);
		
	}
	public void PostOrder() {
		PostOrder(this.root);
		System.out.println();
	}
	private void PostOrder(Node nn) {
		// TODO Auto-generated method stub
		if(nn==null) {
			return ;
			
		}
		
		PostOrder(nn.left);
		PostOrder(nn.right);
		System.out.print(nn.data+"   ");
		
	}
	public void LevelOrder() {
		LinkedList<Node> queue=new LinkedList<treversal.Node>();
		queue.add(root);//add last 
		while(!queue.isEmpty()) {
			Node rv =queue.remove();//remove first
			System.out.print(rv.data+" ");
			if(rv.left!=null) {
				queue.add(rv.left);
			}
			if(rv.right!=null) {
				queue.add(rv.right );
				
			}
			System.out.println();
			
		}
	}
	public static void main(String[] args) {
		treversal tl = new treversal();
//		tl.PreOrder();
//		tl.PostOrder();
		tl.LevelOrder();
	}
}
