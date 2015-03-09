import java.util.Arrays;
import java.util.Random;

public class QSort{
    public int partition(int[] a, int l, int r) {
        int tmp;
        //int pivotIndex = l+rnd.nextInt(r-l);
        int pivotIndex=l;
        int pivot = a[pivotIndex];
        tmp = a[r];
        a[r] = a[pivotIndex];
        a[pivotIndex]=tmp;

        int wall=l;
        int pcount=1;
        for (int i=l;i<r;i++) {
            if (a[i]<pivot) {
                tmp = a[i];
                a[i]=a[wall];
                a[wall]=tmp;
                wall++;
            }
            if (a[i]==pivot)
                pcount++;
        }
        // now copy over all the pivots
        int rwall=wall;
        tmp = a[rwall];
        a[wall]=a[r];
        a[r]=tmp;
        rwall++;
        for (int i=rwall+1;i<=r;i++) {
            if (a[i]==pivot) {
                tmp = a[rwall];
                a[rwall]=a[i];
                a[i]=tmp;
                rwall++;
            }
        }
        return (wall+rwall)/2;
    }

    public void qsort(int[] a, int l, int h){
        int pi,pval;
        pi = partition(a,l,h);
        pval = a[pi];
        if (pi - l > 1)
            qsort(a,l,pi-1);
        if (h - pi > 1)
            qsort(a,pi+1,h);
    }

    public int[] qsort(int[] a){
        int[] b = Arrays.copyOf(a,a.length);
        qsort(b,0,b.length-1);
        return b;
    }

    public int[] randList(int length) {
        Random r = new Random();
        int[] out = new int[length];
        for (int i = 0; i < length; i++) {
            out[i] = r.nextInt(length);
        }
        return out;
    }

    public static void main(String[] args) {
        QSort q = new QSort();
        int[] a = q.randList(30);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(q.qsort(a)));

    }
}
