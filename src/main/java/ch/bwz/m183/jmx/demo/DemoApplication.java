package ch.bwz.m183.jmx.demo;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		LOG.debug("This is basic JMX tutorial");

		try {
			ObjectName studentObjectName = new ObjectName("ch.m183.jmx.demo:type=basic,name=student");
			ObjectName uuidObjectName = new ObjectName("ch.m183.jmx.demo:type=basic,name=node-identity");
			MBeanServer server = ManagementFactory.getPlatformMBeanServer();
			server.registerMBean(new Student(), studentObjectName);
			server.registerMBean(new NodeIdentity(), uuidObjectName);
		} catch (MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException e) {
			e.printStackTrace();
		}

		LOG.debug("Registration for Game mbean with the platform server is successfull");
		LOG.debug("Please open jconsole to access Game mbean");

		while (true) {
			// to ensure application does not terminate
		}

	}

}
