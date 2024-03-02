package TreeAssignment;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Print_leaf_nodes {
	  static Scanner sc = new Scanner(System.in);

		public static void main(String[] args) {
			Print_leaf_nodes   m = new Print_leaf_nodes ();
			BinaryTree bt = m.new BinaryTree();
			bt.leafs();
		}
	    	private class BinaryTree {
	public class Node{
		int data;
		Node left;
		Node right;
		
		
	}
	   private Node root;
	   
	public  BinaryTree() {
	    
		CreateTree();
	}
	private void CreateTree() {
		// TODO Auto-generated method stub
		int item = sc.nextInt();
		Queue<Node> qq= new LinkedList<>();
		Node nn = new Node();
		nn.data= item;
		this.root =nn;
		qq.add(nn);
		while(!qq.isEmpty()) {
			
		Node rv =qq.remove();
	    int hlc = sc.nextInt();
	    int hlr = sc.nextInt();
	    
		if(hlc != -1) {
			Node n = new Node();
			n.data= hlc;
			rv.left=n;
			qq.add(n);
		}
	    
		if(hlr !=-1) {
			Node n = new Node();
			n.data= hlr;
			rv.right=n;
			qq.add(n);
		}
	   
	
		}
		
	}
	        public  void leafs(){
	            leafs(this.root);
	        }
	        private void leafs(Node root){
	            
	             
	            if(root.left==null && root.right==null) {
	                System.out.print(root.data+" ");
	                return;
	            }else 
	            {
	             if(root.right!=null)
	            leafs(root.right);

	            if(root.left!=null)
	            leafs(root.left);
	            }
	            
	        }
	        }
	}
