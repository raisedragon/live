package com.raise.generator;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.raise.generator.mode.Configuration;
import com.raise.generator.mode.ObjectFactory;

public class GeneratorParserTest extends GeneratorParser {

    // @Test
    public void testParse() throws IOException, JAXBException {
        GeneratorParser parser = new GeneratorParser();
        Configuration config = parser.parse();
        System.out.println(config);
        System.out.println(ToStringBuilder.reflectionToString(config.getEntity()));

    }

    // @Test
    public void t() throws IOException, JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(ObjectFactory.class);
        Marshaller marshaller = ctx.createMarshaller();
        Configuration config = new Configuration();
        marshaller.marshal(config, System.out);
        ;
    }

}
