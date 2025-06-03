package com.example.balo_center.controller.admin;

import com.example.balo_center.domain.dto.response.ApiResponse;
import com.example.balo_center.service.admin.impl.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final StripeService stripeService;

    @PostMapping("/create-payment-intent")
    public ApiResponse<Map<String, String>> createPaymentIntent(@RequestBody Map<String, Object> payload) {
        try {
            Long amount = Long.parseLong(payload.get("amount").toString());
            PaymentIntent paymentIntent = stripeService.createPaymentIntent(amount, "vnd");

            Map<String, String> response = new HashMap<>();
            response.put("clientSecret", paymentIntent.getClientSecret());

            return new ApiResponse<>(HttpStatus.OK.value(), "Successful create payment intent", response);
        } catch (StripeException exception) {
            Map<String, String> error = new HashMap<>();
            error.put("error", exception.getMessage());
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error happen when create payment intent", error);
        }
    }

    @GetMapping("/config")
    public ApiResponse<Map<String, String>> getConfig() {
        Map<String, String> config = new HashMap<>();
        config.put("publishableKey", stripeService.getPublishableKey());
        return new ApiResponse<>(HttpStatus.OK.value(), "Successful get publishable key", config);
    }

    @PostMapping("/invoice")
    public ApiResponse<Map<String, String>> createAndPayInvoice(@RequestParam String email, @RequestParam Long amount, @RequestParam String currency) {
        try {
            stripeService.createAndPayInvoiceForCustomer(email, amount, currency);
            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("email", email);
            response.put("amount", amount.toString());
            response.put("currency", currency);
            return new ApiResponse<>(HttpStatus.OK.value(), "Invoice created and paid successfully", response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error happened when creating invoice", error);
        }
    }
}