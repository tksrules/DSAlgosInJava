
//given sorted array rotated at some unknown pivot find the minimum element.

package RandomAlgos;

public class SmallestInSortedArray {
	
	public static int findSmallest(int [] arr){
		int left = 0;
		int right = arr.length-1;
		
		while(left<right){
			int mid = (left+right)/2;
			if(arr[mid] > arr[right])
				left = mid+1;
			else
				right = mid;
		}
		return arr[left];
	}
	
	public static void main(String[] args) {
		int [] arr1 = new int[]{0,1,2,3,4};
		System.out.println(findSmallest(arr1));
		int [] arr2= new int[]{1,2,3,4,-1};
		System.out.println(findSmallest(arr2));
		int [] arr3 = new int[]{2,3,4,-3,1};
		System.out.println(findSmallest(arr3));
		int [] arr4 = new int[]{3,4,-1,1,2};
		System.out.println(findSmallest(arr4));
		int [] arr5 = new int[]{4,-90,1,2,3};
		System.out.println(findSmallest(arr5));
	}

}