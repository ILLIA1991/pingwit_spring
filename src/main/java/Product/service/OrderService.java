package Product.service;

import Product.controller.ProductDTO.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAll();

    Integer createOrder(OrderDto orderDto);

    void deleteOrder(Integer orderId);

    OrderDto getById(Integer orderId);
}
