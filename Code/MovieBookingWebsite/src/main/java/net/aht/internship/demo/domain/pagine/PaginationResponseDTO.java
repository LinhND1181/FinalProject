package net.aht.internship.demo.domain.pagine;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponseDTO<T> {
    private Integer status;
    private String message;
    private PaginateDTO<T> result;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PaginateDTO<T> getResult() {
        return result;
    }

    public void setResult(PaginateDTO<T> result) {
        this.result = result;
    }
}
