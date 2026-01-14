package coreprogramming.methods.level3;

import java.util.Scanner;

public class MatrixUtility {

    public static double[][] createRandomMatrix(int rows, int cols) {

        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int)(Math.random() * 9) + 1;
            }
        }
        return matrix;
    }

    public static double[][] add(double[][] A, double[][] B) {

        int r = A.length;
        int c = A[0].length;
        double[][] C = new double[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                C[i][j] = A[i][j] + B[i][j];

        return C;
    }

    public static double[][] subtract(double[][] A, double[][] B) {

        int r = A.length;
        int c = A[0].length;
        double[][] C = new double[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                C[i][j] = A[i][j] - B[i][j];

        return C;
    }

    public static double[][] multiply(double[][] A, double[][] B) {

        int r = A.length;
        int c = B[0].length;
        int n = B.length;

        double[][] C = new double[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                for (int k = 0; k < n; k++)
                    C[i][j] += A[i][k] * B[k][j];

        return C;
    }

    public static double[][] transpose(double[][] M) {

        double[][] T = new double[M[0].length][M.length];

        for (int i = 0; i < M.length; i++)
            for (int j = 0; j < M[0].length; j++)
                T[j][i] = M[i][j];

        return T;
    }

    public static double determinant2x2(double[][] M) {

        return M[0][0] * M[1][1] - M[0][1] * M[1][0];
    }

    public static double determinant3x3(double[][] M) {

        return M[0][0]*(M[1][1]*M[2][2] - M[1][2]*M[2][1])
                - M[0][1]*(M[1][0]*M[2][2] - M[1][2]*M[2][0])
                + M[0][2]*(M[1][0]*M[2][1] - M[1][1]*M[2][0]);
    }

    public static double[][] inverse2x2(double[][] M) {

        double det = determinant2x2(M);
        if (det == 0) return null;

        double[][] inv = new double[2][2];
        inv[0][0] =  M[1][1] / det;
        inv[0][1] = -M[0][1] / det;
        inv[1][0] = -M[1][0] / det;
        inv[1][1] =  M[0][0] / det;

        return inv;
    }

    public static double[][] inverse3x3(double[][] M) {

        double det = determinant3x3(M);
        if (det == 0) return null;

        double[][] inv = new double[3][3];

        inv[0][0] =  (M[1][1]*M[2][2] - M[1][2]*M[2][1]) / det;
        inv[0][1] = -(M[0][1]*M[2][2] - M[0][2]*M[2][1]) / det;
        inv[0][2] =  (M[0][1]*M[1][2] - M[0][2]*M[1][1]) / det;

        inv[1][0] = -(M[1][0]*M[2][2] - M[1][2]*M[2][0]) / det;
        inv[1][1] =  (M[0][0]*M[2][2] - M[0][2]*M[2][0]) / det;
        inv[1][2] = -(M[0][0]*M[1][2] - M[0][2]*M[1][0]) / det;

        inv[2][0] =  (M[1][0]*M[2][1] - M[1][1]*M[2][0]) / det;
        inv[2][1] = -(M[0][0]*M[2][1] - M[0][1]*M[2][0]) / det;
        inv[2][2] =  (M[0][0]*M[1][1] - M[0][1]*M[1][0]) / det;

        return inv;
    }

    public static void display(double[][] M) {

        for (double[] row : M) {
            for (double val : row) {
                System.out.printf("%6.2f ", val);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows of Matrix A: ");
        int r1 = sc.nextInt();
        System.out.print("\nEnter columns of Matrix A: ");
        int c1 = sc.nextInt();

        System.out.print("\nEnter rows of Matrix B: ");
        int r2 = sc.nextInt();
        System.out.print("\nEnter columns of Matrix B: ");
        int c2 = sc.nextInt();

        double[][] A = createRandomMatrix(r1, c1);
        double[][] B = createRandomMatrix(r2, c2);

        System.out.println("\nMatrix A:");
        display(A);

        System.out.println("\nMatrix B:");
        display(B);

        if (r1 == r2 && c1 == c2) {
            System.out.println("A + B:");
            display(add(A, B));

            System.out.println("A - B:");
            display(subtract(A, B));
        } else {
            System.out.println("Addition/Subtraction not possible");
        }

        if (c1 == r2) {
            System.out.println("A * B:");
            display(multiply(A, B));
        } else {
            System.out.println("Multiplication not possible");
        }

        System.out.println("Transpose of A:");
        display(transpose(A));

        if (r1 == 2 && c1 == 2) {
            System.out.println("Determinant of A (2x2): " + determinant2x2(A));
            display(inverse2x2(A));
        }

        if (r1 == 3 && c1 == 3) {
            System.out.println("Determinant of A (3x3): " + determinant3x3(A));
            display(inverse3x3(A));
        }
    }
}
