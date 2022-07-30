# RSA algorithm 
**&raquo; A cryptographic algorithm** <br/><sub> _100% Java_ &middot; _Big Integer_ </sub>

---
## What is RSA?
RSA is a cryptographic algorithm commonly used by people to secure data transmission in different
forms such as card payments, private messages. It’s strength relies on having a key that can be shared to the public and used for encryption and one
key that has to stay private to get the encrypted data back in it’s initial form. Allows to do the same
action using the keys in a reverse way since it also behaves as “Inverse function”.

_**<sub>Still not finding what you are looking for? Try the [Wikipedia](https://en.wikipedia.org/wiki/RSA_(cryptosystem))!</sub>**_

#### Contents
* **[1 Getting RSA cryptosystem](#1-getting-rsa-cryptosystem)**
  * [1.1 Check if RSA can be executed](#11-check-if-rsa-can-be-executed)
  * [1.2 Execute code in terminal](#12-execute-code-in-terminal)
* **[2 About the program](#2-about-the-program)**
  * [2.1 Main components](#21-main-components)
  * [2.2 Options available](#22-options-available)

## 1 Getting RSA cryptosystem
### 1.1 Check if RSA can be executed
To run the RSA algorithm you need to have installed [JDK](https://www.oracle.com/java/technologies/downloads/) on your machine.
The version of the JDK to execute this program can be from version 15.0, however, it might be necessary to have version 17.01.
Check if you have the JDK installed by opening a terminal and typing:
```bash
javac -version
java -version
```
In case where a version was given back by the terminal you can execute the code
but you might have to update it to 17.01 or higher. 

### 1.2 Execute code in terminal
To execute the code in terminal simply go to the downloaded folder where the 
"menu.class" and "menu.java" is. Nextly, copy path address.
After this is done open a terminal and wirte:
```bash
cd "path/address/you/have/copied"
```
and press "Enter" and type:
```bash
javac menu.java
java menu
```
_**<sub>If this has not worked check Windows JDK installation guide [Tutorial Windows](https://www.youtube.com/watch?v=xS8cCAyTANs&t=1s)!</sub>**_

_**<sub>If this has not worked check Mac OS installation guide [Tutorial Mac](https://www.youtube.com/watch?v=54qu9Su2Gos&t=3s)!</sub>**_

## 2 About the program
### 2.1 Main components
Algorithm is made from 4 parts being:
* A crypto random key generator and the algorithm for modular exponentiation.
* RSA encryption algorithm.
* RSA decryption algorithm.
* Additional feature such as scenario symulation, size of keys to generate.
### 2.2 Options available
Options are available in the menu of the program from 1-9 where user needs to generate
keys in one of the first 3 options to encrypt and decrypt text/numbers using other options.

* Generate keys automatically - will generate prime numbers using 64 bits.
* Generate keys (more secure version) - allows the user to generate keys of the same amount of bits ranging from 32 bits up to 3072 in a quick time. 
* Generate keys (the most secure version) - allows to separate amounts of bits used for the first prime "P" and the second prime "Q", which makes primes generated much different from each other. 
* Show context scenario - shows the scenario where two parties want to exchange data and malicious person wants to access this information. 
* Encrypt number message - encrypts the numerical message that user inputs.
* Decrypt number message - decrypts the numerical message that user has previously encrypted.
* Encrypt text - encrypts text message that user inputs.
* Decrypt text - decrypts text message that user has previously encrypted.
* Quit - terminate the program. 
