package ch.bwz.m183.jmx.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class NodeIdentity implements NodeIdentityMBean {
    private static final Logger LOG = LoggerFactory.getLogger(NodeIdentity.class);

    private final String UNIQUE_ID = UUID.randomUUID().toString();

    @Override
    public String getUUID() {
        LOG.debug("Return uuid " + UNIQUE_ID);
        return UNIQUE_ID;
    }
}
