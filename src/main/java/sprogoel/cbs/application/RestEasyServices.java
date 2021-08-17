package sprogoel.cbs.application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class RestEasyServices extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public RestEasyServices() {
        singletons.add(new CinemaCrudService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
