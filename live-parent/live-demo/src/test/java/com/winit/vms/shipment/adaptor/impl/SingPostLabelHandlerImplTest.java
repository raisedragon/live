package com.winit.vms.shipment.adaptor.impl;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.winit.vms.shipment.adaptor.ShipmentAdaptor.LabelHanlerResult;
import com.winit.vms.shipment.entity.Order;
import com.winit.vms.shipment.entity.OrderParcel;
import com.winit.vms.system.BaseTest;

public class SingPostLabelHandlerImplTest extends BaseTest {

    @Resource
    SingPostLabelHandlerImpl singPostLabel;

    @Test
    // @Rollback(false)
    public void testGetLabel() throws Exception {
        List<OrderParcel> parcels = new ArrayList<OrderParcel>();
        for (int i = 0; i < 1; i++) {
            OrderParcel parcel = new OrderParcel();
            parcel.setParcelNo("1338337");
            parcel.setProductCode("K01");
            parcel.setOrderNo("ID12334445556CN");

            parcel.setDeclareName("Toys");
            parcel.setCurrencyUnit("USD");
            parcel.setLength(BigDecimal.valueOf(1d));
            parcel.setWidth(BigDecimal.valueOf(1d));
            parcel.setHeight(BigDecimal.valueOf(1d));
            parcel.setWeight(BigDecimal.valueOf(2d));
            parcel.setValue(BigDecimal.valueOf(800d));

            parcels.add(parcel);
        }

        Order order = new Order();
        order.setProductCode("K01");
        order.setName("繁體字");
        order.setPhone("12345");
        order.setEmail("");
        order.setCountryCode("GB");
        order.setPostcode("SE18 2PD");
        order.setCity("深圳");
        order.setAddress1("안녕하세요. / こんにちは / สวัสดี");
        order.setAddress2("здравствуйте / مرحبا");
        order.setOrderNo("orderNo");
        order.setParcels(parcels);

        LabelHanlerResult result = singPostLabel.getLabel(order);

        assertTrue(result.getLabels().size() > 0);

        String base64 = Base64.encodeBase64String(result.getLabels().get(0).getFileCode());
        System.out.println("base64\n" + base64);
    }
    
    
    @Test
    @Rollback(false)
    public void testCurrentGetTrackNo() throws InterruptedException{
    	for(int i=0;i<100;i++){
	    	Runnable run = new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<100;i++)
						func();
				}
			};
			Thread t = new Thread(run);
			t.start();
    	}
    	Thread.sleep(100000);
    }
    
    List<String> list = new ArrayList<String>();
    
    @Transactional
    public void func(){
    	String no = SingPostLabelHandlerImpl.getTrackingNo();
    	if(list.contains(no)){
    		System.out.println();
    	}
    	list.add(no);
    }
    

}
