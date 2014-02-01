package tests.junit;

import matrix.model.DivCMatrix;
import org.junit.Test;

/**
 * User: Ding
 * Date: 5/12/13
 * Time: 1:01 AM
 */
public class DivCMatrixTestPerformance extends TestPerformance {
    @Test
    public void testProd() throws Exception {
        for (int i = 1; i <= exp; i++) {
            int n = (int) Math.pow(2, i);

            int[][] a = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    a[j][k] = j + k;
                }
            }

            DivCMatrix left = new DivCMatrix(n, n, a);
            //DivCMatrix right = new DivCMatrix(n, n, a);
            DivCMatrix right = left;

            int repeat = calcRepeats(n);
            RecordTime rt = new RecordTime();
            rt.start();
            for (int j = 0; j < repeat; j++) {
                left.prod(right);
            }
            rt.end();

            AddRecord(n, new Record(rt.calc(), repeat));
        }
    }
}
