package com.github.dockerjava.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeBind implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String hostPath;

    private final String containerPath;

    public VolumeBind(String hostPath, String containerPath) {
        this.hostPath = hostPath;
        this.containerPath = containerPath;
    }

    public String getContainerPath() {
        return containerPath;
    }

    public String getHostPath() {
        return hostPath;
    }

    @Override
    public String toString() {
        return hostPath + ":" + containerPath;
    }
}
