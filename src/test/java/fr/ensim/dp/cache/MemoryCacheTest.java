package fr.ensim.dp.cache;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.fail;

public class MemoryCacheTest {

	// @Test
	// public void testSize() {
	// 	fail("Not yet implemented");
	// }

	@Test
	public void testAll() {
		ICache s = Memorycache.getInstance();
		// cle
		// Size vaut0
		assertEquals(0, s.size());
		byte [] b = {12,2 ,3} ;
		// add("key1", b)
		s.add("key1", b);
		// Size vaut 3
		assertEquals(3, s.size());
		//retreive 
		assertEquals(b, s.retreive("key1"));
		
	}


}
