package code;

public class AdvancedSorter implements Sorter {

	/**
	 * This bad boy is just an outward facing shell of QuickSort. It simplifies the method
	 * call for the algorithm, giving less work to the user, or whoever is calling the method.
	 * @param array to be sorted
	 * @throws EmptyArrayException if the array is empty
	 */
	@Override
	public void QuickSort(Integer[] arr) throws EmptyArrayException {
		
		//Covering empty array case, throwing EmptyArrayException
		int size = size(arr);
		if(size == 0) {
			throw new EmptyArrayException();
		}
		
		//Establishing initial bounds of QuickSort algorithm
		int start = 0;
		int end = arr.length-1;
		
		if(start < end) {
			//Actually sorting and partitioning array into sub-arrays, on which QuickSort will be called
			int split = randomizedPartition(arr, start, end);
			
			//Recursively calling QuickSort on both resultant sub-arrays
			QuickSort(arr, start, split-1);
			QuickSort(arr, split, end);
		}
	}
	
	/**
	 * QuickSort is a sorting algorithm not too different from how you might think Bugs Bunny would
	 * sort something. It tosses everything larger than a certain element into one sub-array, and
	 * everything smaller than it into another sub-array. The algorithm then repeats itself on those
	 * resultant sub-arrays until all items are sorted. This algoritm is O(nlgn)
	 * @param array to be sorted
	 * @param starting index of sub-array
	 * @param ending index of sub-array
	 * @throws EmptyArrayException if the array is empty
	 */
	private void QuickSort(Integer[] arr, int start, int end) throws EmptyArrayException {
		
		//Establishing initial bounds of QuickSort algorithm
		if(start < end) {
			//Actually sorting and partitioning array into sub-arrays, on which QuickSort will be called
			int split = randomizedPartition(arr, start, end);
			
			//Recursively calling QuickSort on both resultant sub-arrays
			QuickSort(arr, start, split-1);
			QuickSort(arr, split, end);
		}
	}
	
	/**
	 * partition is a private helper method that will facilitate the partitioning of the
	 * array in order to perform QuickSort on these sub-arrays. Additionally, partition
	 * performs the sorting functionality of QuickSort, lumping all values smaller than
	 * the pivot value into the left side of the sub-array, and all values larger than
	 * the pivot value into the right side. 
	 * @param array to be sorted
	 * @param starting index of sub-array
	 * @param ending index of sub-array
	 * @return index at which the parent array is split
	 */
	private int partition(Integer[] arr, int start, int end) {
		
		//Establishing pivot value against which all values will be compared
		int pivot = arr[end];
		//Also establishing first of 2 incrementing variables
		int i = start - 1;
		
		//We gonna walk that hoe till we appropriately place all elements
		for(int j=start ; j<end ; j++) {
			
			//Tossing left all elements less than pivot, and right all elements greater than pivot
			if(arr[j].compareTo(pivot) <= 0) {
				i++;	//walkin
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		//Placing pivot between elements smaller than it and larger than it
		int temp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = temp;
		
		//Returning index of the pivot value (where we split the sub-array)
		return i+1;
	}
	
	private int randomizedPartition(Integer[] arr, int start, int end) {
		
		//Getting a random pivot value, and placing shawty at the end of the sub-array
		int i = (int) (Math.random()*(end-start+1)+start);
		int temp = arr[end];
		arr[end] = arr[i];
		arr[i] = temp;
		
		//Then we partition the mf
		return partition(arr, start, end);
	}

	/**
	 * HeapSort is a sorting algorithm that works by converting the array to be sorted
	 * into a MaxHeap. It then places the maximum value at the end of the array,
	 * reconstructs the MaxHeap, then repeats until the array is sorted. This algorithm
	 * makes use of helper methods to initially convert, and then reconstruct MaxHeaps
	 * out of the remaining unsorted elements in the array. This algorithm is O(nlgn)
	 * @param array to be sorted
	 * @throws EmptyArrayException if the array is empty
	 */
	@Override
	public void HeapSort(Integer[] arr) throws EmptyArrayException {
		
		//Covering 1 element array case, terminating the method
		int size = size(arr);
		if(size == 1) {
			return;
		}
		
		//Covering empty array case, throwing EmptyArrayException
		else if(size == 0) {
			throw new EmptyArrayException();
		}
		
		//Tracking current heap size to prevent Heapifying sorted elements
		int heapSize = arr.length;
		
		//Initially building the MaxHeap
		BuildMaxHeap(arr);
		
		//Until we sort all the hoes...
		for(int i = arr.length-1 ; i>0 ; i--) {
			
			//we swap the root and last leaf...
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			//decrement the heap size...
			heapSize = heapSize - 1;
			
			//and rebuild the MaxHeap
			MaxHeapify(arr, 0, heapSize);
		}
	}
	
	/**
	 * BuildMaxHeap will convert a run-on-the-mill array into a MaxHeap. It will do so by 
	 * finding the last non-leaf element in the array and calling MaxHeapify on it to ensure
	 * that it and its children form a MaxHeap. The algorithm will then repeat this process
	 * on each element prior to it in the array until the entire array has been converted.
	 * @param array to be converted into a MaxHeap
	 */
	private void BuildMaxHeap(Integer[] arr) {
		
		//Starting at the last non-leaf element and ending at the root...
		for(int i=arr.length/2-1 ; i>=0 ; i--) {
			
			//we build a MaxHeap
			MaxHeapify(arr, i, arr.length);
		}
	}
	
	/**
	 * MaxHeapify is a helper method that will reconstruct the MaxHeap once the maximum value
	 * has been popped. It will do so by examining a node and its children, determining which
	 * is the largest, then exchanging a child node with its parent, if necessary. Once this
	 * operation is complete, the method will recursively call itself until the node at index
	 * i is larger than its children.
	 * @param array to be sorted
	 * @param index of the current node
	 */
	private void MaxHeapify(Integer[] arr, int i, int heapSize) {
		
		//Tracking importante información
		int largest = i;	//Storing parent index
		int left = 2*i+1;	//Storing left child index
		int right = 2*i+2;	//Storing right child index
		
		//Checking if left child is the largest of left child and parent
		if(left < heapSize) {
			if(arr[left].compareTo(arr[i]) > 0) {
				//Storing in largest if so
				largest = left;
			}
		}
		
		//Checking if right child is largest of the family
		if(right < heapSize) {
			if(arr[right].compareTo(arr[largest]) > 0) {
				//Storing in largest if so
				largest = right;
			}
		}
		
		//If parent is not the largest of the fam, we swap the parent with the largest child
		if(largest != i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			
			//Recursive call the find the proper place for the former parent
			MaxHeapify(arr, largest, heapSize);
		}
	}

	/**
	 * RadixSort is a funky sorting algorithm that blows my mind every time I watch the sorting
	 * algorithm video. It works by calling a counting sort algorithm for every digit in the largest
	 * element in the data set. Effectively, it sorts elements by the value of their ones place digit,
	 * then the next highest digit until there are no more digits to sort.
	 * @param array to be sorted
	 * @throws EmptyArrayException
	 */
	@Override
	public void RadixSort(Integer[] arr) throws EmptyArrayException {
		
		//Covering empty array case, throwing EmptyArrayException
		int size = size(arr);
		if(size == 0) {
			throw new EmptyArrayException();
		}
		
		//Finding the largest element in the array
		int largest = arr[0];
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i] > largest) {
				largest = arr[i];
			}
		}
		
		
		Integer[] b;	//B array will store the array elements as they get sorted, eventually copied into arr
		int max = 0;
		
		//Executing counting sort for every digit in the largest element in the data set
		for(int i=1 ; largest/i>0 ; i*=10) {
			
			//Finding the maximum value in the array at a particular digit
			for(int j=0 ; j<arr.length ; j++) {
				if((arr[j]/i)%10 > max) {
					max = (arr[j]/i)%10;
				}
			}
			
			//Resetting B array for a clean work space
			b = new Integer[arr.length];
			
			//Calling counting sort on a particular digit
			CountingSort(arr, b, max, i);
		}
	}
	
	/**
	 * CountingSort is a sorting algorithm that can only work on one digit of a numerical value
	 * at once. However, it can be repeated for each digit of the numbers in a data set to
	 * adequately sort them. It works by counting how many elements of a particular value exist
	 * in the array, sorting that data into another array, C. It then uses the number of elements
	 * at particular value to determine its index in the final, sorted list.
	 * @param array to be sorted
	 * @param B array into which sorted elements are initially inserted
	 * @param largest value present in the current digit
	 * @param digit in question
	 */
	private void CountingSort(Integer[] arr, Integer[] b, int k, int digit) {
		
		//Allocating only as much space as we need in the counting array
		Integer[] c = new Integer[k+1];
		
		//Setting all indices to 0, initially
		for(int i=0 ; i<=k ; i++) {
			c[i] = 0;
		}
		
		//Counting how many elements exist for a particular value
		for(int j=0 ; j<arr.length ; j++) {
			c[(arr[j]/digit)%10] = c[(arr[j]/digit)%10] + 1;
		}
		
		//Summing current index with previous index, helps us when inserting into B array
		for(int i=1 ; i<=k ; i++) {
			c[i] = c[i] + c[i-1];
		}
		
		for( int j=arr.length-1 ; j>=0 ; j--) {
			//Inserting into B array in sorted order
			b[c[(arr[j]/digit)%10]-1] = arr[j];
			//Decrementing the count of elements for that value
			c[(arr[j]/digit)%10] = c[(arr[j]/digit)%10] - 1;
		}
		
		//Copying into the original array
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = b[i];
		}
	}
	
	/**
	 * size is a private helper method that simply returns the number of elements stored
	 * in the array to be sorted.
	 * @param array to be sorted
	 * @return integer number of elements in the array
	 */
	private int size(Integer[] arr) {
		
		//I don't want to comment this
		int counter = 0;
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i] != null) {
				counter++;
			}
		}
		
		return counter;
	}

}
