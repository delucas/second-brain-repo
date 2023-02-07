package delucas.dp;

import org.junit.Assert;
import org.junit.Test;

public class BoxStackTests {
	
	Box[] boxes = {
			new Box(4,5,3),
			new Box(2,3,2),
			new Box(3,6,2),
			new Box(1,5,4),
			new Box(2,4,1),
			new Box(1,2,2)
	};
	
	@Test
	public void recursive() {
		Assert.assertEquals(7, BoxStack.recursive(boxes));
	}
	
	@Test
	public void topDown() {
		Assert.assertEquals(7, BoxStack.topDown(boxes));
	}

	@Test
	public void bottomUp() {
		Assert.assertEquals(7, BoxStack.bottomUp(boxes));
	}
}
