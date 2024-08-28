import java.util.ArrayList;

public class Utils {
  
  public static int[] sort(int[] arr) {
    
    for (int i = 0; i < arr.length; i++) {
      for (int j = 1; j < arr.length; j++) {
        if (arr[j - 1] > arr[j]) {
          int temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
        }
      }
    }
    
    return arr;
  }
  
  public static int[] removeDuplicates(int[] arr) {
    
    int uniqueCount = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] != arr[i]) uniqueCount++;
    }
    
    int[] result = new int[uniqueCount];
    int j = 1;
    
    result[0] = arr[0];
    
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] != arr[i]) {
        result[j] = arr[i];
        j++;
      }
    }
    
    return result;
  }
}