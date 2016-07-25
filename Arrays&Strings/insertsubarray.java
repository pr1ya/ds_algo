import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Priya on 6/6/2016.
 */
public class insertsubarray {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public class Solution {
        public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

            if (newInterval.start >= intervals.get(intervals.size() - 1).end) {
                if (newInterval.start == intervals.get(intervals.size() - 1).end) {
                    intervals.get(intervals.size() - 1).end = newInterval.end;
                } else {
                    intervals.add(newInterval);
                }
                return intervals;
            }
            if (newInterval.end < intervals.get(0).start) {
                intervals.add(0, newInterval);
                return intervals;
            }

            for (int i = 0; i < intervals.size(); i++) {
                if (newInterval.start >= intervals.get(i).start && newInterval.start <= intervals.get(i).end) {
                    int tempend = intervals.get(i).end;
                    intervals.get(i).end = newInterval.end;
                    for (int j = i+1; j < intervals.size() && (intervals.get(i).end >= intervals.get(j).end); j++) {
                         intervals.remove(j--);
                    }
                    if (i+1 <= intervals.size()-1) {
                        if(intervals.get(i).end < intervals.get(i+1).start) {
                          return intervals;
                        } else if (intervals.get(i+1).start >= intervals.get(i).start &&
                                intervals.get(i+1).start <= intervals.get(i).end) {
                            intervals.get(i).end = intervals.get(i+1).end;
                            intervals.remove(i+1);
                            return intervals;
                        }
                    }
                }

            }
            return intervals;
        }
    }
}
