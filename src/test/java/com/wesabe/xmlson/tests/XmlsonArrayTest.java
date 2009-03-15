package com.wesabe.xmlson.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.wesabe.xmlson.XmlsonArray;
import com.wesabe.xmlson.XmlsonObject;

@RunWith(Enclosed.class)
public class XmlsonArrayTest {
	public static class A_New_Array {
		@Test
		public void itHasAName() throws Exception {
			XmlsonArray array = new XmlsonArray("blah");
			assertEquals("blah", array.getName());
		}
		
		@Test
		public void itHasNoMembers() throws Exception {
			XmlsonArray array = new XmlsonArray("blah");
			assertTrue(array.getMembers().isEmpty());
		}
	}
	
	public static class Adding_A_Member {
		@Test
		public void itReturnsTheArrayForChainingPurposes() throws Exception {
			XmlsonArray array = new XmlsonArray("blah");
			assertSame(array, array.add(new XmlsonObject("blee")));
		}
		
		@Test
		public void itAddsTheMemberToTheEndOfTheArray() throws Exception {
			XmlsonArray array = new XmlsonArray("blah");
			XmlsonObject object = new XmlsonObject("blee");
			
			array.add(object);
			
			assertSame(object, array.getMembers().get(array.getMembers().size() - 1));
		}
	}
	
	public static class Adding_Itself_As_A_Member {
		@Test
		public void itThrowsAnException() throws Exception {
			XmlsonArray array = new XmlsonArray("blah");
			
			boolean exceptionThrown = false;
			try {
				array.add(array);
			} catch (IllegalArgumentException e) {
				exceptionThrown = true;
			}
			assertTrue("should have thrown an exception but didn't", exceptionThrown);
		}
	}
}