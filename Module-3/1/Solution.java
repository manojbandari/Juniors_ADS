import java.util.*;
class Solution{
	public int[] sortInsertion(int[] arr){
		for(int i=1;i<arr.length;i++) {
			int j=i-1;
			int temp=arr[i];
			while(j>=0 && temp<arr[j]){
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
		
		return arr;
	}

	public int[] sortSelection(int[] arr){
		for(int i=0;i<arr.length-1;i++) {
			int mid = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j] < arr[mid]) {
					mid=j;
				}
			}
			int temp = arr[i];
			arr[i]=arr[mid];
			arr[mid]=temp;
		}	
		System.out.println(Arrays.toString(arr));


		return arr;
	}
}