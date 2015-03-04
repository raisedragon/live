package com.winit.vms.adaptor.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.adaptor.entity.SingPostShippingNo;
import com.winit.vms.adaptor.query.SingPostShippingNoQuery;
import com.winit.vms.system.BaseTest;

/**
 * 新邮快递单号 Dao Test Case Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-10 16:35:03			Created
 * 
 * </pre>
 * @since 1.
 */
public class SingPostShippingNoDaoTest extends BaseTest {

    @Resource
    private SingPostShippingNoDao singPostShippingNoDao;

    private SingPostShippingNo getByShippingNo(String shippingNo) {
        SingPostShippingNoQuery.FindQuery query = new SingPostShippingNoQuery.FindQuery();
        query.createCriteria().andShippingNoEqualTo(shippingNo).andIsActiveEqualTo(true);
        List<SingPostShippingNo> list = singPostShippingNoDao.queryByCriteria(query);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Test
    public void testCreate() {
        SingPostShippingNo singPostShippingNo = new SingPostShippingNo();
        Integer randId = new Double(100000 * Math.random()).intValue();
        singPostShippingNo.setShippingNo("sin" + randId);
        singPostShippingNo.setValid(true);
        singPostShippingNo.setOrganizationId(Long.parseLong(randId + ""));
        singPostShippingNo.setCreated(new Date());
        singPostShippingNo.setCreatedby("sin" + randId);
        singPostShippingNo.setUpdated(new Date());
        singPostShippingNo.setUpdatedby("sin" + randId);
        singPostShippingNo.setActive(true);

        // 创建一实体
        singPostShippingNoDao.add(singPostShippingNo);
        SingPostShippingNoQuery.FindQuery query = new SingPostShippingNoQuery.FindQuery();
        query.createCriteria().andShippingNoEqualTo(singPostShippingNo.getShippingNo()).andIsActiveEqualTo(false);
        SingPostShippingNo singPostShippingNo1 = getByShippingNo(singPostShippingNo.getShippingNo());

        assertEquals(singPostShippingNo.getOrganizationId(), singPostShippingNo1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        SingPostShippingNo singPostShippingNo = new SingPostShippingNo();
        Integer randId = new Double(100000 * Math.random()).intValue();
        singPostShippingNo.setShippingNo("sin" + randId);
        singPostShippingNo.setValid(true);
        singPostShippingNo.setOrganizationId(Long.parseLong(randId + ""));
        singPostShippingNo.setCreated(new Date());
        singPostShippingNo.setCreatedby("sin" + randId);
        singPostShippingNo.setUpdated(new Date());
        singPostShippingNo.setUpdatedby("sin" + randId);
        singPostShippingNo.setActive(true);

        // 创建一实体
        singPostShippingNoDao.add(singPostShippingNo);

        singPostShippingNo = getByShippingNo(singPostShippingNo.getShippingNo());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        singPostShippingNo.setShippingNo("sin" + randId2);
        singPostShippingNo.setValid(true);
        singPostShippingNo.setOrganizationId(Long.parseLong(randId2 + ""));
        singPostShippingNo.setCreated(new Date());
        singPostShippingNo.setCreatedby("sin" + randId2);
        singPostShippingNo.setUpdated(new Date());
        singPostShippingNo.setUpdatedby("sin" + randId2);
        singPostShippingNo.setActive(true);

        // 创建一实体
        singPostShippingNoDao.update(singPostShippingNo);

        SingPostShippingNo singPostShippingNo2 = getByShippingNo(singPostShippingNo.getShippingNo());

        assertEquals(singPostShippingNo.getOrganizationId(), singPostShippingNo2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        SingPostShippingNo singPostShippingNo = new SingPostShippingNo();
        Integer randId = new Double(100000 * Math.random()).intValue();
        singPostShippingNo.setShippingNo("sin" + randId);
        singPostShippingNo.setValid(true);
        singPostShippingNo.setOrganizationId(Long.parseLong(randId + ""));
        singPostShippingNo.setCreated(new Date());
        singPostShippingNo.setCreatedby("sin" + randId);
        singPostShippingNo.setUpdated(new Date());
        singPostShippingNo.setUpdatedby("sin" + randId);
        singPostShippingNo.setActive(true);

        // 创建一实体
        singPostShippingNoDao.add(singPostShippingNo);

        singPostShippingNoDao.tombstoned(getByShippingNo(singPostShippingNo.getShippingNo()).getId());

        SingPostShippingNo singPostShippingNo2 = getByShippingNo(singPostShippingNo.getShippingNo());

        assertNull(singPostShippingNo2);
    }

    @Test
    public void testGet() {
        SingPostShippingNo singPostShippingNo = new SingPostShippingNo();
        Integer randId = new Double(100000 * Math.random()).intValue();
        singPostShippingNo.setShippingNo("sin" + randId);
        singPostShippingNo.setValid(true);
        singPostShippingNo.setOrganizationId(Long.parseLong(randId + ""));
        singPostShippingNo.setCreated(new Date());
        singPostShippingNo.setCreatedby("sin" + randId);
        singPostShippingNo.setUpdated(new Date());
        singPostShippingNo.setUpdatedby("sin" + randId);
        singPostShippingNo.setActive(true);

        // 创建一实体
        singPostShippingNoDao.add(singPostShippingNo);

        SingPostShippingNo singPostShippingNo2 = getByShippingNo(singPostShippingNo.getShippingNo());

        assertEquals(singPostShippingNo.getCreatedby(), singPostShippingNo2.getCreatedby());
    }

}
