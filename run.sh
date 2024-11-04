#!/bin/bash

# Compile Java files from the src directory into the bin directory
javac src/*.java -d bin

# Check if the compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful."
    # Run the Main class with the specified classpath
    java -cp ./bin Main
else
    echo "Compilation failed."
fi

