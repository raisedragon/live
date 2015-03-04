package com.winit.vms.shipment.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.spi.ShipOrderParcelLabelService;
import com.winit.vms.spi.command.GetLabelCommand;
import com.winit.vms.spi.vo.ShipOrderParcel;
import com.winit.vms.spi.vo.ShipOrderParcelLabel;
import com.winit.vms.system.BaseTest;

public class ShipOrderParcelLabelServiceImplTest extends BaseTest {

    @Resource
    ShipOrderParcelLabelService shipOrderParcelLabelService;

    @Test
    public void testGetLabel() {
        GetLabelCommand command = new GetLabelCommand();
        command.setAddress1("2");
        command.setAddress2("2");
        command.setCity("2");
        command.setCountryCode("SG");
        command.setEmail("2");
        command.setHouseNumber("2");
        command.setName("2");
        command.setOrderNo("001");
        command.setOrganizationId(new Long(1));
        command.setPhone("2");
        command.setPostcode("2");
        command.setState("2");
        command.setVendorCode("SING");
        command.setProductCode("SING01");
        command.setOrganizationId(01l);
        List<ShipOrderParcel> parcels = new ArrayList<ShipOrderParcel>();
        ShipOrderParcel pl = new ShipOrderParcel();
        pl.setCurrencyUnit("URC");
        pl.setDeclareName("中国制造");
        pl.setDescription("222");
        pl.setHeight(new BigDecimal(1));
        pl.setLength(new BigDecimal(1));
        pl.setOrganizationId(new Long(1));
        pl.setParcelNo("SING01");
        pl.setValue(new BigDecimal(1));
        pl.setWeight(new BigDecimal(1));
        pl.setWidth(new BigDecimal(1));
        pl.setProductCode("K01");
        parcels.add(pl);
        command.setParcels(parcels);
        ShipOrderParcelLabel sp = shipOrderParcelLabelService.getLabel(command);
        assertEquals(sp.getOrderNo(), command.getOrderNo());
    }
}
