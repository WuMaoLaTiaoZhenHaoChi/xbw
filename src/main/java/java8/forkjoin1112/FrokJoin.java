package java8.forkjoin1112;

import java.util.concurrent.RecursiveTask;

/**
 * @Author: 小霸王
 * @Date: 2019/11/12 9:18
 */
public class FrokJoin extends RecursiveTask<Long> {

    private long start;
    private long end;
    private static final long TEMP = 10000L;

    public FrokJoin(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= TEMP){
            long sum = 0L;
            for (long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        }else {
            long middle = (start + end) / 2;
            FrokJoin left = new FrokJoin(start,middle);
            left.fork();
            FrokJoin right = new FrokJoin(middle + 1,end);
            right.fork();
            return left.join() + right.join();
        }
    }
}
