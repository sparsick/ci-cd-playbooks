#!groovy

import jenkins.model.Jenkins

// Jenkins instance
final Jenkins instance = Jenkins.instance

// Disable old JNLP unsecured protocols
final HashSet<String> newProtocols = new HashSet<>(instance.agentProtocols);
newProtocols.removeAll(Arrays.asList("CLI-connect", "JNLP-connect", "JNLP2-connect", "JNLP3-connect"));
instance.agentProtocols = newProtocols;

// Save security settings
instance.save()
