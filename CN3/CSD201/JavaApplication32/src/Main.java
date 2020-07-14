import java.lang.reflect.Array;

public class Main {
    public static double sortBy(Sort s, String method){
        s.makeCopyArr();
        long start = System.currentTimeMillis();
        switch(method){
            case "SELECTION":
                s.seclectionSort();
                break;
            case "BUBBLE":
                s.bubbleSort();
                break;
            case "QUICK":
                s.QuickSort(0, s.n-1);
                break;
        }
        double end = System.currentTimeMillis()-start;
        System.out.println("Is Sorted: "+s.isSorted());
        System.out.println("Time sort by "+method+" Sort: " + end);
        s.recoverArr();
        return end;

    }
    public static void main(String[] args) {
        Sort sort = new Sort();
        double SE = sortBy(sort, "SELECTION");
        double BU = sortBy(sort, "BUBBLE");
        double QU = sortBy(sort, "QUICK");
        System.out.printf("Ratio SE/BU: %.2f", SE/BU);
        System.out.println("");
        System.out.printf("Ratio SE/QU: %.2f",SE/QU);
        System.out.println("");

    }
}
