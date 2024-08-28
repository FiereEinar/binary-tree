public class Main {

  public static void main(String[] args) {
    
    int[] myArray = { 9, 5, 3, 6, 4, 2, 5, 9, 2, 1 };
    
    BinaryTree tree = new BinaryTree(myArray);
    System.out.println();
    tree.printTreeV2();
    
    Utils.printArray(tree.array);
    
    Node node = tree.find(2);
    
    System.out.println("found: " + node.data);
  }
}