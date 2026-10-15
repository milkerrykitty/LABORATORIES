package sortirovki;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    void main()
    {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            arr.add(m);
        }

        Sorting<Integer> insertion = new InsertionSort();
        insertion.sort(arr);
        System.out.println(arr);
    }
}
