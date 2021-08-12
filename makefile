Main.class: Main.java Tiger.class Monkey.class Giraffe.class
	javac -g Main.java

Tiger.class: Tiger.java AbsPet.class Hunger.class Thirst.class Health.class
	javac -g Tiger.java

Monkey.class: Monkey.java AbsPet.class Hunger.class Thirst.class Health.class
	javac -g Monkey.java

Giraffe.class: Giraffe.java AbsPet.class Hunger.class Thirst.class Health.class
	javac -g Giraffe.java

AbsPet.class: AbsPet.java
	javac -g AbsPet.java

AbsAttr.class: AbsAttr.java
	javac -g AbsAttr.java

Hunger.class: Hunger.java AbsAttr.class
	javac -g Hunger.java

Thirst.class: Thirst.java AbsAttr.class
	javac -g Thirst.java

Health.class: Health.java AbsAttr.class
	javac -g Health.java

clean:
	rm *.class

run: Main.class
	java Main

debug: Main.class
	jdb Main

