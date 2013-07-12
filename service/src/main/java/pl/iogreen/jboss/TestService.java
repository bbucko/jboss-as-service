package pl.iogreen.jboss;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.iogreen.jboss.common.Common;
import pl.iogreen.jboss.common.CommonInterface;

public class TestService implements TestServiceMBean, CommonInterface {

    private final static Logger log = LoggerFactory.getLogger(TestService.class);
    private final static String service = "Service";

    public TestService() {
        log.info("Hello from Common version {} and from service: {}", StringUtils.capitalize(new Common("Service").version), service);
    }

    @Override
    public void stop() {
        log.info("Stopping MBean: {}", service);
    }

    @Override
    public void start() {
        log.info("Starting MBean: {}", service);
    }

    @Override
    public void testService(Common common) {
        log.info("Hello from version {} and from client: {}", common.version, common.client);
    }
}
