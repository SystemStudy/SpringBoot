package com.Lirs.SpringBoot.common;

import java.util.UUID;

public class UuidUtil {

    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();

    }
}
