package org.nithish.graphs;

public class DistanceInfo {

	private int distance;
	private int lastIndex;

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public DistanceInfo(int distance, int lastIndex) {
		this.distance = distance;
		this.lastIndex = lastIndex;
	}

}
