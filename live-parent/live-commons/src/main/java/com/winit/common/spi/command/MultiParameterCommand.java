/**
 * 
 */
package com.winit.common.spi.command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Liuye
 *
 */
public class MultiParameterCommand {
    private List<Parameter> parameters = new ArrayList<Parameter>();
    private Map<String, Integer> indexMap = new HashMap<String, Integer>();


    public void addParameter(String name, Object value) {
        if (indexMap.containsKey(name)) {
            Parameter parameter = parameters.get(indexMap.get(name));
            parameter.setValue(value);
        }
        else {
            Parameter parameter = new Parameter(name, value);
            parameters.add(parameter);
            indexMap.put(name, parameters.size() - 1);
        }
    }


    public Object getValue(String name) {
        if (indexMap.containsKey(name)) {
            Parameter parameter = parameters.get(indexMap.get(name));
            return parameter.getValue();
        }
        else {
            return null;
        }
    }

    public static class Parameter implements Serializable {
        private String name;
        private Object value;


        public Parameter(String name, Object value) {
            this.name = name;
            this.value = value;
        }


        public String getName() {
            return name;
        }


        public Object getValue() {
            return value;
        }


        public void setValue(Object value) {
            this.value = value;
        }

    }
}
