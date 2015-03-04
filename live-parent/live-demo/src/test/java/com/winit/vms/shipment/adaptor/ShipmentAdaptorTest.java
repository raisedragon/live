package com.winit.vms.shipment.adaptor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import com.winit.vms.shipment.adaptor.support.MockLabelHander;
import com.winit.vms.shipment.adaptor.support.MockManifestHandler;
import com.winit.vms.shipment.adaptor.support.MockPreAdviceHandler;
import com.winit.vms.shipment.entity.CalcPayableStatus;
import com.winit.vms.shipment.entity.Manifest;
import com.winit.vms.shipment.entity.ManifestStatus;
import com.winit.vms.shipment.entity.Order;
import com.winit.vms.shipment.entity.OrderParcel;
import com.winit.vms.shipment.entity.OrderParcelItem;
import com.winit.vms.shipment.entity.OrderParcelTracking;
import com.winit.vms.shipment.entity.OrderStatus;
import com.winit.vms.shipment.manager.ManifestManager;
import com.winit.vms.shipment.manager.OrderManager;
import com.winit.vms.shipment.manager.OrderParcelManager;
import com.winit.vms.shipment.manager.OrderParcelTrackingManager;
import com.winit.vms.shipment.query.OrderQuery;
import com.winit.vms.system.BaseTest;
import com.winit.vms.system.entity.Config;
import com.winit.vms.system.manager.ConfigManager;
import com.winit.vms.vendor.entity.ProductAttribute;
import com.winit.vms.vendor.manager.ProductAttributeManager;
import com.winit.vms.vendor.manager.ShipmentConfigManager;

public class ShipmentAdaptorTest extends BaseTest {

    @Resource
    ShipmentAdaptor            shipmentAdaptor;

    @Resource
    ShipmentConfigManager      shipmentConfigManager;

    @Resource
    ConfigManager              configManager;

    @Resource
    ManifestManager            manifestManager;

    @Resource
    OrderParcelTrackingManager orderParcelTrackingManager;

    @Resource
    ProductAttributeManager    procutAttributeManager;

    @Resource
    OrderManager               orderManager;

    @Resource
    OrderParcelManager         orderParcelManager;

    // @Before
    public void setUpBefore() throws Exception {
        {
            ProductAttribute entity = new ProductAttribute();
            entity.setProductCode("SING01");
            entity.setButtJoinLabel(true);
            entity.setButtJoinManifest(false);
            entity.setButtJoinTracking(false);
            entity.setButtJoinPreadvice(false);
            entity.setLabelFileExtensioin("txt");
            entity.setManifestFileExtensioin("txt");
            entity.setOpenApiTrackFetch(false);
            entity.setOpenFtpTrackFetch(false);
            entity.setOpenWebTrackFetch(false);
            entity.setLabelImplClass(MockLabelHander.class.getName());
            entity.setManifestImplClass(MockManifestHandler.class.getName());
            entity.setPreadviceImplClass(MockPreAdviceHandler.class.getName());
            procutAttributeManager.add(entity);
            ;
        }

        {
            Config config = new Config();
            config.setName("PREADVICE_STORE_BASE_PATH");
            config.setValue("E:/temp/vms/alert");
            configManager.add(config);
        }
        {
            Config config = new Config();
            config.setName("MANIFEST_STORE_BASE_PATH");
            config.setValue("E:/temp/vms/manifest");
            configManager.add(config);
        }

        {
            Config config = new Config();
            config.setName("LABEL_STORE_BASE_PATH");
            config.setValue("E:/temp/vms/label");
            configManager.add(config);
        }

    }

    @Before
    public void testAddManifest() {
        Order order = new Order();
        Integer randId = new Double(100000 * Math.random()).intValue();

        order.setOrderNo("ord" + randId);
        order.setName("ord" + randId);
        order.setCountryCode("US");
        order.setCity("city");
        order.setState("state");
        order.setAddress1("address1");
        order.setPostcode("postCode");
        order.setOrderStatus(OrderStatus.LGF);
        order.setOrganizationId(Long.parseLong(randId + ""));
        order.setCreated(new Date());
        order.setCreatedby("ord" + randId);
        order.setUpdated(new Date());
        order.setUpdatedby("ord" + randId);
        order.setActive(true);
        order.setProductCode("SING01");
        order.setCalcPayableStatus(CalcPayableStatus.INI);
        order.setManifestNo("manifest999");
        // 创建一实体
        orderManager.add(order);

        OrderParcel orderParcel = new OrderParcel();
        Integer randId2 = new Double(100000 * Math.random()).intValue();

        orderParcel.setOrderNo("ord" + randId2);
        orderParcel.setParcelNo("ord" + randId2);
        orderParcel.setProductCode("SING01");
        orderParcel.setOrganizationId(Long.parseLong(randId2 + ""));
        orderParcel.setCreated(new Date());
        orderParcel.setCreatedby("ord" + randId2);
        orderParcel.setUpdated(new Date());
        orderParcel.setUpdatedby("ord" + randId2);
        orderParcel.setActive(true);

        // 创建一实体
        orderParcelManager.add(orderParcel);

        com.winit.vms.shipment.entity.Manifest manifest = new com.winit.vms.shipment.entity.Manifest();
        Integer randId3 = new Double(100000 * Math.random()).intValue();
        manifest.setManifestNo("manifest999");
        manifest.setOrganizationId(Long.parseLong(randId3 + ""));
        manifest.setCreated(new Date());
        manifest.setCreatedby("man" + randId);
        manifest.setUpdated(new Date());
        manifest.setUpdatedby("man" + randId);
        manifest.setActive(true);
        manifest.setStatus(ManifestStatus.INI);
        manifest.setProductCode("SING01");
        // 创建一实体
        manifestManager.add(manifest);

    }

    // @Test
    public void testGetTracking() throws Exception {
        String shipemntNo = "12313";// idGenerator.getSuid();
        for (int i = 0; i < 10; i++) {
            OrderParcelTracking orderParcelTracking = new OrderParcelTracking();
            Integer randId = new Double(100000 * Math.random()).intValue();
            orderParcelTracking.setOrderNo("001");
            orderParcelTracking.setParcelNo("ParcelNo0");
            orderParcelTracking.setProductCode("ProductCode");
            orderParcelTracking.setVendorShippingNo(shipemntNo);
            orderParcelTracking.setTime(new Date());
            orderParcelTracking.setLocation("ord" + randId);
            orderParcelTracking.setOperator("ord" + randId);
            orderParcelTracking.setReceivedBy("ord" + randId);
            orderParcelTracking.setMessage("ord" + randId);
            orderParcelTracking.setStatus("ord" + randId);
            orderParcelTracking.setVendorStatus("ord" + randId);
            orderParcelTracking.setSource("API");
            orderParcelTracking.setOrganizationId(Long.parseLong(randId + ""));
            orderParcelTracking.setCreated(new Date());
            orderParcelTracking.setCreatedby("ord" + randId);
            orderParcelTracking.setUpdated(new Date());
            orderParcelTracking.setUpdatedby("ord" + randId);
            orderParcelTracking.setActive(true);
            orderParcelTrackingManager.add(orderParcelTracking);
        }
        List<OrderParcelTracking> a = shipmentAdaptor.getTracking("001", shipemntNo, "ProductCode");
        assertEquals(10, a.size());
    }

    // @Test
    public void testSendPreAdvice() throws Exception {
        OrderQuery.FindQuery query = new OrderQuery.FindQuery();
        List<Order> orders = orderManager.queryByCriteria(query);

        List<String> orderNos = new ArrayList<String>();
        for (Order order : orders) {
            orderNos.add(order.getOrderNo());
        }
        shipmentAdaptor.sendPreAdvice("M001", orderNos, new Date());
    }

    @Test
    public void testGetManifest() throws Exception {
        String manifestNo = "manifest999";
        Manifest manifest = shipmentAdaptor.getManifest(manifestNo);
        assertNotNull(manifest);
    }

    @Test
    // @Rollback(false)
    public void testAddOrder() throws Exception {
        Order order = new Order();
        order.setOrderNo(String.valueOf(new Random().nextInt(100)));
        order.setAddress1("Address1");
        order.setAddress2("Address2");
        order.setAddress3("Address3");
        order.setCity("City");
        order.setCountryCode("US");
        order.setEmail("Email");
        order.setHouseNumber("HouseNumber");
        order.setName("Name");
        order.setPhone("Phone");
        order.setPostcode("Postcode");
        order.setState("State");
        order.setProductCode("SING01");
        for (int i = 0; i < 1; i++) {
            OrderParcel orderParcel = new OrderParcel();
            orderParcel.setParcelNo("ParcelNo" + i);

            orderParcel.setCurrencyUnit("USD");
            orderParcel.setDescription("Description");
            orderParcel.setHeight(BigDecimal.valueOf(1d));
            orderParcel.setLength(BigDecimal.valueOf(1d));
            orderParcel.setProductCode("SING01");
            orderParcel.setValue(BigDecimal.valueOf(1d));
            orderParcel.setWeight(BigDecimal.valueOf(1d));
            orderParcel.setWidth(BigDecimal.valueOf(1d));
            for (int j = 0; j < 2; j++) {
                OrderParcelItem orderParcelItem = new OrderParcelItem();
                orderParcelItem.setCurrencyUnit("USD");
                orderParcelItem.setDescription("Description");
                orderParcelItem.setHeight(BigDecimal.valueOf(1d));
                orderParcelItem.setLength(BigDecimal.valueOf(1d));
                orderParcelItem.setName("Name");
                orderParcelItem.setQuantity(1);
                orderParcelItem.setSku("Sku");
                orderParcelItem.setValue(BigDecimal.valueOf(1d));
                orderParcelItem.setWeight(BigDecimal.valueOf(1d));
                orderParcelItem.setWidth(BigDecimal.valueOf(1d));
                orderParcel.getItems().add(orderParcelItem);
            }

            order.getParcels().add(orderParcel);

        }
        shipmentAdaptor.addOrder(order);

    }

    // @Test
    public void testFetchTracking() {
        // fail("Not yet implemented");
    }

}
