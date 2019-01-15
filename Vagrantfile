# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure("2") do |config|
  # The most common configuration options are documented and commented below.
  # For a complete reference, please see the online documentation at
  # https://docs.vagrantup.com.

  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://atlas.hashicorp.com/search.
  config.vm.define "ubuntu" do |ubuntu|
    ubuntu.vm.box = "ubuntu/bionic64"
    ubuntu.vm.network "private_network", ip: "192.168.33.10"

    ubuntu.trigger.after :up do |trigger|
      trigger.run = { path: "./postInstall.sh", args: "192.168.33.10" }
    end

    ubuntu.trigger.after :destroy do |trigger|
      trigger.run = { inline: "rm ubuntu-bionic-18.04-cloudimg-console.log" }
    end

    ubuntu.vm.provision "shell", inline: <<-SHELL
      sudo apt-get update
      sudo apt-get install python -y
      sudo sed -i 's/PasswordAuthentication no/PasswordAuthentication yes/' /etc/ssh/sshd_config
      sudo service sshd restart
    SHELL
  end

  config.vm.define "centos" do |centos|
    centos.vm.box = "centos/7"
    centos.vm.network "private_network", ip: "192.168.33.11"

    centos.trigger.after :up do |trigger|
      trigger.run = { path: "./postInstall.sh", args: "192.168.33.11"  }
    end

    centos.vm.provision "shell", inline: <<-SHELL
      sudo sed -i 's/PasswordAuthentication no/PasswordAuthentication yes/' /etc/ssh/sshd_config
      sudo service sshd restart
    SHELL
  end

  config.vm.define "centos-docker", autostart: false  do |docker|
    docker.vm.provider "docker" do |d|
      d.build_dir = "./docker/"
      d.dockerfile = "centos7"
      d.name = "ansible"
    end
  end

  config.vm.define "ubuntu-docker", autostart: false  do |docker|
    docker.vm.provider "docker" do |d|
      d.build_dir = "./docker/"
      d.dockerfile = "ubuntu1604"
      d.name = "ansible"
    end
  end


end
