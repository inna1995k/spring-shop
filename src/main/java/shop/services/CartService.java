package shop.services;

import shop.entities.OrderItem;
import shop.entities.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private List<OrderItem> items;

    public void clear() {
        this.items = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public List<OrderItem> getItems() {
        return items;
    }


    public void add(Product product) {
        for (OrderItem i : items) {
            if (i.getProduct().getId().equals(product.getId())) {
                return;
            }
        }
        items.add(new OrderItem(product));
    }

}
