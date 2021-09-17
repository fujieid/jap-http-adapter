package com.fujieid.jap.http.blade;

import com.blade.mvc.http.Cookie;
import com.fujieid.jap.http.JapHttpCookie;


/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */
public class BladeCookieAdapter extends JapHttpCookie {

    public BladeCookieAdapter(Object cookie) {
        super(cookie);
        Cookie bladeCookie = (Cookie) cookie;
        super.setDomain(bladeCookie.domain());
        super.setPath(bladeCookie.path());
        super.setName(bladeCookie.name());
        super.setValue(bladeCookie.value());
        super.setMaxAge((int) bladeCookie.maxAge());
        super.setSecure(bladeCookie.secure());
        super.setHttpOnly(bladeCookie.httpOnly());
    }

}
