package com.winit.common.utils;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Collecitons3Test {
    @Test
    public void testExtractToMap(){
        Collection<TestBean3> list=new ArrayList<TestBean3>();
        list.add(new TestBean3(1,"abc"));
        list.add(new TestBean3(2,"xyz"));
        Map<Integer,String> map=Collections3.extractToMap(list,"id","name");
        assertFalse(Collections3.isEmpty(map));
        assertEquals(2,map.size());
    }

    @Test
    public void testExtractToListp(){
        Collection<TestBean3> list=new ArrayList<TestBean3>();
        list.add(new TestBean3(1,"abc"));
        list.add(new TestBean3(2,"xyz"));
        List<String> list2=Collections3.extractToList(list,"name");
        assertFalse(Collections3.isEmpty(list2));
        assertEquals(2, list2.size());
    }

    @Test
    public void convertElementPropertyToString() {
        TestBean3 bean1 = new TestBean3();
        bean1.setId(1);
        TestBean3 bean2 = new TestBean3();
        bean2.setId(2);

        List list = Lists.newArrayList(bean1, bean2);

        assertThat(Collections3.extractToString(list, "id", ",")).isEqualTo("1,2");
    }

    @Test
    public void convertElementPropertyToList() {
        TestBean3 bean1 = new TestBean3();
        bean1.setId(1);
        TestBean3 bean2 = new TestBean3();
        bean2.setId(2);

        List list = Lists.newArrayList(bean1, bean2);
        List result = Collections3.extractToList(list, "id");
        assertThat(result).containsOnly(1, 2);
    }

    @Test
    public void convertCollectionToString() {
        List<String> list = Lists.newArrayList("aa", "bb");
        String result = Collections3.convertToString(list, ",");
        assertThat(result).isEqualTo("aa,bb");

        result = Collections3.convertToString(list, "<li>", "</li>");
        assertThat(result).isEqualTo("<li>aa</li><li>bb</li>");
    }



    @Test
    public void testIsCollection(){
        assertTrue(Collections3.isCollectionType(new ArrayList()));
        assertFalse(Collections3.isCollectionType(new TestBean3()));
    }
    @Test
    public void testIsCollection2(){
        assertTrue(Collections3.isCollectionType((new ArrayList()).getClass()));
        assertFalse(Collections3.isCollectionType((new TestBean3()).getClass()));
    }
    @Test
    public void testIsMap(){
        assertTrue(Collections3.isMapType((new HashMap())));
        assertFalse(Collections3.isMapType((new TestBean3())));
    }
    @Test
    public void testIsMap2(){
        assertTrue(Collections3.isMapType((new HashMap()).getClass()));
        assertFalse(Collections3.isMapType((new TestBean3()).getClass()));
    }

    @Test
    public void testIsEmpty(){
        Collection<String> list=new HashSet<String>();
        assertTrue(Collections3.isEmpty(list));
        assertFalse(Collections3.isNotEmpty(list));
        list.add("abc");
        assertFalse(Collections3.isEmpty(list));
        assertTrue(Collections3.isNotEmpty(list));

        Collection<String> set=new HashSet<String>();
        assertTrue(Collections3.isEmpty(set));
        assertFalse(Collections3.isNotEmpty(set));
        set.add("abc");
        assertFalse(Collections3.isEmpty(set));
        assertTrue(Collections3.isNotEmpty(set));
    }

    @Test
    public void testIsEmpty2(){
        Map<String,String> map=new HashMap<String,String>();
        assertTrue(Collections3.isEmpty(map));
        map.put("abc", "abc");
        assertFalse(Collections3.isEmpty(map));
    }

    @Test
    public void testGetLastAndFirst(){
        Collection<String> list=new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        assertEquals("1", Collections3.getFirst(list));
        assertEquals("5", Collections3.getLast(list));
    }

    @Test
    public void testUnion(){
        Collection<String> list1=new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        Collection<String> list2=new ArrayList<String>();
        list2.add("3");
        list2.add("4");
        list2.add("5");
        Collection<String> list3=Collections3.union(list1,list2);
        assertTrue(list1.size() + list2.size() == list3.size());
    }

    @Test
    public void testSubtract(){
        List<String> list1=new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        List<String> list2=new ArrayList<String>();
        list2.add("1");
        list2.add("3");
        list2.add("5");
        List<String> list3=Collections3.subtract(list1, list2);
        assertTrue(list3.size()==1);
        assertEquals("2",list3.get(0));
    }

    @Test
    public void testIntersection(){
        List<String> list1=new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        List<String> list2=new ArrayList<String>();
        list2.add("1");
        list2.add("3");
        list2.add("5");
        List<String> list3=Collections3.intersection(list1, list2);
        assertTrue(list3.size()==1);
        assertEquals("1",list3.get(0));
    }

    public static class TestBean3 {

        private int id;

        private String name;

        public TestBean3() {
        }

        public TestBean3(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
