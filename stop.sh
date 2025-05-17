#!/bin/bash

# Para o docker compose e remove os containers
cd "$(dirname "$0")/infra" || exit
docker compose down
