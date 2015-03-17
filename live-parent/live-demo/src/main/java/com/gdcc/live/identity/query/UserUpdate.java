package com.gdcc.live.identity.query;

import java.util.ArrayList;
import java.util.List;

import com.gdcc.live.core.context.AppContext;
import com.gdcc.live.core.query.AbstractUpdate;
import com.gdcc.live.core.query.SetData;
import com.gdcc.live.identity.dao.UserDao;
import com.gdcc.live.identity.manager.UserManager;

public class UserUpdate extends AbstractUpdate<UserUpdate> {
	
	private UserCriteria criteria;
	
	protected List<SetData> dataClauses;

	public UserUpdate(AppContext appContext) {
		super(appContext);
		criteria = new UserCriteria();
		dataClauses = new ArrayList<SetData>();
	}
	
	public UserCriteria getCriteria() {
		return criteria;
	}

	public List<SetData> getdataClauses() {
		if (dataClauses.size() == 0) {
			throw new RuntimeException("更新的数据，必须指定");
		}
		return dataClauses;
	}

	public void setFirstName(String firstName) {
		dataClauses.add(new SetData(UserProperty.COLUMN_NAME_firstName + " = ", firstName));
	}

	@Override
	public long execute() {
		return appContext.getDao(UserDao.class).updateByCriteria(this);
	}

}
