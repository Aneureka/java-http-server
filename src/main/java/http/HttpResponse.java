package http;

/**
 * @author Aneureka
 * @createdAt 2019-12-20 09:37
 * @description
 **/
public class HttpResponse extends HttpMessage {

    private HttpStatus status;

    public HttpResponse() {
        this(new HttpContent(), HttpStatus.OK, HttpVersion.HTTP_1_1, HttpHeaders.defaultHeaders);
    }

    public HttpResponse(HttpContent content) {
        this(content, HttpStatus.OK, HttpVersion.HTTP_1_1, HttpHeaders.defaultHeaders);
    }

    public HttpResponse(HttpContent content, HttpStatus status, HttpVersion version, HttpHeaders headers) {
        super(version, content, headers);
        this.status = status;
    }

    public HttpStatus status() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }


    public void setContent(HttpContent content) {
        this.content = content;
        HttpHeaders.setHeader(this, HttpHeaders.Names.CONTENT_LENGTH, String.valueOf(this.content.length()));
    }

    public void setContent(String text) {
        this.content.setContent(text);
        HttpHeaders.setHeader(this, HttpHeaders.Names.CONTENT_LENGTH, String.valueOf(this.content.length()));
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "status=" + status +
                ", version=" + version +
                ", content=" + content +
                ", headers=" + headers +
                '}';
    }
}