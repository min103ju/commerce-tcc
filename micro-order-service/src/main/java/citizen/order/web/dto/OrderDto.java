package citizen.order.web.dto;

import java.util.UUID;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
public class OrderDto {

    private String productId;
    private Integer quantity;
    private Integer amount;

    public OrderDto(Integer quantity, Integer amount) {
        this(null, quantity, amount);
    }

    public OrderDto(String productId, Integer quantity, Integer amount) {
        this.productId = setProductId(productId);
        this.quantity = quantity;
        this.amount = amount;
    }

    private String setProductId(String productId) {
        if (StringUtils.hasText(productId)) {
            return productId;
        }
        return UUID.randomUUID().toString();
    }

}
