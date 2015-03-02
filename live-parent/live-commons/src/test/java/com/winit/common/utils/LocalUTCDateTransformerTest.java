package com.winit.common.utils;

import com.winit.common.utils.Dates;
import com.winit.common.utils.LocalUTCDateTransformer;
import com.winit.common.utils.LocalUTCDateTransformer.Direction;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by liuye on 2015/1/27.
 */
public class LocalUTCDateTransformerTest {
    private static Date referDate;

    @BeforeClass
    public static void setup() throws ParseException {
        referDate = DateUtils.parseDate("2014/12/12", "yyyy/MM/dd");
    }
    
    @Test
    public void testTransforForDate() throws ParseException {
        Date createdDate = DateUtils.parseDate("2014/12/12", "yyyy/MM/dd");
        LocalUTCDateTransformer.transform(createdDate, LocalUTCDateTransformer.Direction.TO_UTC);
        assertEquals(referDate, Dates.getLocalDate(createdDate));
        LocalUTCDateTransformer.transform(createdDate, LocalUTCDateTransformer.Direction.TO_LOCAL);
        assertEquals(referDate, createdDate);
    }

    @Test
    public void testTransformForObject() throws ParseException {
        User user = new User();
        user.setName("John");
        user.setCreatedDate(DateUtils.parseDate("2014/12/12", "yyyy/MM/dd"));
        LocalUTCDateTransformer.transform(user, LocalUTCDateTransformer.Direction.TO_UTC);
        assertEquals(referDate, Dates.getLocalDate(user.getCreatedDate()));
        LocalUTCDateTransformer.transform(user, LocalUTCDateTransformer.Direction.TO_LOCAL);
        assertEquals(referDate, user.getCreatedDate());
    }

    @Test
    public void testTransformForEmbedObject() throws ParseException {
        UserProfile profile = new UserProfile();
        profile.setGender(true);
        profile.setCreatedDate(DateUtils.parseDate("2014/12/12", "yyyy/MM/dd"));

        User user = new User();
        user.setProfile(profile);
        LocalUTCDateTransformer.transform(user, LocalUTCDateTransformer.Direction.TO_UTC);
        assertEquals(referDate, Dates.getLocalDate(user.getProfile().getCreatedDate()));
        LocalUTCDateTransformer.transform(user, LocalUTCDateTransformer.Direction.TO_LOCAL);
        assertEquals(referDate, user.getProfile().getCreatedDate());
    }

    @Test
    public void testTransformForArray() throws ParseException {
        UserProfile profile = new UserProfile();
        profile.setGender(true);
        profile.setCreatedDate(DateUtils.parseDate("2014/12/12", "yyyy/MM/dd"));

        User user = new User();
        user.setProfile(profile);
        user.setName("John");
        user.setCreatedDate(DateUtils.parseDate("2014/12/12", "yyyy/MM/dd"));

        Object[] objects = new Object[]{DateUtils.parseDate("2014/12/12", "yyyy/MM/dd"), user};
        LocalUTCDateTransformer.transform(objects, Direction.TO_UTC);
        assertEquals(referDate, Dates.getLocalDate((Date) objects[0]));
        assertEquals(referDate, Dates.getLocalDate(((User) objects[1]).getCreatedDate()));
        assertEquals(referDate, Dates.getLocalDate(((User) objects[1]).getProfile().getCreatedDate()));
        
        LocalUTCDateTransformer.transform(objects, Direction.TO_LOCAL);
        assertEquals(referDate, objects[0]);
        assertEquals(referDate, ((User) objects[1]).getCreatedDate());
        assertEquals(referDate, ((User) objects[1]).getProfile().getCreatedDate());
    }

    @Test
    public void testTransformForList() throws ParseException {
          List<Object> dateList = new ArrayList<Object>();
          dateList.add(DateUtils.parseDate("2014/12/12", "yyyy/MM/dd"));
          dateList.add(DateUtils.parseDate("2014/12/12", "yyyy/MM/dd"));
          
          UserProfile profile = new UserProfile();
          profile.setGender(true);
          profile.setCreatedDate(DateUtils.parseDate("2014/12/12", "yyyy/MM/dd"));

          User user = new User();
          user.setProfile(profile);
          user.setName("John");
          user.setCreatedDate(DateUtils.parseDate("2014/12/12", "yyyy/MM/dd"));
          dateList.add(user);
          
          LocalUTCDateTransformer.transform(dateList, Direction.TO_UTC);
          assertEquals(referDate, Dates.getLocalDate((Date)dateList.get(0)));
          assertEquals(referDate, Dates.getLocalDate((Date)dateList.get(1)));
          assertEquals(referDate, Dates.getLocalDate(((User)dateList.get(2)).getCreatedDate()));
          
          LocalUTCDateTransformer.transform(dateList, Direction.TO_LOCAL);
          assertEquals(referDate, dateList.get(0));
          assertEquals(referDate, dateList.get(1));
          assertEquals(referDate, ((User)dateList.get(2)).getCreatedDate());
    }
    
    @Test
    public void testTransformForMap() throws ParseException {
          Map<String, Object> dateMap = new HashMap<String, Object>();
          dateMap.put("date1", DateUtils.parseDate("2014/12/12", "yyyy/MM/dd"));
          dateMap.put("date2" ,DateUtils.parseDate("2014/12/12", "yyyy/MM/dd"));
          
          UserProfile profile = new UserProfile();
          profile.setGender(true);
          profile.setCreatedDate(DateUtils.parseDate("2014/12/12", "yyyy/MM/dd"));

          User user = new User();
          user.setProfile(profile);
          user.setName("John");
          user.setCreatedDate(DateUtils.parseDate("2014/12/12", "yyyy/MM/dd"));
          dateMap.put("user", user);
          
          LocalUTCDateTransformer.transform(dateMap, Direction.TO_UTC);
          assertEquals(referDate, Dates.getLocalDate((Date)dateMap.get("date1")));
          assertEquals(referDate, Dates.getLocalDate((Date)dateMap.get("date2")));
          assertEquals(referDate, Dates.getLocalDate(((User)dateMap.get("user")).getCreatedDate()));
          
          LocalUTCDateTransformer.transform(dateMap, Direction.TO_LOCAL);
          assertEquals(referDate, dateMap.get("date1"));
          assertEquals(referDate, dateMap.get("date2"));
          assertEquals(referDate, ((User)dateMap.get("user")).getCreatedDate());
    }
    
    @Test
    public void testIsSimpleType() {
        assertTrue(LocalUTCDateTransformer.isSimpleType(1));
        assertTrue(LocalUTCDateTransformer.isSimpleType(true));
        assertTrue(LocalUTCDateTransformer.isSimpleType("abcd"));
        assertFalse(LocalUTCDateTransformer.isSimpleType(new User()));
    }

    @Test
    public void testIsSimpleType2() {
        assertTrue(LocalUTCDateTransformer.isSimpleType("abcd".getClass()));
        assertFalse(LocalUTCDateTransformer.isSimpleType((new User()).getClass()));
    }

    @Test
    public void testIsDateType() {
        assertFalse(LocalUTCDateTransformer.isDateType("abcd"));
        assertTrue(LocalUTCDateTransformer.isDateType(referDate));
    }

    @Test
    public void testIsDateType2() {
        assertFalse(LocalUTCDateTransformer.isDateType("abcd".getClass()));
        assertTrue(LocalUTCDateTransformer.isDateType(referDate.getClass()));
    }

    static class User {
        private String name;
        private Date createdDate;
        private UserProfile profile;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(Date createdDate) {
            this.createdDate = createdDate;
        }

        public UserProfile getProfile() {
            return profile;
        }

        public void setProfile(UserProfile profile) {
            this.profile = profile;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", createdDate=" + createdDate +
                    ", profile=" + profile +
                    '}';
        }
    }

    static class UserProfile {
        private boolean gender;
        private Date createdDate;

        public boolean isGender() {
            return gender;
        }

        public void setGender(boolean gender) {
            this.gender = gender;
        }

        public Date getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(Date createdDate) {
            this.createdDate = createdDate;
        }

        @Override
        public String toString() {
            return "UserProfile{" +
                    "gender=" + gender +
                    ", createdDate=" + createdDate +
                    '}';
        }
    }

}
