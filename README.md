# Caso-Practico-Java
## Pasos para ejecutar el proyecto:
1. docker buildx build -t casopractico --build-arg DOCKER_BUILDKIT=1 --build-arg BUILDKIT_STEP_LOG_MAX_SIZE=10000000 --build-arg BUILDKIT_STEP_LOG_MAX_SPEED=10000000 .
2. docker run -p 8081:8081 casopractico