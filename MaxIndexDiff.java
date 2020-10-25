//https://practice.geeksforgeeks.org/problems/maximum-index3307/1

class MaxIndexDiff {

    int maxIndexDiff(int arr[], int n) {
        int max = -1;
        int i;
        for(int j = arr.length-1; j>=0; j--){
            i = 0;
            while(j>i && max < j-i && arr[j]<arr[i]){
                i++;
            }
            
            if(max < j-i && arr[j]>=arr[i]){
                max = j-i;
            }
        }
        return max;
    }
}