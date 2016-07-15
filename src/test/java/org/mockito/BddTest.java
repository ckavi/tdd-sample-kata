package org.mockito;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BddTest extends Assert {

    @Spy
    Shop shop = new Shop(new Seller(),Arrays.asList(new Bread(),"Gum",new Bread()));

    @Test
    public void given2Breads1GumAsGoodsThen2Breads() throws Exception {

        boolean ass = true;

        Assume.assumeTrue(ass);

        //given(shop.askBreadCount()).willReturn((long)5);
        assertTrue(shop.askBreadCount() == 2);
        verify(shop).askBreadCount();
        verify(shop,never()).buyBread();
    }

    @Test
    public void whenBreadBuyThenBreadNumberDecrease() throws Exception {
        Bread bread = shop.buyBread();
        assertNotNull("where is the bread ?!",bread);
        assertTrue("bread should decrease",shop.askBreadCount() == 1);
    }

    private static class Seller {

    }

    private static class Shop {

        private Seller seller;
        private List<Object> goods;

        public long askBreadCount() {
         return goods.stream().filter(g->g instanceof Bread).count();
        }

        public Shop(Seller seller, List<Object> goods) {
            this.seller = seller;
            this.goods = goods;
        }

        public Shop(Seller seller) {
           this(seller,new ArrayList());
        }

        public Bread buyBread() {
          Bread br = (Bread) goods.stream().filter(g->g instanceof Bread).findFirst().get();
           goods.set(goods.indexOf(br),null);
            return br;
        }
    }

    private static class Bread {

    }
}