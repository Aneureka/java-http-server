package http;

import org.jetbrains.annotations.NotNull;

import static java.lang.Integer.parseInt;

/**
 * @author Aneureka
 * @createdAt 2019-12-20 09:44
 * @description
 **/
public class HttpStatus implements Comparable<HttpStatus> {

    /**
     * 100 Continue
     */
    public static final HttpStatus CONTINUE = newStatus(100, "Continue");

    /**
     * 101 Switching Protocols
     */
    public static final HttpStatus SWITCHING_PROTOCOLS = newStatus(101, "Switching Protocols");

    /**
     * 102 Processing (WebDAV, RFC2518)
     */
    public static final HttpStatus PROCESSING = newStatus(102, "Processing");

    /**
     * 200 OK
     */
    public static final HttpStatus OK = newStatus(200, "OK");

    /**
     * 201 Created
     */
    public static final HttpStatus CREATED = newStatus(201, "Created");

    /**
     * 202 Accepted
     */
    public static final HttpStatus ACCEPTED = newStatus(202, "Accepted");

    /**
     * 203 Non-Authoritative Information (since HTTP/1.1)
     */
    public static final HttpStatus NON_AUTHORITATIVE_INFORMATION =
            newStatus(203, "Non-Authoritative Information");

    /**
     * 204 No Content
     */
    public static final HttpStatus NO_CONTENT = newStatus(204, "No Content");

    /**
     * 205 Reset Content
     */
    public static final HttpStatus RESET_CONTENT = newStatus(205, "Reset Content");

    /**
     * 206 Partial Content
     */
    public static final HttpStatus PARTIAL_CONTENT = newStatus(206, "Partial Content");

    /**
     * 207 Multi-Status (WebDAV, RFC2518)
     */
    public static final HttpStatus MULTI_STATUS = newStatus(207, "Multi-Status");

    /**
     * 300 Multiple Choices
     */
    public static final HttpStatus MULTIPLE_CHOICES = newStatus(300, "Multiple Choices");

    /**
     * 301 Moved Permanently
     */
    public static final HttpStatus MOVED_PERMANENTLY = newStatus(301, "Moved Permanently");

    /**
     * 302 Found
     */
    public static final HttpStatus FOUND = newStatus(302, "Found");

    /**
     * 303 See Other (since HTTP/1.1)
     */
    public static final HttpStatus SEE_OTHER = newStatus(303, "See Other");

    /**
     * 304 Not Modified
     */
    public static final HttpStatus NOT_MODIFIED = newStatus(304, "Not Modified");

    /**
     * 305 Use Proxy (since HTTP/1.1)
     */
    public static final HttpStatus USE_PROXY = newStatus(305, "Use Proxy");

    /**
     * 307 Temporary Redirect (since HTTP/1.1)
     */
    public static final HttpStatus TEMPORARY_REDIRECT = newStatus(307, "Temporary Redirect");

    /**
     * 308 Permanent Redirect (RFC7538)
     */
    public static final HttpStatus PERMANENT_REDIRECT = newStatus(308, "Permanent Redirect");

    /**
     * 400 Bad Request
     */
    public static final HttpStatus BAD_REQUEST = newStatus(400, "Bad Request");

    /**
     * 401 Unauthorized
     */
    public static final HttpStatus UNAUTHORIZED = newStatus(401, "Unauthorized");

    /**
     * 402 Payment Required
     */
    public static final HttpStatus PAYMENT_REQUIRED = newStatus(402, "Payment Required");

    /**
     * 403 Forbidden
     */
    public static final HttpStatus FORBIDDEN = newStatus(403, "Forbidden");

    /**
     * 404 Not Found
     */
    public static final HttpStatus NOT_FOUND = newStatus(404, "Not Found");

    /**
     * 405 Method Not Allowed
     */
    public static final HttpStatus METHOD_NOT_ALLOWED = newStatus(405, "Method Not Allowed");

    /**
     * 406 Not Acceptable
     */
    public static final HttpStatus NOT_ACCEPTABLE = newStatus(406, "Not Acceptable");

    /**
     * 407 Proxy Authentication Required
     */
    public static final HttpStatus PROXY_AUTHENTICATION_REQUIRED =
            newStatus(407, "Proxy Authentication Required");

    /**
     * 408 Request Timeout
     */
    public static final HttpStatus REQUEST_TIMEOUT = newStatus(408, "Request Timeout");

    /**
     * 409 Conflict
     */
    public static final HttpStatus CONFLICT = newStatus(409, "Conflict");

    /**
     * 410 Gone
     */
    public static final HttpStatus GONE = newStatus(410, "Gone");

    /**
     * 411 Length Required
     */
    public static final HttpStatus LENGTH_REQUIRED = newStatus(411, "Length Required");

    /**
     * 412 Precondition Failed
     */
    public static final HttpStatus PRECONDITION_FAILED = newStatus(412, "Precondition Failed");

    /**
     * 413 Request Entity Too Large
     */
    public static final HttpStatus REQUEST_ENTITY_TOO_LARGE =
            newStatus(413, "Request Entity Too Large");

    /**
     * 414 Request-URI Too Long
     */
    public static final HttpStatus REQUEST_URI_TOO_LONG = newStatus(414, "Request-URI Too Long");

    /**
     * 415 Unsupported Media Type
     */
    public static final HttpStatus UNSUPPORTED_MEDIA_TYPE = newStatus(415, "Unsupported Media Type");

    /**
     * 416 Requested Range Not Satisfiable
     */
    public static final HttpStatus REQUESTED_RANGE_NOT_SATISFIABLE =
            newStatus(416, "Requested Range Not Satisfiable");

    /**
     * 417 Expectation Failed
     */
    public static final HttpStatus EXPECTATION_FAILED = newStatus(417, "Expectation Failed");

    /**
     * 421 Misdirected Request
     *
     * @see <a href="https://tools.ietf.org/html/rfc7540#section-9.1.2">421 (Misdirected Request) Status Code</a>
     */
    public static final HttpStatus MISDIRECTED_REQUEST = newStatus(421, "Misdirected Request");

    /**
     * 422 Unprocessable Entity (WebDAV, RFC4918)
     */
    public static final HttpStatus UNPROCESSABLE_ENTITY = newStatus(422, "Unprocessable Entity");

    /**
     * 423 Locked (WebDAV, RFC4918)
     */
    public static final HttpStatus LOCKED = newStatus(423, "Locked");

    /**
     * 424 Failed Dependency (WebDAV, RFC4918)
     */
    public static final HttpStatus FAILED_DEPENDENCY = newStatus(424, "Failed Dependency");

    /**
     * 425 Unordered Collection (WebDAV, RFC3648)
     */
    public static final HttpStatus UNORDERED_COLLECTION = newStatus(425, "Unordered Collection");

    /**
     * 426 Upgrade Required (RFC2817)
     */
    public static final HttpStatus UPGRADE_REQUIRED = newStatus(426, "Upgrade Required");

    /**
     * 428 Precondition Required (RFC6585)
     */
    public static final HttpStatus PRECONDITION_REQUIRED = newStatus(428, "Precondition Required");

    /**
     * 429 Too Many Requests (RFC6585)
     */
    public static final HttpStatus TOO_MANY_REQUESTS = newStatus(429, "Too Many Requests");

    /**
     * 431 Request Header Fields Too Large (RFC6585)
     */
    public static final HttpStatus REQUEST_HEADER_FIELDS_TOO_LARGE =
            newStatus(431, "Request Header Fields Too Large");

    /**
     * 500 Internal Server Error
     */
    public static final HttpStatus INTERNAL_SERVER_ERROR = newStatus(500, "Internal Server Error");

    /**
     * 501 Not Implemented
     */
    public static final HttpStatus NOT_IMPLEMENTED = newStatus(501, "Not Implemented");

    /**
     * 502 Bad Gateway
     */
    public static final HttpStatus BAD_GATEWAY = newStatus(502, "Bad Gateway");

    /**
     * 503 Service Unavailable
     */
    public static final HttpStatus SERVICE_UNAVAILABLE = newStatus(503, "Service Unavailable");

    /**
     * 504 Gateway Timeout
     */
    public static final HttpStatus GATEWAY_TIMEOUT = newStatus(504, "Gateway Timeout");

    /**
     * 505 HTTP Version Not Supported
     */
    public static final HttpStatus HTTP_VERSION_NOT_SUPPORTED =
            newStatus(505, "HTTP Version Not Supported");

    /**
     * 506 Variant Also Negotiates (RFC2295)
     */
    public static final HttpStatus VARIANT_ALSO_NEGOTIATES = newStatus(506, "Variant Also Negotiates");

    /**
     * 507 Insufficient Storage (WebDAV, RFC4918)
     */
    public static final HttpStatus INSUFFICIENT_STORAGE = newStatus(507, "Insufficient Storage");

    /**
     * 510 Not Extended (RFC2774)
     */
    public static final HttpStatus NOT_EXTENDED = newStatus(510, "Not Extended");

    /**
     * 511 Network Authentication Required (RFC6585)
     */
    public static final HttpStatus NETWORK_AUTHENTICATION_REQUIRED =
            newStatus(511, "Network Authentication Required");
    private final int code;

    private final String reasonPhrase;

    private final static String DEFAULT_REASON_PHRASE = "Reason Not Specified";

    private HttpStatus(int code) {
        this(code, DEFAULT_REASON_PHRASE);
    }

    private HttpStatus(int code, String reasonPhrase) {
        if (code < 0) {
            throw new IllegalArgumentException("code:" + code + " is invalid");
        }
        if (reasonPhrase == null || reasonPhrase.isEmpty()) {
            throw new IllegalArgumentException("reasonPhrase is invalid" + reasonPhrase);
        }
        for (int i = 0; i < reasonPhrase.length(); i++) {
            char c = reasonPhrase.charAt(i);
            switch (c) {
                case '\n':
                case '\r':
                    throw new IllegalArgumentException(
                            "reasonPhrase contains one of the following prohibited characters: " +
                                    "\\r\\n: " + reasonPhrase);
            }
        }
        this.code = code;
        this.reasonPhrase = reasonPhrase;
    }

    private static HttpStatus newStatus(int statusCode, String reasonPhrase) {
        return new HttpStatus(statusCode, reasonPhrase);
    }

    private static HttpStatus valueOf(int code, String reasonPhrase) {
        HttpStatus status = valueOf(code);
        if (status.reasonPhrase.equals(DEFAULT_REASON_PHRASE)) {
            status = new HttpStatus(code, reasonPhrase);
        }
        return status;
    }

    public static HttpStatus valueOf(int code) {
        switch (code) {
            case 100:
                return CONTINUE;
            case 101:
                return SWITCHING_PROTOCOLS;
            case 102:
                return PROCESSING;
            case 200:
                return OK;
            case 201:
                return CREATED;
            case 202:
                return ACCEPTED;
            case 203:
                return NON_AUTHORITATIVE_INFORMATION;
            case 204:
                return NO_CONTENT;
            case 205:
                return RESET_CONTENT;
            case 206:
                return PARTIAL_CONTENT;
            case 207:
                return MULTI_STATUS;
            case 300:
                return MULTIPLE_CHOICES;
            case 301:
                return MOVED_PERMANENTLY;
            case 302:
                return FOUND;
            case 303:
                return SEE_OTHER;
            case 304:
                return NOT_MODIFIED;
            case 305:
                return USE_PROXY;
            case 307:
                return TEMPORARY_REDIRECT;
            case 308:
                return PERMANENT_REDIRECT;
            case 400:
                return BAD_REQUEST;
            case 401:
                return UNAUTHORIZED;
            case 402:
                return PAYMENT_REQUIRED;
            case 403:
                return FORBIDDEN;
            case 404:
                return NOT_FOUND;
            case 405:
                return METHOD_NOT_ALLOWED;
            case 406:
                return NOT_ACCEPTABLE;
            case 407:
                return PROXY_AUTHENTICATION_REQUIRED;
            case 408:
                return REQUEST_TIMEOUT;
            case 409:
                return CONFLICT;
            case 410:
                return GONE;
            case 411:
                return LENGTH_REQUIRED;
            case 412:
                return PRECONDITION_FAILED;
            case 413:
                return REQUEST_ENTITY_TOO_LARGE;
            case 414:
                return REQUEST_URI_TOO_LONG;
            case 415:
                return UNSUPPORTED_MEDIA_TYPE;
            case 416:
                return REQUESTED_RANGE_NOT_SATISFIABLE;
            case 417:
                return EXPECTATION_FAILED;
            case 421:
                return MISDIRECTED_REQUEST;
            case 422:
                return UNPROCESSABLE_ENTITY;
            case 423:
                return LOCKED;
            case 424:
                return FAILED_DEPENDENCY;
            case 425:
                return UNORDERED_COLLECTION;
            case 426:
                return UPGRADE_REQUIRED;
            case 428:
                return PRECONDITION_REQUIRED;
            case 429:
                return TOO_MANY_REQUESTS;
            case 431:
                return REQUEST_HEADER_FIELDS_TOO_LARGE;
            case 500:
                return INTERNAL_SERVER_ERROR;
            case 501:
                return NOT_IMPLEMENTED;
            case 502:
                return BAD_GATEWAY;
            case 503:
                return SERVICE_UNAVAILABLE;
            case 504:
                return GATEWAY_TIMEOUT;
            case 505:
                return HTTP_VERSION_NOT_SUPPORTED;
            case 506:
                return VARIANT_ALSO_NEGOTIATES;
            case 507:
                return INSUFFICIENT_STORAGE;
            case 510:
                return NOT_EXTENDED;
            case 511:
                return NETWORK_AUTHENTICATION_REQUIRED;
            default:
                return new HttpStatus(code);
        }
    }

    public static HttpStatus parseLine(String line) {
        try {
            int space = line.indexOf(' ');
            return space == -1 ? valueOf(parseInt(line)) :
                    valueOf(parseInt(line.substring(0, space)), line.substring(space + 1));
        } catch (Exception e) {
            throw new IllegalArgumentException("malformed status line: " + line, e);
        }
    }

    public int code() {
        return code;
    }

    public String codeAsText() {
        return String.valueOf(code);
    }

    public String reasonPhrase() {
        return reasonPhrase;
    }

    @Override
    public int hashCode() {
        return code();
    }

    /**
     * Equality of {@link HttpStatus} only depends on {@link #code()}. The
     * reason phrase is not considered for equality.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HttpStatus)) {
            return false;
        }
        return code() == ((HttpStatus) o).code();
    }

    @Override
    public int compareTo(@NotNull HttpStatus o) {
        return code() - o.code();
    }

    @Override
    public String toString() {
        return codeAsText() + ' ' + reasonPhrase();
    }
}
