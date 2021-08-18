package citizen.order.adapter.impl;

import citizen.order.adapter.RestAdapter;
import citizen.order.adapter.link.RequestRestLink;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class RestAdapterImpl implements RestAdapter {

    private final RestTemplate restTemplate;

    @Override
    public List<ResponseEntity> doTry(final List<RequestRestLink> links) {
        final List<ResponseEntity> result = new ArrayList<>();
        links.forEach(link -> {
            result.add(
                restTemplate
                    .exchange(link.getUri(), HttpMethod.POST, new HttpEntity(link.getRestBody()),
                        ResponseEntity.class)
            );
        });
        return result;
    }

    @Override
    public void confirm(final RequestRestLink link) {
        // TODO: 2021-08-19 order service에서 confirm rest 호출 후 정상 처리 시 db에 반영
//        Long orderId = (Long) link.getRestBody().getBody().get(ORDER_ID_FIELD);
//        Order order = orderRepository.findById(orderId).orElseThrow(
//            () -> new NoSuchElementException(String.format("Not Found Order. ID [%d]", orderId)));

    }

    @Override
    public void cancel(final RequestRestLink link) {

    }

}
