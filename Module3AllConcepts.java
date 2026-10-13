 /*
 * ============================================================
 *  MODULE 3 : ARRAYS
 *  Combined Demonstration Program
 *
 *  This single file walks through every topic covered in the
 *  Module 3 training deck, in the same order:
 *
 *    1. Declaration & Initialization  -> 3 ways to create an array
 *    2. Accessing Elements             -> reading & writing by index
 *    3. Traversal                       -> for loop and for-each loop
 *    4. Searching                        -> linear search & binary search
 *    5. Insertion                         -> shifting elements right
 *    6. Deletion                           -> shifting elements left
 *
 *  Compile : javac Module3AllConcepts.java
 *  Run     : java Module3AllConcepts
 * ============================================================
 */

import java.util.Arrays;
import java.util.Scanner;

public class Module3AllConcepts {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println(" MODULE 3: ARRAYS");
        System.out.println(" Combined Demonstration Program");
        System.out.println("========================================\n");

        // ---------------------------------------------------
        // 1. DECLARATION & INITIALIZATION
        // ---------------------------------------------------
        System.out.println("---- 1. Declaration & Initialization ----");

        // Way 1: declare, then allocate a fixed size
        int[] scores = new int[5];

        // Way 2: declare and initialize together
        int[] marks = {85, 90, 78, 92, 88}; 

        // Way 3: allocate, then assign one by one
        String[] names = new String[3];
        names[0] = "Riya";
        names[1] = "Aman";
        names[2] = "Zara";

        System.out.println("scores.length = " + scores.length + " (all default to 0)");
        System.out.println("marks.length  = " + marks.length);
        System.out.println("names= " + Arrays.toString(names));
        System.out.println();

        // ---------------------------------------------------
        // 2. ACCESSING ELEMENTS (real-life: student marks)
        // ---------------------------------------------------
        System.out.println("---- 2. Accessing Elements ----");

        System.out.println("First subject : " + marks[0]);
        System.out.println("Third subject : " + marks[2]);
        System.out.println("Last subject  : " + marks[marks.length - 1]);

        marks[1] = 95;   // overwrite an element
        System.out.println("Updated 2nd subject to 95 -> " + Arrays.toString(marks));
        System.out.println();

        // ---------------------------------------------------
        // 3. TRAVERSAL: for loop, for-each loop, class average
        // ---------------------------------------------------
        System.out.println("---- 3. Traversal ----");

        System.out.println("Using a for loop:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Index " + i + ": " + marks[i]);
        }

        System.out.println("Using a for-each loop:");
        int total = 0;
        for (int m : marks) {
            System.out.print(m + " ");
            total += m;
        }
        System.out.println();

        double average = (double) total / marks.length;
        System.out.println("Total = " + total + ", Average = " + average);
        System.out.println();

        // ---------------------------------------------------
        // 4. SEARCHING: linear search & binary search
        // ---------------------------------------------------
        System.out.println("---- 4. Searching ----");

        int[] rollNumbers = {101, 105, 103, 110, 107};
        
        System.out.print("Enter a roll number to search for: ");
        int target = sc.nextInt();
        int foundAt = -1;

        // Linear search - works on unsorted data
        for (int i = 0; i < rollNumbers.length; i++) {
            if (rollNumbers[i] == target) {
                foundAt = i;
                break;
            }
        }
        if (foundAt != -1) {
            System.out.println("Linear search: found " + target + " at index " + foundAt);
        } else {
            System.out.println("Linear search: " + target + " not found");
        }

        // Binary search - requires a SORTED array
        int[] sortedScores = {10, 20, 30, 40, 50, 60, 70};
        int searchValue = 50;
        int low = 0, high = sortedScores.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedScores[mid] == searchValue) {
                result = mid;
                break;
            } else if (sortedScores[mid] < searchValue) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Binary search: " + searchValue + " found at index " + result +
            " in " + Arrays.toString(sortedScores));
        System.out.println();

        // ---------------------------------------------------
        // 5. INSERTION: shifting elements right
        // ---------------------------------------------------
        System.out.println("---- 5. Insertion ----");

        int[] insertArr = {10, 20, 30, 40, 50, 0};  // extra slot reserved at the end
        int n = 5;          // current number of real elements
        int insertPos = 2;  // insert at index 2
        int insertValue = 25;

        System.out.println("Before insertion: " + Arrays.toString(Arrays.copyOf(insertArr, n)));

        for (int i = n; i > insertPos; i--) {
            insertArr[i] = insertArr[i - 1];   // shift right
        }
        insertArr[insertPos] = insertValue;
        n++;

        System.out.println("After inserting " + insertValue + " at index " + insertPos + ": " +
            Arrays.toString(Arrays.copyOf(insertArr, n)));
        System.out.println();

        // ---------------------------------------------------
        // 6. DELETION: shifting elements left
        // ---------------------------------------------------
        System.out.println("---- 6. Deletion ----");

        int[] deleteArr = {10, 20, 25, 30, 40, 50};
        int m = 6;         // current number of real elements
        int deletePos = 2; // delete the element at index 2

        System.out.println("Before deletion: " + Arrays.toString(Arrays.copyOf(deleteArr, m)));

        for (int i = deletePos; i < m - 1; i++) {
            deleteArr[i] = deleteArr[i + 1];   // shift left
        }
        m--;

        System.out.println("After deleting index " + deletePos + ": " +
            Arrays.toString(Arrays.copyOf(deleteArr, m)));

        System.out.println("\n========================================");
        System.out.println(" End of Module 3 Demonstration Program");
        System.out.println("========================================");

        sc.close();
    }
}





