package in.tryeasy.recordkeeping.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import in.tryeasy.recordkeeping.exception.PaymentProcessingError;
import in.tryeasy.recordkeeping.model.payment.ChargeRequest;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Slf4j
@Service
public class StripeService {

    @Value("${tryeasy.stripe.key.secret}")
    private String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = this.secretKey;
    }

    public Charge charge(ChargeRequest chargeRequest) {

        try {
            final var chargeParams = new HashMap<String, Object>();
            chargeParams.put("amount", chargeRequest.getAmount());
            chargeParams.put("currency", chargeRequest.getCurrency());
            chargeParams.put("description", chargeRequest.getDescription());
            chargeParams.put("source", chargeRequest.getStripeToken());
            return Charge.create(chargeParams);
        } catch (StripeException e) {
            log.info("Error while processing payment.", e);
            throw new PaymentProcessingError("Payment Failure");
        }

    }

    public void doStripeCheckout(HttpServletResponse response) {
        final var domain = "http://localhost:9000";
        SessionCreateParams params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(domain + "/checkout/result")
                .setCancelUrl(domain + "/checkout/result")
                .addLineItem(SessionCreateParams.LineItem.builder()
                        .setQuantity(1L)
                        .setPrice("price_1LjNc8SBc7frNjd7D2LEHryK")
                        .build())
                .build();
        try {
            Session session = Session.create(params);
            response.sendRedirect(session.getUrl());
        } catch (StripeException | IOException e) {
            e.printStackTrace();
        }
    }
}
