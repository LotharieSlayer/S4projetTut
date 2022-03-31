#!/bin/bash
# Script by Juanlu J. Laredo
# version 1.0

if [ $# -ne 2 ]; then
  echo "Usage: $0 IP_SERVEUR PORT_SERVEUR" >&2
  exit 1
fi

nc -u $1 $2
