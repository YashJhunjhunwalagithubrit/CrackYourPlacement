class Circulartour
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	// Your code here
	  int totalPetrol=Arrays.stream(petrol).sum();
       int totalDist=Arrays.stream(distance).sum();
       
       if(totalPetrol<totalDist){
           return -1;
       }
       int curr=0,start=0;
       
       for(int i=0; i<petrol.length; i++){
           curr += (petrol[i]-distance[i]);
           if(curr<0){
               start=i+1;
               curr=0;
           }
       }
       return start;
    }
}