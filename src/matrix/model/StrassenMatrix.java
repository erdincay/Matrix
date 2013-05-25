package matrix.model;

/**
 * User: Ding
 * Date: 4/29/13
 * Time: 5:22 PM
 * Strassen's methods
 */
public class StrassenMatrix extends DivCMatrix {

    public StrassenMatrix(int lines, int rows, int[][] mtx) {
        super(lines, rows, mtx);
    }

    public StrassenMatrix(Matrix mtx) {
        super(mtx);
    }

    private StrassenMatrix trimMtx(int expectedLines, int expectedRows, Matrix mtx) {
        return new StrassenMatrix(expectedLines, expectedRows, mtx.getMtx());
    }

    public StrassenMatrix prod(StrassenMatrix r) {
        if ((getLines() != r.getRows()) || (getRows() != r.getLines())) {
            return null;
        }

        DivideMatrix();
        r.DivideMatrix();

        if (getLt() == null || getLb() == null || getRt() == null || getRb() == null) {
            return new StrassenMatrix(super.prod(r));
        }

        StrassenMatrix P = (new StrassenMatrix(getLt().plus(getRb())))
                            .prod(new StrassenMatrix(r.getLt().plus(r.getRb())));
        StrassenMatrix Q = (new StrassenMatrix(getLb().plus(getRb())))
                            .prod(new StrassenMatrix(r.getLt()));
        StrassenMatrix R = (new StrassenMatrix(getLt()))
                            .prod(new StrassenMatrix(r.getRt().diff(r.getRb())));
        StrassenMatrix S = (new StrassenMatrix(getRb()))
                            .prod(new StrassenMatrix(r.getLb().diff(r.getLt())));
        StrassenMatrix T = (new StrassenMatrix(getLt().plus(getRt())))
                            .prod(new StrassenMatrix(r.getRb()));
        StrassenMatrix U = (new StrassenMatrix(getLb().diff(getLt())))
                            .prod(new StrassenMatrix(r.getLt().plus(r.getRt())));
        StrassenMatrix V = (new StrassenMatrix(getRt().diff(getRb())))
                            .prod(new StrassenMatrix(r.getLb().plus(r.getRb())));

        Matrix retMlt = P.plus(S).diff(T).plus(V);
        Matrix retMrt = R.plus(T);
        Matrix retMlb = Q.plus(S);
        Matrix retMrb = P.plus(R).diff(Q).plus(U);

        return trimMtx(getLines(), r.getRows(),assembleMatrix(retMlt,retMlb,retMrt,retMrb));
    }
}
