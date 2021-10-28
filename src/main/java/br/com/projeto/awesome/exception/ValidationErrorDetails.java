package br.com.projeto.awesome.exception;

public class ValidationErrorDetails extends ErrorDetailsAbstract {

    private String field;
    private String fieldMessage;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return fieldMessage;
    }

    public void setFieldMessage(String message) {
        this.fieldMessage = message;
    }

    public static final class Builder {
        private String title;
        private Integer status;
        private String detail;
        private Long timestamp;
        private String developerMessage;
        private String field;
        private String fieldMessage;

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

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder fieldMessage(String fieldMessage) {
            this.fieldMessage = fieldMessage;
            return this;
        }

        public ValidationErrorDetails build() {
            ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
            validationErrorDetails.setTitle(this.title);
            validationErrorDetails.setDeveloperMessage(this.developerMessage);
            validationErrorDetails.setTimestamp(this.timestamp);
            validationErrorDetails.setDetail(this.detail);
            validationErrorDetails.setStatus(this.status);
            validationErrorDetails.setField(this.field);
            validationErrorDetails.setFieldMessage(this.fieldMessage);
            return validationErrorDetails;
        }
    }
}
