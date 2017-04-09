package com.transferwise;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class AppleOrchardTest {

	@InjectMocks
	private AppleOrchard appleOrchard;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void collectApples() {
		int[][] orchard = createSquaredOrchard();
		int collected = appleOrchard.collectApples(orchard);
		assertThat(collected, equalTo(6));
	}

	@Test
	public void collectApplesWhenIsNotSquared() {
		int[][] orchard = createNotSquaredOrchard();
		int collected = appleOrchard.collectApples(orchard);
		assertThat(collected, equalTo(21));
	}

	@Test
	public void collectApplesWhenHasOne() {
		int[][] orchard = new int[1][1];
		orchard[0][0] = 4;
		int collected = appleOrchard.collectApples(orchard);
		assertThat(collected, equalTo(4));
	}

	@Test
	public void collectApplesWhenHasNoValues() {
		int[][] orchard = new int[3][3];
		int collected = appleOrchard.collectApples(orchard);
		assertThat(collected, equalTo(0));
	}

	@Test
	public void collectApplesWhenIsEmpty() {
		int[][] orchard = new int[0][0];
		int collected = appleOrchard.collectApples(orchard);
		assertThat(collected, equalTo(0));
	}

	@Test
	public void collectApplesWhenIsNull() {
		int collected = appleOrchard.collectApples(null);
		assertThat(collected, equalTo(0));
	}

	@Test
	public void collectApplesWithToken() {
		int[][] orchard = createSquaredOrchard();
		int collected = appleOrchard.collectApplesWithToken(orchard);
		assertThat(collected, equalTo(11));
	}

	@Test
	public void collectApplesWithTokenWhenIsNotSquared() {
		int[][] orchard = createNotSquaredOrchard();
		int collected = appleOrchard.collectApplesWithToken(orchard);
		assertThat(collected, equalTo(35));
	}

	@Test
	public void collectApplesWithTokenWhenHasOne() {
		int[][] orchard = new int[1][1];
		orchard[0][0] = 4;
		int collected = appleOrchard.collectApplesWithToken(orchard);
		assertThat(collected, equalTo(8));
	}

	@Test
	public void collectApplesWithTokenWhenHasNoValues() {
		int[][] orchard = new int[3][3];
		int collected = appleOrchard.collectApplesWithToken(orchard);
		assertThat(collected, equalTo(0));
	}

	@Test
	public void collectApplesWithTokenWhenIsEmpty() {
		int[][] orchard = new int[0][0];
		int collected = appleOrchard.collectApplesWithToken(orchard);
		assertThat(collected, equalTo(0));
	}

	@Test
	public void collectApplesWithTokenWhenIsNull() {
		int collected = appleOrchard.collectApplesWithToken(null);
		assertThat(collected, equalTo(0));
	}

	private int[][] createSquaredOrchard() {
		int[][] orchard = new int[3][3];
		orchard[0][0] = 4;
		orchard[0][1] = 0;
		orchard[0][2] = 1;
		orchard[1][0] = 1;
		orchard[1][1] = 0;
		orchard[1][2] = 0;
		orchard[2][0] = 0;
		orchard[2][1] = 4;
		orchard[2][2] = 0;
		return orchard;
	}

	private int[][] createNotSquaredOrchard() {
		int[][] orchard = new int[3][2];
		orchard[0][0] = 1;
		orchard[0][1] = 6;
		orchard[1][0] = 5;
		orchard[1][1] = 2;
		orchard[2][0] = 8;
		orchard[2][1] = 1;
		return orchard;
	}

}
