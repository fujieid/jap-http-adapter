package com.fujieid.jap.http.jakarta;

import com.fujieid.jap.http.JapHttpResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */
public class JakartaResponseAdapter implements JapHttpResponse {

    private final HttpServletResponse response;

    public JakartaResponseAdapter(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * Get the actual source object
     *
     * @return Object
     */
    @Override
    public Object getSource() {
        return this.response;
    }

    /**
     * Delete cookie
     *
     * @param name cookie name
     * @return current response
     */
    @Override
    public JapHttpResponse delCookie(String name) {
        addCookie(null);
        return this;
    }

    /**
     * Add cookie
     *
     * @param name       name of the cookie.
     * @param value      value of this Cookie.
     * @param path       the path on the server to which the browser returns this cookie.
     * @param domain     domain name of this Cookie.
     * @param expiry     maximum age in seconds of this Cookie.
     * @param secure     send cookies only over a secure protocol, such as HTTPS or SSL.
     * @param isHttpOnly http only.
     * @return current response
     */
    @Override
    public JapHttpResponse addCookie(String name, String value, String path, String domain, int expiry, boolean secure, boolean isHttpOnly) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);
        cookie.setDomain(domain);
        cookie.setMaxAge(expiry);
        cookie.setSecure(secure);
        cookie.setHttpOnly(isHttpOnly);
        this.response.addCookie(cookie);
        return this;
    }

    /**
     * Set response status code
     *
     * @param status Response status code
     * @return current response
     */
    @Override
    public JapHttpResponse setStatus(int status) {
        this.response.setStatus(status);
        return this;
    }

    /**
     * Add response header
     *
     * @param name  name of the response header
     * @param value value of the response header
     * @return current response
     */
    @Override
    public JapHttpResponse addHeader(String name, String value) {
        this.response.addHeader(name, value);
        return this;
    }

    /**
     * Sets the content type of the response being sent to the client, if the response has not been committed yet. The
     * given content type may include a character encoding specification, for example,
     * <code>text/html;charset=UTF-8</code>. The response's character encoding is only set from the given content type
     * if this method is called before <code>getWriter</code> is called.
     *
     * @param contentType a <code>String</code> specifying the MIME type of the content
     * @return current response
     */
    @Override
    public JapHttpResponse setContentType(String contentType) {
        this.response.setContentType(contentType);
        return this;
    }

    /**
     * Sets the length of the content body in the response In HTTP servlets, this method sets the HTTP Content-Length
     * header.
     *
     * @param len an integer specifying the length of the content being returned to the client; sets the Content-Length
     *            header
     * @return current response
     */
    @Override
    public JapHttpResponse setContentLength(int len) {
        this.response.setContentLength(len);
        return this;
    }

    /**
     * Write HTML to the browser or web side
     *
     * @param html content
     */
    @Override
    public void write(String html) {
        try {
            this.response.getWriter().write(html);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the name of the character encoding (MIME charset) used for the body sent in this response
     * <p>
     * See RFC 2047 (http://www.ietf.org/rfc/rfc2047.txt) for more information about character encoding and MIME.
     *
     * @return a <code>String</code> specifying the name of the character encoding, for example, <code>UTF-8</code>
     */
    @Override
    public String getCharacterEncoding() {
        return this.response.getCharacterEncoding();
    }

    /**
     * Returns a {@link OutputStream} suitable for writing binary data in the response.
     *
     * @return a {@link OutputStream} for writing binary data
     * @throws IOException if an input or output exception occurred
     */
    @Override
    public OutputStream getOutputStream() throws IOException {
        return this.response.getOutputStream();
    }

    /**
     * Redirect to url
     *
     * @param url Redirect url
     */
    @Override
    public void redirect(String url) {
        try {
            this.response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
