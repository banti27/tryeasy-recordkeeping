package in.tryeasy.recordkeeping.controller;


import in.tryeasy.recordkeeping.exception.PaymentProcessingError;
import in.tryeasy.recordkeeping.model.payment.ChargeRequest;
import in.tryeasy.recordkeeping.service.StripeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class PaymentGatewayController {

    private final StripeService stripeService;

    @Value("${tryeasy.stripe.key.public}")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public void checkout(HttpServletResponse response) {
        this.stripeService.doStripeCheckout(response);
    }

    @RequestMapping("/checkout/result")
    public String checkoutResult(HttpServletRequest request) {
        return "payment/result";
    }

    @PostMapping("/charge")
    public String charge(Model model, ChargeRequest request) {
        final var chargeRequest = ChargeRequest.builder()
                .description("Test Charge for: " + request.getStripeEmail())
                .currency(ChargeRequest.Currency.INR)
                .stripeToken(request.getStripeToken())
                .amount(new BigDecimal("10000"))
                .build();

        final var charge = this.stripeService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        return "payment/result";
    }

    @ExceptionHandler(PaymentProcessingError.class)
    public String handlePaymentError(Model model, PaymentProcessingError error) {
        model.addAttribute("error", error.getMessage());
        return "payment/result";
    }


}
