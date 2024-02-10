package tw.shop.payment.service;

import tw.shop.payment.dto.PaymentDto;
import java.util.List;

public interface PaymentService {
    PaymentDto createPayment(PaymentDto paymentDto);
    PaymentDto getPaymentById(Long paymentId);
    List<PaymentDto> getAllPayments();
    PaymentDto updatePayment(Long paymentId, PaymentDto paymentDto);
    void deletePayment(Long paymentId);
}
