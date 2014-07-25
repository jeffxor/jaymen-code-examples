package org.jeffxor.skytree.problem2;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.jeffxor.problem2.Animation;
import org.junit.Test;

public class SkytreeAnimationTest {

	@Test
	public void test() {
		List<String> expected = new ArrayList<String>();
		expected.add("..X....");
		expected.add("....X..");
		expected.add("......X");
		expected.add(".......");
		
		
		List<String> animate = Animation.animate(2, "..R....");
		
		Assert.assertEquals(expected, animate);
	}

}
