package com.gdcc.live.core.query;

import java.util.List;

/**
 * Describes basic methods for querying.
 */
public interface Query<T extends Query< ? , ? >, U extends Object> {

  /**
   * Order the results ascending on the given property as defined in this
   * class (needs to come after a call to one of the orderByXxxx methods).
   */
  T asc();

  /**
   * Order the results descending on the given property as defined in this
   * class (needs to come after a call to one of the orderByXxxx methods).
   */
  T desc();

  /** Executes the query and returns the number of results */
  long count();

  /**
   * Executes the query and returns the resulting entity or null if no
   * entity matches the query criteria.
   * @throws LiveException when the query results in more than one
   * entities.
   */
  U singleResult();

  /** Executes the query and get a list of entities as the result. */
  List<U> list();

  /** Executes the query and get a list of entities as the result. */
  List<U> listPage(int firstResult, int maxResults);
  
}
