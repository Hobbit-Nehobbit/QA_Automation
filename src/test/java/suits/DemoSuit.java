package suits;

import kare.AutoTicketBuyTest;
import kare.CheckTiketResultTest;
import lasVegas.LasVegasBuyTicketsTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import registrationTest.RegistrationTest;

/**
 * Created by hobbit on 1/3/20.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                AutoTicketBuyTest.class,
                CheckTiketResultTest.class,
                LasVegasBuyTicketsTest.class,
                RegistrationTest.class

        }
)
public class DemoSuit {
}
