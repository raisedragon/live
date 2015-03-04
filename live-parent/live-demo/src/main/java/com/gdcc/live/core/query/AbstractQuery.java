package com.gdcc.live.core.query;

import java.io.Serializable;
import java.util.List;

import com.gdcc.live.core.context.AppContext;
import com.gdcc.live.core.exception.LiveException;


public abstract class AbstractQuery<T extends Query<?, ?>, U> 
	extends ListQueryParameterObject implements Query<Query<?,?>, U>,Serializable {

	private static final long serialVersionUID = 1L;

	public static final String SORTORDER_ASC = "asc";
	public static final String SORTORDER_DESC = "desc";

	private static enum ResultType {
		LIST, LIST_PAGE, SINGLE_RESULT, COUNT
	}

	protected String orderBy;

	protected ResultType resultType;

	protected QueryProperty orderProperty;

	
	 protected transient AppContext appContext;
	
	protected AbstractQuery(AppContext appContext) {
		this.appContext = appContext;
	}



	@SuppressWarnings("unchecked")
	public T orderBy(QueryProperty property) {
		this.orderProperty = property;
		return (T) this;
	}

	public T asc() {
		return direction(Direction.ASCENDING);
	}

	public T desc() {
		return direction(Direction.DESCENDING);
	}

	@SuppressWarnings("unchecked")
	public T direction(Direction direction) {
		if (orderProperty == null) {
			throw new LiveException(
					"You should call any of the orderBy methods first before specifying a direction");
		}
		addOrder(orderProperty.getName(), direction.getName());
		orderProperty = null;
		return (T) this;
	}

	protected void checkQueryOk() {
		if (orderProperty != null) {
			throw new LiveException(
					"Invalid query: call asc() or desc() after using orderByXX()");
		}
	}

	public U singleResult() {
		this.resultType = ResultType.SINGLE_RESULT;
		return executeSingleResult();
	}

	public List<U> list() {
		this.resultType = ResultType.LIST;
		return executeList( null);
	}

	@SuppressWarnings("unchecked")
	public List<U> listPage(int firstResult, int maxResults) {
		this.firstResult = firstResult;
		this.maxResults = maxResults;
		this.resultType = ResultType.LIST_PAGE;
		return executeList(new Page(firstResult, maxResults));
	}

	public long count() {
		this.resultType = ResultType.COUNT;
		return executeCount();
	}

	public Object execute() {
		if (resultType == ResultType.LIST) {
			return executeList(null);
		} else if (resultType == ResultType.SINGLE_RESULT) {
			return executeSingleResult();
		} else if (resultType == ResultType.LIST_PAGE) {
			return executeList( null);
		} else {
			return executeCount();
		}
	}

	public abstract long executeCount();

	/**
	 * Executes the actual query to retrieve the list of results.
	 * 
	 * @param page
	 *            used if the results must be paged. If null, no paging will be
	 *            applied.
	 */
	public abstract List<U> executeList(Page page);

	public U executeSingleResult() {
		List<U> results = executeList( null);
		if (results.size() == 1) {
			return results.get(0);
		} else if (results.size() > 1) {
			throw new LiveException("Query return " + results.size()
					+ " results instead of max 1");
		}
		return null;
	}

	protected void addOrder(String column, String sortOrder) {
		if (orderBy == null) {
			orderBy = "";
		} else {
			orderBy = orderBy + ", ";
		}
		orderBy = orderBy + column + " " + sortOrder;
	}

	public String getOrderBy() {
		if (orderBy == null) {
			return super.getOrderBy();
		} else {
			return orderBy;
		}
	}
}
