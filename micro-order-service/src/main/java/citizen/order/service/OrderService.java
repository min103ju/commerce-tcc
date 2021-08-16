package citizen.order.service;

import citizen.order.domain.OrderRepository;
import citizen.order.domain.order.Order;
import citizen.order.web.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Order placeOrder(OrderDto orderDto) {

        // insert order into temp table
        Order savedTempOrder = orderRepository.save(
            Order.of(
                orderDto.getProductId(),
                orderDto.getQuantity(),
                orderDto.getAmount()
            )
        );

        // call Payment Rest Api
        // call Stock Rest Api

        return savedTempOrder;
    }
}
