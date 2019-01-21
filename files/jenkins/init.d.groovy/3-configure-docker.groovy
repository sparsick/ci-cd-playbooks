#!groovy

import hudson.model.*;
import jenkins.model.*;
import hudson.tools.*;
import org.jenkinsci.plugins.docker.commons.tools.DockerTool;

def dockerDescriptor = Jenkins.instance.getDescriptorByType(DockerTool.DescriptorImpl.class)

dockerDescriptor.setInstallations(new DockerTool("Docker", "/usr/bin/docker", Collections.<ToolProperty<?>>emptyList()))
dockerDescriptor.save()
