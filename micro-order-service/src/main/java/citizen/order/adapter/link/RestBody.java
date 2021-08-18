package citizen.order.adapter.link;

import java.util.Map;
import lombok.Getter;

@Getter
public class RestBody {

    private final Map<String, Object> body;

    public RestBody(Map<String, Object> body) {
        this.body = body;
    }
}
