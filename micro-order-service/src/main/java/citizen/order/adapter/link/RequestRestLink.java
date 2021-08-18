package citizen.order.adapter.link;

import java.net.URI;
import lombok.Getter;

@Getter
public abstract class RequestRestLink {

    protected URI uri;

    protected RestBody restBody;

    // TODO: 2021-08-19 Request 쪽에서 expired를 설정하려면 어떻게 해야하는지 확인
    public RequestRestLink(URI uri, RestBody restBody) {
        this.uri = uri;
        this.restBody = restBody;
    }
}
