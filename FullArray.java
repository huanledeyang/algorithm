package test;

public class FullArray {

	int count = 0;
	
	void initData(int[] data, int n) {
		if(data == null) {
			data = new int[n];
		}
		for(int i=0; i < n ;  i++) {
			data[i] = i+1;
		}
	}
	
	void swap(int[] data, int x, int y) {
		int temp = data[x];
		data[x] = data[y];
		data[y] = temp;
	}
	void printData(int[]  data) {
		count++;
		StringBuilder sb = new StringBuilder();
		sb.append(count).append(" : ");
		for(int i=0; i < data.length; i++) {
			sb.append(data[i]).append(" , ");
		}
		sb.append('\n');
		System.out.println(sb.toString());
	}
	void array(int[] data, int start, int len) {
		if(start == 0) {
			printData(data);
		}
		for(int i = start; i<len; i++) {
			if(i == start) {
				array(data,start+1, len);
			}else {
				swap(data,start,i);
				printData(data);
				array(data,start+1, len);
				swap(data,start,i);
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int N = 3;
		int[] data = new int[N];
		
		FullArray fullArray = new FullArray();
		fullArray.initData(data, N);
		
		fullArray.array(data, 0, N);

	}

}
