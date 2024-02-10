package tw.shop.payment.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.shop.order.model.Order;
import tw.shop.order.repository.OrderRepository;
import tw.shop.payment.dto.PaymentDto;
import tw.shop.payment.model.Payment;
import tw.shop.payment.repository.PaymentRepository;
import tw.shop.payment.service.PaymentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository, ModelMapper modelMapper) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PaymentDto createPayment(PaymentDto paymentDto) {
        Order order = orderRepository.findById(paymentDto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + paymentDto.getOrderId()));
        Payment payment = modelMapper.map(paymentDto, Payment.class);
        payment.setOrder(order);
        payment = paymentRepository.save(payment);
        return modelMapper.map(payment, PaymentDto.class);
    }

    @Override
    public PaymentDto getPaymentById(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + paymentId));
        return modelMapper.map(payment, PaymentDto.class);
    }

    @Override
    public List<PaymentDto> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(payment -> modelMapper.map(payment, PaymentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDto updatePayment(Long paymentId, PaymentDto paymentDto) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + paymentId));
        modelMapper.map(paymentDto, payment);
        payment = paymentRepository.save(payment);
        return modelMapper.map(payment, PaymentDto.class);
    }

    @Override
    public void deletePayment(Long paymentId) {
        if (!paymentRepository.existsById(paymentId)) {
            throw new RuntimeException("Payment not found with id: " + paymentId);
        }
        paymentRepository.deleteById(paymentId);
    }
}
