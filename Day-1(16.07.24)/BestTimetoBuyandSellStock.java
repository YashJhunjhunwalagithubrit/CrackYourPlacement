class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int minSoFar=prices[0];
        int maxProf=0;
        for(int i=0;i<prices.length;i++){
            minSoFar=Math.min(minSoFar,prices[i]);
            int prof=prices[i]-minSoFar;
            maxProf=Math.max(prof,maxProf);
        }
        return maxProf;
    }
}