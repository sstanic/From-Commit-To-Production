import junit.framework.Assert;

import org.junit.Test;

import java.util.Date;

import ch.hsr.mge.gadgeothek.domain.Gadget;
import ch.hsr.mge.gadgeothek.domain.Loan;

/**
 * Created by s on 10/28/17.
 */


public class LoanTest {

    @Test
    public void TestLoan_Ctor_WithAllInitValues_ReturnsLoanInstance()
    {
        //ARRANGE
        String id = "99";
        Gadget g = new Gadget("testGadget");
        Date pickupDate = new Date(1);
        Date returnDate = new Date(5);

        //ACT
        Loan testee = new Loan(id, g, pickupDate, returnDate);

        //ASSERT
        Assert.assertEquals(id, testee.getLoanId());
        Assert.assertEquals(g.getName(), testee.getGadget().getName());
    }
}
