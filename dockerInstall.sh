#!/bin/sh
sudo yum update -y
sudo yum install docker -y
sudo yum install python3-pip -y
pip3 install --user docker-compose # without root access for security reasons
sudo systemctl enable docker.service
sudo systemctl start docker.service