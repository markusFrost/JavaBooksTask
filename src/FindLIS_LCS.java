public class FindLIS_LCS {

// Find LIS by LCS.
// Time complexity = O(n^2).
// LCS.
// Time complexity = O(n^2).
// Note:
// UP LEFT MARK = -1.
// UP MARK = -2.
// LEFT MARK = -3.
private static int LCS (int[] firstA, int[] secondA, int[][]c, int[][]b) {
    int lenFA = firstA.length;
    int lenSA = secondA.length;

    // Init c matrix.
    for (int i = 0; i < lenFA; i ++) c[i][0] = 0;
    for (int i = 0; i < lenSA; i ++) c[0][i] = 0;

    for (int i = 1; i < lenFA+1; i ++) {
        for (int j = 1; j < lenSA+1; j ++) {
            if (firstA[i - 1] == secondA[j - 1]) {
                c[i][j] = c[i - 1][j - 1] + 1;
                b[i - 1][j - 1] = -1;
            } else if (c[i - 1][j] >= c[i][j - 1]) {
                c[i][j] = c[i - 1][j];
                b[i - 1][j - 1] = -2;
            } else {
                c[i][j] = c[i][j - 1];
                b[i - 1][j - 1] = -3;
            }
        }
    }
    return c[lenFA][lenSA];
}

// Print out the LCS.
// Time complexity = O(m + n).
private static void printLCS_Helper (int[] firstA, int[][]b, int i, int j) {
    if (i < 0 || j < 0) return; // Base case.
    if (b[i][j] == -1) {
        printLCS_Helper(firstA, b, i - 1, j - 1);
        System.out.print(String.format("%-6d", firstA[i]));
    } else if (b[i][j] == -2) printLCS_Helper(firstA, b, i - 1, j);
    else printLCS_Helper(firstA, b, i, j - 1);
}
public static void printLCS (int[] firstA, int[][]b) {
    int size = firstA.length;
    printLCS_Helper(firstA, b, size - 1, size - 1);
}

// Quick sort for array.
// Time complexity = O(nlgn).
private static void exchange (int[] givenArray, int firstIndex, int secondIndex) {
    int temp = givenArray[firstIndex];
    givenArray[firstIndex] = givenArray[secondIndex];
    givenArray[secondIndex] = temp;
}
private static int partition (int[] givenArray, int start, int end, int pivotIndex) {
    int pivot = givenArray[pivotIndex];
    int left = start;
    int right = end;
    while (left <= right) {
        while (givenArray[left] < pivot) left ++;
        while (givenArray[right] > pivot) right --;
        if (left <= right) {
            exchange(givenArray, left, right);
            left ++;
            right --;
        }
    }
    return left;
}
private static void quickSortFromMinToMax_Helper (int[] givenArray, int start, int end) {
    if (start >= end) return; // Base case.
    // Generate a random num in the range[start, end] as the pivot index to partition the array.
    int rand = start + (int) (Math.random() * ((end - start) + 1));
    int split = partition (givenArray, start, end, rand);
    // Do recursion.
    quickSortFromMinToMax_Helper(givenArray, start, split - 1);
    quickSortFromMinToMax_Helper(givenArray, split, end);
}
public static void quickSortFromMinToMax (int[] givenArray) {
    int size = givenArray.length;
    quickSortFromMinToMax_Helper(givenArray, 0, size - 1);
}

// Copy array.
public static int[] copyArray (int [] givenArray) {
    int size = givenArray.length;
    int[] newArr = new int[size];
    for (int i = 0; i < size; i ++) 
        newArr[i] = givenArray[i];
    return newArr;
}

// Main method to test.
public static void main (String[] args) {
    // Test data: {1, 2, 1, 4, 5, 3, 10}.
    //int[] givenArray = {1, 2, 1, 4, 5, 3, 10};
    int[] givenArray = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11,7, 15};
    int size = givenArray.length;
    // Test finding LIS by LCS approach.
    int[] sortedArr = copyArray(givenArray);
    quickSortFromMinToMax (sortedArr);
    int[][]c = new int[size + 1][size + 1];
    int[][]b = new int[size][size];
    System.out.println("Test max len = " + LCS(givenArray, sortedArr, c, b));
    printLCS(givenArray, b);
}
}