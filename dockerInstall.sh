#!/bin/sh
sudo yum update -y
sudo yum install docker -y
sudo yum install python3-pip -y
pip3 install --user docker-compose # without root access for security reasons
sudo systemctl enable docker.service
sudo systemctl start docker.service
git clone https://github.com/Ahdy-K/Stage.git
cd Stage
cd auth-service
docker build --pull --rm -f "Dockerfile" -t authservice:latest "."
cd ..
cd entreprise_service
docker build --pull --rm -f "Dockerfile" -t entrepriseservice:latest "."
cd ..
cd InternshipApplicationService
docker build --pull --rm -f "Dockerfile" -t internshipservice:latest "."
cd ..
cd IPA-Gateway-service
docker build --pull --rm -f "Dockerfile" -t gatwayservice:latest "."
cd ..
cd myDiscEur
docker build --pull --rm -f "Dockerfile" -t eurekadiscoveryservice:latest "."
cd ..
cd UserService
docker build --pull --rm -f "Dockerfile" -t userservice:latest "."
cd ..
docker compose up  --remove-orphans