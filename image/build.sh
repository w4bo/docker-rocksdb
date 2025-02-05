#!/bin/bash
set -exo

ROCKSDB_VERSION=v9.2.1

cd /usr/src
git clone --depth 1 --branch ${ROCKSDB_VERSION} https://github.com/facebook/rocksdb.git
cd /usr/src/rocksdb

sed -i 's/install -C/install -c/g' Makefile

make -j4 shared_lib
make install-shared
make -j8 rocksdbjava

cp -r java/target/* /src/java-libs
