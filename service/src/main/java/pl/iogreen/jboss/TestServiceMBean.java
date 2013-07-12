package pl.iogreen.jboss;

import pl.iogreen.jboss.common.Common;

public interface TestServiceMBean {
    void stop();

    void start();

    void testService(Common common);
}
