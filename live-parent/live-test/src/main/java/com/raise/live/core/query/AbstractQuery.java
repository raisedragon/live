package com.raise.live.core.query;

import java.io.Serializable;
import java.util.List;

import com.raise.live.core.command.Command;
import com.raise.live.core.command.CommandExecutor;
import com.raise.live.core.command.context.CommandContext;
import com.raise.live.core.context.Context;
import com.raise.live.core.exception.LiveException;

public abstract class AbstractQuery<T extends Query<?, ?>, U> extends
		ListQueryParameterObject implements Command<Object>, Query<T, U>,
		Serializable {

	private static final long serialVersionUID = 1L;

	public static final String SORTORDER_ASC = "asc";
	public static final String SORTORDER_DESC = "desc";

	private static enum ResultType {
		LIST, LIST_PAGE, SINGLE_RESULT, COUNT
	}

	protected transient CommandExecutor commandExecutor;
	protected transient CommandContext commandContext;
	protected String orderBy;

	protected ResultType resultType;

	protected QueryProperty orderProperty;

	protected AbstractQuery() {
		parameter = this;
	}

	protected AbstractQuery(CommandExecutor commandExecutor) {
		this.commandExecutor = commandExecutor;
	}

	public AbstractQuery(CommandContext commandContext) {
		this.commandContext = commandContext;
	}

	public AbstractQuery<T, U> setCommandExecutor(
			CommandExecutor commandExecutor) {
		this.commandExecutor = commandExecutor;
		return this;
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

	@SuppressWarnings("unchecked")
	public U singleResult() {
		this.resultType = ResultType.SINGLE_RESULT;
		if (commandExecutor != null) {
			return (U) commandExecutor.execute(this);
		}
		return executeSingleResult(Context.getCommandContext());
	}

	@SuppressWarnings("unchecked")
	public List<U> list() {
		this.resultType = ResultType.LIST;
		if (commandExecutor != null) {
			return (List<U>) commandExecutor.execute(this);
		}
		return executeList(Context.getCommandContext(), null);
	}

	@SuppressWarnings("unchecked")
	public List<U> listPage(int firstResult, int maxResults) {
		this.firstResult = firstResult;
		this.maxResults = maxResults;
		this.resultType = ResultType.LIST_PAGE;
		if (commandExecutor != null) {
			return (List<U>) commandExecutor.execute(this);
		}
		return executeList(Context.getCommandContext(), new Page(firstResult,
				maxResults));
	}

	public long count() {
		this.resultType = ResultType.COUNT;
		if (commandExecutor != null) {
			return (Long) commandExecutor.execute(this);
		}
		return executeCount(Context.getCommandContext());
	}

	public Object execute(CommandContext commandContext) {
		if (resultType == ResultType.LIST) {
			return executeList(commandContext, null);
		} else if (resultType == ResultType.SINGLE_RESULT) {
			return executeSingleResult(commandContext);
		} else if (resultType == ResultType.LIST_PAGE) {
			return executeList(commandContext, null);
		} else {
			return executeCount(commandContext);
		}
	}

	public abstract long executeCount(CommandContext commandContext);

	/**
	 * Executes the actual query to retrieve the list of results.
	 * 
	 * @param page
	 *            used if the results must be paged. If null, no paging will be
	 *            applied.
	 */
	public abstract List<U> executeList(CommandContext commandContext, Page page);

	public U executeSingleResult(CommandContext commandContext) {
		List<U> results = executeList(commandContext, null);
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
