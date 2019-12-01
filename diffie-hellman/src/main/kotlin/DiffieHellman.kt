import java.math.BigInteger
import kotlin.random.Random

object DiffieHellman {

    fun privateKey(prime: BigInteger): BigInteger {

        if(prime.signum() != 1) throw IllegalArgumentException("")

        if(prime.compareTo(BigInteger(Int.MAX_VALUE.toString())) == 1){
            return BigInteger(prime.bitLength()-1, java.util.Random())
        }else{
            return BigInteger(Random.nextInt(1, prime.toInt()-1).toString())
        }

    }

    /**
     * g^privateKey mod p
     *
     */
    fun publicKey(p: BigInteger, g: BigInteger, privateKey: BigInteger): BigInteger {
        return g.modPow(privateKey, p)
    }

    fun secret(prime: BigInteger, publicKey: BigInteger, privateKey: BigInteger): BigInteger {
        return publicKey.modPow(privateKey, prime)
    }

}
