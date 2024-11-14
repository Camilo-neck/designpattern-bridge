package factory;

import encriptacion.InterfaceEncriptar;
import encriptacion.ProcesoEncriptarAES;
import encriptacion.ProcesoEncriptarDES;
import encriptacion.ProcesoEncriptarRSA;
import encriptacion.ProcesoSinEncriptar;

import java.io.InputStream;
import java.util.Properties;

public class EncryptionFactory {
    public static InterfaceEncriptar createEncryption() throws Exception {
        Properties properties = new Properties();
        try (InputStream input = EncryptionFactory.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new Exception("Unable to find config.properties");
            }
            properties.load(input);
        }

        String className = properties.getProperty("encryption.class");
        switch (className) {
            case "ProcesoEncriptarAES":
                return new ProcesoEncriptarAES();
            case "ProcesoEncriptarDES":
                return new ProcesoEncriptarDES();
            case "ProcesoEncriptarRSA":
                return new ProcesoEncriptarRSA();
            case "ProcesoSinEncriptar":
                return new ProcesoSinEncriptar();
            default:
                throw new IllegalArgumentException("Unknown encryption class: " + className);
        }
    }
}