package Day2;

/** Day2 */
import java.io.File;
import java.nio.file.*;

public class Day2 {
  public static String readFileAsString(String fileName) throws Exception {
    String data = "";
    data = new String(Files.readAllBytes(Paths.get(fileName)));
    return data;
  }

  public static boolean isSorted(String[] ary) {

    boolean ascending = true;
    boolean descending = true;

    for (int i = 0; i < ary.length - 1; i++) {
      int a = Integer.parseInt(ary[i]);
      int b = Integer.parseInt(ary[i + 1]);

      if (a > b) {
        ascending = false;
      }
      if (a < b) {
        descending = false;
      }
    }

    return ascending || descending;
  }

  public static boolean isValued(String[] ary) {
    boolean val = true;
    for (int i = 0; i < ary.length - 1; i++) {
      int a = Integer.parseInt(ary[i]);
      int b = Integer.parseInt(ary[i + 1]);

      if (Math.abs(a - b) >= 1 && Math.abs(a - b) <= 3) {
        continue;
      } else {
        val = false;
      }
    }
    return val;
  }

  public static void main(String[] args) throws Exception {
    String currentPath = System.getProperty("user.dir");
    String data = readFileAsString(currentPath + File.separator + "day2.txt");
    String[] num = data.trim().split("\n");

    int count = 0;
    for (int i = 0; i < num.length; i++) {
      String[] val = num[i].trim().split(" ");
      if (isSorted(val)) {
        if (isValued(val)) {
          count++;
        }
      }
    }
    System.out.println(count);
  }
}
