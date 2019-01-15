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

  config.vm.define "centos-vm", autostart: false do |vbox|
    vbox.vm.box = "centos/7"
    vbox.vm.network "private_network", ip: "192.168.33.10"
    vbox.vm.provision "shell", inline: <<-SHELL
      sudo sed -i 's/PasswordAuthentication no/PasswordAuthentication yes/' /etc/ssh/sshd_config
      sudo service sshd restart
    SHELL
  end

  config.vm.define "ubuntu-vm", autostart: false do |vbox|
    vbox.vm.box =  "boxcutter/ubuntu1604"
    vbox.vm.box_version = "17.0907.1"
    vbox.vm.network "private_network", ip: "192.168.33.10"
    vbox.vm.provision "shell", inline: <<-SHELL
      sudo apt-get update
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
