import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/** RSA implementation.
 * Presents: key generation (couple versions), encryption for integers, decryption for integers,
 * encryption for text, decryption for text.
 * <b>
 * Special thanks to Justin Yoon (jyoon004) who helped
 * in explaining of how to make a conversion of ASCII values
 * to BigInteger and what could be done to get relativePrime.
 * <br>
 * </b>
 * @author Arkadiusz Nowacki
 * @version 17.0.1
 * <ol> Resources used
 *     <li>Resource one: "https://www.geeksforgeeks.org/java-math-biginteger-probableprime-method-in-java/" </li>
 *     <li>Resource two: "https://www.geeksforgeeks.org/biginteger-class-in-java/" </li>
 *     <li>Resource three: "https://www.javatpoint.com/rsa-encryption-algorithm" </li>
 * </ol>
 **/
class menu {
    //Vars
    static Random random = new Random();
    static BigInteger p, q, n, r, e, d;
    static BigInteger [] primes = new BigInteger[2];
    static BigInteger[] publicKey = new BigInteger[2];
    static BigInteger[] privateKey = new BigInteger[2];
    static BigInteger cipherText;
    static final int delay = 600;
    static BigInteger[] finalMessage = new BigInteger[]{};

    // Helper method
    static void placeInBetween(){
        System.out.println();
    }

    /**
     * Loop as long as the Euler's Totient 'm' greatest common divisor of 'e' is not equal to one
     * to get the relative prime.
     * @param r Euler's totient value.
     * @return A power that will be used for encryption
     **/
    static BigInteger relativePrime(BigInteger r){
        int length = r.bitLength() - 1;
        e = BigInteger.probablePrime(length, random);
        while (!(r.gcd(e)).equals(BigInteger.ONE)) {
            e = BigInteger.probablePrime(length, random);
        }
        return e;
    }

    /**
     * It takes amount of bits specified by user and generates two primes 'p' and 'q'.
     * Where 'p' is random prime and 'q' is next prime after 'p' prime.
     * Less secure version to generate them.
     * @param numberOfBits the number of bits in 'binary notation' to represent the given number.
     **/
    static void generatePrimes(int numberOfBits){
        p = BigInteger.probablePrime(numberOfBits, random);
        q = p.nextProbablePrime();
        primes[0] = p;
        primes[1] = q;
    }

    /**
     * It takes amount of bits specified by user and generates two primes 'p' and 'q'.
     * Where 'p' & 'q' are random primes.
     * More secure version to generate them.
     * @param numberOfBitsOne the number of bits in 'binary notation' to represent the 'p' prime.
     * @param numberOfBitsTwo the number of bits in 'binary notation' to represent the 'q' prime.
     **/
    static void generatePrimesAlternative(int numberOfBitsOne, int numberOfBitsTwo){
        p = BigInteger.probablePrime(numberOfBitsOne, random);
        q = BigInteger.probablePrime(numberOfBitsTwo, random);
        primes[0] = p;
        primes[1] = q;
    }

    /**
     * Result of multiplying 'p * q'.
     */
    static void modulusN(){
        n = primes[0].multiply(primes[1]);
    }

    /**
     * Euler's Totient for 'r'- which is a (p-1) * (q-1)
     **/
    static void eulerTotientM(){
        r = (primes[0].subtract(BigInteger.ONE)).multiply(primes[1].subtract(BigInteger.ONE));
    }

    /**
     * Get public key 'e' that is a prime that is less than n.
     */
    static void getE(){
        e = relativePrime(r);
    }

    /**
     * Get private key part 'd'.
     */
    static void getD(){
        d = e.modInverse(r);
    }

    /**
     * Add an array format for each key.
     */
    static void createKeys(){
        publicKey[0] = n;
        publicKey[1] = e;
        privateKey[0] = n;
        privateKey[1] = d;
    }

    /**
     * Generate key variables.
     * @param amountOfBits the number of bits in 'binary notation' to represent the given number.
     */
    static void generateKeys(int amountOfBits){
        try {
            generatePrimes(amountOfBits);
            modulusN();
            eulerTotientM();
            getE();
            getD();
            createKeys();
            System.out.println("Generating P ...");
            TimeUnit.MILLISECONDS.sleep(delay);
            System.out.println("Generating Q ...");
            TimeUnit.MILLISECONDS.sleep(delay);
            System.out.println("Generating R ...");
            TimeUnit.MILLISECONDS.sleep(delay);
            System.out.println("Generating N ...");
            TimeUnit.MILLISECONDS.sleep(delay);
            System.out.println("Generating Public key ...");
            TimeUnit.MILLISECONDS.sleep(delay);
            System.out.println("Generating Private key ...");
            TimeUnit.MILLISECONDS.sleep(delay);
            placeInBetween();
            System.out.println("P: " + primes[0]);
            System.out.println("Q: " + primes[1]);
            System.out.println("R: " + r);
            System.out.println("N: " + n);
            System.out.println("E: " + e);
            System.out.println("D: " + d);
            TimeUnit.MILLISECONDS.sleep(delay);
            placeInBetween();
            System.out.println("Public key: " + Arrays.asList(publicKey));
            placeInBetween();
            System.out.println("Private key: " + Arrays.asList(privateKey));
        }catch (InterruptedException err){}
    }

    /**
     * Generate key variables.
     * @param amountOfBitsOne the number of bits in 'binary notation' to represent the prime 'p'.
     * @param amountOfBitsTwo the number of bits in 'binary notation' to represent the prime 'q'.
     */
    static void generateKeysTwo(int amountOfBitsOne, int amountOfBitsTwo){
        try {
            generatePrimesAlternative(amountOfBitsOne, amountOfBitsTwo);
            modulusN();
            eulerTotientM();
            getE();
            getD();
            createKeys();
            System.out.println("Generating P ...");
            TimeUnit.MILLISECONDS.sleep(delay);
            System.out.println("Generating Q ...");
            TimeUnit.MILLISECONDS.sleep(delay);
            System.out.println("Generating R ...");
            TimeUnit.MILLISECONDS.sleep(delay);
            System.out.println("Generating N ...");
            TimeUnit.MILLISECONDS.sleep(delay);
            System.out.println("Generating Public key ...");
            TimeUnit.MILLISECONDS.sleep(delay);
            System.out.println("Generating Private key ...");
            TimeUnit.MILLISECONDS.sleep(delay);
            placeInBetween();
            System.out.println("P: " + primes[0]);
            System.out.println("Q: " + primes[1]);
            System.out.println("R: " + r);
            System.out.println("N: " + n);
            System.out.println("E: " + e);
            System.out.println("D: " + d);
            TimeUnit.MILLISECONDS.sleep(delay);
            placeInBetween();
            System.out.println("Public key: " + Arrays.asList(publicKey));
            placeInBetween();
            System.out.println("Private key: " + Arrays.asList(privateKey));
        }catch (InterruptedException err){}
    }

    /**
     * Changes each character to integers corresponding to ASCII value and
     * then to String.
     * BigInteger needs random number for integers so better
     * option is to put String that has ASCII's value to BigInteger.
     * @param character char to be changed integer in form of BigInteger.
     * @return BigInteger with the ASCII value for given character.
     **/
    static BigInteger charToAsciiValue(char character){
        char currentLetter = character;//character
        int asciiValue = currentLetter; //int of ascii
        String asciiValueToStr = Integer.toString(asciiValue);
        BigInteger strToBigInt = new BigInteger(asciiValueToStr);
        return strToBigInt;
    }

    /**
     * @param integer to be encrypted.
     * @return Encrypted ASCII value of the character.
     */
    static BigInteger rsaEncryptText(BigInteger integer){
        BigInteger encrypt = integer.modPow(e, n);
        return encrypt;
    }

    /**
     * @param integer to be decrypted.
     * @return Decrypted character from the BigInteger ASCII value.
     */
    static BigInteger rsaDecryptText(BigInteger integer){
        BigInteger decryption = integer.modPow(d, n);
        return decryption;
    }

    /**
     * Encrypts the text given by user by changing each character of text
     * to ASCII value, which then is encrypted one by one and saved in the array.
     * 'finalMessage' collects each character of the text in form of encrypted
     * integer.
     */
    static void encryptText(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Encrypt a string: ");
            String text = scanner.nextLine();
            BigInteger[] arrayOfEncryptedChars = new BigInteger[text.length()];
            for (int i = 0; i < arrayOfEncryptedChars .length; i++) {
                arrayOfEncryptedChars[i] = charToAsciiValue(text.charAt(i));
                arrayOfEncryptedChars[i] = rsaEncryptText(arrayOfEncryptedChars [i]);
            }
            finalMessage = arrayOfEncryptedChars;
            TimeUnit.MILLISECONDS.sleep(delay);
            System.out.println("Encryption on each character: " + Arrays.toString(finalMessage));
        }catch (NullPointerException err){
            System.out.println("Keys were not generated, please generate the keys first");
        }catch (InterruptedException err){}
    }

    /**
     * Checks whether there is text to decrypt and if there is it decrypt each
     * character one by one. Once this is done StringBuilder builds the original message
     * that was encrypted and displays it.
     */
    static void decryptText(){
        try {
            if (finalMessage.length > 0) {
                StringBuilder stringBuilt = new StringBuilder();
                for (int i = 0; i < finalMessage.length; i++) {
                    BigInteger decrypt = rsaDecryptText(finalMessage[i]);
                    int changeBack = decrypt.intValue();
                    String part = Character.toString((char) changeBack);
                    stringBuilt.append(part);
                }
                TimeUnit.MILLISECONDS.sleep(delay);
                System.out.println("Decrypted text is: " + stringBuilt);
            } else {
                System.out.println("No message to decrypt");
            }
        }catch (InterruptedException err){}
    }

    /**
     * Once the keys were generated and primes are big enough the whole
     * number message is encrypted with 'e' and 'n'.
     */
    static void encryptNumberMessageWithScenario(){
        try {
            generateKeys(8);
            System.out.println("Please write a short integer message (such as 10 or 123) to encrypt it: ");
            Scanner scanner = new Scanner(System.in);
            BigInteger input = scanner.nextBigInteger();
            TimeUnit.MILLISECONDS.sleep(delay);
            System.out.println("#".repeat(120));
            System.out.println("Alice is using Bob's public key to encrypt a message she wants to be secured");
            System.out.println("|Alice has| Plain text: " +  input + " + public key.");
            System.out.println("|Bob has| nothing yet.");
            System.out.println("|Charlie has| nothing yet.");
            System.out.println("#".repeat(120));
            TimeUnit.MILLISECONDS.sleep(delay*2);
            cipherText = input.modPow(e, n);
            System.out.println("Encrypted message is: " + cipherText);
            System.out.println("Cipher text has been sent to Bob.");
            System.out.println("Bob can decrypt is with his private key.");
            TimeUnit.MILLISECONDS.sleep(delay*2);
            System.out.println("#".repeat(120));
            System.out.println("|Alice has| Plain text: " +  input + " + public key.");
            System.out.println("|Bob has| Cipher text: " + cipherText + " Plain text: " + input + " + private key.");
            System.out.println("|Charlie has| Cipher text: " + cipherText + " + public key.");
            TimeUnit.MILLISECONDS.sleep(delay*2);
            System.out.println("#".repeat(120));
            System.out.println("By intercepting the messages Charlie has access to the cipher text and the public" + "\n" +
                    "key when the primes are not large enough. Charlie is also able to use Brute force attack to find" + "\n" +
                    "prime factors from 'n'. Once he knows 'p' and 'q' and 'n' he will be able to get '(p-1) * (q-1)'" + "\n" +
                    "Lastly he knows 'p,q,n,r' so he can proceed to get 'e' and then 'd' to finally get initial message.");
            TimeUnit.MILLISECONDS.sleep(delay*2);
        }catch (NullPointerException err){
            System.out.println("Keys were not generated, please generate the keys first");
        }catch (InputMismatchException err){
            System.out.println("Wrong type of message to encrypt, use integers only");
        } catch (InterruptedException err) {}
    }

    /**
     * Once the keys were generated and primes are big enough the whole
     * number message is encrypted with 'e' and 'n'.
     */
    static void encryptNumberMessage(){
        try {
            System.out.println("Please write a integer message to encrypt it: ");
            Scanner scanner = new Scanner(System.in);
            BigInteger input = scanner.nextBigInteger();
            TimeUnit.MILLISECONDS.sleep(delay);
            cipherText = input.modPow(e, n);
            System.out.println("Encrypted message is: " + cipherText);
            TimeUnit.MILLISECONDS.sleep(delay);
        }catch (NullPointerException err){
            System.out.println("Keys were not generated, please generate the keys first");
        }catch (InputMismatchException err){
            System.out.println("Wrong type of message to encrypt, use integers only");
        } catch (InterruptedException err) {}
    }

    /**
     * Once the message was encrypted do a decryption of this number message with use of 'd' and 'n'.
     */
    static void decryptNumberMessage(){
        try {
            BigInteger decryption = cipherText.modPow(d, n);
            TimeUnit.MILLISECONDS.sleep(delay);
            System.out.println("Decrypted message is: " + decryption);
        }catch (NullPointerException err){
            System.out.println("No message to decrypt");
        } catch (InterruptedException err) {}
    }

    /**
     * A menu to go over the option of RSA.
     */
    static void menu(){
        try {
            Scanner scanner;
            String option;
            do {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("~~~~~~~~~~~~ R S A ~~~~~~~~~~~~");
                System.out.println("~~~~~~~~~~~~ by AN ~~~~~~~~~~~~");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Please select an option.");
                System.out.println("1. Generate keys automatically.");
                System.out.println("2. Generate keys (more secure version).");
                System.out.println("3. Generate keys (the most secure version).");
                System.out.println("4. Show context scenario.");
                System.out.println("5. Encrypt number message.");
                System.out.println("6. Decrypt number message.");
                System.out.println("7. Encrypt text.");
                System.out.println("8. Decrypt text.");
                System.out.println("9. Quit.");
                System.out.println("#".repeat(65));
                System.out.println("Please choose and option.");
                scanner = new Scanner(System.in);
                option = scanner.next();
                switch (option) {
                    case "1":
                        generateKeys(64); //Seems like a reasonable choice, since it generates enough big primes and other values accordingly.
                        System.out.println();
                        break;
                    case "2":
                        try {
                            System.out.println("~".repeat(97));
                            System.out.println("This option enhances the security of the keys generated by specifying the amount of bits to use");
                            System.out.println("for the first prime \'p\'. The \'q\' is next prime after \'p\'.");
                            System.out.println("The security increases with larger numbers (32, 64, 128, 256, 512, 1028, 2056, 3072).");
                            System.out.println("~".repeat(97));
                            System.out.println("How many bits should the primes have?");
                            System.out.println("Please choose a number: ");
                            int amountOfBits = scanner.nextInt();
                            generateKeys(amountOfBits);
                            System.out.println();
                            break;
                        }catch (ArithmeticException err){
                            System.out.println("Amount of bits specified for prime is too small");
                            menu();
                        }
                    case "3":
                        try {
                            System.out.println("~".repeat(97));
                            System.out.println("This option enhances the security of the keys generated by specifying the amount of bits to use");
                            System.out.println("for the first prime \'p\' and second prime \'q\'.");
                            System.out.println("The security increases with larger numbers (32, 64, 128, 256, 512, 1028, 2056, 3072).");
                            System.out.println("~".repeat(97));
                            System.out.println("How many bits should the first prime have?");
                            System.out.println("Please choose a number: ");
                            int firstBits = scanner.nextInt();
                            System.out.println("How many bits should the second prime have?");
                            System.out.println("Please choose a number: ");
                            int secondBits = scanner.nextInt();
                            generateKeysTwo(firstBits, secondBits);
                            break;
                        }catch (ArithmeticException err){
                            System.out.println("Amount of bits specified for  or primes is too small");
                            menu();
                        }
                    case "4":
                        encryptNumberMessageWithScenario();
                        System.out.println();
                        break;
                    case "5":
                        encryptNumberMessage();
                        System.out.println();
                        break;
                    case "6":
                        decryptNumberMessage();
                        System.out.println();
                        break;
                    case "7":
                        encryptText();
                        break;
                    case "8":
                        decryptText();
                        break;
                    default:
                        System.out.println("Please write the correct option choice!");
                        placeInBetween();
                        break;
                    case "9":
                        System.out.println("Bye!");
                }
            } while (!option.equals("9"));
        }catch (InputMismatchException err){
            System.out.println("Wrong input type");
            menu();
        }
    }

    public static void main(String[] args) {
        //Run the menu.
        menu.menu();
    }
}
