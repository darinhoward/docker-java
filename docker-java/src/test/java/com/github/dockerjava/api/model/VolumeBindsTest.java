package com.github.dockerjava.api.model;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.dockerjava.test.serdes.JSONTestHelper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class VolumeBindsTest {

    @Test
    public void t() throws IOException {
        String s = "{\"/data\":\"/some/path\"}";
        VolumeBinds volumeBinds = JSONTestHelper.getMapper().readValue(s, VolumeBinds.class);
        VolumeBind[] binds = volumeBinds.getBinds();
        assertEquals(binds.length, 1);
        assertEquals(binds[0].getHostPath(), "/some/path");
        assertEquals(binds[0].getContainerPath(), "/data");
    }

    @Test(expected = JsonMappingException.class)
    public void t1() throws IOException {
        String s = "{\"/data\": {} }";
        JSONTestHelper.getMapper().readValue(s, VolumeBinds.class);
    }

}
