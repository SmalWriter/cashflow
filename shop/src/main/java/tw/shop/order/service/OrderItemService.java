package tw.shop.order.service;

import tw.shop.order.dto.OrderItemDto;
import java.util.List;

public interface OrderItemService {
    OrderItemDto addOrderItem(OrderItemDto orderItemDto);
    OrderItemDto getOrderItemById(Long orderItemId);
    List<OrderItemDto> getAllOrderItemsByOrderId(Long orderId);
    OrderItemDto updateOrderItem(Long orderItemId, OrderItemDto orderItemDto);
    void removeOrderItem(Long orderItemId);
}
