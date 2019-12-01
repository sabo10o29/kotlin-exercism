import org.junit.Test
import java.lang.IllegalArgumentException
import java.math.BigInteger
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class DiffieHellmanTest {

    @Test
    fun `private key is in range from 1 to prime`() {
        val prime = 23.toBigInteger()
        (0..100).map { DiffieHellman.privateKey(prime) }.forEach {
            assertTrue(it >= BigInteger.ONE)
            assertTrue(it < prime)
        }
    }

    @Test
    fun `Int max value, private key is in range from 1 to v`() {
        val v = BigInteger(Int.MAX_VALUE.toString())
        (0..1000).map { DiffieHellman.privateKey(v) }.forEach {
            assertTrue(it >= BigInteger.ONE)
            assertTrue(it < v)
        }
    }

    @Test
    fun `Big value, private key is in range from 1 to v`() {
        val v = BigInteger("21474836473532134")
        (0..1000).map { DiffieHellman.privateKey(v) }.forEach {
            assertTrue(it >= BigInteger.ONE)
            assertTrue(it < v)
        }
    }

    @Test(expected = IllegalArgumentException::class)
    fun `private key is illegal value`() {
        val prime = BigInteger("-12345")
        DiffieHellman.privateKey(prime)
    }

    /**
     * Due to the nature of randomness, there is always a chance that this test fails.
     * Be sure to check the actual generated values.
     */
    @Test
    fun `private key is random`() {
        val prime = 7919.toBigInteger()
        val privateKeyA = DiffieHellman.privateKey(prime)
        val privateKeyB = DiffieHellman.privateKey(prime)

        assertNotEquals(privateKeyA, privateKeyB)
    }

    @Test
    fun `calculate public key using private key`() {
        val primeA = 23.toBigInteger()
        val primeB = 5.toBigInteger()
        val privateKey = 6.toBigInteger()
        val expected = 8.toBigInteger()

        assertEquals(expected, DiffieHellman.publicKey(primeA, primeB, privateKey))
    }


    @Test
    fun `calculate secret using other party's public key`() {
        val prime = 23.toBigInteger()
        val publicKey = 19.toBigInteger()
        val privateKey = 6.toBigInteger()
        val expected = 2.toBigInteger()

        assertEquals(expected, DiffieHellman.secret(prime, publicKey, privateKey))
    }


    @Test
    fun `key exchange`() {
        val primeA = 23.toBigInteger()
        val primeB = 5.toBigInteger()

        val alicePrivateKey = DiffieHellman.privateKey(primeA)
        val bobPrivateKey = DiffieHellman.privateKey(primeB)

        val alicePublicKey = DiffieHellman.publicKey(primeA, primeB, alicePrivateKey)
        val bobPublicKey = DiffieHellman.publicKey(primeA, primeB, bobPrivateKey)

        val secretA = DiffieHellman.secret(primeA, bobPublicKey, alicePrivateKey)
        val secretB = DiffieHellman.secret(primeA, alicePublicKey, bobPrivateKey)

        assertEquals(secretA, secretB)
    }

    @Test
    fun `key exchange 2`(){
        //1. Alice and Bob agree to use a modulus p = 6397273 and base g = 1659661
        //   P: Prime and G: Primitive root modulo p.
        val primeP = BigInteger("6397273")
        val primeG = BigInteger("1659661")
        //2. Alice make a secret number
        val a = DiffieHellman.privateKey(primeP)
        //3. Alice computes A and sends to Bob
        val A = DiffieHellman.publicKey(primeP, primeG, a)
        //4. Bob make a secret number
        val b = DiffieHellman.privateKey(primeP)
        //5. Bob computes B and sends to Alice
        val B = DiffieHellman.publicKey(primeP, primeG, b)
        //6. Alice computes a secret key
        val secretKey_Alice = DiffieHellman.secret(primeP, B, a)
        //7. bob computes a secret key
        val secretKey_Bob = DiffieHellman.secret(primeP, A, b)

        assertEquals(secretKey_Alice, secretKey_Bob)

    }

}
