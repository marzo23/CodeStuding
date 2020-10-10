import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0

class GetSubArraySum {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTests = Integer.parseInt(br.readLine());
		for(int i = 0; i<numTests; i++){
		    String[] param=br.readLine().split("\\s");
		    String[] arrStr=br.readLine().split("\\s");
		    int[] arr = new int[Integer.parseInt(param[0])];
		    for(int k = 0; k<arr.length; k++){
		        arr[k] = Integer.parseInt(arrStr[k]);
		    }
            getSubArraySum(arr, Integer.parseInt(param[1]));
		}
	}
	
	public static int getSubArraySum(int[] arr, int tgtSum){
	    int begin = 0;
	    int sum = 0;
	    for(int i = 0; i<arr.length; i++){
            sum += arr[i];
	        while(sum>tgtSum){
	            sum-=arr[begin++];
	        }
	        
	        if(sum == tgtSum){
	            begin++; i++;
	            System.out.println(begin+" "+i);
	            return 1;
	        }
	    }
	    System.out.println("-1"); 
	    return -1;
	}
}