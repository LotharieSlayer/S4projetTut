#!/bin/bash
# Script by Juanlu J. Laredo
# version 1.0

#>>> Function to capture the interruption CTRL-C 
#    and then kill all processes
_term() { 
  echo "Caught SIGTERM signal!" 
  kill -TERM "$pid1" 2>/dev/null
  kill -TERM "$pid2" 2>/dev/null
}


trap _term INT
#<<< 

# Launching Server
java -jar GameServerUDP.jar 8000 > /dev/null 2>&1 &
pid1=$!
sleep 1
# Launching first client (Red player)
java -jar GameClientUDP.jar random.properties 
pid2=$!
sleep 1

# Waits for ending the script
wait "$pid1"
