package tests.junit;

import matrix.model.StrassenMatrix;
import org.junit.Test;

/**
 * User: Ding
 * Date: 5/12/13
 * Time: 5:02 PM
 */
public class StrassenMatrixTestPerformance extends TestPerformance {
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

            StrassenMatrix left = new StrassenMatrix(n, n, a);
            //StrassenMatrix right = new StrassenMatrix(n, n, a);
            StrassenMatrix right = left;

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
