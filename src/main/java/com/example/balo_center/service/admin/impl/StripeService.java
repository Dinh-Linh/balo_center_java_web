package com.example.balo_center.service.admin.impl;

import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.stripe.param.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter
public class StripeService {
    @Value("${stripe.publishable.key}")
    private String publishableKey;

    public PaymentIntent createPaymentIntent(Long amount, String currency) throws StripeException {
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder().setAmount(amount).setCurrency(currency).build();

        return PaymentIntent.create(params);
    }

    public void createAndPayInvoiceForCustomer(String email, Long amount, String currency) throws Exception {
        Customer customer = findOrCreateCustomerByEmail(email);

        InvoiceItemCreateParams invoiceItemCreateParams = InvoiceItemCreateParams.builder()
                .setCustomer(customer.getId())
                .setAmount(amount)
                .setCurrency(currency)
                .setDescription("Order for " + email)
                .build();
        InvoiceItem.create(invoiceItemCreateParams);

        InvoiceCreateParams invoiceCreateParams = InvoiceCreateParams.builder()
                .setCustomer(customer.getId())
                .build();
        Invoice invoice = Invoice.create(invoiceCreateParams);

        Invoice finalizesInvoice = invoice.finalizeInvoice();
        finalizesInvoice.pay();
    }

    public Customer findOrCreateCustomerByEmail(String email) throws Exception {
        CustomerListParams params = CustomerListParams.builder()
                .setEmail(email)
                .setLimit(1L)
                .build();
        CustomerCollection customers = Customer.list(params);

        if (!customers.getData().isEmpty()) {
            return customers.getData().get(0);
        } else {
            CustomerCreateParams createParams = CustomerCreateParams.builder()
                    .setEmail(email)
                    .build();
            return Customer.create(createParams);
        }
    }
}
