public class Main {

  public static void main(String[] args) {
    
    int[] myArray = { 9, 5, 3, 6, 4, 2, 5, 9, 2, 1 };
    
    BinaryTree tree = new BinaryTree(myArray);
    
    System.out.println("Tree as array: ");
    Utils.printArray(tree.array);
    System.out.println();
    
    System.out.println("Tree: ");
    tree.printBinaryTree(tree.root);
    System.out.println("Height: " + tree.height());
    System.out.println("Balanced: " + tree.isBalanced());
    
    tree.insert(0);
    
    System.out.println("Tree: ");
    tree.printBinaryTree(tree.root);
    System.out.println("Height: " + tree.height());
    System.out.println("Balanced: " + tree.isBalanced());
    
    tree.insert(-1);
    
    System.out.println("Tree: ");
    tree.printBinaryTree(tree.root);
    System.out.println("Height: " + tree.height());
    System.out.println("Balanced: " + tree.isBalanced());
    
    tree.rebalance();
    
    System.out.println("Tree: ");
    tree.printBinaryTree(tree.root);
    System.out.println("Height: " + tree.height());
    System.out.println("Balanced: " + tree.isBalanced());
    
    Node node = tree.find(2);
    System.out.println("found: " + node.data);
  }
}