import java.util.Scanner;

public class Sort {
    Scanner sc = new Scanner(System.in);
    int n;
    int[] arr, temp;

    public Sort() {
        System.out.print("Enter the number element: ");
        n = sc.nextInt();
        arr = new int[n];
        temp = new int[n];
        arr = randomValueOfArray(10, 50);
    }

    public void makeCopyArr() {
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }
    }

    public void recoverArr() {
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    public void display() {
        for (int i = 0; i < arr.length; i++) {
            if (i == n - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("");
    }

    private void swapAt(int a, int b) {
        int tg = arr[a];
        arr[a] = arr[b];
        arr[b] = tg;
    }

    //Seclection Sort
    public void seclectionSort() {
        for (int i = 0; i <= n - 2; i++) {
            int vtbn = findMinPos(i, n - 1);
            swapAt(i, vtbn);
        }
    }

    //Buble Sort
    public void bubbleSort() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swapAt(i, j);
                }
            }
        }
    }

    //Quick Sort
    public void QuickSort(int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            QuickSort(left, index - 1);
        }
        if (index < right) {
            QuickSort(index, right);
        }
    }

    // Support function
    private int findMinPos(int st, int end) {
        int minIndex = st;
        for (int i = st + 1; i <= end; i++) {
            if (arr[minIndex] > arr[i]) minIndex = i;
        }
        return minIndex;
    }

    public boolean isSorted() {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    //Allow user input value of array
    public int[] randomValueOfArray(int min, int max) {
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (min + Math.random() * (max - min));
        }
        return arr;
    }

    private int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swapAt(i, j);
                i++;
                j--;
            }
        }
        ;
        return i;
    }

    void BoSung(int L, int R) {
        int cha = L, con = 2 * cha;
        while (con <= R) {
            if (arr[con + 1] > arr[con])
                con++;
            if (arr[cha] > arr[con]) return;
            swapAt(cha, con);
            con = con;
            con = 2 * cha;
        }
    }

    void heapSort() {
        int L = n / 2 + 1;
        while (L > 0) BoSung(--L, n - 1);
        int R = n - 1;
        while (R > 0) {
            swapAt(0, R);
            BoSung(0, --R);
        }
    }
}
