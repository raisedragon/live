package com.winit.vms.shipment.adaptor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;

import com.winit.vms.core.identity.UniqueIdUtil;
import com.winit.vms.shipment.adaptor.impl.SingPostLabelHandlerImpl;
import com.winit.vms.shipment.adaptor.impl.SingPostPreAdviceHanlerImpl;
import com.winit.vms.shipment.adaptor.support.MockManifestHandler;
import com.winit.vms.shipment.entity.Manifest;
import com.winit.vms.shipment.entity.Order;
import com.winit.vms.shipment.entity.OrderParcel;
import com.winit.vms.shipment.entity.OrderParcelItem;
import com.winit.vms.shipment.entity.OrderParcelLabel;
import com.winit.vms.shipment.entity.OrderParcelTracking;
import com.winit.vms.shipment.entity.OrderStatus;
import com.winit.vms.shipment.manager.OrderManager;
import com.winit.vms.shipment.manager.OrderParcelTrackingManager;
import com.winit.vms.shipment.query.OrderQuery;
import com.winit.vms.system.BaseTest;
import com.winit.vms.system.entity.Config;
import com.winit.vms.system.manager.ConfigManager;
import com.winit.vms.vendor.entity.ProductAttribute;
import com.winit.vms.vendor.entity.ShipmentConfig;
import com.winit.vms.vendor.entity.ShipmentConfigConst;
import com.winit.vms.vendor.manager.ProductAttributeManager;
import com.winit.vms.vendor.manager.ShipmentConfigManager;

public class SingPostShipmentAdaptorTest extends BaseTest {

    @Resource
    ShipmentAdaptor            shipmentAdaptor;

    @Resource
    ShipmentConfigManager      shipmentConfigManager;

    @Resource
    ConfigManager              configManager;

    @Resource
    OrderParcelTrackingManager orderParcelTrackingManager;

    @Resource
    ProductAttributeManager    procutAttributeManager;

    @Resource
    OrderManager               orderManager;

    // @Resource
    // GetLabelJob getLabelJob;

    // static boolean isInit = false;

    // @Before
    public void setUpBefore() throws Exception {
        // if(isInit){
        // return;
        // }
        {
            ProductAttribute entity = new ProductAttribute();
            entity.setProductCode("SingPost001");
            entity.setButtJoinLabel(true);
            entity.setButtJoinManifest(false);
            entity.setButtJoinTracking(false);
            entity.setButtJoinPreadvice(true);
            entity.setLabelFileExtensioin("PDF");
            entity.setManifestFileExtensioin("PDF");
            entity.setOpenApiTrackFetch(false);
            entity.setOpenFtpTrackFetch(false);
            entity.setOpenWebTrackFetch(false);
            entity.setLabelImplClass(SingPostLabelHandlerImpl.class.getName());
            entity.setManifestImplClass(MockManifestHandler.class.getName());
            entity.setPreadviceImplClass(SingPostPreAdviceHanlerImpl.class.getName());
            procutAttributeManager.add(entity);
            ;
        }

        {
            Config config = new Config();
            config.setName("PREADVICE_STORE_BASE_PATH");
            config.setValue("E:/temp/sing/alert");
            configManager.add(config);
        }
        {
            Config config = new Config();
            config.setName("MANIFEST_STORE_BASE_PATH");
            config.setValue("E:/temp/sing/manifest");
            configManager.add(config);
        }

        {
            Config config = new Config();
            config.setName("LABEL_STORE_BASE_PATH");
            config.setValue("E:/temp/sing/label");
            configManager.add(config);
        }
        {
            ShipmentConfig config = new ShipmentConfig();
            config.setProductCode("SingPost001");
            config.setName(ShipmentConfigConst.FORM_COUNTRY_CODE);
            config.setValue("US");
            shipmentConfigManager.add(config);
        }
        {
            ShipmentConfig config = new ShipmentConfig();
            config.setProductCode("SingPost001");
            config.setName(ShipmentConfigConst.FROM_POSTCODE);
            config.setValue("45385-385");
            shipmentConfigManager.add(config);
        }
        // isInit = true;
    }

    // @Test
    public void testGetTracking() throws Exception {
        String shipemntNo = "shipmentNo";
        for (int i = 0; i < 10; i++) {
            OrderParcelTracking orderParcelTracking = new OrderParcelTracking();
            Integer randId = new Double(100000 * Math.random()).intValue();
            orderParcelTracking.setOrderNo("001");
            orderParcelTracking.setParcelNo("aaa");
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

    @Test
    @Repeat(2)
    @Rollback(false)
    public void testAddOrder() throws Exception {
        Order order = new Order();
        order.setOrderNo(UniqueIdUtil.getSuid());
        order.setAddress1("良良");
        order.setAddress2("平平");
        order.setAddress3("村村的村");
        order.setCity("湛江");
        order.setCountryCode("CN");
        order.setEmail("li@mail.com");
        order.setHouseNumber("01");
        order.setName("小李");
        order.setVendorCode("SingPost");
        order.setPhone("15813689987");
        order.setPostcode("524532");
        order.setState("广东");
        order.setProductCode("SING01");
        for (int i = 0; i < 1; i++) {
            OrderParcel orderParcel = new OrderParcel();
            orderParcel.setParcelNo("ParcelNo" + i);

            orderParcel.setValue(BigDecimal.valueOf(1d));
            orderParcel.setCurrencyUnit("USD");
            orderParcel.setDescription("Description");
            orderParcel.setDeclareName("NNN");
            orderParcel.setHeight(BigDecimal.valueOf(10d));
            orderParcel.setLength(BigDecimal.valueOf(10d));
            orderParcel.setWeight(BigDecimal.valueOf(10d));
            orderParcel.setWidth(BigDecimal.valueOf(10d));
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

    @Test
    @Rollback(false)
    public void testGetLabel() throws Exception {
        OrderQuery.FindQuery orderQuery = new OrderQuery.FindQuery();
        List<OrderStatus> statuses = new ArrayList<OrderStatus>();
        statuses.add(OrderStatus.INI);
        statuses.add(OrderStatus.LGF);
        orderQuery.createCriteria().andIsActiveEqualTo(true).andOrderStatusIn(statuses);
        List<Order> orders = orderManager.queryByCriteria(orderQuery);
        for (Order order : orders) {
            try {
                List<OrderParcelLabel> labels = shipmentAdaptor.getLabel(order.getOrderNo());
                System.out.println(labels.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

     @Test
    @Rollback(false)
    public void testSendPreAdvice() throws Exception {
        OrderQuery.FindQuery query = new OrderQuery.FindQuery();
        query.createCriteria()
//            .andOrderStatusEqualTo(OrderStatus.PSC)
            .andCountryCodeEqualTo("CN")
            .andProductCodeEqualTo("SING01");
        List<Order> orders = orderManager.queryByCriteria(query);

        List<String> orderNos = new ArrayList<String>();
        for (Order order : orders) {
            orderNos.add(order.getOrderNo());
        }
        // orderNos.add("555918030190809088");
        // orderNos.add("555918540071374848");

        shipmentAdaptor.sendPreAdvice(UniqueIdUtil.getSuid(), orderNos, new Date());
    }

    // @Test
    public void testFetchTracking() {
        // fail("Not yet implemented");
    }

     @Test
     @Rollback(false)
    public void testGetManifest() throws Exception {
        String manifestNo = "563281660171390976";
        Manifest manifest = shipmentAdaptor.getManifest(manifestNo);
        assertNotNull(manifest);
    }
}
