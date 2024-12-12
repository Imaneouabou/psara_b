package adoption.annonce.services.dto;

public class ResponseDto {
    private String message;
    private String status;
    private Object data; // Optional, for carrying any additional data

    // Constructors
    public ResponseDto() {}

    public ResponseDto(String message) {
        this.message = message;
    }

    public ResponseDto(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public ResponseDto(String message, String status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
