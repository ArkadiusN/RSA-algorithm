# RSA algorithm <img src="RSA_Image.PNG" height="90" align="left" style="margin-right:15px; margin-bottom:19px; border: 5px solid #181414" />

**&raquo; A public-key cryptographic algorithm** <br/><sub> _100% Java_ &middot; _Big Integer_ &middot; Simulator</sub>

---

## What is RSA?

RSA is a cryptographic algorithm commonly used by people to secure data transmission in different forms, such as card payments and private messages. Its strength relies on having a key that can be shared with the public and used for encryption, whereas another has to stay private to get the encrypted data back in its initial form. Keys, therefore, play a role as components of the [**trapdoor function**](https://en.wikipedia.org/wiki/Trapdoor_function). Accordingly, the keys could be used, in a reverse manner, since they apply principles of the [**inverse function**](https://en.wikipedia.org/wiki/Inverse_function).

<sub>_Still not finding what you are looking for? Try the [Wikipedia](<https://en.wikipedia.org/wiki/RSA_(cryptosystem)>)!_</sub>

#### Contents

- **[1 Getting RSA cryptosystem](#1-getting-rsa-cryptosystem)**
  - [1.1 Check if RSA can be executed](#11-check-if-rsa-can-be-executed)
  - [1.2 Execute code in terminal](#12-execute-code-in-terminal)
- **[2 About the program](#2-about-the-program)**
  - [2.1 Main components](#21-main-components)
  - [2.2 Available options](#22-available-options)

## 1 Getting RSA cryptosystem

### 1.1 Check if RSA can be executed

To run the RSA algorithm you need to have installed [JDK](https://www.oracle.com/java/technologies/downloads/) on your machine.
The version of the JDK to execute this program can start from version _15.0_, however, it might be necessary to have version _17.01_.
Check if you have the JDK installed by opening a terminal and typing :

```bash
javac -version
java -version
```

or

```bash
java -version && javac -version
```

In case where a version was given back by the terminal you can execute the code.

<img src="https://github.com/ArkadiusN/RSA-algorithm/blob/master/CheckVersions.PNG" height="90" align="centre" style="border: 5px solid #181414"/>

### 1.2 Execute code in terminal

To execute the code in terminal simply go to the downloaded folder where the
"menu.class" and "menu.java" is. Nextly, copy path address.
After this is done open a terminal and type :

```bash
cd "path/address/you/have/copied"
```

confirm with "Enter" and type :

```bash
javac menu.java
java menu
```

On successful completion of going through these steps, you should be able to view the result below :

<img src="https://github.com/ArkadiusN/RSA-algorithm/blob/master/Menu.PNG" height="350" style="border: 5px solid #181414"/>

_**<sub>If this has not worked check Windows JDK installation guide [Tutorial Windows](https://www.youtube.com/watch?v=xS8cCAyTANs&t=1s)!</sub>**_

_**<sub> Alternatively try Mac OS installation guide [Tutorial Mac OS](https://www.youtube.com/watch?v=54qu9Su2Gos&t=3s)!</sub>**_

<sub>[[Top 🢁](#contents)]</sub>

## 2 About the program

### 2.1 Main components

Algorithm is made from 4 parts being :

- A crypto random key generator and the algorithm for modular exponentiation.
- RSA encryption algorithm.
- RSA decryption algorithm.
- Additional feature such as scenario simulation, choice of the key size (in bits).

### 2.2 Available options

Options are available in the menu of the program from 1-9 where user needs to generate
keys in one of the first 3 options to encrypt and decrypt text/numbers using other options.

- Generate keys automatically - will generate prime numbers using 64 bits.
- Generate keys (more secure version) - allows the user to generate keys of the same amount of bits ranging from 32 bits up to 3072 in a quick time.
- Generate keys (the most secure version) - allows to separate amounts of bits used for the first prime "P" and the second prime "Q", which makes primes generated a lot different from each other.
- Show context scenario - shows the scenario where two parties want to exchange data and malicious person wants to access this information.
- Encrypt number message - encrypts the numerical message that user inputs.
- Decrypt number message - decrypts the numerical message that user has previously encrypted.
- Encrypt text - encrypts text message that user inputs.
- Decrypt text - decrypts text message that user has previously encrypted.
- Quit - terminate the program.

<sub>[[Top 🢁](#contents)]</sub>
