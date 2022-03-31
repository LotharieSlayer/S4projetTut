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

if [ $# -ne 2 ]; then
  echo "Usage: $0 IP_SERVEUR PORT_SERVEUR" >&2
  exit 1
fi

# Launching first client (Red player)
java -jar GameClientUDP.jar ip=$1 port=$2 > /dev/null 2>&1 &
pid2=$!
sleep 1
# Launching second client (Green player)

nc -u $1 $2

# Waits for ending the script
wait "$pid1"
