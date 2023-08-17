package in.tryeasy.recordkeeping.exception;

public class PaymentProcessingError extends RuntimeException {
    public PaymentProcessingError(String message) {
        super(message);
    }
}
