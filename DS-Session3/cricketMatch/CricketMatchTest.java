package cricketMatch;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Deekshika Sharma This class will have test cases for Cricket match
 */
public class CricketMatchTest {

	Map<String, Integer> bowlerMap;

	@Before
	public void createObject() {
		bowlerMap = new LinkedHashMap<String, Integer>(); // a linked hash map
															// is initialized
															// which have values
															// in linked order

		bowlerMap.put("deekshika", 7);
		bowlerMap.put("prakalpa", 9);
		bowlerMap.put("arjita", 5);
	}

	/**
	 * This method will have positive test case and check the correct order of
	 * balling
	 */
	@Test
	public void cricketMatchTest1() {
		CricketMatch cricketMatch = new CricketMatch(10, bowlerMap);
		List<String> expectedBowlingOrder = new ArrayList<String>() {
			{
				add("prakalpa");
				add("prakalpa");
				add("deekshika");
				add("prakalpa");
				add("deekshika");
				add("prakalpa");
				add("deekshika");
				add("prakalpa");
				add("arjita");
				add("deekshika");
			}
		};
		assertEquals(expectedBowlingOrder, cricketMatch.bowlingOrder());
	}

	/**
	 * This test case is run when no. of total balls is greater then the total
	 * balls of bowlers
	 */
	@Test(expected = AssertionError.class)
	public void cricketMatchErrorTest() {

		new CricketMatch(40, bowlerMap);
	}
}
