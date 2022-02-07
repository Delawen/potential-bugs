package potential.bugs.model;

import java.util.List;
import java.util.Optional;

public interface Configuration {
    Optional<List<String>> strings();

    Optional<List<ComplexObject>> objects();

    interface ComplexObject {
        String s();
        Integer i();
    }
}
