import java.util.*;

public class BinaryTree {
  public Node root;
  public int[] array;
  
  public BinaryTree(int[] arr) {
    int[] formattedArr = Utils.removeDuplicates(Utils.sort(arr));

    this.array = formattedArr;
    this.root = buildTree(formattedArr, 0, formattedArr.length - 1);
    printTree(this.root, 0);
  }
  
  private Node buildTree(int[] arr, int start, int end) {
    if (start > end) return null;
    
    int mid = (int)Math.floor((start + end) / 2);
    Node node = new Node(arr[mid]);
    
    node.left = buildTree(arr, start, mid - 1);
    node.right = buildTree(arr, mid + 1, end);
    
    return node;
  }
  
  private void printTree(Node root, int depth) {
    if (root == null) return;
    
    System.out.println(depth + " - " + root.data);
    printTree(root.left, depth + 1);
    printTree(root.right, depth + 1);
  }
  
  // TODO: maybe add some proper spacing so it looks like a pyramid
  public void printTreeV2() {
    if (this.root == null) return;
    
    Queue<Node> queue = new LinkedList<Node>();
    queue.offer(this.root);
    
    String result = "";
    int i = 0;
    int nextLine = 1;
    
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      
      result += "" + node.data;
      if (node.left != null) queue.offer(node.left);
      if (node.right != null) queue.offer(node.right);
      
      i++;
      
      if (nextLine == i) {
        result += "\n";
        nextLine = nextLine * 2;
        i = 0;
      }
    }
    
    System.out.println(result);
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
}