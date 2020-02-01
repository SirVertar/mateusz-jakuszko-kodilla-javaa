package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;



    @Test
    @Transactional
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Apple");
        Product product2 = new Product("Pear");
        Product product3 = new Product("Cola");
        Product product4 = new Product("Grapes");
        Product product5 = new Product("Milk");
        Item item1 = new Item(BigDecimal.valueOf(250), 3, BigDecimal.valueOf(750));
        Item item2 = new Item(BigDecimal.valueOf(120), 4, BigDecimal.valueOf(480));
        Item item3 = new Item(BigDecimal.valueOf(50), 5, BigDecimal.valueOf(250));
        Item item4 = new Item(BigDecimal.valueOf(30), 6, BigDecimal.valueOf(180));
        Item item5 = new Item(BigDecimal.valueOf(20), 7, BigDecimal.valueOf(140));
        Invoice invoice = new Invoice("32");

        product1.getItems().add(item1);
        product2.getItems().add(item2);
        product3.getItems().add(item3);
        product4.getItems().add(item4);
        product5.getItems().add(item5);

        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product3);
        item4.setProduct(product4);
        item5.setProduct(product5);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);
        item5.setInvoice(invoice);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);
        invoice.getItems().add(item5);

        //When

        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        //invoiceDao.deleteById(id);
    }
}
