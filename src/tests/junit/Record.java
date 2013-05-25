package tests.junit;

/**
 * User: Ding
 * Date: 5/12/13
 * Time: 11:01 AM
 * record the every excuted time as [excuted millsecs / excuted times]
 */
public class Record {
    public long exceTime_;
    public int repeats_;

    public Record(long exceTime, int repeats) {
        this.exceTime_ = exceTime;
        this.repeats_ = repeats;
    }

    @Override
    public String toString() {
        return exceTime_ + "/" + repeats_;
    }
}
