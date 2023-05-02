# Dungeons and Dragons Model

This program simulates a fight between different types of monsters, and it is built on the object-oriented programming principles of inheritance and polymorphism. The program contains a Main class and various subclasses of the Monster class. 

## The key concepts learned in this program are:

    - Inheritance: The subclasses of the Monster class are derived from the Monster class and inherit all its properties.
    - Polymorphism: The Monster class is a general class that can be instantiated to create different types of monsters.
    - Access Modifiers: Private access modifiers are used to limit access to the attributes of the Monster class, and public access modifiers are used to allow access to the         methods and attributes from outside the class.
    - Constructors: There are two constructors in the Monster class: one that passes all the monster's attributes, and one that passes only the clan name, while the rest of         the attributes are randomly generated.
    - Method Overriding: The toString() method is overridden in the Monster class to display the monster's stats.
    - Method Overloading: The attackMonster() method is overloaded to accept different types of monsters.
    - Super Keyword: The super keyword is used to call the constructor of the superclass when creating a subclass.

## The Monster class has the following attributes:

    - clan: A string that represents the name of the monster's clan.
    - ferocity, defence, and magic: Integers that represent the monster's attributes.
    - treasure: An integer that represents the monster's treasure.
    - health: A double that represents the monster's health.
    - aliveStatus: A boolean that represents whether the monster is alive or dead.

## The Monster class has the following methods:

    - toString(): Overrides the toString() method to display the monster's stats.
    - generateAttackScore(): A method that generates a random attack score based on the monster's attributes.
    - attackMonster(): A method that simulates a fight between two monsters.

## There are various subclasses of the Monster class, which include:

    Goblin: A subclass of Monster that represents a Goblin.
    Orc: A subclass of Monster that represents an Orc.
    Troll: A subclass of Monster that represents a Troll.
    Undead: A subclass of Monster that represents an Undead.

All subclasses are interactable in the Main class, where the user can choose to create and display different types of monsters and simulate a fight between them. The program uses various Java programming concepts such as loops, conditional statements, and random number generators to create a unique gaming experience for the user.

## Screenshots

![image](https://i.imgur.com/MED2jD6.png)
![image2](https://i.imgur.com/1tBxgJJ.png)
![image3](https://i.imgur.com/3Sy2BTs.png)
