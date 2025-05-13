name: Run Java App

on:
  push:
    branches:
      - main
  workflow_dispatch:

jobs:
  run-app:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout repository
        uses: actions/checkout@v3

      - name: Set up Java
        uses: actions/setup-java@v3
        with:
          distribution: 'temurin'
          java-version: '17'

      - name: Compile Java application
        run: javac src/main/java/com/example/WelcomeApp.java

      - name: Run Java application
        run: java src/main/java/com/example/WelcomeApp.java &

      - name: Wait for server to start
        run: sleep 2

      - name: Test with curl
        run: curl http://localhost:8080

      - name: Sleep before exit
        run: sleep 20
