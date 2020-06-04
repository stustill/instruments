package investments.goji;

import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ReactiveGreetingService {

    @Inject
    GreetingRepo greetingRepo;

    public Uni<String> greeting(String name) {
        return greetingRepo.greeting().map(it -> it + name);
    }
}
