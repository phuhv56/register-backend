package com.mitrais.registerbackend.utils;

import java.util.Calendar;
import java.util.Date;

public class TimeUtils
{

    public static Date now() {
        return Calendar.getInstance().getTime();
    }
}
