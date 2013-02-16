package com.jg.hgsvn;

import com.jg.hgsvn.model.*;

import java.util.*;

/**
 *
 */
public class ParameterMap {

    Comparator<Parameter> comp = new Comparator<Parameter>() {
        public int compare(Parameter parameter, Parameter parameter1) {
            return parameter.getName().compareTo(parameter1.getName());
        }
    };


    private Map<String, Parameter> map = new HashMap<String, Parameter>();

    public ParameterMap(String... rawCommandTexts) {
        init(rawCommandTexts);
    }

    private void init(String... rawCommandTexts) {
        for (String rawCommandText : rawCommandTexts) {
            extractParameters(rawCommandText);
        }
    }

    private void extractParameters(String text) {
        if (text == null || text.trim().length() == 0) {
            return;
        }

        StringBuilder sbParam = new StringBuilder();
        boolean readingParam = false;
        int index = 0;
        while (index < text.length()) {
            char c = text.charAt(index++);
            if (c == '[') {
                readingParam = true;
            }
            else if (c == ']') {
                String name = sbParam.toString();
                map.put(name, new Parameter(name, null));
                sbParam = new StringBuilder();
                readingParam = false;
            }
            else if (readingParam) {
                sbParam.append(c);
            }
        }
    }


    public List<Parameter> getParamList() {
        List<Parameter> list = new ArrayList<Parameter>(map.values());
        Collections.sort(list, comp);
        return list;
    }

    public boolean contains(Parameter p) {
        return map.containsKey(p.getName());
    }


    public void put(Parameter p) {
        map.put(p.getName(), p);
    }

    public Parameter get(String paramName) {
        return map.get(paramName);
    }
}
