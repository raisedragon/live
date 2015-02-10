package com.raise.live.core.query;

/**
 * holds the parameters of a page (partial result) for a query.
 */
public class Page {

	protected int firstResult;
	protected int maxResults;

	public Page(int firstResult, int maxResults) {
		this.firstResult = firstResult;
		this.maxResults = maxResults;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public int getMaxResults() {
		return maxResults;
	}
}
