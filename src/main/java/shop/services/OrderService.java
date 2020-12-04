package shop.services;

import shop.entities.Order;
import shop.repositories.OrderItemRepository;

import org.springframework.stereotype.Service;


@Service
public class OrderService {


    private final CartService cartService;
    private final OrderItemRepository orderItemRepository;

    public OrderService(CartService cartService,
                        OrderItemRepository orderItemRepository) {
        this.cartService = cartService;
        this.orderItemRepository = orderItemRepository;
    }

    public void saveOrder() {

        Order order = new Order();
        order.setItems(cartService.getItems());
    }

}
