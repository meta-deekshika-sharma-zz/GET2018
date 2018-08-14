package cricketMatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Deekshika Sharma This class will have the methods to display the
 *         match scenario where captain wants to bowl in such a way that virat
 *         Kohli score minimum runs
 */
public class CricketMatch {

	Map<String, Integer> bowlerMap; // a map is initializes which stores bowler
									// name and its remaining balls
	int totalNoOfBalls;

	public CricketMatch(int totalNoOfballs, Map<String, Integer> bowlerMap) {

		if (sum(bowlerMap) >= totalNoOfballs) {
			this.totalNoOfBalls = totalNoOfballs;
			this.bowlerMap = bowlerMap;
		} else
			throw new AssertionError("Insufficient bowlers!!");
	}

	/**
	 * This method will return the bowling order by which Virat Kohli scores
	 * minimum runs
	 * 
	 * @return
	 */
	public List<String> bowlingOrder() {
		List<String> bowlingOrder = new ArrayList<>();

		// This method will add bowlers with their remaining balls to map
		for (int i = 0; i < totalNoOfBalls; i++) {
			String bowler = findBowler();
			bowlingOrder.add(bowler);
			bowlerMap.put(bowler, bowlerMap.get(bowler) - 1);
		}

		return bowlingOrder;
	}

	// This method will find the bowler which has to be ball next
	private String findBowler() {
		int maxBalls = 0;
		String bowler = null;

		for (String bowlerName : bowlerMap.keySet()) {
			int balls = bowlerMap.get(bowlerName);
			if (maxBalls < balls) {
				maxBalls = balls;
				bowler = bowlerName;
			}
		}

		return bowler;
	}

	// This method will validate whether there is enough ball are present for
	// bowlers to ball Virat
	private int sum(Map<String, Integer> bowlerMap) {
		int sum = 0;

		for (String bowler : bowlerMap.keySet())
			sum += bowlerMap.get(bowler);

		return sum;
	}
}
