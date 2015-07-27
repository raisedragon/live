package com.winit.label.service;

import java.util.List;
import java.util.Map;

import com.winit.label.shippment.entity.LabelEntity;

public interface LabelService {

	public int addLabel(LabelEntity label);
	
    public LabelEntity queryLabelByMap(Map<String, Object> map);
	
	public LabelEntity findByDocumentNo(String documentNo);

	void updateLabel(LabelEntity label);
	
    public List<LabelEntity> getAllLabel(boolean withFile);

    public LabelEntity getById(Long id);

}
