package hw5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class No7Tests {

	private COMP232ArrayHeap<Integer, String> heap;

	@Before
	public void setUp() {
		heap = new COMP232ArrayHeap<Integer, String>();
	}

	@Test
	public void testOnEmptyHeap() {
		try {
			heap.adjustPriority("B", 3);
			fail("Should throw exception.");
		}
		catch(IllegalStateException e) {
			// pass
		}
		catch(Exception e) {
			fail("Incorrect exception type thrown.");
		}
	}

	private COMP232ArrayHeap<Integer,String> buildHeap() {
		Integer[] keys = new Integer[] {10, 8, 6, 4, 2};
		String[] vals = new String[] {"E", "D", "C", "B", "A"};
		COMP232ArrayHeap<Integer,String> heap = new COMP232ArrayHeap<Integer,String>(keys, vals);
		return heap;
	}

	@Test
	public void testValueNotInHeap() {
		heap = buildHeap();
		heap.adjustPriority("F", 12);
		assertEquals("Root should not have moved.", "E", heap.peek());
		assertTrue("Heap property was not preserved.", heap.checkHeapProperty());
	}

	/*
	 * Helper method to check full heap contents.
	 */
	private void checkHeap(String keys) {
		String h = "";
		while (heap.size() > 0) {
			h = h + heap.remove();
		}
		assertEquals("Heap contents not in correct order", keys, h);
	}

	@Test
	public void testDontMoveRoot() {
		heap = buildHeap();
		heap.adjustPriority("E", 12);

		checkHeap("EDCBA");

		assertTrue("Heap property was not preserved.", heap.checkHeapProperty());
	}

	@Test
	public void testDontMoveLeaf() {
		heap = buildHeap();
		heap.adjustPriority("C", 7);

		checkHeap("EDCBA");

		assertTrue("Heap property was not preserved.", heap.checkHeapProperty());
	}

	@Test 
	public void testMoveRootDownOne() {
		heap = buildHeap();
		heap.adjustPriority("E", 7);

		checkHeap("DECBA");

		assertTrue("Heap property was not preserved.", heap.checkHeapProperty());
	}

	@Test
	public void testMoveLeftChildUpOneToRoot() {
		heap = buildHeap();
		heap.adjustPriority("D", 12);

		checkHeap("DECBA");

		assertTrue("Heap property was not preserved.", heap.checkHeapProperty());
	}

	@Test
	public void testMoveRightChildUpOneToRoot() {
		heap = buildHeap();
		heap.adjustPriority("C", 12);

		checkHeap("CEDBA");

		assertTrue("Heap property was not preserved.", heap.checkHeapProperty());
	}

	@Test
	public void testMoveLeftLeafToRoot() {
		heap = buildHeap();
		heap.adjustPriority("B", 12);

		checkHeap("BEDCA");

		assertTrue("Heap property was not preserved.", heap.checkHeapProperty());
	}

	@Test
	public void testMoveRightLeafToRoot() {
		heap = buildHeap();
		heap.adjustPriority("A", 12);

		checkHeap("AEDCB");

		assertTrue("Heap property was not preserved.", heap.checkHeapProperty());
	}

	@Test
	public void testMoveRootToLeaf() {
		heap = buildHeap();
		heap.adjustPriority("E", 1);

		checkHeap("DCBAE");

		assertTrue("Heap property was not preserved.", heap.checkHeapProperty());
	}
}