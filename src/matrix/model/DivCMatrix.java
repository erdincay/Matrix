package matrix.model;

/**
  * User: Ding
 * Date: 4/29/13
 * Time: 5:22 PM
 * Divided and Conquer methods
 */
public class DivCMatrix extends Matrix {
    static private int line_holder = 0;
    static private int row_holder = 0;
    private DivCMatrix lt_;
    private DivCMatrix lb_;
    private DivCMatrix rt_;
    private DivCMatrix rb_;

    public DivCMatrix(int lines, int rows, int[][] mtx) {
        super(lines, rows, mtx);

        lt_ = null;
        lb_ = null;
        rt_ = null;
        rb_ = null;
    }

    public DivCMatrix(int lines, int rows) {
        super(lines, rows);

        lt_ = null;
        lb_ = null;
        rt_ = null;
        rb_ = null;
    }

    public DivCMatrix(Matrix mtx) {
        super(mtx.getLines(), mtx.getRows(), mtx.getMtx());

        lt_ = null;
        lb_ = null;
        rt_ = null;
        rb_ = null;
    }

    protected DivCMatrix getLt() {
        return lt_;
    }

    protected DivCMatrix getLb() {
        return lb_;
    }

    protected DivCMatrix getRt() {
        return rt_;
    }

    protected DivCMatrix getRb() {
        return rb_;
    }

    protected void DivideMatrix() {
        if (lt_ != null && lb_ != null && rt_ != null && rb_ != null) {
            return;
        }

        if (getLines() <= 2 || getRows() <= 2) {
            return;
        }

        int divLines = getLines() / 2;
        if (getLines() % 2 != 0) {
            divLines++;
        }

        int divRows = getRows() / 2;
        if (getRows() % 2 != 0) {
            divRows++;
        }

        lt_ = new DivCMatrix(divLines, divRows);
        lb_ = new DivCMatrix(divLines, divRows);
        rt_ = new DivCMatrix(divLines, divRows);
        rb_ = new DivCMatrix(divLines, divRows);

        for (int i = 0; i < divLines; i++) {
            for (int j = 0; j < divRows; j++) {
                lt_.setMtx(i, j, getMtx(i, j));

                if ((divLines * 2 > getLines()) && (i == divLines - 1)) {
                    lb_.setMtx(i, j, line_holder);
                } else {
                    lb_.setMtx(i, j, getMtx(divLines + i, j));
                }

                if ((divRows * 2 > getRows()) && (j == divRows - 1)) {
                    rt_.setMtx(i, j, row_holder);
                } else {
                    rt_.setMtx(i, j, getMtx(i, divRows + j));
                }

                if ((divLines * 2 > getLines()) && (i == divLines - 1)) {
                    rb_.setMtx(i, j, line_holder);
                } else if ((divRows * 2 > getRows()) && (j == divRows - 1)) {
                    rb_.setMtx(i, j, row_holder);
                } else {
                    rb_.setMtx(i, j, getMtx(divLines + i, divRows + j));
                }
            }
        }
    }

    private DivCMatrix trimMtx(int expectedLines, int expectedRows, Matrix mtx) {
        return new DivCMatrix(expectedLines, expectedRows, mtx.getMtx());
    }

    public DivCMatrix prod(DivCMatrix r) {
        if ((getLines() != r.getRows()) || (getRows() != r.getLines())) {
            return null;
        }

        DivideMatrix();
        r.DivideMatrix();

        if (lt_ == null || lb_ == null || rt_ == null || rb_ == null) {
            return trimMtx(getLines(), getRows(), super.prod(r));
        }

        Matrix retMlt = (lt_.prod(r.getLt())).plus(rt_.prod(r.getLb()));
        Matrix retMrt = (lt_.prod(r.getRt())).plus(rt_.prod(r.getRb()));
        Matrix retMlb = (lb_.prod(r.getLt())).plus(rb_.prod(r.getLb()));
        Matrix retMrb = (lb_.prod(r.getRt())).plus(rb_.prod(r.getRb()));

        return trimMtx(getLines(), r.getRows(), assembleMatrix(retMlt, retMlb, retMrt, retMrb));
    }
}
