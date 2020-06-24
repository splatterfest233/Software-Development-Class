import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class htmlRemovalTest {

	@Test
	void test() {
		String test = TextAnalysis.htmlRemoval("Remove the <h1>Html</h1> tags.");
		String expectedOutput = new String("Remove the Html tags.");
		assertEquals(expectedOutput, test);
	}

}
