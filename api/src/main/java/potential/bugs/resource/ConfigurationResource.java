package potential.bugs.resource;

import io.smallrye.config.ConfigMapping;
import potential.bugs.model.Configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@ApplicationScoped
public class ConfigurationResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        System.out.println(config.strings());
        System.out.println(config.objects());
        return config.strings().toString();
    }

    private MyConfiguration config;

    @Inject
    public void setConfig(final MyConfiguration config) {
        this.config = config;
    }

    @ConfigMapping(prefix = "configuration")
    interface MyConfiguration extends Configuration {
    }
}
