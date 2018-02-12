Java Properties With Optional Encoding
======================================

```shell
mvn package
$ java -jar target/proplister-1.0-SNAPSHOT.jar 
Usage: target/proplister-1.0-SNAPSHOT.jar FILE [ENCODING]

$ java -jar target/proplister-1.0-SNAPSHOT.jar fixtures/a.properties
-- listing properties --
maxtemp=28
network.interfaces.eth3.dhcp=1
ingredienz=Waldmeister
loremipsum=Lorem ipsum dolor sit amet, consectet...
network.interfaces.eth3.auto=1
umlaut=äöü
```

Properties file in UTF-8 format, garbled output with default IS0-8859-1 encoding:

```shell
$ java -jar target/proplister-1.0-SNAPSHOT.jar fixtures/b.properties 
-- listing properties --
maxtemp=28
network.interfaces.eth3.dhcp=1
ingredienz=Waldmeister
loremipsum=Lorem ipsum dolor sit amet, consectet...
network.interfaces.eth3.auto=1
umlaut=Ã¤Ã¶Ã¼
```

Pass encoding name to read correctly:

```shell
$ java -jar target/proplister-1.0-SNAPSHOT.jar fixtures/b.properties UTF-8
-- listing properties --
maxtemp=28
network.interfaces.eth3.dhcp=1
ingredienz=Waldmeister
loremipsum=Lorem ipsum dolor sit amet, consectet...
network.interfaces.eth3.auto=1
umlaut=äöü
```
