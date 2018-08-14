package dictionaryImplementation;

/**
 * @author Deekshika Sharma
 * This class will specify the node of binary search tree
 */
public class BSTNode{

	private final String key;
	private String value;
	private BSTNode leftChild, rightChild;
	
	/**
	 * This constructor is called when a new node is created
	 * @param key
	 * @param value
	 */
	public BSTNode(String key, String value) {
		this.key = key;
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}
    // Getters setters are present for further implementation
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public BSTNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BSTNode leftChild) {
		this.leftChild = leftChild;
	}

	public BSTNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BSTNode rightChild) {
		this.rightChild = rightChild;
	}

	public String getKey() {
		return key;
	}
}
