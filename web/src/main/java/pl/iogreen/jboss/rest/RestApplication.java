package pl.iogreen.jboss.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RestApplication extends Application {

    private final static Logger LOG = LoggerFactory.getLogger(RestApplication.class);

    public RestApplication() {
        super();
        LOG.info("REST Application activated");
    }
}