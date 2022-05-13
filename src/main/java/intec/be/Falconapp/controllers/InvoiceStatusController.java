package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.InvoiceStatus;
import intec.be.Falconapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;


    @GetMapping("/invoiceStatuses")
    public String findAll(Model model) {
        List<InvoiceStatus> listOfInvoiceStatuses = invoiceStatusService.findAll();
        model.addAttribute("invoiceStatuses", invoiceStatusService.findAll());
        return "InvoiceStatus";

    }


    // Add New invoices
    @PostMapping("/invoiceStatuses/addNew")
    public String addNew(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatus";

    }

    @RequestMapping("invoiceStatuses/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findById(Integer id) {
        return invoiceStatusService.findById(id);

    }


    // Update invoice status
    @RequestMapping(value = "/invoiceStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    private String update(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatus";
    }


    // Delete invoice status
    @RequestMapping(value = "/invoiceStatuses", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        invoiceStatusService.delete(id);
        return "redirect:/invoiceStatus";
    }
}
