package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.JobTitle;
import intec.be.Falconapp.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;


    @GetMapping("/jobTitles")
    public String findAll(Model model) {
        List<JobTitle> listOfJobTitle = jobTitleService.findAll();
        model.addAttribute("jobTitle", jobTitleService.findAll());
        return "JobTitle";

    }


    // Add New job title
    @PostMapping("/jobTitles/addNew")
    public String addNew(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitle";

    }

    @RequestMapping("jobTitles/findById")
    @ResponseBody
    public Optional<JobTitle> findById(Integer id) {
        return jobTitleService.findById(id);

    }


    // Update jb titles
    @RequestMapping(value = "/jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    private String update(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitle";
    }


    // Delete job titles
    @RequestMapping(value = "/jobTitles", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        jobTitleService.delete(id);
        return "redirect:/jobTitle";
    }
}
