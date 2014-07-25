package org.jeffxor.skytree.problem1;

import junit.framework.Assert;

import org.jeffxor.problem1.MissingLetters;
import org.junit.Test;


public class SkytreeMissingLettersTest {

	private MissingLetters getDefault() {
		return new MissingLetters();
	}

	@Test
	public void MissingLetters_PangramString_ReturnsEmptyString(){
		String pangrams = "A quick brown fox jumps over the lazy dog";
		MissingLetters defaultSkytreeMissingLetters = getDefault();
		
		String missingLetters = defaultSkytreeMissingLetters.getMissingLetters(pangrams);
		
		Assert.assertEquals("", missingLetters);
	}

	@Test
	public void MissingLetters_EmptyString_ReturnsAll(){
		MissingLetters defaultSkytreeMissingLetters = getDefault();
		String emptyString = "";

		String missingLetters = defaultSkytreeMissingLetters.getMissingLetters(emptyString);
		
		Assert.assertEquals("abcdefghijklmnopqrstuvwxyz", missingLetters);
}

	@Test
	public void MissingLetters_NullString_ReturnsAll(){
		MissingLetters defaultSkytreeMissingLetters = getDefault();
		String nullString = null;

		String missingLetters = defaultSkytreeMissingLetters.getMissingLetters(nullString);
		
		Assert.assertEquals("abcdefghijklmnopqrstuvwxyz", missingLetters);
	}

	@Test
	public void MissingLetters_StringContainingNonAlpha_ReturnsAll(){
		MissingLetters defaultSkytreeMissingLetters = getDefault();
		String testString = "Lions, and tigers, and bears, oh my!";

		String missingLetters = defaultSkytreeMissingLetters.getMissingLetters(testString);
		
		Assert.assertEquals("cfjkpquvwxz", missingLetters);
	}

	@Test
	public void MissingLetters_StringContainingUpper_ReturnsCorrect(){
		MissingLetters defaultSkytreeMissingLetters = getDefault();
		String testString = "Lions, and tigers and bears oh my";

		String missingLetters = defaultSkytreeMissingLetters.getMissingLetters(testString);
		
		Assert.assertEquals("cfjkpquvwxz", missingLetters);
	}

	@Test
	public void MissingLetters_StringContainingPartial_ReturnsCorrect(){
		MissingLetters defaultSkytreeMissingLetters = getDefault();
		String testString = "lions and tigers and bears oh my";

		String missingLetters = defaultSkytreeMissingLetters.getMissingLetters(testString);
		
		Assert.assertEquals("cfjkpquvwxz", missingLetters);
	}

}