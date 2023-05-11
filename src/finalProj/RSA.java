package finalProj;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RSA {

    BigInteger p;
    BigInteger q;
    BigInteger e;
    BigInteger phi;
    BigInteger d;
    BigInteger n;

    public RSA(int bitLength) {
        generateKeys(bitLength);
    }

    private void generateKeys(int bitLength) {
        SecureRandom random = new SecureRandom();
        p = BigInteger.probablePrime(bitLength, random);
        q = BigInteger.probablePrime(bitLength, random);
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = new BigInteger("65537"); // common value for public key
        d = e.modInverse(phi);
        while (!e.gcd(phi).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.TWO);
        }
    }

    public BigInteger encrypt(BigInteger plain) {
        return plain.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger cipher) {
        return cipher.modPow(d, n);
    }

    public List<BigInteger> encryption(String message) {
        List<BigInteger> encryptedBlocks = new ArrayList<>();
        byte[] bytes = message.getBytes();
        int blockSize = n.toByteArray().length - 1; // Subtract 1 to account for padding

        for (int i = 0; i < bytes.length; i += blockSize) {
            int end = Math.min(i + blockSize, bytes.length);
            byte[] block = new byte[end - i];
            System.arraycopy(bytes, i, block, 0, block.length);
            BigInteger value = new BigInteger(block);
            encryptedBlocks.add(encrypt(value));
        }

        return encryptedBlocks;
    }

    public String decryption(List<BigInteger> encryptedBlocks) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (BigInteger encryptedBlock : encryptedBlocks) {
            BigInteger decryptedBlock = decrypt(encryptedBlock);
            byte[] blockBytes = decryptedBlock.toByteArray();
            decryptedMessage.append(new String(blockBytes));
        }

        return decryptedMessage.toString();
    }

}
