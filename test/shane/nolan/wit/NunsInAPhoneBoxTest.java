package shane.nolan.wit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import shane.nolan.wit.Nun;
import shane.nolan.wit.PhoneBox;

public class NunsInAPhoneBoxTest {
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimplePhoneBox() {
		PhoneBox<Nun> phoneBox = new PhoneBox<Nun>(3);
		assertEquals(3, phoneBox.getLimit());		
	}
	
	@Test
	public void testGetNunList() {
		List<Nun> sampleNuns = getNunList(8);
		assertEquals(8,sampleNuns.size());	
	}
	
	@Test
	public void testGetNunListWithFail() {
		List<Nun> sampleNuns = getNunList(8);
		assertEquals(9,sampleNuns.size());	
	}
	
	@Test
	public void testAddingNunsToPhoneBox() {
		PhoneBox<Nun> phoneBox = new PhoneBox<Nun>(3);
		
		List<Nun> sampleNuns = getNunList(8);
		
		assertEquals("Nun1",sampleNuns.get(0).getName());
		assertTrue(phoneBox.add(sampleNuns.get(0)));
		assertEquals("Nun1",phoneBox.get(0).getName());
		assertEquals(1,phoneBox.size());
		
		assertEquals("Nun2",sampleNuns.get(1).getName());
		assertTrue(phoneBox.add(sampleNuns.get(1)));
		assertEquals("Nun2",phoneBox.get(1).getName());
		assertEquals(2,phoneBox.size());
		
		assertEquals("Nun3",sampleNuns.get(2).getName());
		assertTrue(phoneBox.add(sampleNuns.get(2)));
		assertEquals("Nun3",phoneBox.get(2).getName());
		assertEquals(3,phoneBox.size());
		
		assertEquals("Nun4",sampleNuns.get(3).getName());
		assertFalse(phoneBox.add(sampleNuns.get(3)));
		assertEquals(3,phoneBox.size());
		
		assertEquals("Nun1",phoneBox.get(0).getName());
		assertEquals("Nun2",phoneBox.get(1).getName());
		assertEquals("Nun3",phoneBox.get(2).getName());
		
		try{
			phoneBox.get(3);
			assertTrue(false);
		}catch(IndexOutOfBoundsException e){
			assertTrue(true);
		}		

	}
	
	/**
	 * Build a list of a given size
	 * Usage example -> getNunList(10).forEach(n -> System.out.println(n.getName()));
	 * @param size
	 * @return
	 */
	private List<Nun> getNunList(int size){
		List<Nun> n = new ArrayList<Nun>(size);
		IntStream.rangeClosed(1, size).forEach(i -> n.add(new Nun("Nun" + i)));
		return n;
	}

}
