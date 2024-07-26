package Chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class Task8_4_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        s.nextLine();
        int[] line1 = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        s.nextLine();
        int[] line2 = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        s.nextLine();
        int[] line3 = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(LCS(line1, line2, line3));
    }
    private static int LCS(int[] lineA, int[] lineB,int[] lineC){
        int[][][] table = new int[lineA.length+1][lineB.length+1][lineC.length+1];
        for (int i = 1; i <= lineA.length; i++) {
            for (int j = 1; j <= lineB.length; j++) {
                for (int k = 1; k <= lineC.length; k++) {
                    if (lineA[i-1] == lineB[j-1] && lineB[j-1] == lineC[k-1]) table[i][j][k] = 1 + table[i-1][j-1][k-1];
                    table[i][j][k] = Math.max(Math.max(Math.max(table[i-1][j][k], table[i][j-1][k]), table[i][j][k-1]), table[i][j][k]);
                }
            }
        }
        return table[lineA.length][lineB.length][lineC.length];
    }
}
