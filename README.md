# vertx.io-sample

1) cd parentheses
2) mvn package
3) cd target
4) java -jar parentheses-1.0.0-SNAPSHOT-fat.jar
5) POST http://localhost:8080/checkParentheses 
RAW Body: 
{
	"input": "))()()((())(()))()()"
}