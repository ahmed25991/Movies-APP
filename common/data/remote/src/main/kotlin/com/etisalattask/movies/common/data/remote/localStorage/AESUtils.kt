package com.etisilattask.movies.common.data.remote.localStorage


import android.util.Base64
import java.nio.charset.Charset
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec

/**
 * A utility class that provides AES256 encryption and decryption methods.
 * This class supports AES encryption in GCM mode, which provides both confidentiality and integrity for data.
 * The encryption uses a random initialization vector (IV) for each encryption operation, ensuring uniqueness for each encryption.
 * It can be used to securely encrypt and decrypt data that needs to be stored or transmitted securely.
 *
 * AES (Advanced Encryption Standard) is a symmetric encryption algorithm, which means the same key is used for both encryption and decryption.
 * AES256 means a 256-bit key is used for encryption, providing a high level of security.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Advanced_Encryption_Standard">AES on Wikipedia</a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html#GCM">GCM Mode</a>
 */
class AESUtils {
    private val keyAlgorithm = "AES"          // AES algorithm used for encryption
    private val cipherAlgorithm = "AES/GCM/NoPadding" // AES algorithm in GCM mode, with no padding
    private val keySize = 256                 // Key size (256 bits) for AES-256 encryption
    private val ivSize = 12                   // Initialization vector (IV) size for AES-GCM (12 bytes recommended)

    /**
     * Generates a new AES key for encryption and decryption.
     * This key is used for both encryption and decryption operations.
     *
     * @return A [SecretKey] object that can be used for AES encryption/decryption.
     */
    fun generateKey(): SecretKey {
        val keyGenerator = KeyGenerator.getInstance(keyAlgorithm)
        keyGenerator.init(keySize) // Initialize the key generator with AES-256 (256-bit key)
        return keyGenerator.generateKey() // Generate and return the AES key
    }

    /**
     * Encrypts the provided string data using AES256-GCM encryption.
     * A new random initialization vector (IV) is generated for each encryption.
     * The IV is prepended to the encrypted data for use during decryption.
     *
     * @param data The plaintext string that needs to be encrypted.
     * @param secretKey The AES key used for encryption.
     * @return The encrypted data, encoded in Base64 format (which includes the IV and ciphertext).
     * @throws Exception If encryption fails.
     */
    fun encrypt(data: String, secretKey: SecretKey): String {
        val cipher = Cipher.getInstance(cipherAlgorithm)

        // Generate a random 12-byte initialization vector (IV)
        val iv = ByteArray(ivSize)
        SecureRandom().nextBytes(iv) // Use SecureRandom for IV generation

        // Create GCMParameterSpec using the IV and a 128-bit authentication tag length
        val gcmSpec = GCMParameterSpec(128, iv)

        // Initialize the cipher for encryption
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmSpec)

        // Perform encryption on the input data
        val encryptedData = cipher.doFinal(data.toByteArray(Charset.forName("UTF-8")))

        // Concatenate the IV and the encrypted data, then encode it in Base64
        val ivAndEncryptedData = iv + encryptedData
        return Base64.encodeToString(ivAndEncryptedData, Base64.NO_WRAP)
    }

    /**
     * Decrypts the provided encrypted data using AES256-GCM decryption.
     * The initialization vector (IV) is extracted from the first 12 bytes of the encrypted data.
     *
     * @param encryptedData The encrypted data (Base64 encoded) to be decrypted.
     * @param secretKey The AES key used for decryption.
     * @return The decrypted plaintext string.
     * @throws Exception If decryption fails (e.g., invalid data or key).
     */
    fun decrypt(encryptedData: String, secretKey: SecretKey): String {
        // Decode the Base64 encoded encrypted data
        val ivAndEncryptedData = Base64.decode(encryptedData, Base64.NO_WRAP)

        // Extract the IV (first 12 bytes) and the encrypted data (the rest)
        val iv = ivAndEncryptedData.copyOfRange(0, ivSize)
        val cipherData = ivAndEncryptedData.copyOfRange(ivSize, ivAndEncryptedData.size)

        // Initialize the cipher for decryption using AES/GCM/NoPadding
        val cipher = Cipher.getInstance(cipherAlgorithm)
        val gcmSpec = GCMParameterSpec(128, iv) // Use 128-bit authentication tag length
        cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmSpec)

        // Perform decryption on the cipher data
        val decryptedData = cipher.doFinal(cipherData)

        // Return the decrypted data as a string
        return String(decryptedData, Charset.forName("UTF-8"))
    }
}
