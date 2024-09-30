package Chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class Task8_7_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = s.nextInt();
        }

        int v = Arrays.stream(values).sum();
        if (v % 3 != 0) {
            System.out.println(0);
            return;
        }
        v = v / 3;
        boolean[][][] split = new boolean[n + 1][v + 1][v + 1];
        split[0][0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int s1 = 0; s1 <= v; s1++) {
                for (int s2 = 0; s2 <= v; s2++) {
                    split[i][s1][s2] = split[i - 1][s1][s2];
                    if (s1 >= values[i-1]) split[i][s1][s2] |= split[i - 1][s1 - values[i-1]][s2];
                    if (s2 >= values[i-1]) split[i][s1][s2] |= split[i - 1][s1][s2 - values[i-1]];
                }
            }
        }
        if (split[n][v][v]) System.out.println(1);
        else System.out.println(0);
    }
}
