FROM amazonlinux:2023

RUN dnf -y install docker

RUN mkdir -p /usr/local/lib/docker/cli-plugins && \
  curl -SL "https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/lib/docker/cli-plugins/docker-compose && \
  chmod +x /usr/local/lib/docker/cli-plugins/docker-compose