package citizen.order.adapter.link;

import citizen.order.domain.order.Order;
import java.net.URI;
import lombok.Getter;

@Getter
public class RequestStockRestLink extends RequestRestLink {

    private static final String STOCK_URL = "http://localhost:9002/api/v1/stocks";

    public RequestStockRestLink(URI uri, RestBody restBody) {
        super(uri, restBody);
    }

    public static RequestStockRestLink of(final Order order) {
        return new RequestStockRestLink(URI.create(STOCK_URL), order.toStockRestBody());
    }
}
