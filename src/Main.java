import factory.EncryptionFactory;
import implementacion.PuenteMensajeEncriptacion;
import implementacion.InterfaceMensajeEncriptacion;

public class Main {
    public static void main(String[] args) {
        try {
            InterfaceMensajeEncriptacion formato = new PuenteMensajeEncriptacion(EncryptionFactory.createEncryption());

            final String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";
            String encryptedMessage = formato.EncryptarMensaje(message, "HG58YZ3CR9123456");
            System.out.println("Mensaje Encriptado > " + encryptedMessage + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}