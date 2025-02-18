package http;

import util.DateTimeUtil;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Aneureka
 * @createdAt 2019-12-15 17:26
 * @description
 **/
public class HttpHeaders {

    public static final HttpHeaders defaultHeaders = new HttpHeaders();

    private Map<String, String> headers = new HashMap<>();

    public HttpHeaders() {
        headers.put(Names.DATE, DateTimeUtil.dateTimeToGMTString(LocalDateTime.now()));
        headers.put(Names.CONTENT_LENGTH, String.valueOf(0));
    }

    public HttpHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public static String getHeader(HttpMessage message, String name) {
        return message.headers().get(name);
    }

    public static void setHeader(HttpMessage message, String name, String value) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name is not exist");
        }

        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("value is not exist");
        }
        message.headers().set(name.trim(), value.trim());
    }

    public static void addHeader(HttpMessage message, String name, String value) {
        HttpHeaders.setHeader(message, name, value);
    }

    public static void removeHeader(HttpMessage message, String name) {
        message.headers().remove(name);
    }

    public static void clearHeaders(HttpMessage message) {
        message.headers().clear();
    }

    public static boolean hasContentLength(HttpMessage message) {
        return message.headers().containsContentLength();
    }

    public static boolean isChunkTransfer(HttpMessage message) {
        return message.headers().isChunkTransfer();
    }

    public static int getContentLength(HttpMessage message) {
        String length = message.headers().get(HttpHeaders.Names.CONTENT_LENGTH);
        if (length == null) {
            throw new IllegalArgumentException(HttpHeaders.Names.CONTENT_LENGTH + " is not exist");
        }
        return Integer.parseInt(length);
    }

    public String get(String name) {
        return headers.get(name);
    }

    public void set(String name, String value) {
        headers.put(name, value);
    }

    public void remove(String name) {
        headers.remove(name);
    }

    public void clear() {
        headers.clear();
    }

    public boolean containsValue(String name, String value, boolean ignoreCase) {
        if (ignoreCase) {
            for (String key : headers.keySet()) {
                if (name.equalsIgnoreCase(key) && value.equalsIgnoreCase(headers.get(key))) {
                    return true;
                }
            }
        } else {
            for (String key : headers.keySet()) {
                if (name.equals(key) && value.equals(headers.get(key))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsContentLength() {
        return headers.containsKey(HttpHeaders.Names.CONTENT_LENGTH);
    }

    public boolean isChunkTransfer() {
        String value = headers.get(HttpHeaders.Names.TRANSFER_ENCODING);
        if (value == null || value.isEmpty()) {
            return false;
        }
        return value.equalsIgnoreCase("chunked");
    }

    public Iterator<Map.Entry<String, String>> headersIterator() {
        return headers.entrySet().iterator();
    }

    /**
     * Standard HTTP header names.
     */
    public static final class Names {
        public static final String ACCEPT = "Accept";
        public static final String ACCEPT_CHARSET = "Accept-Charset";
        public static final String ACCEPT_ENCODING = "Accept-Encoding";
        public static final String ACCEPT_LANGUAGE = "Accept-Language";
        public static final String ACCEPT_RANGES = "Accept-Ranges";
        public static final String ACCEPT_PATCH = "Accept-Patch";
        public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
        public static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
        public static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
        public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
        public static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
        public static final String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";
        public static final String ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-http.Request-Headers";
        public static final String ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-http.Request-Method";
        public static final String AGE = "Age";
        public static final String ALLOW = "Allow";
        public static final String AUTHORIZATION = "Authorization";
        public static final String CACHE_CONTROL = "Cache-Control";
        public static final String CONNECTION = "Connection";
        public static final String CONTENT_BASE = "Content-Base";
        public static final String CONTENT_ENCODING = "Content-Encoding";
        public static final String CONTENT_LANGUAGE = "Content-Language";
        public static final String CONTENT_LENGTH = "Content-Length";
        public static final String CONTENT_LOCATION = "Content-Location";
        public static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding";
        public static final String CONTENT_MD5 = "Content-MD5";
        public static final String CONTENT_RANGE = "Content-Range";
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String COOKIE = "Cookie";
        public static final String DATE = "Date";
        public static final String ETAG = "ETag";
        public static final String EXPECT = "Expect";
        public static final String EXPIRES = "Expires";
        public static final String FROM = "From";
        public static final String HOST = "Host";
        public static final String IF_MATCH = "If-Match";
        public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
        public static final String IF_NONE_MATCH = "If-None-Match";
        public static final String IF_RANGE = "If-Range";
        public static final String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
        public static final String LAST_MODIFIED = "Last-Modified";
        public static final String LOCATION = "Location";
        public static final String MAX_FORWARDS = "Max-Forwards";
        public static final String ORIGIN = "Origin";
        public static final String PRAGMA = "Pragma";
        public static final String PROXY_AUTHENTICATE = "Proxy-Authenticate";
        public static final String PROXY_AUTHORIZATION = "Proxy-Authorization";
        public static final String RANGE = "Range";
        public static final String REFERER = "Referer";
        public static final String RETRY_AFTER = "Retry-After";
        public static final String SEC_WEBSOCKET_KEY1 = "Sec-WebSocket-Key1";
        public static final String SEC_WEBSOCKET_KEY2 = "Sec-WebSocket-Key2";
        public static final String SEC_WEBSOCKET_LOCATION = "Sec-WebSocket-Location";
        public static final String SEC_WEBSOCKET_ORIGIN = "Sec-WebSocket-Origin";
        public static final String SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
        public static final String SEC_WEBSOCKET_VERSION = "Sec-WebSocket-Version";
        public static final String SEC_WEBSOCKET_KEY = "Sec-WebSocket-Key";
        public static final String SEC_WEBSOCKET_ACCEPT = "Sec-WebSocket-Accept";
        public static final String SERVER = "Server";
        public static final String SET_COOKIE = "Set-Cookie";
        public static final String SET_COOKIE2 = "Set-Cookie2";
        public static final String TE = "TE";
        public static final String TRAILER = "Trailer";
        public static final String TRANSFER_ENCODING = "Transfer-Encoding";
        public static final String UPGRADE = "Upgrade";
        public static final String USER_AGENT = "User-Agent";
        public static final String VARY = "Vary";
        public static final String VIA = "Via";
        public static final String WARNING = "Warning";
        public static final String WEBSOCKET_LOCATION = "WebSocket-Location";
        public static final String WEBSOCKET_ORIGIN = "WebSocket-Origin";
        public static final String WEBSOCKET_PROTOCOL = "WebSocket-Protocol";
        public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
    }

    /**
     * Standard HTTP header values.
     */
    public static final class Values {
        public static final String APPLICATION_JSON = "application/json";
        public static final String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
        public static final String BASE64 = "base64";
        public static final String BINARY = "binary";
        public static final String BOUNDARY = "boundary";
        public static final String BYTES = "bytes";
        public static final String CHARSET = "charset";
        public static final String CHUNKED = "chunked";
        public static final String CLOSE = "close";
        public static final String COMPRESS = "compress";
        public static final String CONTINUE = "100-continue";
        public static final String DEFLATE = "deflate";
        public static final String GZIP = "gzip";
        public static final String GZIP_DEFLATE = "gzip,deflate";
        public static final String IDENTITY = "identity";
        public static final String KEEP_ALIVE = "keep-alive";
        public static final String MAX_AGE = "max-age";
        public static final String MAX_STALE = "max-stale";
        public static final String MIN_FRESH = "min-fresh";
        public static final String MULTIPART_FORM_DATA = "multipart/form-data";
        public static final String MUST_REVALIDATE = "must-revalidate";
        public static final String NO_CACHE = "no-cache";
        public static final String NO_STORE = "no-store";
        public static final String NO_TRANSFORM = "no-transform";
        public static final String NONE = "none";
        public static final String ONLY_IF_CACHED = "only-if-cached";
        public static final String PRIVATE = "private";
        public static final String PROXY_REVALIDATE = "proxy-revalidate";
        public static final String PUBLIC = "public";
        public static final String QUOTED_PRINTABLE = "quoted-printable";
        public static final String S_MAXAGE = "s-maxage";
        public static final String TRAILERS = "trailers";
        public static final String UPGRADE = "Upgrade";
        public static final String WEBSOCKET = "WebSocket";
    }
}
