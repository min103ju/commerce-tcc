package citizen.order.domain.order;

import citizen.order.constants.StatusEnum;
import citizen.order.domain.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "status")
    private StatusEnum status;

    private Order(String productId, Integer quantity, Integer amount) {
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
        this.status = StatusEnum.TEMP;
    }

    public static Order of(String productId, Integer quantity, Integer amount) {
        return new Order(productId, quantity, amount);
    }


}
