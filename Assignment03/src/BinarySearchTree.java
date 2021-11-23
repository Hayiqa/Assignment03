public class BinarySearchTree {

	class Node {

		String value;
		Node left, right;

		public Node(String key) {
			value = key;
			left = right = null;
		}
	}

	Node root;

	BinarySearchTree(){
		root = null;
	}

	void insert(String key) {
		root = insertValue(root, key);
	}

	Node insertValue(Node root, String key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key.compareTo(root.value) == -1) {
			root.left = insertValue(root.left, key);
		} else {
			root.right = insertValue(root.right, key);
		}
		return root;
	}

	public boolean Search(Node root, String key) {
		while (root != null) {

			if (key.compareTo(root.value) == 0) {
				return true;

			} else if (key.compareTo(root.value) == -1) {
				root = root.left;
			} else
				root = root.right;
		}
		return false;
	}

	void inorder() {
		inorderTrav(root);
	}

	void inorderTrav(Node root) {
		if (root != null) {
			inorderTrav(root.left);
			System.out.println(root.value);
			inorderTrav(root.right);
		}
	}

}