class Solution {

    class SegmentTree {

        int[] sum;
        int[] squareSum;
        int[] lazy;

        int n;

        SegmentTree(int n) {
            this.n = n;

            sum = new int[4 * n];
            squareSum = new int[4 * n];
            lazy = new int[4 * n];
        }

        void update(int node, int start, int end,
                    int left, int right, int value) {

            // Completely outside the range
            if (right < start || end < left) {
                return;
            }

            // Completely inside the range
            if (left <= start && end <= right) {

                int len = end - start + 1;

                // IMPORTANT:
                // Use old sum before changing it
                squareSum[node] +=
                        2 * value * sum[node]
                        + value * value * len;

                sum[node] += value * len;

                lazy[node] += value;

                return;
            }

            push(node, start, end);

            int mid = start + (end - start) / 2;

            update(node * 2, start, mid,
                    left, right, value);

            update(node * 2 + 1, mid + 1, end,
                    left, right, value);

            sum[node] =
                    sum[node * 2]
                    + sum[node * 2 + 1];

            squareSum[node] =
                    squareSum[node * 2]
                    + squareSum[node * 2 + 1];
        }

        void push(int node, int start, int end) {

            if (lazy[node] == 0 || start == end) {
                return;
            }

            int mid = start + (end - start) / 2;

            apply(node * 2,
                    mid - start + 1,
                    lazy[node]);

            apply(node * 2 + 1,
                    end - mid,
                    lazy[node]);

            lazy[node] = 0;
        }

        void apply(int node, int len, int value) {

            squareSum[node] +=
                    2 * value * sum[node]
                    + value * value * len;

            sum[node] += value * len;

            lazy[node] += value;
        }

        int getSquareSum() {
            return squareSum[1];
        }
    }

    public int sumCounts(List<Integer> list) {

        int n = list.size();
        int nums[] = new int[n];
        for(int i = 0; i< n; i++){
            nums[i] = list.get(i);
        }

        SegmentTree tree = new SegmentTree(n);

        int[] last = new int[101];

        // No element has appeared yet
        java.util.Arrays.fill(last, -1);

        int answer = 0;

        for (int r = 0; r < n; r++) {

            int x = nums[r];

            int left = last[x] + 1;

            // All subarrays starting from
            // left to r gain one distinct element
            tree.update(
                    1,
                    0,
                    n - 1,
                    left,
                    r,
                    1
            );

            // Current sum of squares of
            // distinct counts of all subarrays
            // ending at r
            answer += tree.getSquareSum();

            last[x] = r;
        }

        return answer;
    }
}

// class Solution {
//     public int sumCounts(List<Integer> nums) {
//         int res = 0;
//         int n = nums.size();
//         for(int i = 0; i< n; i++){
//             HashSet<Integer> set = new HashSet<>();
//             for(int j = i; j < n; j++){
//                 set.add(nums.get(j));
//                 res += set.size() * set.size();
//             }
//         }
//         return res;
//     }
// }