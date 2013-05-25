package tests.junit;

import matrix.model.DivCMatrix;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
  * User: Ding
 * Date: 5/11/13
 * Time: 8:57 PM
 */
public class DivCMatrixTestCorrectness {
    private List<MatrixData> mds_;

    @Before
    public void setUp() throws Exception {
        mds_ = new ArrayList<MatrixData>();
        mds_.add(new MatrixData(3, 3));
        mds_.add(new MatrixData(4, 4));
        mds_.add(new MatrixData(5, 5));
        mds_.add(new MatrixData(7, 7));
        mds_.add(new MatrixData(11, 11));
        mds_.add(new MatrixData(23, 23));
    }

    @Test
    public void testProd() throws Exception {
        for (MatrixData md : mds_) {
            for (int i = 0; i < md.matrix_nums; i++) {
                DivCMatrix left = new DivCMatrix(md.line_size, md.row_size, md.left.get(i));
                DivCMatrix right = new DivCMatrix(md.line_size, md.row_size, md.right.get(i));
                DivCMatrix ret = left.prod(right);

                assertEquals(ret.getLines(), md.line_size);
                assertEquals(ret.getRows(), md.row_size);
                for (int j = 0; j < ret.getLines(); j++) {
                    for (int k = 0; k < ret.getRows(); k++) {
                        assertEquals((int) ret.getMtx(j, k), md.prod.get(i)[j][k]);
                    }
                }
            }
        }
    }
}
