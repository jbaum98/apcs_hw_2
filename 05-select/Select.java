import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Select {
    public static int[] partition(int[] list) {
        return partition(list, 0, list.length-1);
    }
    public static int[] partition(int[] list, int start, int end) {
        int[] out = new int[list.length];

        // COPY EVERYTHING OUTSIDE BOUNDS
        for (int i = 0; i < start; i++) {
            out[i] = list[i];
        }
        for (int i = end; i < list.length; i++) {
            out[i] = list[i];
        }

        int pivot_index = list.length / 2;
        int pivot = list[pivot_index];
        System.out.println("pivot: " + pivot);

        for (int i = start; i < end; i++) {
            int val = list[i];
            if (val < pivot) {
                out[start] = val;
                start++;
            } else if (val > pivot) {
                out[end] = val;
                end--;
            }
        }

        out[start] = pivot;

        return out;
    }

    public static void main(String[] args) {
        int[] t = {5, 2, 12, 7, 3};
        System.out.println(Arrays.toString(Select.partition(t)));
    }
}
