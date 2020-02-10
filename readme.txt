This a simple application to test some security permission.

setup
1. install JDK
2. intall maven
3. to build and run the test cases: mvn clean build
4. to run the spring boot application: java -jar target/bcsample-0.0.1-SNAPSHOT.jar
5. make sure app is running. http://localhost:8080/
6. use postman to post following json
{
  "accountIds": ["account001", "account005"],
  "operations": [
    {
        "action": "WRITE",
        "resources": ["video"]
    }
  ]
}
to URL: localhost:8080/users/user001/authorize
this should return 200 ok code.

7. follow json should return a 401 unauthorized
{
  "accountIds": ["account001", "account005"],
  "operations": [
    {
        "action": "WRITE",
        "resources": ["video", "playlist"]
    }
  ]
}