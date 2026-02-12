package kz.aitu.myservicee.controllers;


import kz.aitu.myservicee.entities.Candidate;
import kz.aitu.myservicee.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateService cdServ;

    @GetMapping("/{idY}")
    public Candidate getCandidateById(@PathVariable int idY){
        return cdServ.findById(idY);
    }

    @PostMapping("/add")
    public Candidate addCandidate(@RequestBody Candidate newcandi){
        return cdServ.save(newcandi);
    }
}
