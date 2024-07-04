package sehs.education.scholarship.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sehs.education.scholarship.domain.Application;
import sehs.education.scholarship.repository.ScholarshipRepository;

@Service
public class ScholarshipService {
@Autowired
private ScholarshipRepository repo;

public List<Application> listAll(){
 return repo.findAll();
 } 

public void save(Application app) {
 repo.save(app);
 } 
 
public Application get(long applicationid) {
 return repo.findById(applicationid).get();
 } 

public void delete(long applicationid) {
	 repo.deleteById(applicationid);
	 } 
}