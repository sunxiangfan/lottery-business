package com.lottery.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {

    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (null == cookies || cookies.length == 0) {
            return null;
        }
        Cookie cookie = null;
        for (Cookie c : cookies) {
            if (name.equals(c.getName())) {
                cookie = c;
                break;
            }
        }
        return cookie;
    }
}
