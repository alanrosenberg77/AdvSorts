package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.AdvancedSorter;
import code.EmptyArrayException;

public class AdvancedSortTest {

	AdvancedSorter s;
	Integer[] emptyArray;
	Integer[] smallArray;
	Integer[] largeArray;
	Integer[] sortedSmall;
	Integer[] sortedLarge;
	
	@Before
	public void setUp() throws Exception {
		s = new AdvancedSorter();
		emptyArray = new Integer[100];
		smallArray = new Integer[10];
		largeArray = new Integer[100];
		sortedSmall = new Integer[10];
		sortedLarge = new Integer[100];
		
		//Building sortedSmall
		for(int i=0 ; i<sortedSmall.length ; i++) {
			sortedSmall[i] = i;
		}
				
		//Building sortedLarge
		for(int i=0 ; i<sortedLarge.length ; i++) {
			sortedLarge[i] = i;
		}
				
		//Building smallArray, [0,9,1,8,2,7,3,6,4,5]
		for(int i=0 ; i<smallArray.length ; i+=2) {
			smallArray[i] = i/2;
		}
		for(int i=1 ; i<smallArray.length ; i+=2) {
			smallArray[i] = 9-(i/2);
		}
				
		//Building largeArray, [0,99,1,98,2,97,3,96,4,95,5,94...]
		for(int i=0 ; i<largeArray.length ; i+=2) {
			largeArray[i] = i/2;
		}
		for(int i=1 ; i<largeArray.length ; i+=2) {
			largeArray[i] = 99-(i/2);
		}
	}

	@Test
	public void creationTest() {
		assertNotNull(s);
		assertNotNull(emptyArray);
		assertNotNull(smallArray);
		assertNotNull(largeArray);
		assertNotNull(sortedSmall);
		assertNotNull(sortedLarge);
		
		assertEquals(100, emptyArray.length);
		assertEquals(10, smallArray.length);
		assertEquals(100, largeArray.length);
		assertEquals(10, sortedSmall.length);
		assertEquals(100, sortedLarge.length);
	}
	
	/*
	 * Quick Sort Tests
	 */
	
	@Test
	public void QuickSortOnEmptyArrayTest() {
		try {
			s.QuickSort(emptyArray);
		} catch (EmptyArrayException e) {
			return;
		}
		fail("Expected EmptyListException, got none");
	}
	
	@Test
	public void QuickSortOnSmallArrayTest() {
		try {
			s.QuickSort(smallArray);
		} catch (EmptyArrayException e) {
			fail("Not expecting EmptyListException, got one");
			e.printStackTrace();
		}
		
		assertNotNull(smallArray);
		
		for(int i=0 ; i<smallArray.length ; i++) {
			assertEquals(i, smallArray[i].intValue());
		}
	}
	
	@Test
	public void QuickSortOnLargeArrayTest() {
		try {
			s.QuickSort(largeArray);
		} catch (EmptyArrayException e) {
			fail("Not expecting EmptyListException, got one");
			e.printStackTrace();
		}
		
		assertNotNull(largeArray);
		
		for(int i=0 ; i<largeArray.length ; i++) {
			assertEquals(i, largeArray[i].intValue());
		}
	}
	
	@Test
	public void QuickSortOnSmallSortedArrayTest() {
		try {
			s.QuickSort(sortedSmall);
		} catch (EmptyArrayException e) {
			fail("Not expecting EmptyListException, got one");
			e.printStackTrace();
		}
		
		assertNotNull(sortedSmall);
		
		for(int i=0 ; i<sortedSmall.length ; i++) {
			assertEquals(i, sortedSmall[i].intValue());
		}
	}
	
	@Test
	public void QuickSortOnLargeSortedArrayTest() {
		try {
			s.QuickSort(sortedLarge);
		} catch (EmptyArrayException e) {
			fail("Not expecting EmptyListException, got one");
			e.printStackTrace();
		}
		
		assertNotNull(sortedLarge);
		
		for(int i=0 ; i<sortedLarge.length ; i++) {
			assertEquals(i, sortedLarge[i].intValue());
		}
	}
	
	/*
	 * Heap Sort Tests
	 */
	
	@Test
	public void HeapSortOnEmptyArrayTest() {
		try {
			s.HeapSort(emptyArray);
		} catch (EmptyArrayException e) {
			return;
		}
		fail("Expecting EmptyListException, got none");
	}
	
	@Test
	public void HeapSortOnSmallArrayTest() {
		try {
			s.HeapSort(smallArray);
		} catch (EmptyArrayException e) {
			fail("Not expecting EmptyListException, got one");
			e.printStackTrace();
		}
		
		assertNotNull(smallArray);
		
		for(int i=0 ; i<smallArray.length ; i++) {
			assertEquals(i, smallArray[i].intValue());
		}
	}
	
	@Test
	public void HeapSortOnLargeArrayTest() {
		try {
			s.HeapSort(largeArray);
		} catch (EmptyArrayException e) {
			fail("Not expecting EmptyListException, got one");
			e.printStackTrace();
		}
		
		assertNotNull(largeArray);
		
		for(int i=0 ; i<largeArray.length ; i++) {
			assertEquals(i, largeArray[i].intValue());
		}
	}
	
	@Test
	public void HeapSortOnSmallSortedArrayTest() {
		try {
			s.HeapSort(sortedSmall);
		} catch (EmptyArrayException e) {
			fail("Not expecting EmptyListException, got one");
			e.printStackTrace();
		}
		
		assertNotNull(sortedSmall);
		
		for(int i=0 ; i<sortedSmall.length ; i++) {
			assertEquals(i, sortedSmall[i].intValue());
		}
	}
	
	@Test
	public void HeapSortOnLargeSortedArrayTest() {
		try {
			s.HeapSort(sortedLarge);
		} catch (EmptyArrayException e) {
			fail("Not expecting EmptyListException, got one");
			e.printStackTrace();
		}
		
		assertNotNull(sortedLarge);
		
		for(int i=0 ; i<sortedLarge.length ; i++) {
			assertEquals(i, sortedLarge[i].intValue());
		}
	}
	
	/*
	 * Radix Sort Tests
	 */
	
	@Test
	public void RadixSortOnEmptyArrayTest() {
		try {
			s.RadixSort(emptyArray);
		} catch (EmptyArrayException e) {
			return;
		}
		fail("Expecting EmptyListException, got none");
	}
	
	@Test
	public void RadixSortOnSmallArrayTest() {
		try {
			s.RadixSort(smallArray);
		} catch (EmptyArrayException e) {
			fail("Not expecting EmptyListException, got one");
			e.printStackTrace();
		}
		
		assertNotNull(smallArray);
		
		for(int i=0 ; i<smallArray.length ; i++) {
			assertEquals(i, smallArray[i].intValue());
		}
	}
	
	@Test
	public void RadixSortOnLargeArrayTest() {
		try {
			s.RadixSort(largeArray);
		} catch (EmptyArrayException e) {
			fail("Not expecting EmptyListException, got one");
			e.printStackTrace();
		}
		
		assertNotNull(largeArray);
		
		for(int i=0 ; i<largeArray.length ; i++) {
			assertEquals(i, largeArray[i].intValue());
		}
	}
	
	@Test
	public void RadixSortOnSmallSortedArrayTest() {
		try {
			s.RadixSort(sortedSmall);
		} catch (EmptyArrayException e) {
			fail("Not expecting EmptyListException, got one");
			e.printStackTrace();
		}
		
		assertNotNull(sortedSmall);
		
		for(int i=0 ; i<sortedSmall.length ; i++) {
			assertEquals(i, sortedSmall[i].intValue());
		}
	}
	
	@Test
	public void RadixSortOnLargeSortedArrayTest() {
		try {
			s.RadixSort(sortedLarge);
		} catch (EmptyArrayException e) {
			fail("Not expecting EmptyListException, got one");
			e.printStackTrace();
		}
		
		assertNotNull(sortedLarge);
		
		for(int i=0 ; i<sortedLarge.length ; i++) {
			assertEquals(i, sortedLarge[i].intValue());
		}
	}

}
