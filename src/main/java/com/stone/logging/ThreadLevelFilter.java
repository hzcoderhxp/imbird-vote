package com.stone.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.Marker;

/**
 * Created by chenghao on 10/10/16.
 */

public class ThreadLevelFilter extends TurboFilter {
    private static ThreadLocal<Level> threadLocal=new ThreadLocal<>();

    public static void setLevel(Level level){
        threadLocal.set(level);
    }

    @Override
    public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
        Level threadLevel=threadLocal.get();
        if(threadLevel!=null && level.levelInt<threadLevel.levelInt)
            return FilterReply.DENY;
        return FilterReply.NEUTRAL;
    }
}
