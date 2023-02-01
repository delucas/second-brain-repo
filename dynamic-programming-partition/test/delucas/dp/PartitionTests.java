package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class PartitionTests {
	int[] arr = {4, 5, 3, 2, 5, 1};
	
	@Test
	public void recursive() {
		Assert.assertTrue(Partition.recursive(arr));
	}
	
	@Test
	public void reusing() {
		Assert.assertTrue(Partition.reusing(arr));
	}
}
