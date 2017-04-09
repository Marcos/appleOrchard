package com.transferwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class AppleOrchard {

	private int maxTokens;

	public AppleOrchard() {
		maxTokens = 2;
	}

	public int collectApples(int[][] orchard) {
		Map<Integer, String> harvestMap = collect(orchard);
		return getSortedHarvest(harvestMap).get(0);
	}

	public int collectApplesWithToken(int[][] orchard) {
		Map<Integer, String> harvestMap = collect(orchard);
		Integer maxHarvest = getSortedHarvest(harvestMap).get(0);
		List<Integer> squares = getSortedPath(orchard, harvestMap, maxHarvest);
		useTokens(squares);
		return squares.stream().mapToInt(i -> i.intValue()).sum();
	}

	private void useTokens(List<Integer> squares) {
		for (int i = 0; i < maxTokens; i++)
			useToken(squares, i);
	}

	private Map<Integer, String> collect(int[][] orchard) {
		if (isEmpty(orchard))
			return createEmptyHarvestMap();
		return takeApples(orchard);
	}

	private boolean isEmpty(int[][] orchard) {
		return orchard == null || orchard.length == 0;
	}

	private Map<Integer, String> createEmptyHarvestMap() {
		Map<Integer, String> harvestMap = new HashMap<>();
		harvestMap.put(0, "");
		return harvestMap;
	}

	private Map<Integer, String> takeApples(int[][] orchard) {
		Map<Integer, String> harvestMap = new HashMap<>();
		int maxI = 0;
		int maxJ = orchard[0].length - 1;
		int initialI = orchard.length - 1;
		int initialJ = 0;
		String initialPath = "";
		int initialSum = 0;
		takeApples(orchard, maxI, maxJ, initialI, initialJ, initialPath, initialSum, harvestMap);
		return harvestMap;
	}

	private List<Integer> getSortedHarvest(Map<Integer, String> collectedMap) {
		List<Integer> collecteds = new ArrayList<>(collectedMap.keySet());
		collecteds.sort((a, b) -> b.compareTo(a));
		return collecteds;
	}

	private void useToken(List<Integer> squares, int indexUsed) {
		if (squares.size() > indexUsed)
			squares.set(indexUsed, squares.get(indexUsed) * 2);
	}

	private List<Integer> getSortedPath(int[][] orchard, Map<Integer, String> harvestMap, Integer maxHarvest) {
		List<Integer> values = new ArrayList<>();
		String[] steps = harvestMap.get(maxHarvest).split(" ");
		for (String step : steps)
			addStep(orchard, values, step);
		values.sort((a, b) -> b.compareTo(a));
		return values;
	}

	private void addStep(int[][] orchard, List<Integer> values, String step) {
		if (step.length() == 0)
			values.add(0);
		else {
			String[] coordinates = step.split(",");
			int i = Integer.parseInt(coordinates[0]);
			int j = Integer.parseInt(coordinates[1]);
			values.add(orchard[i][j]);
		}
	}

	private void takeApples(int[][] orchard, int maxI, int maxJ, int i, int j, String path, int sum,
			Map<Integer, String> harvestMap) {
		path += String.format(" %d,%d", i, j);
		sum += orchard[i][j];
		if (i == maxI && j == maxJ) {
			System.out.println(path.trim() + "=" + sum);
			harvestMap.put(sum, path.trim());
		} else {
			if (i > maxI)
				takeApples(orchard, maxI, maxJ, i - 1, j, path, sum, harvestMap);
			if (j < maxJ)
				takeApples(orchard, maxI, maxJ, i, j + 1, path, sum, harvestMap);
		}
	}

}
