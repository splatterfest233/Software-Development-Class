import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

class WordCountTest {

	@Test
	void test() {
		String[] testStrings = {"Test", "is", "Test", "finished"};
		Map<String,Integer> test = TextAnalysis.wordCount(testStrings);
		Map<String,Integer> expectedOutput = new HashMap<String,Integer>();
		expectedOutput.put("Test", 2);
		expectedOutput.put("is", 1);
		expectedOutput.put("finished", 1);
		assertEquals(expectedOutput, test);
	}

}
