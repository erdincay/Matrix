package tests.junit;

import java.util.ArrayList;
import java.util.List;

/**
  * User: Ding
 * Date: 5/11/13
 * Time: 10:42 AM
 * generate testing data for correctness
 */
public class MatrixData {
    public int line_size;
    public int row_size;
    public int matrix_nums;

    public List<int[][]> left;
    public List<int[][]> right;
    public List<int[][]> prod;
    public List<int[][]> plus;
    public List<int[][]> diff;

    public MatrixData(int line, int row) {
        line_size = line;
        row_size = row;
        matrix_nums = 0;

        left = new ArrayList<int[][]>();
        right = new ArrayList<int[][]>();
        prod = new ArrayList<int[][]>();
        plus = new ArrayList<int[][]>();
        diff = new ArrayList<int[][]>();

        switch (line_size) {
            case 3:
                switch (row_size) {
                    case 3:
                        initMatrix33();
                        break;

                    default:
                        initMatrix(line_size);
                }
                break;

            case 4:
                switch (row_size) {
                    case 4:
                        initMatrix44();
                        break;

                    default:
                        initMatrix(line_size);
                }
                break;

            default:
                initMatrix(line_size);
        }
    }

    private void initMatrix33() {
        int[][] left0 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        int[][] right0 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        int[][] prod0 = {{6, 12, 18}, {6, 12, 18}, {6, 12, 18}};
        int[][] plus0 = {{2, 4, 6}, {2, 4, 6}, {2, 4, 6}};
        int[][] diff0 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        left.add(left0);
        right.add(right0);
        prod.add(prod0);
        plus.add(plus0);
        diff.add(diff0);
        matrix_nums++;

        int[][] left1 = {{8, 12, 23}, {11, 13, 11}, {25, 22, 17}};
        int[][] right1 = {{11, 21, 31}, {17, 41, 21}, {6, 31, 22}};
        int[][] prod1 = {{430, 1373, 1006}, {408, 1105, 856}, {751, 1954, 1611}};
        int[][] plus1 = {{19, 33, 54}, {28, 54, 32}, {31, 53, 39}};
        int[][] diff1 = {{-3, -9, -8}, {-6, -28, -10}, {19, -9, -5}};
        left.add(left1);
        right.add(right1);
        prod.add(prod1);
        plus.add(plus1);
        diff.add(diff1);
        matrix_nums++;

        int[][] left2 = {{1, 0, 1}, {2, 3, 0}, {5, 7, 8}};
        int[][] right2 = {{3, 2, 1}, {9, 0, 8}, {0, 2, 3}};
        int[][] prod2 = {{3, 4, 4}, {33, 4, 26}, {78, 26, 85}};
        int[][] plus2 = {{4, 2, 2}, {11, 3, 8}, {5, 9, 11}};
        int[][] diff2 = {{-2, -2, 0}, {-7, 3, -8}, {5, 5, 5}};
        left.add(left2);
        right.add(right2);
        prod.add(prod2);
        plus.add(plus2);
        diff.add(diff2);
        matrix_nums++;

        int[][] left3 = {{1, 0, 1}, {0, 2, 2}, {3, 3, 0}};
        int[][] right3 = {{1, 1, 0}, {3, 0, 3}, {0, 2, 2}};
        int[][] prod3 = {{1, 3, 2}, {6, 4, 10}, {12, 3, 9}};
        int[][] plus3 = {{2, 1, 1}, {3, 2, 5}, {3, 5, 2}};
        int[][] diff3 = {{0, -1, 1}, {-3, 2, -1}, {3, 1, -2}};
        left.add(left3);
        right.add(right3);
        prod.add(prod3);
        plus.add(plus3);
        diff.add(diff3);
        matrix_nums++;
    }

    private void initMatrix44() {
        int[][] left1 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        int[][] right1 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        int[][] prod1 = {{4, 4, 4, 4}, {4, 4, 4, 4}, {4, 4, 4, 4}, {4, 4, 4, 4}};
        int[][] plus1 = {{2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}};
        int[][] diff1 = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        left.add(left1);
        right.add(right1);
        prod.add(prod1);
        plus.add(plus1);
        diff.add(diff1);
        matrix_nums++;

        int[][] left2 = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int[][] right2 = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int[][] prod2 = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int[][] plus2 = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int[][] diff2 = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        left.add(left2);
        right.add(right2);
        prod.add(prod2);
        plus.add(plus2);
        diff.add(diff2);
        matrix_nums++;

        int[][] left3 = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        int[][] right3 = {{4, 3, 2, 1}, {4, 3, 2, 1}, {4, 3, 2, 1}, {4, 3, 2, 1}};
        int[][] prod3 = {{40, 30, 20, 10}, {40, 30, 20, 10}, {40, 30, 20, 10}, {40, 30, 20, 10},};
        int[][] plus3 = {{5, 5, 5, 5}, {5, 5, 5, 5}, {5, 5, 5, 5}, {5, 5, 5, 5}};
        int[][] diff3 = {{-3, -1, 1, 3}, {-3, -1, 1, 3}, {-3, -1, 1, 3}, {-3, -1, 1, 3}};
        left.add(left3);
        right.add(right3);
        prod.add(prod3);
        plus.add(plus3);
        diff.add(diff3);
        matrix_nums++;
    }

    private void initMatrix(int size) {
        initLeq0(size);
        initReq0(size);
        initLeq1(size);
        initReq1(size);
        initLeqR_SameLine(size);
        initLeqR_SameRow(size);
    }

    private void initLeq1(int size) {
        int[][] left = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                left[i][j] = 1;
            }
        }

        int[][] right = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                right[i][j] = i * j;
            }
        }

        int[][] plus = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                plus[i][j] = 1 + i * j;
            }
        }

        int[][] diff = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                diff[i][j] = 1 - i * j;
            }
        }

        int[][] prod = new int[size][size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += i;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                prod[i][j] = sum * j;
            }
        }

        this.left.add(left);
        this.right.add(right);
        this.plus.add(plus);
        this.diff.add(diff);
        this.prod.add(prod);
        matrix_nums++;
    }

    private void initReq1(int size) {
        int[][] left = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                left[i][j] = i * j;
            }
        }

        int[][] right = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                right[i][j] = 1;
            }
        }

        int[][] plus = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                plus[i][j] = i * j + 1;
            }
        }

        int[][] diff = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                diff[i][j] = i * j - 1;
            }
        }

        int[][] prod = new int[size][size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += i;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                prod[i][j] = sum * i;
            }
        }

        this.left.add(left);
        this.right.add(right);
        this.plus.add(plus);
        this.diff.add(diff);
        this.prod.add(prod);
        matrix_nums++;
    }

    private void initLeq0(int size) {
        int[][] left = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                left[i][j] = 0;
            }
        }

        int[][] right = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                right[i][j] = i + j;
            }
        }

        int[][] plus = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                plus[i][j] = i + j;
            }
        }

        int[][] diff = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                diff[i][j] = 0 - (i + j);
            }
        }

        int[][] prod = new int[size][size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += i;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                prod[i][j] = 0;
            }
        }

        this.left.add(left);
        this.right.add(right);
        this.plus.add(plus);
        this.diff.add(diff);
        this.prod.add(prod);
        matrix_nums++;
    }

    private void initReq0(int size) {
        int[][] left = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                left[i][j] = i + j;
            }
        }

        int[][] right = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                right[i][j] = 0;
            }
        }

        int[][] plus = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                plus[i][j] = i + j;
            }
        }

        int[][] diff = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                diff[i][j] = i + j;
            }
        }

        int[][] prod = new int[size][size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += i;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                prod[i][j] = 0;
            }
        }

        this.left.add(left);
        this.right.add(right);
        this.plus.add(plus);
        this.diff.add(diff);
        this.prod.add(prod);
        matrix_nums++;
    }

    private void initLeqR_SameLine(int size) {
        int[][] left = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                left[i][j] = j;
            }
        }

        int[][] right = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                right[i][j] = j;
            }
        }

        int[][] plus = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                plus[i][j] = j + j;
            }
        }

        int[][] diff = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                diff[i][j] = 0;
            }
        }

        int[][] prod = new int[size][size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += i;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                prod[i][j] = sum * j;
            }
        }

        this.left.add(left);
        this.right.add(right);
        this.plus.add(plus);
        this.diff.add(diff);
        this.prod.add(prod);
        matrix_nums++;
    }

    private void initLeqR_SameRow(int size) {
        int[][] left = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                left[i][j] = i;
            }
        }

        int[][] right = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                right[i][j] = i;
            }
        }

        int[][] plus = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                plus[i][j] = i + i;
            }
        }

        int[][] diff = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                diff[i][j] = 0;
            }
        }

        int[][] prod = new int[size][size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += i;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                prod[i][j] = sum * i;
            }
        }

        this.left.add(left);
        this.right.add(right);
        this.plus.add(plus);
        this.diff.add(diff);
        this.prod.add(prod);
        matrix_nums++;
    }
}
