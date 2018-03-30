#!/bin/bash

name="$1"

comp=()
out=()
cd "/Users/Sensei/Projects/[Educational]/Competitive/Codechef/problems/$name"

javac $name".java"
java $name <in.txt> out.txt

i=0
while IFS= read -r line;
do
	comp[i]=line
	i=$i+1 
done < "comp.txt"

i=0

while IFS= read -r line;
do
	out[i]=line
	i=$i+1 
done < "out.txt"

diff=$(diff <(printf "%s\n" "${comp[@]}") <(printf "%s\n" "${out[@]}"))

if [[ -z "$diff" ]]; then
    echo "PASS"
else
    echo "FAIL"
fi
