package com.fujieid.jap.http.adapter.blade;

import com.blade.mvc.http.Session;
import com.fujieid.jap.http.JapHttpSession;

import java.util.Map;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */
public class BladeSessionAdapter implements JapHttpSession {

    private final Session session;

    public BladeSessionAdapter(Session session) {
        this.session = session;
    }

    /**
     * Returns the time when this session was created, measured in milliseconds since midnight January 1, 1970 GMT.
     *
     * @return a <code>long</code> specifying when this session was created, expressed in milliseconds since 1/1/1970
     * GMT
     */
    @Override
    public long getCreationTime() {
        return this.session.created();
    }

    /**
     * Returns a string containing the unique identifier assigned to this session. The identifier is assigned by the
     * servlet container and is implementation dependent.
     *
     * @return a string specifying the identifier assigned to this session
     */
    @Override
    public String getId() {
        return this.session.id();
    }

    /**
     * Returns the object bound with the specified name in this session, or <code>null</code> if no object is bound
     * under the name.
     *
     * @param name a string specifying the name of the object
     * @return the object with the specified name
     */
    @Override
    public Object getAttribute(String name) {
        return this.session.attribute(name);
    }

    /**
     * Binds an object to this session, using the name specified. If an object of the same name is already bound to the
     * session, the object is replaced.
     *
     * @param name  the name to which the object is bound; cannot be null
     * @param value the object to be bound; cannot be null
     */
    @Override
    public void setAttribute(String name, Object value) {
        this.session.attribute(name, value);
    }

    /**
     * Removes the object bound with the specified name from this session. If the session does not have an object bound
     * with the specified name, this method does nothing.
     *
     * @param name the name of the object to remove from this session
     */
    @Override
    public void removeAttribute(String name) {
        this.session.removeAttribute(name);
    }

    /**
     * Invalidates this session then unbinds any objects bound to it.
     */
    @Override
    public void invalidate() {
        Map<String, Object> map = this.session.attributes();
        if (null == map || map.isEmpty()) {
            return;
        }
        map.keySet().forEach(this.session::removeAttribute);
    }
}
