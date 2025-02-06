#!/bin/bash
set -exo

ROCKSDB_VERSION=v9.9.3

rm -rf rocksdb || true
git clone --depth 1 --branch ${ROCKSDB_VERSION} https://github.com/facebook/rocksdb.git
cd rocksdb

sed -i 's/install -C/install -c/g' Makefile

# make rocksdbjavastaticreleasedocker
# make -j8 static_lib
# make -j8 shared_lib
# make -j8 install-shared
make -j8 rocksdbjava

rm -rf /src/java-libs/*
touch /src/java-libs/.dummy
cp -r java/target/* /src/java-libs