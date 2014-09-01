package com.raise.orgs.identity;

import com.raise.orgs.query.NativeQuery;

/**
 * Allows querying of {@link com.raise.orgs.identity.User}s via native (SQL) queries
 * @author Henry Yan(http://www.kafeitu.me)
 */
public interface NativeUserQuery extends NativeQuery<NativeUserQuery, User> {

}