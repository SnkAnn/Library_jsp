package by.fpmibsu.LIBRARY.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JspHelper {
    private static final String JSP_FORMAT = "/JSP/%s.jsp";

    public static String getPath(String jspName){
        return String.format(JSP_FORMAT, jspName);
    }
}