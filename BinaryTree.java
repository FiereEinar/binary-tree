public class BinaryTree {
  Node root;
  
  public BinaryTree(int[] arr) {
    int[] formattedArr = Utils.removeDuplicates(Utils.sort(arr));

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
    
    System.out.print(depth + " - ");
    System.out.println(root.data);
    printTree(root.left, depth + 1);
    printTree(root.right, depth + 1);
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