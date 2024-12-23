package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface IRuleMap {
	public void put(int key, int value);
	public List<Integer> get(int key);
}

/**
 * RuleMap is simply a HashMap of Integer lists
 * This allows us to store a list of rules for a given key,
 * to then look them up after
 */
public class RuleMap implements IRuleMap {

	private Map<Integer, List<Integer>> rules = new HashMap<>();

	@Override
	public List<Integer> get(int key) {
		return rules.get(key);
	}

	@Override
	public void put(int key, int value) {
		if (!rules.containsKey(key)) {
			rules.put(key, new ArrayList<Integer>());
			rules.get(key).add(value);
			return;
		}
		rules.get(key).add(value);
		return;
	}
}
