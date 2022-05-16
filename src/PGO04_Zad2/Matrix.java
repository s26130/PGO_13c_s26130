package PGO04_Zad2;

public class Matrix {

    private int[][] content;

    private static int[][] temporaryContent;
    private static int nextRow;


    private Matrix() {};

    void print() {
        for (int i = 0; i < content.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < content[i].length; j++) {
                var current = content[i][j];
                System.out.print(current);
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }

    Matrix add(Matrix m) {
        validateForAddOrSubtract(this, m);

        for (int i = 0; i < this.content.length; i++) {
            for (int j = 0; j <this.content[i].length; j++){
                this.content[i][j] = this.content[i][j] + m.content[i][j];
            }
        }

        return this;
    }

    static Matrix add(Matrix m1, Matrix m2) {
        validateForAddOrSubtract(m1, m2);

        var rows = m1.content.length;
        var cols = m1.content[0].length;

        setUpMatrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            var row = new int[cols];
            for (int j = 0; j < cols; j++) {
                row[j] = m1.content[i][j] + m2.content[i][j];
            }
            insertRow(row);
        }

        Matrix result = create();

        return result;
    }

    Matrix subtract(Matrix m) {
        validateForAddOrSubtract(this, m);

        for (int i = 0; i < this.content.length; i++) {
            for (int j = 0; j <this.content[i].length; j++){
                this.content[i][j] = this.content[i][j] - m.content[i][j];
            }
        }

        return this;
    }

    static Matrix subtract(Matrix m1, Matrix m2) {
        validateForAddOrSubtract(m1, m2);
        var rows = m1.content.length;
        var cols = m1.content[0].length;

        setUpMatrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            var row = new int[cols];
            for (int j = 0; j < cols; j++) {
                row[j] = m1.content[i][j] - m2.content[i][j];
            }
            insertRow(row);
        }

        Matrix result = create();

        return result;
    }

    /*
    1 7
    3 4
    9 9

    1 2 3 4
    9 0 1 0
     */
    Matrix multiply(Matrix m) {
        validateForMultiply(this, m);
        var result = multiply(this, m);

        return result;
    }

    Matrix multiply(Matrix m1, Matrix m2) {
        validateForMultiply(m1, m2);

        var rows = m1.content.length;
        var cols = m2.content[0].length;
        setUpMatrix(rows, cols);

        for(int i = 0; i< rows; i++) {
            var newRow = new int[cols];

            for (int j = 0; j < cols; j++) {
                var cell = 0;
                for (int k = 0; k < rows; k++) {
                    cell += m1.content[i][k] * m2.content[k][j];
                }

                newRow[i] = cell;
            }
            insertRow(newRow);
        }

        var result = create();
        return result;
    }

    static void setUpMatrix(int rowCount, int columnCount) {
        if (rowCount <= 0 || columnCount <= 0) {
            System.out.printf("Matrix can be at least 1x1. Fix matrix size: (%d x %d)%n", rowCount, columnCount);
            return;
        }
        temporaryContent = new int[rowCount][columnCount];
        nextRow = 0;
    }

    static void insertRow(int[] row) {
        if (temporaryContent == null) {
            System.out.println("You must call 'setUpMatrix' first");
            return;
        }

        if (row == null) {
            System.out.println("You can not insert null row");
            return;
        }

        if (row.length != temporaryContent[0].length) {
            System.out.println("Row length must be equal to declared row length: " + temporaryContent[0].length);
            return;
        }

        if( nextRow > temporaryContent.length) {
            System.out.println("You can not add more rows than declared: " + temporaryContent.length);
            return;
        }

        for (int i = 0; i < row.length; i++) {
            temporaryContent[nextRow][i] = row[i];
        }
        nextRow++;
    }

    static Matrix create() {
        if (temporaryContent == null) {
            throw new RuntimeException("You must first call 'setUpMatrix' method");
        }

        var m = new Matrix();
        m.content = temporaryContent;
        releaseTemporary();
        return m;
    }

    private static void releaseTemporary() {
        temporaryContent = null;
        nextRow = 0;
    }

    private static void validateForAddOrSubtract(Matrix m1, Matrix m2) {
        if (m1 == null || m2 == null) {
            throw new IllegalArgumentException("Matrix can not be null");
        }
        if (m1.content == null || m2.content == null) {
            throw new IllegalArgumentException("Matrix must be initialized");
        }

        if (m1.content.length != m2.content.length
                || m1.content[0].length != m2.content[0].length) {
            throw new ArithmeticException("Both matrixes must have the same dimension");
        }
    }

    private static void validateForMultiply(Matrix m1, Matrix m2) {
        if (m1 == null || m2 == null) {
            throw new IllegalArgumentException("Matrix can not be null");
        }
        if (m1.content == null || m2.content == null) {
            throw new IllegalArgumentException("Matrix must be initialized");
        }
        if (m1.content[0].length != m2.content.length) {
            throw new ArithmeticException("To multiply matrixes width of first one must be equal to height of second");
        }
    }
}
