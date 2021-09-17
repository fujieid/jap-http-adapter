/*
 * Copyright (c) 2020-2040, 北京符节科技有限公司 (support@fujieid.com & https://www.fujieid.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
