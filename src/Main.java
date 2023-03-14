//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void Task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n & m : ");
        double n = 0.0;
        double m = 0.0;
        boolean validInput = false;

        do {
            try {
                System.out.print("Enter n: ");
                n = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter m: ");
                m = Double.parseDouble(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException var12) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while(!validInput);

        int n1 = (int)n;
        int m1 = (int)m;
        if (n - m != 0.0 && (m + 2.0 != 0.0 || n1 - m1 != 0) && m1 + 2 != 0) {
            double answer = Math.pow((n + 1.0) / (m + 2.0) + 5.0 / (n - m), 2.0) * n * m;
            double answerInteger = Math.pow(((double)n1 + 1.0) / (double)(m1 + 2) + 5.0 / (double)(n1 - m1), 2.0) * (double)(n1 * m1);
            System.out.print("1 : n = " + n + " m = " + m + "; answer = " + answer + "\n2 : n = " + n1 + " m = " + m1 + "; answer = " + answerInteger + "\n3 : n = " + n + " m = " + m + "; answer = " + (int)answer + "\n");
        } else {
            System.out.println("We can't divide on zero");
        }

    }

    public static void readArray(Scanner scanner, int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            try {
                arr[i] = scanner.nextInt();
            } catch (InputMismatchException var4) {
                System.out.println("Invalid input, please enter an integer.");
                scanner.next();
                --i;
            }
        }

    }

    private static boolean contains(int[] array, int endIndex, int value) {
        for(int i = 0; i < endIndex; ++i) {
            if (array[i] == value) {
                return true;
            }
        }

        return false;
    }

    public static void Task2() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        boolean isValidInput = false;

        while(!isValidInput) {
            try {
                System.out.print("Enter a non-negative integer: ");
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) {
                    throw new NumberFormatException("The number must be non-negative");
                }

                isValidInput = true;
            } catch (NumberFormatException var12) {
                System.out.println("Invalid input: " + var12.getMessage());
            }
        }

        int[] X = new int[n];
        int[] Y = new int[n];
        System.out.print("Array X : ");
        readArray(scanner, X);
        System.out.print("Array Y : ");
        readArray(scanner, Y);
        int[] mergedArray = new int[n * 2];
        int mergedIndex = 0;
        int[] uniqueElements = X;
        int product = X.length;

        int sum;
        int i;
        for(sum = 0; sum < product; ++sum) {
            i = uniqueElements[sum];
            if (!contains(mergedArray, mergedIndex, i)) {
                mergedArray[mergedIndex] = i;
                ++mergedIndex;
            }
        }

        uniqueElements = Y;
        product = Y.length;

        for(sum = 0; sum < product; ++sum) {
            i = uniqueElements[sum];
            if (!contains(mergedArray, mergedIndex, i)) {
                mergedArray[mergedIndex] = i;
                ++mergedIndex;
            }
        }

        uniqueElements = new int[mergedIndex];
        product = 1;
        sum = 0;

        for(i = 0; i < mergedIndex; ++i) {
            int element = mergedArray[i];
            uniqueElements[i] = mergedArray[i];
            product *= element;
            sum += element;
        }

        System.out.print("Merged array: ");

        for(i = 0; i < uniqueElements.length; ++i) {
            System.out.print(uniqueElements[i] + " ");
        }

        System.out.println("Sum of merged array: " + sum);
        System.out.println("Product of merged array: " + product);
    }

    public static void readMatrix(Scanner scanner, int[][] matrix) {
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                try {
                    matrix[i][j] = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException var5) {
                    System.out.println("Invalid input. Please enter an integer value.");
                    --j;
                }
            }
        }

    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

    }

    public static void Task3() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        boolean isValidInput = false;

        while(!isValidInput) {
            try {
                System.out.print("Enter a non-negative integer N: ");
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) {
                    throw new NumberFormatException("The number must be non-negative");
                }

                isValidInput = true;
            } catch (NumberFormatException var9) {
                System.out.println("Invalid input: " + var9.getMessage());
            }
        }

        int[][] X = new int[n][n];
        int[][] Y = new int[n][n];
        System.out.println("Enter the elements of the matrix A:");
        readMatrix(scanner, X);
        System.out.println("Enter the elements of the matrix B:");
        readMatrix(scanner, Y);
        int[] A = new int[n];

        int i;
        for(i = 0; i < n; ++i) {
            boolean allNegative = true;

            for(int j = 0; j < n; ++j) {
                if (X[i][j] >= 0 || Y[i][j] >= 0) {
                    allNegative = false;
                    break;
                }
            }

            if (allNegative) {
                A[i] = 1;
            } else {
                A[i] = 0;
            }
        }

        System.out.println("Matrix X:");
        printMatrix(X);
        System.out.println("Matrix Y:");
        printMatrix(Y);
        System.out.print("The resulting vector is : ");

        for(i = 0; i < n; ++i) {
            System.out.print(A[i] + " ");
        }

    }

    public static void Task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your text please: ");
        String text = scanner.nextLine();
        String[] lines = text.split("[\\s,.!?:;-]+");

        for(int i = 0; i < lines.length; ++i) {
            if (lines[i].length() % 2 == 1) {
                int mid = lines[i].length() / 2;
                lines[i] = lines[i].substring(0, mid) + lines[i].substring(mid + 1);
            }
        }

        String result = String.join(" ", lines);
        System.out.println("The resulting text is : " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                System.out.print("Continue ? (Y/N) : ");
                char cycle = scanner.next().charAt(0);
                if (cycle != 'y' && cycle != 'Y') {
                    break;
                }

                System.out.print("Please, input a number of task (1-4) that you want to review for the first Laboratory Experiment : ");
                int answer = scanner.nextInt();
                switch (answer) {
                    case 1:
                        Task1();
                        break;
                    case 2:
                        Task2();
                        break;
                    case 3:
                        Task3();
                        break;
                    case 4:
                        Task4();
                        break;
                    default:
                        System.out.println("Your number is incorrect");
                }
            } catch (InputMismatchException var4) {
                System.out.println("Invalid input. Please enter a valid character.");
                scanner.nextLine();
            }
        }

        System.out.println("Goodbye!");
    }
}
