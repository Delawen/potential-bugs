package potential.bugs.resource;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.config.ConfigMapping;
import org.junit.jupiter.api.Test;
import potential.bugs.model.Configuration;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
@TestHTTPEndpoint(ConfigurationResource.class)
class ConfigurationTest {

    @Test
    void test() {
        assertNotNull(config);
        System.out.println(config.strings());
        System.out.println(config.objects());
    }

    private TestConfiguration config;

    @Inject
    public void setConfig(final TestConfiguration config) {
        this.config = config;
    }

    @ConfigMapping(prefix = "configuration")
    interface TestConfiguration extends Configuration {
    }
}
