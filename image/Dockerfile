FROM ubuntu:24.04

RUN apt update
RUN apt install -y curl openjdk-8-jdk build-essential libgflags-dev libsnappy-dev zlib1g-dev libbz2-dev liblz4-dev libzstd-dev cmake git bash perl
RUN mkdir -p /usr/src

ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:$PATH"

WORKDIR /usr/src