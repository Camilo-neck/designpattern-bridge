package encriptacion;

import javax.crypto.*;
import java.security.*;

public class ProcesoEncriptarRSA implements InterfaceEncriptar {
    @Override
    public String encryptar(String message, String password) throws Exception {
        // RSA encryption
        try {
            KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
            KeyPair keypair = keygen.generateKeyPair();

            Cipher rsaCipher = Cipher.getInstance("RSA");

            rsaCipher.init(Cipher.ENCRYPT_MODE, keypair.getPrivate());
            byte[] mensajeCifrado = rsaCipher.doFinal(message.getBytes("UTF8"));
            return new String(mensajeCifrado, "UTF8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
