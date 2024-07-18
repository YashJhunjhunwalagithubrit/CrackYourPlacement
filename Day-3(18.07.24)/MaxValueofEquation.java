class MaxValueofEquation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int maxVal = Integer.MIN_VALUE;

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            // Remove points that are out of the range of k
            while (!pq.isEmpty() && x - pq.peek()[1] > k) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                // Calculate the potential maximum value with the top of the heap
                maxVal = Math.max(maxVal, y + x + pq.peek()[0]);
            }

            // Add the current point to the heap
            pq.offer(new int[]{y - x, x});
        }

        return maxVal;
    }
}
