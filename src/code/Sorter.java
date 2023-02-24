package code;

public interface Sorter {

	public void QuickSort(Integer[] arr) throws EmptyArrayException;
	
	public void HeapSort(Integer[] arr) throws EmptyArrayException;
	
	public void RadixSort(Integer[] arr) throws EmptyArrayException;
}
