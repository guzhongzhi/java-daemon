package com.gulusoft.util;

import java.util.HashMap;

import java.util.HashMap;

public class QueryStringParser {
    public static String DEFAULT_ENCODING = "ISO8859-1";
    public static HashMap<String,String> parseStr(String queryString) {
        String[] params = queryString.split("&");
        HashMap<String, String> map = new HashMap<String, String>();
        for (String param : params)
        {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            String decodedValue = "";
            try {
                decodedValue = java.net.URLDecoder.decode(value, DEFAULT_ENCODING);
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            map.put(name, decodedValue);
        }
        return map;
    }
}
