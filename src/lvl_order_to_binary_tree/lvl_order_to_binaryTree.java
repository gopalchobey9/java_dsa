package lvl_order_to_binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import TreeTraversal.treversal.Node;

public class lvl_order_to_binaryTree {
public class Node { 
	int val;
	 Node right;
	  Node left;
}
private Node root;
Scanner sc = new Scanner(System.in);
public lvl_order_to_binaryTree() {
	CreateTree();
}
private void CreateTree() {
	// TODO Auto-generated method stub
	int item =sc.nextInt();
	Node nn = new Node();
	nn.val =item ;
	root =nn;
	Queue<Node> q = new LinkedList<>();
	q.add(nn);
	while(!q.isEmpty()) {
		Node rv =q.remove();
		int c1 =sc.nextInt();
		int c2 =sc.nextInt();
		if(c1!=-1) {
			Node ll = new Node();
			ll.val =c1;
			rv.left =ll;
			q.add(ll);
			
		}
		if(c2!=-1) {
			Node ll = new Node();
			ll.val =c2;
			rv.left =ll;
			q.add(ll);
		}
		
	}
	
	

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
	System.out.print(nn.val+"   ");
	PreOrder(nn.left);
	PreOrder(nn.right);
	
}
public static void main(String[] args) {
	lvl_order_to_binaryTree lv = new lvl_order_to_binaryTree();
	lv.PreOrder();
}
}
