package bst;

public class Binary_search_tree {
	public class Node {
		int val;
		Node right;
		Node left;

	}

	private Node root;

	public Binary_search_tree(int[] in) {
		root = createTree(in, 0, in.length - 1);

	}

	private Node createTree(int[] in, int si, int ei) {
		// TODO Auto-generated method stub
		if (si > ei) {
			return null;
		}
		int mid = (si + ei) / 2;
		Node nn = new Node();
		nn.val = in[mid];
		nn.left = createTree(in, si, mid - 1);
		nn.right = createTree(in, mid + 1, ei);

		return nn;
	}
}
