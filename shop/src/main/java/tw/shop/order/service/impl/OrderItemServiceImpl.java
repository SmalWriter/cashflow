package tw.shop.order.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.shop.order.dto.OrderItemDto;
import tw.shop.order.model.Order;
import tw.shop.order.model.OrderItem;
import tw.shop.order.repository.OrderItemRepository;
import tw.shop.order.repository.OrderRepository;
import tw.shop.order.service.OrderItemService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderItemDto addOrderItem(OrderItemDto orderItemDto) {
        Order order = orderRepository.findById(orderItemDto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderItemDto.getOrderId()));
        OrderItem orderItem = modelMapper.map(orderItemDto, OrderItem.class);
        orderItem.setOrder(order);
        orderItem = orderItemRepository.save(orderItem);
        return modelMapper.map(orderItem, OrderItemDto.class);
    }

    @Override
    public OrderItemDto getOrderItemById(Long orderItemId) {
        OrderItem orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new RuntimeException("OrderItem not found with id: " + orderItemId));
        return modelMapper.map(orderItem, OrderItemDto.class);
    }

    @Override
    public List<OrderItemDto> getAllOrderItemsByOrderId(Long orderId) {
        List<OrderItem> orderItems = orderItemRepository.findAll().stream()
                .filter(item -> item.getOrder().getOrderId().equals(orderId))
                .collect(Collectors.toList());
        return orderItems.stream()
                .map(item -> modelMapper.map(item, OrderItemDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemDto updateOrderItem(Long orderItemId, OrderItemDto orderItemDto) {
        OrderItem orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new RuntimeException("OrderItem not found with id: " + orderItemId));
        modelMapper.map(orderItemDto, orderItem);
        orderItem = orderItemRepository.save(orderItem);
        return modelMapper.map(orderItem, OrderItemDto.class);
    }

    @Override
    public void removeOrderItem(Long orderItemId) {
        if (!orderItemRepository.existsById(orderItemId)) {
            throw new RuntimeException("OrderItem not found with id: " + orderItemId);
        }
        orderItemRepository.deleteById(orderItemId);
    }
}
