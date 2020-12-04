package shop.frontend;

import shop.entities.OrderItem;
import shop.services.CartService;
import shop.services.OrderService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("cart")
public class CartView extends VerticalLayout{

    private final CartService cartService;
    private final OrderService orderService;

    public CartView(CartService cartService, OrderService orderService) {
        this.cartService = cartService;
        this.orderService = orderService;
        initCartPage();
    }


    private void initCartPage() {
        Grid<OrderItem> grid = new Grid<>(OrderItem.class);
        grid.setItems(cartService.getItems());
        grid.setWidth("60%");
        grid.setColumns("product", "price", "quantity");

        Button toOrderButton = new Button("Создать заказ", e -> {

            orderService.saveOrder();

            cartService.clear();
            UI.getCurrent().navigate("market");

        });

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(grid);
    }

}
