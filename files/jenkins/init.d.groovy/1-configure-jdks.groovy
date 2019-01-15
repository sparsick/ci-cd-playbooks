#!groovy

import jenkins.model.*
import hudson.model.*
import hudson.tools.*

def versions = [
  "jdk11": "/opt/jdk-11.0.1/",
  "jdk8": "/opt/jdk1.8.0_192/"
]

def inst = Jenkins.getInstance()

def installations = [];
for (v in versions) {
  def installation = new JDK(v.key, v.value)
  installations.push(installation)
}

def desc = inst.getDescriptor("hudson.model.JDK")
desc.setInstallations(installations.toArray(new JDK[0]))
desc.save()
