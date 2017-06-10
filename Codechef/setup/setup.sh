#!/bin/bash

name="$1"

cd /Users/Sensei/Projects/Competitive/Codechef/problems
mkdir $name
cd $name
touch "in.txt"
touch "out.txt"
touch "comp.txt"

echo "import java.util.Scanner;

class $name {

	public static void main( String args[] ) {
		Scanner sc = new Scanner( System.in );
		int numTestCases = sc.nextInt();
		sc.nextLine();

		while( numTestCases > 0 ) {
			// write code here

			numTestCases--;
		}
		sc.close();
	}
}" >> "$name.java"