package citizen.order.adapter.link;

import citizen.order.domain.order.Order;
import java.net.URI;
import lombok.Getter;

@Getter
public class RequestPaymentLink extends RequestRestLink {

    private static final String PAYMENT_URL = "http://localhost:9003/api/v1/payment";

    public RequestPaymentLink(URI uri, RestBody restBody) {
        super(uri, restBody);
    }

    public static RequestStockRestLink of(final Order order) {
        return new RequestStockRestLink(URI.create(PAYMENT_URL), order.toStockRestBody());
    }
}
