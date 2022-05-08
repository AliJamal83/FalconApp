package intec.be.Falconapp.services;


import intec.be.Falconapp.models.JobTitle;
import intec.be.Falconapp.models.Location;
import intec.be.Falconapp.repositories.JobTitleRepository;
import intec.be.Falconapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository ;

    //Get All job titles --> this method will return a list of countries
    public List<JobTitle> getAllJobTitles() {
        return jobTitleRepository.findAll();
    }

    // Get job title By id
    public Optional<JobTitle> findById(Integer id) {
        return jobTitleRepository.findById(id);
    }

    // Save New job title
    public void save(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }


    // Delete job title
    public void delete(Integer id) {
        jobTitleRepository.deleteById(id);
    }
}
