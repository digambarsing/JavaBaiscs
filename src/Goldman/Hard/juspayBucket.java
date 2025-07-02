package Goldman.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class juspayBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = Integer.parseInt(sc.nextLine());

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            if (parts[0].equals("add")) {
                int n = Integer.parseInt(parts[1]);
                ans.add(n);
            } else if (parts[0].equals("get")) {
                ArrayList<Integer> sorted = new ArrayList<>(ans);
                Collections.sort(sorted);
                int l = sorted.size();
                double median;

                if (l % 2 != 0) {
                    median = sorted.get(l / 2);
                } else {
                    median = (sorted.get(l / 2 - 1) + sorted.get(l / 2)) / 2.0;
                }

                System.out.printf("%.1f\n", median);
            }
        }
    }
}
