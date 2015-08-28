package com.raise.generator.freemarker;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
public class FreemarkEngine {

    // 配置来自app-resources.xml
    @Autowired
    private Configuration configuration;

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 把指定的模板生成对应的字符串。
     * 
     * @param templateName 模板名
     * @param model 传入数据对象。
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    public String parse(String templateName, Object model) throws IOException, TemplateException {

        Template template = configuration.getTemplate(templateName);
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
    }
}
