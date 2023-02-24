package code;

public class MainDriver {

	public static void main(String[] args) {
		
		//Making the important pieces
		Integer[] arr = new Integer[10];
		Integer[] rando = new Integer[10];
		AdvancedSorter s = new AdvancedSorter();
		
		//Populating with random values
		for(int i=0 ; i<arr.length ; i++) {
			rando[i] = (int) (Math.random()*10+1);
		}
		arr = rando.clone();	//Cloning the hoe
		
		//To calculate time taken to sort
		long before = 0;
		long after = 0;
		for(int i=0 ; i<=10000 ; i+=100) {
			arr = new Integer[i];
			for(int j=0 ; j<i ; j++) {
				arr[j] = (int) (Math.random()*i+1);
			}
			
			try {
				before = System.nanoTime();
				//s.QuickSort(arr);
				//s.HeapSort(arr);
				s.RadixSort(arr);
				after = System.nanoTime();
			} catch (EmptyArrayException e) {
				e.printStackTrace();
			}
					
			//results[i] = after-before;
			System.out.print(after-before+", ");
		}
	}

}
