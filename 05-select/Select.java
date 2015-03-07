import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Select {

    public static int select(int[] list, int rank, int low, int high) {
        int pivot_index = (low + high) / 2;
        int pivot = list[pivot_index];

        int[] partitioned = new int[list.length];


        // COPY EVERYTHING OUTSIDE BOUNDS
        for (int i = 0; i < low; i++) {
            partitioned[i] = list[i];
        }
        for (int i = high+1; i < list.length; i++) {
            partitioned[i] = list[i];
        }

        // don't want to mutate our inputs
        int low_dest = low;
        int high_dest = high;

        for (int i = low; i <= high; i++) {
            int val = list[i];
            if (val < pivot) {
                partitioned[low_dest] = val;
                low_dest++;
            } else if (val > pivot) {
                partitioned[high_dest] = val;
                high_dest--;
            }
        }

        pivot_index = low_dest;
        partitioned[pivot_index] = pivot;
        int pivot_rank = pivot_index + 1; // for clarity

        if (pivot_rank > rank) {
            return select(partitioned, rank, low, pivot_index-1);
        } else if (pivot_rank < rank) {
            return select(partitioned, rank, pivot_index+1, high);
        } else {
            return pivot;
        }

    }

    public static int select(int[] list, int rank) {
        return select(list, rank, 0, list.length-1);
    }

    public static void main(String[] args) {
        int[] t = {5, 2, 12, 7, 3};
        System.out.println(Select.select(t, 3));
    }
}
