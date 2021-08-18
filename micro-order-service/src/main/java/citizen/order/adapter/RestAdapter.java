package citizen.order.adapter;

import citizen.order.adapter.link.RequestRestLink;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface RestAdapter {

    List<ResponseEntity> doTry(List<RequestRestLink> links);

    void confirm(RequestRestLink link);

    void cancel(RequestRestLink link);
}
