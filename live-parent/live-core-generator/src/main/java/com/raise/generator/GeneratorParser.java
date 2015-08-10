package com.raise.generator;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.raise.generator.mode.Configuration;
import com.raise.generator.mode.ObjectFactory;


public class GeneratorParser {

    public Configuration parse() throws IOException, JAXBException {
        String file = "conf/generator/configuration.xml";
        Resource resource = new ClassPathResource(file);
        InputStream is = resource.getInputStream();
        JAXBContext ctx = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        Configuration configuration = ((JAXBElement<Configuration>) unmarshaller.unmarshal(is)).getValue();
        return configuration;
    }
}
