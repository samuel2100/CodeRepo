package com.datastructure.treetraversal;

public class TreeTraversal {

	class Node{
		Node left;
		Node right;
		int value;
		
		public Node(int value){
			this.value = value;
			this.left = this.right = null;
		}
		
		public void setRight(int value){
			this.right = new Node(value);
		}
		
		public void setLeft(int value){
			this.left = new Node(value);
		}
		
		public Node getRight(){
			return this.right;
		}
		
		public Node getLeft(){
			return this.left;
		}
	}	
	/**
	 * Preorder (Root, Left, Right)  : 1 2 4 5 3
	 * @param root
	 */
	public void preOrderTraversal(Node root){
		System.out.print(root.value +"\t");
		if(root.getLeft() != null){
			preOrderTraversal(root.getLeft());
		}
		
		if(root.getRight() != null){
			preOrderTraversal(root.getRight());
		}
	}
	
	/**
	 * Postorder (Left, Right, Root) : 4 5 2 3 1
	 * @param root
	 */
	public void postOrderTraversal(Node root){
		
		if(root.getLeft() != null){
			postOrderTraversal(root.getLeft());
		}
		if(root.getRight() != null){
			postOrderTraversal(root.getRight());
		}
		System.out.print(root.value+"\t");
	}
	/**
	 * Inorder (Left, Root, Right) : 4 2 5 1 3s
	 * @param root
	 */
	public void inOrderTraversal(Node root){
		
		
		if(root.getLeft() != null){
			inOrderTraversal(root.getLeft());
		}
		System.out.print(root.value+"\t");
		if(root.getRight() != null){
			inOrderTraversal(root.getRight());
		}
	}
	
	
	public static void main(String[] args){
		TreeTraversal treeTraversal = new TreeTraversal();
		Node root = treeTraversal.new Node(1);
		root.setLeft(2);
		root.setRight(3);
		root.getLeft().setLeft(4);
		root.getLeft().setRight(5);
		System.out.println("===============PreOrder Traversal ====");
		treeTraversal.preOrderTraversal(root);
		System.out.println("\n===============End of PreOrder Traversal ====");
		System.out.println("===============InOrder Traversal ====");
		treeTraversal.inOrderTraversal(root);
		System.out.println("\n===============End of inOrder Traversal ====");
		
		System.out.println("===============PostOrder Traversal ====");
		treeTraversal.postOrderTraversal(root);
		System.out.println("\n===============End of PostOrder Traversal ====");
		
	}
}
