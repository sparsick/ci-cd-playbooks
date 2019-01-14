#!groovy

import hudson.model.*;
import jenkins.model.*;
import hudson.tools.*;
import hudson.tasks.Maven.MavenInstaller;
import hudson.tasks.Maven.MavenInstallation;

def versions = [
      "3.6.0"
]


def mavenPluginExtension = Jenkins.instance.getExtensionList(hudson.tasks.Maven.DescriptorImpl.class)[0]

def installation = (mavenPluginExtension.installations as List)
for (version in versions ) {
  def newMavenInstallation = new MavenInstallation("Maven $version", null, [new InstallSourceProperty([new MavenInstaller("$version")])])
  if(!installation.contains(newMavenInstallation)) {
    installation.add(newMavenInstallation)
    println "Add Maven Version $version"
  } else {
    println "Found already existing Maven Version $version"
  }
}

mavenPluginExtension.installations = installation

mavenPluginExtension.save()
