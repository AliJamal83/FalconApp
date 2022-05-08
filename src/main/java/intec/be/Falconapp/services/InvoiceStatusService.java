package intec.be.Falconapp.services;


import intec.be.Falconapp.models.InvoiceStatus;
import intec.be.Falconapp.models.Location;
import intec.be.Falconapp.repositories.InvoiceStatusRepository;
import intec.be.Falconapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {


    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    //Get All invoices --> this method will return a list of countries
    public List<InvoiceStatus> getAllInvoices() {
        return invoiceStatusRepository.findAll();
    }

    // Get invoice By id
    public Optional<InvoiceStatus> findById(Integer id) {
        return invoiceStatusRepository.findById(id);
    }

    // Save New invoice
    public void save(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }


    // Delete invoice
    public void delete(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }
}
