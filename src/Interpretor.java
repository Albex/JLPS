import java.rmi.RemoteException;
import java.util.Arrays;

/**
 * This is the controller class. It translates Prolog-like declaration into objects for the program.
 * @author Albex
 *
 */
public class Interpretor {

    public Interpretor() {

    }

    public static boolean isProlog(String string) {
        boolean res = false;
        if (string.matches("[^(,|\\(|\\))]*\\(([^(,|\\(|\\))]+(,[^(,|\\(|\\))]+)*)*\\)")) {
            res = true;
        }

        return res;
    }

    public static Predicate prologToPredicate(String string) throws RemoteException {
        Predicate res;
        if (Interpretor.isProlog(string)) {
            String[] nameAndVar = string.split("\\(|,|\\)");
            for (int i = 1; i < nameAndVar.length; i++) {
                nameAndVar[i] = (nameAndVar[i].matches("[A-Z].*")) ? null : nameAndVar[i];
            }
            res = new Predicate(nameAndVar[0], Arrays.copyOfRange(nameAndVar, 1, nameAndVar.length));
            System.out.println(res.toString());

            return res;
        } else {
            throw new RemoteException("It is not a Prolog-like predicate.");
        }
    }
}
