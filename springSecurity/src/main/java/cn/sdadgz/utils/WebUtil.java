package cn.sdadgz.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 废物本物
 * </p>
 *
 * @author sdadgz
 * @since 2023/2/25 11:53:05
 */
public class WebUtil {
    public static void renderString(HttpServletResponse response, String str){
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
