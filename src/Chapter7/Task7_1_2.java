package Chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task7_1_2 {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
            int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            reader.readLine();
            int[] keys = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int key : keys){
                System.out.println(binarySearch(key, a));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int binarySearch(int key, int[] arr){
        int minIndex = 0;
        int midIndex;
        int maxIndex = arr.length-1;
        while (minIndex <= maxIndex){
            midIndex = (maxIndex + minIndex)>>1;
            if (arr[midIndex]==key) return midIndex;
            if (arr[midIndex] > key) maxIndex = midIndex-1;
            if (arr[midIndex] < key) minIndex = midIndex+1;
        }
        return -1;
    }
}
