import java.util.*;

class Aggressivecows {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int cows = scanner.nextInt();
            int[] stalls = new int[n];
            
            for (int i = 0; i < n; i++) {
                stalls[i] = scanner.nextInt();
            }
            
            System.out.println(largestMinimumDistance(stalls, n, cows));
        }
        
        scanner.close();
    }
    
    // Function to check if it is possible to place cows with minimum distance 'dist'
    private static boolean isFeasible(int[] stalls, int n, int cows, int dist) {
        int count = 1;  // First cow is placed at the first stall
        int last_position = stalls[0];
        
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last_position >= dist) {
                count++;
                last_position = stalls[i];
                if (count == cows) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // Function to find the largest minimum distance
    private static int largestMinimumDistance(int[] stalls, int n, int cows) {
        Arrays.sort(stalls); // Sort the stall positions
        
        int left = 0;
        int right = stalls[n - 1] - stalls[0];
        int result = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (isFeasible(stalls, n, cows, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}
