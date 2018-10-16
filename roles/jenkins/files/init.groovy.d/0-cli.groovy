#!groovy

import jenkins.model.Jenkins

// Jenkins instance
final Jenkins instance = Jenkins.instance

// Disable CLI over remoting
instance.getDescriptor("jenkins.CLI").get().setEnabled(false)

// Save security settings
instance.save()
