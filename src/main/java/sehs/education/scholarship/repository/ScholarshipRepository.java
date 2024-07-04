package sehs.education.scholarship.repository;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
import sehs.education.scholarship.domain.Application;

@Repository
public interface ScholarshipRepository extends JpaRepository<Application, Long>{
}