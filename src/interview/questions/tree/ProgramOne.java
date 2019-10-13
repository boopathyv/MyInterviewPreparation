package interview.questions.tree;

public class ProgramOne {
	
	public static void main(String[] args) {
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
		System.out.println(node);
		convert(node);
		System.out.println(node);
//		tree.add(1);
//		tree.add(2);
//		tree.add(3);
//		tree.add(4);
//		tree.add(5);
//		tree.add(6);
//		tree.add(7);
	}

	private static int convert(Node node) {
		if(node.left == null && node.right == null) {
			int data = node.data;
			node.setData(0);
			return data;
		}
		if(node != null) {
			int left = convert(node.left);
			int right = convert(node.right);
			int data = left+right;
			node.setData(data);
			return data;
		}
		return 0;
	}
	
}

class Tree{
	public Node root;
	public void add(int data) {
		if(root != null) {
//			root = new Node(data);
		}else {
			root = addData(root,data);
		}
	}
	private Node addData(Node node, int data) {
		if(node == null) {
//			return new Node(data);
		}
		if(data < node.getData()) {
			node.left = addData(node.left,data);
		}else if(data > node.getData()) {
			node.right = addData(node.right,data);
		}
		return node;
	}
}

class Node{
	int data;
	Node left;
	Node right;
	
	@Override
	public String toString() {
		return String.valueOf(this.data);
	}
	public Node(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
}