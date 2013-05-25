package tests.junit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * User: Ding
 * Date: 5/12/13
 * Time: 11:41 AM
 */
public class TestPerformance {
    static protected final int exp = 12;

    private String filename_;
    private Map<Integer, Record> records_;

    public TestPerformance() {
        Class<?> enclosingClass = getClass().getEnclosingClass();
        if (enclosingClass != null) {
            filename_ = enclosingClass.getName();
        } else {
            filename_ = getClass().getName();
        }
        filename_ += ".rd";

        records_ = new TreeMap<Integer, Record>();

        BufferedWriter out;
        try {
            out = new BufferedWriter(new FileWriter(filename_, true));
            out.newLine();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeRecords() throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();

        BufferedWriter out = new BufferedWriter(new FileWriter(filename_, true));
        out.newLine();
        out.write(dateFormat.format(date) + " : ");
        out.write(records_.toString());
        out.close();
    }

    protected void AddRecord(Integer key, Record val) throws IOException {
        records_.put(key, val);
        writeRecords();
    }

    protected int calcRepeats(int size) {
        int ret = 1;

        if (size <= 2) {
            ret = 200000;
        } else if (size <= 4) {
            ret = 100000;
        } else if (size <= 8) {
            ret = 20000;
        } else if (size <= 16) {
            ret = 4000;
        } else if (size <= 32) {
            ret = 500;
        } else if (size <= 64) {
            ret = 100;
        } else if (size <= 128) {
            ret = 10;
        } else {
            ret = 1;
        }

        return ret;
    }
}
