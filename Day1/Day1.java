/** Day1 */
import java.io.File;
import java.nio.file.*;

public class Day1 {
  public static String readFileAsString(String fileName) throws Exception {
    String data = "";
    data = new String(Files.readAllBytes(Paths.get(fileName)));
    return data;
  }

  public static int[] sort(int[] list) {
    int temp;
    for (int i = 0; i < list.length; i++) {
      for (int j = i + 1; j < list.length; j++) {
        if (list[i] > list[j]) {
          temp = list[i];
          list[i] = list[j];
          list[j] = temp;
        }
      }
    }
    return list;
  }

  public static void main(String[] args) throws Exception {
    String currentPath = System.getProperty("user.dir");
    String data = readFileAsString(currentPath + File.separator + "day1.txt");

    // Split the string by whitespace
    String[] numbers = data.trim().split("\\s+");
    int[] list = new int[numbers.length];

    // Parse each number and add to list
    for (int i = 0; i < numbers.length; i++) {
      if (!numbers[i].isEmpty()) {
        list[i] = Integer.parseInt(numbers[i]);
      }
    }

    int[] list1 = new int[numbers.length];
    int[] list2 = new int[numbers.length];
    for (int i = 0; i < list.length; i++) {
      if (i % 2 == 0) {
        list1[i] = list[i];
      } else {
        list2[i] = list[i];
      }
    }
    //
    // list1 = sort(list1);
    // list2 = sort(list2);
    //
    int sum = 0;
    // for (int i = 0; i < list1.length; i++) {
    //    sum = sum + Math.abs(list1[i] - list2[i]);
    // }
    //

    int count = 0;

    for (int i = 0; i < list1.length; i++) {
      for (int j = 0; j < list2.length; j++) {
        if (list1[i] == list2[j]) {
          count++;
        }
      }
      sum = sum + (list1[i] * count);
      count = 0;
    }

    System.out.println(sum);
  }
}

