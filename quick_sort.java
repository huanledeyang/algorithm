void quick_sort(int[] data, int start, int end)
{
	if(start >= end)
		return;
	
	int i = start;
	int j = end;
	int key = data[start];

	while(1)
	{
		while(data[i] < key) i++;
		while(data[j] > key ) j--;

		if(i >= j) break;
		
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		
		i++;
		j--;
	}
	
	quick_sort(data,start,i-1);
	quick_sort(data,j+1,end);
}
