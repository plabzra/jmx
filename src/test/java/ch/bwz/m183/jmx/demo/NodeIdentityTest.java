package ch.bwz.m183.jmx.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeIdentityTest {

    @Test
    void getUUID_everyInstance_new() {
        String first = new NodeIdentity().getUUID();
        String second = new NodeIdentity().getUUID();
        assertNotEquals(first, second);
    }
}