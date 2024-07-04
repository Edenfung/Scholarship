package sehs.education.scholarship.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Application {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long applicationid;
private String studentname;
private String studentid;
private String gpa;
private String personal;
private String scholarshipid;
private String email;
private String fund;
private String process;
 
public Application() {
 super();
 } 
public Application(Long applicationid, 
		String studentname, 
		String studentid,
		String gpa,
		String personal,
		String scholarshipid,
		String email,
		String fund,
		String process) {
 super();
 this.applicationid = applicationid;
 this.studentname = studentname;
 this.studentid = studentid;
 this.gpa = gpa;
 this.personal = personal;
 this.scholarshipid = scholarshipid;
 this.email = email;
 this.fund = fund;
 this.process = process;
 } 

public Long getApplicationid() {
 return applicationid;
 
 } 
public void setApplicationid(Long applicationid) {
	this.applicationid = applicationid;
}

public String getStudentname() {
return studentname;
} 
public void setStudentname(String studentname) {
this.studentname = studentname;
}

public String getStudentid() {
return studentid;
} 
public void setStudentid(String studentid) {
this.studentid = studentid;
}

public String getGpa() {
return gpa;
} 
public void setGpa(String gpa) {
this.gpa = gpa;
}

public String getPersonal() {
return personal;
} 
public void setPersonal(String personal) {
this.personal = personal;
}

public String getScholarshipid() {
return scholarshipid;
} 
public void setScholarshipid(String scholarshipid) {
this.scholarshipid = scholarshipid;
}

public String getEmail() {
return email;
} 
public void setEmail(String email) {
this.email = email;
}

public String getFund() {
return fund;
} 
public void setFund(String fund) {
this.fund = fund;
}

public String getProcess() {
return process;
}
public void setProcess(String process) {
	this.process = process;
}

}