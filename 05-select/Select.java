public class Select {
    public static int select(List<Integer> list, int rank) {
        int pivot_index = list.size() / 2;
        int pivot = list.get(pivot_index);

        List<Integer> smaller = new ArrayList<Integer>();
        List<Integer> larger = new ArrayList<Integer>();

        for (int n : list) {
            if (n < pivot) {
                smaller.add(n);
            }
        }
    }
}
