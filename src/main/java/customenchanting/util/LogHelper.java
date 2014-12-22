package customenchanting.util;

import cpw.mods.fml.common.FMLLog;
import customenchanting.config.Settings;
import customenchanting.reference.Reference;
import org.apache.logging.log4j.Level;

public class LogHelper
{
    public static void log(String modId, Level level, Object message)
    {
        FMLLog.log(modId, level, String.valueOf(message));
    }

    public static void log(Level level, Object message)
    {
        log(Reference.ID, level, message);
    }

    public static void info(Object message)
    {
        log(Level.INFO, message);
    }

    public static void debugInfo(Object message)
    {
        if (Settings.debugMode) info(message);
        else debug(message);
    }

    public static void debug(Object message)
    {
        log(Level.DEBUG, message);
    }

    public static void warn(Object message)
    {
        log(Level.WARN, message);
    }

    public static void error(Object message)
    {
        log(Level.ERROR, message);
    }

    public static void fatal(Object message)
    {
        log(Level.FATAL, message);
    }

    public static void fatalWarning(Object message)
    {
        log(Level.FATAL, "-------------------------------------------------------------------------------------------");
        log(Level.FATAL, message);
        log(Level.FATAL, "-------------------------------------------------------------------------------------------");
    }
}
