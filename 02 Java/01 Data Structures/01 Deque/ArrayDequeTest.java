public class ArrayDequeTest {
    
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkGet(int expected, int actual) {
        if (expected != actual) {
            System.out.println("get() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkGet(String expected, String actual) {
        if (expected.compareTo(actual) != 0) {
            System.out.println("get() returned " + actual + ", but expected: " + expected);
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> ad1 = new ArrayDeque<String>();

        boolean passed = checkEmpty(true, ad1.isEmpty());
        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addFirst("c");
        ad1.addLast("d");
        ad1.addLast("e");
        ad1.addFirst("f");

        //passed = checkGetRecursive("front", ad1.getRecursive(0));

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(6, ad1.size()) && passed;
        passed = checkEmpty(false, ad1.isEmpty()) && passed;

        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();



        passed = checkSize(0, ad1.size()) && passed;
        passed = checkEmpty(true, ad1.isEmpty()) && passed;

        ArrayDeque<String> ad2 = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            ad2.addLast(String.valueOf((char)(97 + i)));
        }

        System.out.println("Printing out deque: ");
        ad2.printDeque();

        passed = checkGet("z", ad2.get(25)) && passed;
        passed = checkGet("d", ad2.get(3)) && passed;

        ArrayDeque<String> ad3 = new ArrayDeque<>(ad2);
        for (int i = 0; i < ad2.size(); i++) {
            if (ad3.get(i) != ad2.get(i)) {
                passed = false;
            }
        }

        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, ad1.isEmpty());

        ad1.addFirst(0);
        // should not be empty
        passed = checkEmpty(false, ad1.isEmpty()) && passed;

        ad1.addLast(1);
        ad1.addLast(2);
        ad1.addLast(3);

        passed = checkGet(0, ad1.get(0)) && passed;
        passed = checkGet(3, ad1.get(3)) && passed;

        System.out.println();

        ArrayDeque<Integer> ad3 = new ArrayDeque<Integer>(ad1);
        for (int i = 0; i < ad1.size(); i++) {
            if (ad3.get(i) != ad1.get(i)) {
                passed = false;
            }
        }

        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();
        for (int i = 0; i < 16; i++) {
            ad2.addLast(i);
        }

        passed = checkGet(15, ad2.get(15)) && passed;
        passed = checkGet(12, ad2.get(12)) && passed;
        passed = checkGet(4, ad2.get(4)) && passed;
        passed = checkSize(16, ad2.size()) && passed;

        System.out.println("Printing out deque: ");
        ad2.printDeque();

        ArrayDeque<Integer> ad4 = new ArrayDeque<Integer>(ad2);
        for (int i = 0; i < ad2.size(); i++) {
            if (ad2.get(i) != ad4.get(i)) {
                passed = false;
            }
        }

        printTestStatus(passed);
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
    }
}
