# Topic: *Behavioral Design Patterns*
## Author: *Polisciuc Vlad*
------
## Objectives:
&ensp; &ensp; __1. Study and understand the Behavioral Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, we must think about what communication between software entities might be involed in your system.__

&ensp; &ensp; __3. Implement some additional functionalities using behavioral design patterns.__

## Theory:
Just like the previous deisgn patterns, the Behavioral DPs are a tool used to make code more efficient, both for the person who maintains the code as well for the user of said program. Behavioral DPs are based mostly on the ways things interact with one another as per the name 'behavioral'

The most well Known Behavioral Design patterns are:

   * Chain of Responsibility - Lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
   * Command -  Turns a request into a stand-alone object that contains all information about the request. This transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations
   * Iterator - Lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.).
   * Mediator - Lets you reduce chaotic dependencies between objects. The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator object.
   * Memento -  Lets you save and restore the previous state of an object without revealing the details of its implementation.
   * Observer - Lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.
   * Strategy - Lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.
   * State -  Lets an object alter its behavior when its internal state changes. It appears as if the object changed its class.
   * Template Method -  Defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.
   * Visitor -  Lets you separate algorithms from the objects on which they operate.
   

## Implementation:

For this laboratory I have implemented the Strategy and State Design Patterns

### Strategy

For the Strategy BDP I chose to work with the Course Subsystem, and implement different strategies for how a course can be structured, I created 3 ways: 

VideoBasedStrategy

![image](https://github.com/user-attachments/assets/76011ae0-e3c2-4f08-8e01-a4401ed09081)

ProjectBasedStrategy

![image](https://github.com/user-attachments/assets/c110a608-607f-4175-b0fc-53c0f60a3187)

and StandardStrategy when no other is specified

![image](https://github.com/user-attachments/assets/956b0a51-43af-4a84-9fcf-c861cf7df5d6)

Thats the only real difference of the strategies, they define a different course structure that will be printed to the console.

To make that work a CourseStrategy interface was created

![image](https://github.com/user-attachments/assets/1c98e790-d674-430f-9274-5a256c980c30)

So the implementing classes must define a clear course structure.

All the other changes in the Strategy package are just an adaptation of the existing flyweight to make the new implementation work in a similar manner to the old one.

And this is how this DP is used via the Facade

![image](https://github.com/user-attachments/assets/3b20edae-f063-470c-8462-7f1f9d2ee436)

First we take as arguments the course type, name, and structure. Then using a switch condition we careate a strategy object of the correct Strategy Class.

Then we Actually create the course object using the StrategicFlyweightFactory, behind the scenes based on this choice a different structure is allocated to the respective course. and it keeps the existing Flyweight implementation, only adding new things on top.


### State

For the State BDP I also chose to modify the existing course functionality, now introducing different states such as draft, waiting approval, published etc, making a basic system for a privileged user to create and manage a course.

I have defined a few states, and the action that will result when taking a certain step while being in a different one (imagine a mesh grid, thats literally what it is) for example if you are waiting for approval by an admin you cant publish the course etc.

![image](https://github.com/user-attachments/assets/32347351-b128-4877-a00c-665158dffd42)

These are the states, for simplicity's sake I will not show here each of them in particular

Just know that they all must implement the following methods

![image](https://github.com/user-attachments/assets/47ab3603-8eb6-498a-9320-90a3a3e08102)


Then we have just the CourseContext Class that unites everything together, and makes it possible to work with the different states

![image](https://github.com/user-attachments/assets/08709788-dbd8-4560-829c-5393d0d0479f)

Here we keep track of the current state of a course, when created a course is in draft mode, and we encapsulated the state attribute, creating getters and setters to be used in the various Course state implementations.

Afterwards in our Impl class we define the methods for state change as follows

![image](https://github.com/user-attachments/assets/e2234ab5-e183-47a4-a1b1-4ac9e45d591e)

and so on for the other states in the project


In the end this is added to the facade

![image](https://github.com/user-attachments/assets/d9a3ce26-0fa7-4d00-8831-b0ab8f1593d9)

Where I hardcoded a few state changes when creating a course just to see that the system is working. 


This is how the output looks like

![image](https://github.com/user-attachments/assets/f9ae5503-a5ce-4e79-8a5a-77cad8ec8824)

## Conclusion

In conclusion We have studied the Behavioral Design Patterns in this laboratory, that has allowed us to get a better understanding of Software Design in general, making a foundation for more efficient Software Development.

P.S: I hope this Report is better xD
