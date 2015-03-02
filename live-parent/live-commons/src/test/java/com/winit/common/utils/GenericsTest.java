package com.winit.common.utils;

import com.winit.common.utils.Generics;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuye on 2015/1/27.
 */
public class GenericsTest {

    @Test
    public void testGetSuperClassGenricType() {
        A a=new A();
        B<Address> b=new C();
        b.setBean(new Address());
        a.setBean(b);
        Class cls=Generics.getSuperClassGenricType(a.getBean().getClass());
        Assert.assertEquals(Address.class,cls);
    }

    @Test
    public void testGetSuperClassGenricType2() {
        A a=new A();
        B<Address> b=new C();
        b.setBean(new Address());
        a.setBean(b);
        Class cls=Generics.getSuperClassGenricType(a.getBean().getClass(),0);
        Assert.assertEquals(Address.class, cls);
    }

    @Test
    public void testGetMethodGenericReturnType() throws NoSuchMethodException {
        A a=new A();
        B<Address> b=new C();
        b.setBean(new Address());
        a.setBean(b);
        Method method=a.getClass().getMethod("getBean",null);

        Class cls=Generics.getMethodGenericReturnType(method);
        Assert.assertEquals(Address.class, cls);
    }

    @Test
    public void testGetMethodGenericReturnType2() throws NoSuchMethodException {
        A a=new A();
        B<Address> b=new C();
        b.setBean(new Address());
        a.setBean(b);
        Method method=a.getClass().getMethod("getBean",null);

        Class cls=Generics.getMethodGenericReturnType(method,0);
        Assert.assertEquals(Address.class, cls);
    }

    private static class A {
        private String name;
        private B<Address> bean;
        private List<Address> addresses;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public B<Address> getBean() {
            return bean;
        }

        public void setBean(B<Address> bean) {
            this.bean = bean;
        }

        public List<Address> getAddresses() {
            return addresses;
        }

        public void setAddresses(List<Address> addresses) {
            this.addresses = addresses;
        }
    }

    private static class B<T> {
        private T bean;

        public T getBean() {
            return bean;
        }

        public void setBean(T bean) {
            this.bean = bean;
        }
    }

    private static class C extends B<Address> {
    }
    private static class Address {
        private String zip;

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }
    }


}
