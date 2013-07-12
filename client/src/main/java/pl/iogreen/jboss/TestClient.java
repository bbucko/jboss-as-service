package pl.iogreen.jboss;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import pl.iogreen.jboss.common.Common;
import pl.iogreen.jboss.common.CommonInterface;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class TestClient implements TestClientMBean {

    private final static Logger log = Logger.getLogger(TestClient.class);
    private final static MBeanServer server = ManagementFactory.getPlatformMBeanServer();

    public TestClient() {
        log.info("Hello from version " + new Common().version + StringUtils.defaultIfBlank(" and from service: Client", ""));
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
    public void testClient() {
        try {
            StringUtils.abbreviate("Hello world", 3);

            final ObjectName mbeanObject = new ObjectName("jboss:name=service,type=service,version=2");

            final CommonInterface handler = MBeanServerInvocationHandler.newProxyInstance(server, mbeanObject, CommonInterface.class, false);
            handler.testService(new Common());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
