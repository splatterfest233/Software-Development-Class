import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumTest {

	@Test
	void test() {
		int[] tester = {1, 2, 3, 5, 7};
		int expectedOutput = 18;
		int output = ConcurrencyProcessing.sum(tester);
		assertEquals(expectedOutput, output);
	}

}
