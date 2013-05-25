package tests.junit;

import matrix.model.Matrix;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
  * User: Ding
 * Date: 5/11/13
 * Time: 11:26 AM
 */
public class MatrixTestCorrectness {
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
    public void testPlus() throws Exception {
        for (MatrixData md : mds_) {
            for (int i = 0; i < md.matrix_nums; i++) {
                Matrix left = new Matrix(md.line_size, md.row_size, md.left.get(i));
                Matrix right = new Matrix(md.line_size, md.row_size, md.right.get(i));
                Matrix ret = left.plus(right);

                assertEquals(ret.getLines(), md.line_size);
                assertEquals(ret.getRows(), md.row_size);
                for (int j = 0; j < ret.getLines(); j++) {
                    for (int k = 0; k < ret.getRows(); k++) {
                        assertEquals((int) ret.getMtx(j, k), md.plus.get(i)[j][k]);
                    }
                }
            }
        }
    }

    @Test
    public void testDiff() throws Exception {
        for (MatrixData md : mds_) {
            for (int i = 0; i < md.matrix_nums; i++) {
                Matrix left = new Matrix(md.line_size, md.row_size, md.left.get(i));
                Matrix right = new Matrix(md.line_size, md.row_size, md.right.get(i));
                Matrix ret = left.diff(right);

                assertEquals(ret.getLines(), md.line_size);
                assertEquals(ret.getRows(), md.row_size);
                for (int j = 0; j < ret.getLines(); j++) {
                    for (int k = 0; k < ret.getRows(); k++) {
                        assertEquals((int) ret.getMtx(j, k), md.diff.get(i)[j][k]);
                    }
                }
            }
        }
    }

    @Test
    public void testProd() throws Exception {
        for (MatrixData md : mds_) {
            for (int i = 0; i < md.matrix_nums; i++) {
                Matrix left = new Matrix(md.line_size, md.row_size, md.left.get(i));
                Matrix right = new Matrix(md.line_size, md.row_size, md.right.get(i));
                Matrix ret = left.prod(right);

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
