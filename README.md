# DataStructureApplications

application of hashtable, resizable array, balanced tree

## Price is Right

aid with purchasing decisions by always selecting the most expensive item within a particular budget. Once an item is purchased, it is removed from the collection of products. 

for example:

```
   PriceIsRight pricer = new PriceIsRight();
    
    pricer.addProduct(5000.0, "vacation"); // $5000.00 vacation
    pricer.addProduct(20.0, "blender");
    pricer.addProduct(40.0, "vacuum");
    
    System.out.println(pricer.buy(50.0)); // prints "vacuum"
    System.out.println(pricer.buy(50.0)); // prints "blender"
    System.out.println(pricer.buy(50.0)); // prints null
    
    pricer.addProduct(25000.0, "car");
    System.out.println(pricer.buy(10000.0)); // prints "vacation"
```

## Hide and Seek

a hide and seek game where items can be hidden at arbitrary geographic coordinates. Any number of items may be hidden at the same location

```
  HideNSeek hs = new HideNSeek();

    hs.hide(1, 2, "keys"); // Hide the keys at coordinates (1, 2)
    
    System.out.println(hs.seek(1, 2, "keys"));   // true
    System.out.println(hs.seek(1, 2, "monkey")); // false
    System.out.println(hs.seek(2, 1, "keys"));   // false

    hs.hide(1, 2, "glasses"); // Hide glasses at coordinates (1, 2)
    
    System.out.println(hs.seek(1, 2, "keys"));    // true
    System.out.println(hs.seek(1, 2, "glasses")); // true
    System.out.println(hs.seek(1, 2, "monkey"));  // false

    // Integer positions can be arbitrarily large or small:
    hs.hide(10000, 10000, "keys");
    System.out.println(hs.seek(10000, 10000, "keys")); // true
    System.out.println(hs.seek(-1000000, 20, "keys")); //false
```

## Malware Blocker

keep track of a collection of blocked URLs that are serving up malware.

```
MalwareBlocker blocker = new MalwareBlocker();
    
    blocker.blockSite("evil.com");
    System.out.println(blocker.isBlocked("evil.com")); // true
    System.out.println(blocker.isBlocked("good.com")); // false
    System.out.println(blocker.size()); // prints 1
```

## Message Board

a threaded messaging system where users can post messages and other users can post replies.

```
    // The commands below result in the following message board:
    //
    // "Party planning!"                         // id 0 
    // "Wed. or Thurs?"                          // id 1
    //   └ "Wed. is no good."                    // id 2
    //       └ "Why do you hate Wednesdays?"     // id 4
    //           └  "I don't hate Wednesdays!"   // id 5
    //     "Wed. works for me!"                  // id 3
    // "Wait! Why are we having a party"         // id 6

    MessageBoard board = new MessageBoard();
    
    board.addMessage("Party planning!"); // message id is 0
    board.addMessage("Wed. or Thurs?"); // id is 1
    
    // We can reply to a particular message by providing the id:
    board.addReply(1, "Wed. is no good."); // id is 2
    board.addReply(1, "Wed. works for me!"); // id is 3
    board.addReply(2, "Why do you hate Wednesdays?"); // id is 4
    board.addReply(4, "I don't hate Wednesdays!"); // id is 5
    
    board.addMessage("Wait! Why are we having a party"); // id is 6
    
    // There are three methods that allow us to query the board:
    
    System.out.println(board.getMessageText(0)); // prints "Party planning!"
    System.out.println(board.getReplies(1)); // prints "[2, 3]"
    
    // Return the full "thread" originating at this message:
    System.out.println(board.getThread(1)); // prints "[1, 2, 4, 5, 3]"
```

