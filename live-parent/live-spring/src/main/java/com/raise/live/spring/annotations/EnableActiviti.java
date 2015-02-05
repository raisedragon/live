package com.raise.live.spring.annotations;

import org.springframework.context.annotation.Import;

import com.raise.live.spring.components.config.annotations.ActivitiConfiguration;

import java.lang.annotation.*;

/**
 * @author Josh Long
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ActivitiConfiguration.class)
public @interface EnableActiviti {
}
