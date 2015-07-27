package com.winit.label.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.winit.label.service.LabelService;
import com.winit.label.shippment.entity.LabelEntity;

@Service("labelService")
public class LabelServiceImpl extends BaseServiceImpl implements LabelService{

	private String LABEL_NAMESPACE = LabelEntity.class.getName();
	
	private String ADD_LABEL = "addLabel";
	private String UPDATE_LABEL = "updateLabel";
	
	private String QUERY_LABEL_BY_MAP = "queryLabelByMap";
	
	
	@Override
	public int addLabel(LabelEntity label) {
		return save(LABEL_NAMESPACE+"."+ADD_LABEL,label);
	}

	@Override
	public void updateLabel(LabelEntity label){
		update(LABEL_NAMESPACE+"."+UPDATE_LABEL, label);
	}
	
	@Override
    public LabelEntity queryLabelByMap(Map<String, Object> map) {
		return (LabelEntity) single(LABEL_NAMESPACE+"."+QUERY_LABEL_BY_MAP, map);
	}

	@Override
	public LabelEntity findByDocumentNo(String documentNo)
	{
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("documentNo", documentNo);
		return queryLabelByMap(map);
	}

    @Override
    public List<LabelEntity> getAllLabel(boolean withFile) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("withFile", withFile);
        return (List<LabelEntity>) list(LABEL_NAMESPACE + ".getAllLabel", map);
    }

    @Override
    public LabelEntity getById(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        return queryLabelByMap(map);
    }
}
