

public class Main {

  public static void main(String[] args) {
    
    System.out.println("Hello");
    
    int[] myArray = { 9, 5, 3, 6, 4, 2, 5, 9, 2, 1 };
    
    BinaryTree tree = new BinaryTree(myArray);
    
    Node node = tree.find(2);
    
    System.out.println("found: " + node.data);
  }
}