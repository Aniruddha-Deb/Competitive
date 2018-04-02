#!/bin/bash

name="$1"

mkdir $name
cd $name

cp "../../setup/config.java" "Main.java"
