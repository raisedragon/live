package com.winit.vms.shipment.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.common.utils.Dates;
import com.winit.vms.spi.TrackService;
import com.winit.vms.spi.command.SearchTrackCommand;
import com.winit.vms.spi.vo.ShipOrderTrack;
import com.winit.vms.system.BaseTest;

/**
 * <SPI SERVICE TEST CLASS>
 * 
 * @version <pre>
 * Author	Version		Date		Changes
 * jianfa.zhuang 	1.0  		2015-1-12 	Created
 * 
 * </pre>
 * @since 1.
 */
public class TrackServiceTest extends BaseTest {

    @Resource
    private TrackService trackService;

    @Test
    public void testTrackService() {
        DateFormat dd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SearchTrackCommand command = new SearchTrackCommand();
        command.setOrderNo("ISP123456");
        command.setProductCode("K01");
        command.setTrackingNo("RC628102947SG");
        List<ShipOrderTrack> list = trackService.queryTrack(command);
        for (ShipOrderTrack tr : list) {
            TimeZone timeZone = TimeZone.getTimeZone("PRC");
            dd.setTimeZone(timeZone);
            System.out.println(dd.format(Dates.getLocalDate(tr.getTime())));
        }
        System.out.println(list.size());
    }
}
