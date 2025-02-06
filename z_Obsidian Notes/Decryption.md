**Decryption** is the reverse process of [[encryption]]. It converts the unreadable ciphertext back into the original message mmm using a decryption key $D$.

Mathematically, decryption is expressed as:

$$m = D_{\text{key}}(\text{Ciphertext})$$
where:

- $\text{Ciphertext} = E_{\text{key}}(m)$ is the encrypted message,
- $D_{\text{key}}$​ is the decryption function, using a key compatible with the encryption key $E_{\text{key}}$​.

In symmetric encryption, the same key is used for both $E$ and $D$. In asymmetric encryption, $E$ uses a public key, and $D$ uses the corresponding private key.