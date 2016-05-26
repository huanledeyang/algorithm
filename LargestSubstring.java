

public class LargestSubstring {
	static int start = 0;
	static int end = 0;
	public static int largestSub(int data[]) {
		int max = 0;
		int temp = 0;

		for(int i=0; i<data.length; i++) {
			
			temp += data[i];
			
			if(temp < 0) {
				temp = 0;
				start = i+1;
			}
			if(max < temp) {
				max = temp;
				end = i;
			}

		}
		
		return max;
	} 
	
	public static void main(String args[]){
		int data[] = {1, -2, 3, 10, -4, 7, 2, -5,-1, 7,-1,2};
		System.out.print("max: "+largestSub(data) + " start: "+start+" end "+end );
	}
}
