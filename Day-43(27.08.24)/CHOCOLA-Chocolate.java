import java.util.*;
import java.lang.*;

class CHOCOLA-Chocolate
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases
        sc.nextLine();  // Move to the next line

        for (int test = 0; test < t; test++) {
            if (test > 0) sc.nextLine();  // Skip blank line between test cases
            
            int m = sc.nextInt();
            int n = sc.nextInt();

            int[] verticalCosts = new int[m - 1];
            int[] horizontalCosts = new int[n - 1];

            for (int i = 0; i < m - 1; i++) {
                verticalCosts[i] = sc.nextInt();
            }
            
            for (int i = 0; i < n - 1; i++) {
                horizontalCosts[i] = sc.nextInt();
            }

            // Sort the costs in descending order
            Arrays.sort(verticalCosts);
            Arrays.sort(horizontalCosts);
            
            // Reverse the sorted arrays to get descending order
            for (int i = 0; i < verticalCosts.length / 2; i++) {
                int temp = verticalCosts[i];
                verticalCosts[i] = verticalCosts[verticalCosts.length - 1 - i];
                verticalCosts[verticalCosts.length - 1 - i] = temp;
            }

            for (int i = 0; i < horizontalCosts.length / 2; i++) {
                int temp = horizontalCosts[i];
                horizontalCosts[i] = horizontalCosts[horizontalCosts.length - 1 - i];
                horizontalCosts[horizontalCosts.length - 1 - i] = temp;
            }

            int h = 1, v = 1;  // Initial number of pieces for horizontal and vertical cuts
            int totalCost = 0;
            int i = 0, j = 0;

            // Greedily choose the more expensive cut
            while (i < verticalCosts.length && j < horizontalCosts.length) {
                if (verticalCosts[i] > horizontalCosts[j]) {
                    totalCost += verticalCosts[i] * h;
                    v++;
                    i++;
                } else {
                    totalCost += horizontalCosts[j] * v;
                    h++;
                    j++;
                }
            }

            // Add the remaining vertical cuts
            while (i < verticalCosts.length) {
                totalCost += verticalCosts[i] * h;
                i++;
            }

            // Add the remaining horizontal cuts
            while (j < horizontalCosts.length) {
                totalCost += horizontalCosts[j] * v;
                j++;
            }

            System.out.println(totalCost);
        }

        sc.close();
		
	}
}