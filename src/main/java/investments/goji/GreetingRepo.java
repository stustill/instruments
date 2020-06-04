package investments.goji;

import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GreetingRepo {

    @Inject
    io.vertx.mutiny.mysqlclient.MySQLPool client;

    Uni<String> greeting() {
        return client.query("SELECT COUNT(*) FROM MY_TABLE").execute()
            .map(it -> "Hello, ");
    }
}
