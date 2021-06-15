# spring-boot-example-crud
simple crud example project

put post delete and update rest api with a single object, student.
runs on localhost: 8089
for api doc: localhost:8089/swagger-ui.html

To test in intelliJ:

###
POST http://localhost:8089/
Content-Type: application/json

{
  "firstName": "Edmund",
  "lastName": "Elephant",
  "email": "edmund@yahoo.com"
}

<> 2021-06-15T125431.500.json
<> 2021-06-15T125318.500.json
<> 2021-06-15T125225.500.json

###
POST http://localhost:8089/

###
DELETE http://localhost:8089/1

<> 2021-06-15T131110.500.json
<> 2021-06-15T130955.404.json
<> 2021-06-15T130752.404.json

###
PUT http://localhost:8089/1?name=Peter&email=peter@yahoo.com
Content-Type: application/json
