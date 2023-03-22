#!/bin/bash

# make wait-for-it executable
chmod +x wait-for-it.sh

# call wait-for-it with passed in args and then start node if it succeeds
bash ./wait-for-it.sh -h "${DB_HOST}" -p "${DB_PORT}" -t 300 -s -- node start
