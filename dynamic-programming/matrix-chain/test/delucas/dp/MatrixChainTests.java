package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class MatrixChainTests {

	M[] matrices = { new M(40, 20), new M(20, 30), new M(30, 10), new M(10, 30), new M(30, 50) };
	
	@Test
	public void recursive() {
		Assert.assertEquals(49000, MatrixChain.recursive(matrices));
	}
	
	@Test
	public void topDown() {
		Assert.assertEquals(49000, MatrixChain.topDown(matrices));
	}
	
	@Test
	public void bottomUp() {
		Assert.assertEquals(49000, MatrixChain.bottomUp(matrices));
	}
	
}
