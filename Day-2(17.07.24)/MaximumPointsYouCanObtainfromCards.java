class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        int sumOfKEIs=0;
        for(int i=0;i<k;i++){
            sumOfKEIs+=cardPoints[i];
        }
        int len=cardPoints.length;
        int maxSum=sumOfKEIs;
        int i=0;
        while(i<k){
            sumOfKEIs=sumOfKEIs-cardPoints[k-i-1]+cardPoints[len-1-i];
            maxSum=Math.max(maxSum,sumOfKEIs);
            i++;
        }
        return maxSum;
    }
}