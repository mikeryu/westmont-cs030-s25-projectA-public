javac -cp junit-platform-console-standalone-1.11.4.jar ./*.java

java -jar junit-platform-console-standalone-1.11.4.jar execute \
  --classpath . \
  --scan-class-path

rm ./*.class