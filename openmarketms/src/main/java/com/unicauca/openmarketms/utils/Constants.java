package com.unicauca.openmarketms.utils;

public class Constants {
    public final static String HOST_NAME = "localhost";     
    public final static String EXCHANGE_TYPE = "fanout";
    public final static String EXCHANGE_NAME1 = "EXCHANGE_CARTS";
    public final static String EXCHANGE_NAME2 = "EXCHANGE_DEL_ORDER";    
    public static void printStringList(String[] list) {         
        for (String item : list) {             
            System.out.println(item);         
        }     
    }
}
