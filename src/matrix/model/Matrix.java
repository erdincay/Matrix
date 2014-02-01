package matrix.model;

/**
 * User: Ding
 * Date: 4/29/13
 * Time: 5:20 PM
 * standard matrix mult
 */
public class Matrix {
    private int lines_;
    private int rows_;
    private int[][] mtx_;

    public Matrix(int lines, int rows, int[][] mtx) {
        lines_ = lines;
        rows_ = rows;
        mtx_ = mtx;
    }

    public Matrix(int lines, int rows) {
        lines_ = lines;
        rows_ = rows;
        mtx_ = new int[lines][rows];
    }

    public int[][] getMtx() {
        return mtx_;
    }

    public int getLines() {
        return lines_;
    }

    public int getRows() {
        return rows_;
    }

    public Integer getMtx(int lineIndex, int rowIndex) {
        if (lineIndex < 0 || lineIndex >= getLines() || rowIndex < 0 || rowIndex >= getRows()) {
            throw new IllegalStateException("linIndex is " + lineIndex +
                    " while it should be >= 0 and < " + getLines() +
                    "rowIndex is " + rowIndex + " while it should be >= 0 and < " + getRows());
        }

        return mtx_[lineIndex][rowIndex];
    }

    public int setMtx(int lineIndex, int rowIndex, int val) {
        if (lineIndex < 0 || lineIndex >= getLines() || rowIndex < 0 || rowIndex >= getRows()) {
            return -1;
        }

        mtx_[lineIndex][rowIndex] = val;

        return 0;
    }

    public Matrix prod(Matrix r) {
        if ((getLines() != r.getRows()) || (getRows() != r.getLines())) {
            return null;
        }

        Matrix retM = new Matrix(getLines(), r.getRows());
        for (int i = 0; i < getLines(); i++) {
            for (int j = 0; j < r.getRows(); j++) {
                int sum = 0;
                for (int k = 0; k < getRows(); k++) {
                    sum += getMtx(i, k) * r.getMtx(k, j);
                }
                retM.setMtx(i, j, sum);
            }
        }

        return retM;
    }

    public Matrix plus(Matrix r) {
        if ((getLines() != r.getLines()) || (getRows() != r.getRows())) {
            return null;
        }

        Matrix retM = new Matrix(getLines(), r.getRows());
        for (int i = 0; i < getLines(); i++) {
            for (int j = 0; j < getRows(); j++) {
                retM.setMtx(i, j, getMtx(i, j) + r.getMtx(i, j));
            }
        }

        return retM;
    }

    public Matrix diff(Matrix r) {
        if ((getLines() != r.getLines()) || (getRows() != r.getRows())) {
            return null;
        }

        Matrix retM = new Matrix(getLines(), r.getRows());
        for (int i = 0; i < getLines(); i++) {
            for (int j = 0; j < getRows(); j++) {
                retM.setMtx(i, j, getMtx(i, j) - r.getMtx(i, j));
            }
        }

        return retM;
    }

    protected Matrix assembleMatrix(Matrix lt, Matrix lb, Matrix rt, Matrix rb) {
        int lines = lt.getLines() + lb.getLines();
        int rows = lt.getRows() + rt.getRows();

        Matrix retM = new Matrix(lines, rows);
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < rows; j++) {
                if (i < lt.getLines() && j < lt.getRows()) {
                    retM.setMtx(i, j, lt.getMtx(i, j));
                } else if (i < lt.getLines() && j >= lt.getRows()) {
                    retM.setMtx(i, j, rt.getMtx(i, j - lt.getRows()));
                } else if (i >= lt.getLines() && j < lt.getRows()) {
                    retM.setMtx(i, j, lb.getMtx(i - lt.getLines(), j));
                } else {
                    retM.setMtx(i, j, rb.getMtx(i - lt.getLines(), j - lt.getRows()));
                }
            }
        }

        return retM;
    }
}
