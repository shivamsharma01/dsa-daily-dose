package binary_search;

import java.util.Arrays;
import java.util.Comparator;

public class MaxScheduleProfit {
    public static void main(String[] args) {
        int startTime[], endTime[], profit[];

        startTime = new int[]{0, 1, 1, 4, 7};
        endTime = new int[]{4, 3, 5, 8, 11};
        profit = new int[]{100, 300, 500, 200, 300};
        System.out.println("Max Profit: " + calculateMaxProfit(startTime, endTime, profit));

        startTime = new int[]{1, 2, 3, 3};
        endTime = new int[]{3, 4, 5, 6};
        profit = new int[]{500, 100, 400, 700};
        System.out.println("Max Profit: " + calculateMaxProfit(startTime, endTime, profit));
    }

    static class Schedule {
        int start;
        int end;
        int profit;

        public Schedule(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.profit = p;
        }
    }

    private static int calculateMaxProfit(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        Schedule schedules[] = new Schedule[n];
        for (int i = 0; i < n; i++) schedules[i] = new Schedule(startTime[i], endTime[i], profit[i]);

        Arrays.sort(schedules, Comparator.comparingInt(o -> o.end));

        int dpProfit[] = new int[n];
        dpProfit[0] = schedules[0].profit;

        for (int i = 1; i < n; i++) {
            int low = 0, high = i - 1, mid;
            while (low < high) {
                mid = low + (high - low + 1) / 2; // we added one because in case i is even with general formula, right most element will be missed
                if (schedules[mid].end <= schedules[i].start) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            dpProfit[i] = schedules[i].profit;
            if (schedules[low].end <= schedules[i].start) {
                dpProfit[i] += dpProfit[low];
            }
            dpProfit[i] = Math.max(dpProfit[i], dpProfit[i - 1]);
        }
        return dpProfit[n - 1];
    }
}
