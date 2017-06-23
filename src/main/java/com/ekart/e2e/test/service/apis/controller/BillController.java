package com.ekart.e2e.test.service.apis.controller;
import com.ekart.e2e.test.service.service.BillService;
import com.ekart.e2e.test.service.service.daos.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by hemantj on 23/06/17.
 */
@RestController
public class BillController {

    @Autowired
    BillService billService;


    @RequestMapping(value = "/bill/", method = RequestMethod.GET)
    public ResponseEntity<List<Bill>> listAllBills() {
        List<Bill> bills = billService.findALl();
        if (bills.isEmpty()) {
            return new ResponseEntity<List<Bill>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Bill>>(bills, HttpStatus.OK);
    }


    @RequestMapping(value = "/bill/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bill> getBill(@PathVariable("id") long id) {
        System.out.println("Fetching Bill with id " + id);
        Bill bill = billService.findById(id);
        return new ResponseEntity<Bill>(bill, HttpStatus.OK);
    }

    @RequestMapping(value = "/bill/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBill(@RequestBody Bill bill, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating bill " + bill.getrId());

        billService.saveBill(bill);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/bill/{id}").buildAndExpand(bill.getoId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/bill/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Bill> updateUser(@PathVariable("id") long id, @RequestBody Bill bill) {

        Bill currentBill = billService.findById(id);

        currentBill.setMenuDetails(bill.getMenuDetails());
        billService.updateBill(currentBill);
        return new ResponseEntity<Bill>(currentBill, HttpStatus.OK);
    }

}
