package assign9;

/**
 * Represents a generically-typed binary tree node. Each binary node contains
 * data, a left child, and a right child.
 * 
 * @author Tim Ellenberger, ellenber
 * @author John Strasser, strasser
 * @author Erin Parker
 * @version 11/05/2015 
 */
public class BinaryNode<Type> {

  private Type data;

  private BinaryNode<Type> leftChild;

  private BinaryNode<Type> rightChild;

  public BinaryNode(Type _data, BinaryNode<Type> _leftChild,
      BinaryNode<Type> _rightChild) {
    data = _data;
    leftChild = _leftChild;
    rightChild = _rightChild;
  }

  public BinaryNode(Type _data) {
    this(_data, null, null);
  }

  /**
   * Getter method.
   * 
   * @return the node data.
   */
  public Type getData() {
    return data;
  }

  /**
   * Setter method.
   * 
   * @param _data
   *          - the node data to be set.
   */
  public void setData(Type _data) {
    data = _data;
  }

  /**
   * Getter method.
   * 
   * @return the left child node.
   */
  public BinaryNode<Type> getLeftChild() {
    return leftChild;
  }

  /**
   * Setter method.
   * 
   * @param _leftChild
   *          - the left child node to be set.
   */
  public void setLeftChild(BinaryNode<Type> _leftChild) {
    leftChild = _leftChild;
  }

  /**
   * Getter method.
   * 
   * @return the right child node.
   */
  public BinaryNode<Type> getRightChild() {
    return rightChild;
  }

  /**
   * Setter method.
   * 
   * @param _rightChild
   *          - the right child node to be set.
   */
  public void setRightChild(BinaryNode<Type> _rightChild) {
    rightChild = _rightChild;
  }

  /**
   * Returns the leftmost node in the binary tree rooted at this node.
   */
  public BinaryNode<Type> getLeftmostNode() {
    // FILL IN -- do not return null
    return null;
  }

  /**
   * Returns the rightmost node in the binary tree rooted at this node.
   */
  public BinaryNode<Type> getRightmostNode() {
    // FILL IN -- do not return null
    return null;
  }

  /**
   * Returns the height of the binary tree rooted at this node. The height of a
   * tree is the length of the longest path to a leaf node. Consider a tree with
   * a single node to have a height of zero. 
   */
  public int height() {
    // FILL IN -- do not return 0
    return 0;
  }

}
