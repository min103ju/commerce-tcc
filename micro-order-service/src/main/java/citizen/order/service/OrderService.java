package citizen.order.service;

import citizen.order.adapter.RestAdapter;
import citizen.order.adapter.link.RequestPaymentLink;
import citizen.order.adapter.link.RequestStockRestLink;
import citizen.order.domain.OrderRepository;
import citizen.order.domain.order.Order;
import citizen.order.web.dto.OrderDto;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final RestAdapter restAdapter;
    private final OrderRepository orderRepository;

    @Transactional
    public Order placeOrder(final OrderDto orderDto) {

        // insert order into temp table
        final Order savedTempOrder = orderRepository.save(
            Order.of(
                orderDto.getProductId(),
                orderDto.getQuantity(),
                orderDto.getAmount()
            )
        );

        restAdapter.doTry(
            Arrays.asList(RequestStockRestLink.of(savedTempOrder),
                RequestPaymentLink.of(savedTempOrder))
        );

        // call Payment Rest Api
        // call Stock Rest Api

        return savedTempOrder;
    }


}
