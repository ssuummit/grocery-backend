package com.ekart.e2e.test.service.service;
import com.ekart.e2e.test.service.service.daos.model.Bill;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Service("billService")
@Transactional
public class BillServiceImpl implements BillService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<Bill> bills;

    static {
        bills = populateDummyBill();
    }

    public List<Bill> findAll() {
        return bills;
    }

    public Bill findById(long id) {
        for (Bill bill : bills) {
            if (bill.getoId() == (id)) {
                return bill;
            }
        }
        return null;
    }


    public void saveBill(Bill bill) {
        bill.setoId(counter.incrementAndGet());
        bills.add(bill);
    }

    public void updateBill(Bill bill) {
        int index = bills.indexOf(bill);
        bills.set(index, bill);
    }

    public List<Bill> findALl() {
        return null;
    }

    public boolean isBillExist(Bill bill) {
        return findById(bill.getoId()) != null;
    }

    private static List<Bill> populateDummyBill() {
        List<Bill> bills = new ArrayList<Bill>();
        bills.add(new Bill(UUID.randomUUID().toString(), counter.incrementAndGet(), "{dsds}"));
        return bills;
    }

    public void deleteAllBill() {
        bills.clear();
    }

}
