class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        // Create an empty stack. The stack holds indexes of heights array.
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0; // Initialize max area
        int n = heights.length;
        int i = 0;

        while (i < n) {
            // If this bar is higher than the bar at stack top, push it to the stack.
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                // Pop the top
                int top = stack.pop();
                // Calculate the area with heights[top] as the smallest (or minimum height) bar 'h'.
                int area = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                // Update maxArea, if needed.
                maxArea = Math.max(maxArea, area);
            }
        }

        // Now, pop the remaining bars from stack and calculate area with every popped bar as the smallest bar.
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
