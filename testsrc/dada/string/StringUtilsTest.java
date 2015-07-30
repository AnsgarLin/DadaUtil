package dada.string;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void isNullOrEmptyTest() {
		Assert.assertTrue(StringUtils.isNullOrEmpty(""));
		Assert.assertTrue(StringUtils.isNullOrEmpty(null));
		Assert.assertFalse(StringUtils.isNullOrEmpty("1"));
		Assert.assertFalse(StringUtils.isNullOrEmpty("IAHSDASIH"));
	}
}
