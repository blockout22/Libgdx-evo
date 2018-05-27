package com.blockout22.evolution;

import com.badlogic.gdx.math.Vector2;

public class Bounds {

	private Vector2	min;
	private Vector2	max;

	public Bounds(Vector2 min, Vector2 max) {
		super();
		this.min = min;
		this.max = max;
	}

	public Vector2 getMin() {
		return min;
	}

	public void setMin(Vector2 min) {
		this.min = min;
	}

	public Vector2 getMax() {
		return max;
	}

	public void setMax(Vector2 max) {
		this.max = max;
	}

}
