package pl.iogreen.jboss;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.iogreen.jboss.common.Common;
import pl.iogreen.jboss.common.CommonInterface;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class TestClient implements TestClientMBean {

    private final static Logger log = LoggerFactory.getLogger(TestClient.class);
    private final static MBeanServer server = ManagementFactory.getPlatformMBeanServer();
    private final static String client = "Client";

    public TestClient() {
        log.info("Hello from Common version {} and from service: {}", StringUtils.capitalize(new Common("Client").version), client);
    }

    @Override
    public void stop() {
        log.info("Stopping MBean: {}", client);
    }

    @Override
    public void start() {
        log.info("Starting MBean: {}", client);
    }

    @Override
    public void testClient() {
        try {
            final ObjectName mbeanObject = new ObjectName("jboss:name=service,type=service");
            final CommonInterface handler = MBeanServerInvocationHandler.newProxyInstance(server, mbeanObject, CommonInterface.class, false);
            handler.testService(new Common("Client"));
        } catch (Exception ex) {
            log.error("Error occurred during MBean invocation.", ex);
            ex.printStackTrace();
        }
    }
}
