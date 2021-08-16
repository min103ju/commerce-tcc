package citizen.order.web;

import citizen.order.service.OrderService;
import citizen.order.web.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<OrderDto> placeOrder(@RequestBody OrderDto orderDto) {
        return new ResponseEntity(orderService.placeOrder(orderDto), HttpStatus.CREATED);
    }


}
