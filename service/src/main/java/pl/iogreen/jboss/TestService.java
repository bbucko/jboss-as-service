package pl.iogreen.jboss;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import pl.iogreen.jboss.common.Common;
import pl.iogreen.jboss.common.CommonInterface;

public class TestService implements TestServiceMBean, CommonInterface {

    private final static Logger log = Logger.getLogger(TestService.class);

    public TestService() {
        log.info("Hello from version " + new Common().version + StringUtils.defaultIfBlank(" and from service: Service", ""));
    }

    @Override
    public void stop() {
        log.info("Stop");
    }

    @Override
    public void start() {
        log.info("Start");
    }

    @Override
    public void testService(Common common) {
        StringUtils.abbreviate("Hello world", 3);
        log.info("Hello from version " + common.version);
    }
}
