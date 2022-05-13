package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.Client;
import intec.be.Falconapp.models.Invoice;
import intec.be.Falconapp.models.InvoiceStatus;
import intec.be.Falconapp.services.ClientService;
import intec.be.Falconapp.services.InvoiceService;
import intec.be.Falconapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @Autowired
    private ClientService clientService;


    //Get All Invoices
    @GetMapping("invoices")
    public String findAll(Model model){

        List<Invoice> listOfInvoices = invoiceService.findAll();
        List<Client> listOfClients = clientService.findAll();
        List<InvoiceStatus> listOfInvoicesStatus = invoiceStatusService.findAll();

        model.addAttribute("invoices", invoiceService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("invoiceStatuses", invoiceStatusService.findAll());
        return "Invoice";
    }


    @RequestMapping("invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(Integer id)
    {
        return invoiceService.findById(id);
    }


    //Add Invoice
    @PostMapping(value="invoices/addNew")
    public String addNew(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }


    @RequestMapping(value="invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }


    @RequestMapping(value="invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        invoiceService.delete(id);
        return "redirect:/invoices";
    }
}



