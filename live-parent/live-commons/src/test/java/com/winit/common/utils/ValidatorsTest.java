package com.winit.common.utils;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by liuye on 2015/2/6.
 */
public class ValidatorsTest {
    @Test
    public void testValidateEmail(){
        String email="abc@abc.com";
        Assert.assertTrue(Validators.validateEmail(email));
        String notEmail="abc";
        Assert.assertFalse(Validators.validateEmail(notEmail));
        String notEmail2="abc@";
        Assert.assertFalse(Validators.validateEmail(notEmail2));
    }

    @Test
    public void testValidateOnlyAlphabets(){
        String str="abc";
        Assert.assertTrue(Validators.validateOnlyAlphabets(str));
        str="12345";
        Assert.assertFalse(Validators.validateOnlyAlphabets(str));
        str="abc123";
        Assert.assertFalse(Validators.validateOnlyAlphabets(str));
        str="abc123/";
        Assert.assertFalse(Validators.validateOnlyAlphabets(str));
        str="abc 123";
        Assert.assertFalse(Validators.validateOnlyAlphabets(str));
        str="abcdef\n";
        Assert.assertFalse(Validators.validateOnlyAlphabets(str));
    }

    @Test
    public void TestValidateOnlyAlphabetsAndWhiteSpaces(){
        String str="abc";
        Assert.assertTrue(Validators.validateOnlyAlphabetsAndWhiteSpaces(str));
        str="12345";
        Assert.assertFalse(Validators.validateOnlyAlphabetsAndWhiteSpaces(str));
        str="abc123";
        Assert.assertFalse(Validators.validateOnlyAlphabetsAndWhiteSpaces(str));
        str="abc123/";
        Assert.assertFalse(Validators.validateOnlyAlphabetsAndWhiteSpaces(str));
        str="abcdef\n";
        Assert.assertTrue(Validators.validateOnlyAlphabetsAndWhiteSpaces(str));
    }

    @Test
    public void TestValidateOnlyAlphaNumericAndWhiteSpaces(){
        String str="abc";
        Assert.assertTrue(Validators.validateOnlyAlphaNumericAndWhiteSpaces(str));
        str="12345";
        Assert.assertTrue(Validators.validateOnlyAlphaNumericAndWhiteSpaces(str));
        str="abc123";
        Assert.assertTrue(Validators.validateOnlyAlphaNumericAndWhiteSpaces(str));
        str="abc123/";
        Assert.assertFalse(Validators.validateOnlyAlphaNumericAndWhiteSpaces(str));
        str="abcdef\n";
        Assert.assertTrue(Validators.validateOnlyAlphaNumericAndWhiteSpaces(str));
        str="abcdef123\n123";
        Assert.assertTrue(Validators.validateOnlyAlphaNumericAndWhiteSpaces(str));
    }

    @Test
    public void TestValidateOnlyDigits(){
        String str="abc";
        Assert.assertFalse(Validators.validateOnlyDigits(str));
        str="12345";
        Assert.assertTrue(Validators.validateOnlyDigits(str));
        str="abc123";
        Assert.assertFalse(Validators.validateOnlyDigits(str));
        str="abc123/";
        Assert.assertFalse(Validators.validateOnlyDigits(str));
        str="abcdef\n";
        Assert.assertFalse(Validators.validateOnlyDigits(str));
        str="abcdef123\n123";
        Assert.assertFalse(Validators.validateOnlyDigits(str));
    }

    @Test
    public void TestValidateNonDigits(){
        String str="abc";
        Assert.assertTrue(Validators.validateNonDigits(str));
        str="12345";
        Assert.assertFalse(Validators.validateNonDigits(str));
        str="abc123";
        Assert.assertFalse(Validators.validateNonDigits(str));
        str="abc123/";
        Assert.assertFalse(Validators.validateNonDigits(str));
        str="abcdef\n";
        Assert.assertTrue(Validators.validateNonDigits(str));
        str="abcdef123\n123";
        Assert.assertFalse(Validators.validateNonDigits(str));
    }

    @Test
    public void testValidateAlphaNumeric(){
        String str="abc";
        Assert.assertTrue(Validators.validateAlphaNumeric(str));
        str="12345";
        Assert.assertTrue(Validators.validateAlphaNumeric(str));
        str="abc123";
        Assert.assertTrue(Validators.validateAlphaNumeric(str));
        str="abc123/";
        Assert.assertFalse(Validators.validateAlphaNumeric(str));
        str="abcdef\n";
        Assert.assertFalse(Validators.validateAlphaNumeric(str));
        str="abcdef123\n123";
        Assert.assertFalse(Validators.validateAlphaNumeric(str));
    }

    @Test
    public void testValidateAlphabetsAndDots(){
        String str="abc";
        Assert.assertTrue(Validators.validateAlphabetsAndDots(str));
        str="12345";
        Assert.assertFalse(Validators.validateAlphabetsAndDots(str));
        str="abc123";
        Assert.assertFalse(Validators.validateAlphabetsAndDots(str));
        str="abc.";
        Assert.assertTrue(Validators.validateAlphabetsAndDots(str));
        str="abcdef\n";
        Assert.assertFalse(Validators.validateAlphabetsAndDots(str));
        str="abcdef123\n123";
        Assert.assertFalse(Validators.validateAlphabetsAndDots(str));
    }

    @Test
    public void testValidateCharacters(){
        String str="abc";
        Assert.assertFalse(Validators.validateCharacters(str));
        str="1234578";
        Assert.assertFalse(Validators.validateCharacters(str));
        str="abc123";
        Assert.assertFalse(Validators.validateCharacters(str));
        str="abc.";
        Assert.assertFalse(Validators.validateCharacters(str));
        str="abcdef\n";
        Assert.assertFalse(Validators.validateCharacters(str));
        str="abcdef123\n123";
        Assert.assertFalse(Validators.validateCharacters(str));
    }

    @Test
    public void testValidateNineDigits(){
        String str="abc";
        Assert.assertFalse(Validators.validateNineDigits(str));
        str="1234578";
        Assert.assertFalse(Validators.validateNineDigits(str));
        str="abc123";
        Assert.assertFalse(Validators.validateNineDigits(str));
        str="abc.";
        Assert.assertFalse(Validators.validateNineDigits(str));
        str="abcdef\n";
        Assert.assertFalse(Validators.validateNineDigits(str));
        str="abcdef123\n123";
        Assert.assertFalse(Validators.validateNineDigits(str));
    }
}
