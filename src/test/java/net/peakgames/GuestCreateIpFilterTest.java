package net.peakgames;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by cihan on 29/07/16.
 */
public class GuestCreateIpFilterTest {

    @Test
    public void givenIpContainsInTheListReturnFalse(){
        String ip = "12345";
        GuestCreateIpFilter filter = new GuestCreateIpFilter(3);
        filter.offer(ip);
        TestCase.assertFalse(filter.offer(ip));
    }

    @Test
    public void givenIpNotContainInTheListReturnTrue(){
        String ip = "12345";
        GuestCreateIpFilter filter = new GuestCreateIpFilter(3);
        TestCase.assertTrue(filter.offer(ip));
    }

    @Test
    public void givenListIsFullThenRemoveFirstIp(){
        String firstIp = "1111";
        String secondIp = "2222";
        String thirdIp = "3333";
        String forthIp = "4444";
        String fifthIp = "5555";

        GuestCreateIpFilter filter = new GuestCreateIpFilter(4);
        filter.offer(firstIp);
        filter.offer(secondIp);
        filter.offer(thirdIp);
        filter.offer(forthIp);
        filter.offer(fifthIp);

        TestCase.assertEquals(filter.getList().peek(), secondIp);
    }

    @Test
    public void givenListIsNotFullThenDontRemoveFirst(){
        String firstIp = "1111";
        String secondIp = "2222";

        GuestCreateIpFilter filter = new GuestCreateIpFilter(2);
        filter.offer(firstIp);
        filter.offer(secondIp);

        TestCase.assertEquals(filter.getList().peek(), firstIp);
    }

}
