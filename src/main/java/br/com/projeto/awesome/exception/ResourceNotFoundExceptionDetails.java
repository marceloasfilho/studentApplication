package br.com.projeto.awesome.exception;

public class ResourceNotFoundExceptionDetails extends ErrorDetails {

    private ResourceNotFoundExceptionDetails() {
    }

    public static final class Builder {
        private String title;
        private Integer status;
        private String detail;
        private Long timestamp;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourceNotFoundExceptionDetails build() {
            ResourceNotFoundExceptionDetails resourceNotFoundExceptionDetails = new ResourceNotFoundExceptionDetails();
            resourceNotFoundExceptionDetails.setTitle(this.title);
            resourceNotFoundExceptionDetails.setDeveloperMessage(this.developerMessage);
            resourceNotFoundExceptionDetails.setTimestamp(this.timestamp);
            resourceNotFoundExceptionDetails.setDetail(this.detail);
            resourceNotFoundExceptionDetails.setStatus(this.status);
            return resourceNotFoundExceptionDetails;
        }
    }
}
