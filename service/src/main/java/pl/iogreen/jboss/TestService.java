package pl.iogreen.jboss;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.iogreen.jboss.common.Common;
import pl.iogreen.jboss.common.CommonInterface;
import pl.iogreen.jboss.spring.config.ServiceConfig;

public class TestService implements TestServiceMBean, CommonInterface {

    private final static Logger log = LoggerFactory.getLogger(TestService.class);
    private final static String service = "Service";
    private AnnotationConfigApplicationContext context;

    public TestService() {
        log.info("Hello from Common version {} and from service: {}", StringUtils.capitalize(new Common("Service").version), service);
    }

    @Override
    public void stop() {
        log.info("Stopping MBean: {}", service);
        context.stop();
    }

    @Override
    public void start() {
        log.info("Starting MBean: {}", service);
        context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        context.start();
    }

    @Override
    public void testService(Common common) {
        log.info("Hello from version {} and from client: {}", common.version, common.client);
    }
}
