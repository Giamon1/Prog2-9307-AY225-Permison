/**
 * =====================================================
 * Student Name    : Gian Carlo J. Permison
 * Course          : Math 101 — Linear Algebra
 * Assignment      : Programming Assignment 1 — 3x3 Matrix Determinant Solver
 * School          : University of Perpetual Help System DALTA, Molino Campus
 * Date            : March 16, 2026
 * GitHub Repo     : https://github.com/Giamon1/Prog2-9307-AY225-PERMISON.git
 *
 * Description:
 *   This program computes the determinant of a hardcoded 3x3 matrix assigned
 *   to Gian Carlo J. Permison for Math 101. The solution is computed using cofactor
 *   expansion along the first row. Each intermediate step (2x2 minor,
 *   cofactor term, running sum) is printed to the console in a readable format.
 * =====================================================
 */

public class Determinantsolver {

    // ── SECTION 1: Matrix Declaration ───────────────────────────────────
    // Hardcoded assigned matrix
    static int[][] matrix = {
        {2, 3, 5},
        {4, 1, 6},
        {5, 2, 3}
    };

    // ── SECTION 2: 2×2 Determinant Helper ───────────────────────────────
    // Computes determinant of 2x2 matrix using ad - bc
    static int computeMinor(int a, int b, int c, int d) {
        return (a * d) - (b * c);
    }

    // ── SECTION 3: Matrix Printer ───────────────────────────────────────
    static void printMatrix(int[][] m) {
        System.out.println("┌               ┐");
        for (int[] row : m) {
            System.out.printf("│  %2d  %2d  %2d  │%n", row[0], row[1], row[2]);
        }
        System.out.println("└               ┘");
    }

    // ── SECTION 4: Determinant Solver ───────────────────────────────────
    static void solveDeterminant(int[][] m) {

        System.out.println("=".repeat(52));
        System.out.println("  3x3 MATRIX DETERMINANT SOLVER");
        System.out.println("  Student: Gian Carlo J. Permison");
        System.out.println("  Assigned Matrix:");
        System.out.println("=".repeat(52));
        printMatrix(m);
        System.out.println("=".repeat(52));

        int minor11 = computeMinor(m[1][1], m[1][2], m[2][1], m[2][2]);
        System.out.printf("Step 1 — Minor M11: det([%d,%d],[%d,%d]) = (%d×%d)-(%d×%d) = %d%n",
                m[1][1], m[1][2], m[2][1], m[2][2],
                m[1][1], m[2][2], m[1][2], m[2][1], minor11);

        int minor12 = computeMinor(m[1][0], m[1][2], m[2][0], m[2][2]);
        System.out.printf("Step 2 — Minor M12: det([%d,%d],[%d,%d]) = (%d×%d)-(%d×%d) = %d%n",
                m[1][0], m[1][2], m[2][0], m[2][2],
                m[1][0], m[2][2], m[1][2], m[2][0], minor12);

        int minor13 = computeMinor(m[1][0], m[1][1], m[2][0], m[2][1]);
        System.out.printf("Step 3 — Minor M13: det([%d,%d],[%d,%d]) = (%d×%d)-(%d×%d) = %d%n",
                m[1][0], m[1][1], m[2][0], m[2][1],
                m[1][0], m[2][1], m[1][1], m[2][0], minor13);

        int c11 =  m[0][0] * minor11;
        int c12 = -m[0][1] * minor12;
        int c13 =  m[0][2] * minor13;

        System.out.println();
        System.out.printf("Cofactor C11 = (+1) × %d × %d = %d%n", m[0][0], minor11, c11);
        System.out.printf("Cofactor C12 = (-1) × %d × %d = %d%n", m[0][1], minor12, c12);
        System.out.printf("Cofactor C13 = (+1) × %d × %d = %d%n", m[0][2], minor13, c13);

        int det = c11 + c12 + c13;

        System.out.println();
        System.out.printf("det(M) = %d + (%d) + %d%n", c11, c12, c13);
        System.out.println("=".repeat(52));
        System.out.printf("✓ DETERMINANT = %d%n", det);

        if (det == 0) {
            System.out.println("⚠ The matrix is SINGULAR — it has no inverse.");
        }

        System.out.println("=".repeat(52));
    }

    public static void main(String[] args) {
        solveDeterminant(matrix);
    }
}