import java.util.*;

public class BinaryTree {
  public Node root;
  public int[] array;
  
  public BinaryTree(int[] arr) {
    int[] formattedArr = Utils.removeDuplicates(Utils.sort(arr));

    this.array = formattedArr;
    this.root = buildTree(formattedArr, 0, formattedArr.length - 1);
  }
  
  private Node buildTree(int[] arr, int start, int end) {
    if (start > end) return null;
    
    int mid = (int)Math.floor((start + end) / 2);
    Node node = new Node(arr[mid]);
    
    node.left = buildTree(arr, start, mid - 1);
    node.right = buildTree(arr, mid + 1, end);
    
    return node;
  }
  
  public void printBinaryTree(Node node) {
    printBinaryTree(node, 0, "Root: ");
  }
  
  private void printBinaryTree(Node node, int level, String side) {
      if (node == null) return;

      // Indentation based on level in the tree
      String indent = " ".repeat(level * 6);
      
      // Print the current node with its side and level
      System.out.println(indent + side + node.data);
      
      // Recursively print the left and right children
      printBinaryTree(node.right, level + 1, "R --- ");
      printBinaryTree(node.left, level + 1, "L --- ");
  }
  
  public Node find(int value) {
    return findRec(value, this.root);
  }
  
  private Node findRec(int value, Node node) {
    if (node == null) return new Node(-1);
    
    if (value > node.data) return findRec(value, node.right);
    if (value < node.data) return findRec(value, node.left);
    
    return node;
  }
  
  public void insert(int value) {
    this.root = insertRec(value, this.root);
  }
  
  private Node insertRec(int value, Node node) {
    if (node == null) return new Node(value); 
    
    if (value > node.data) node.right = insertRec(value, node.right);
    if (value < node.data) node.left = insertRec(value, node.left);
    
    return node;
  }
  
  public int height() {
    return height(this.root);
  }
  
  private int height(Node node) {
    if (node == null) return 0;
    
    HashMap<Integer, Integer> heights = new HashMap<Integer, Integer>();
    Queue<Node> queue = new LinkedList<Node>();
    
    queue.offer(node);
    heights.put(node.data, 0);
    
    int max = 0;
    
    while (!queue.isEmpty()) {
      Node current = queue.poll();
      int prevHeight = heights.get(current.data);
      
      if (prevHeight > max) max = prevHeight;
      
      if (current.left != null) {
        queue.offer(current.left);
        heights.put(current.left.data, prevHeight + 1);
      }
      
      if (current.right != null) {
        queue.offer(current.right);
        heights.put(current.right.data, prevHeight + 1);
      }
    }
    
    return max;
  }
  
  public Boolean isBalanced() {
    Queue<Node> queue = new LinkedList<Node>();
    queue.offer(this.root);
    
    while (!queue.isEmpty()) {
      Node current = queue.poll();
      
      int left = height(current.left);
      int right = height(current.right);
      
      if (Math.abs(left - right) >= 2) return false;
      
      if (current.left != null) queue.offer(current.left);
      if (current.right != null) queue.offer(current.right);
    }
    
    return true;
  }
  
  public void rebalance() {
    ArrayList<Integer> datas = new ArrayList<>();
    Queue<Node> queue = new LinkedList<Node>();
    queue.offer(this.root);
    
    while(!queue.isEmpty()) {
      Node current = queue.poll();
      
      datas.add(current.data);
      
      if (current.left != null) queue.offer(current.left);
      if (current.right != null) queue.offer(current.right);
    }
    
    int[] arr = new int[datas.size()];
    
    for (int i = 0; i < datas.size(); i++) {
      arr[i] = datas.get(i);
    }
    
    this.root = buildTree(arr, 0, arr.length - 1);
  }
}