package sehs.education.scholarship.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import sehs.education.scholarship.domain.Application;
import sehs.education.scholarship.service.ScholarshipService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
@Controller
public class ScholarshipController {

    @Autowired
    private ScholarshipService service;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/")
    public String homepage(Model model) {
    	String query = "SELECT * FROM scholarship";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        model.addAttribute("records", rows);
        return "index";
    }
    
    @GetMapping("/index")
    public String home(Model model) {
    	String query = "SELECT * FROM scholarship";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        model.addAttribute("records", rows);
        return "index";
    }

    @GetMapping("/student")
    public String Application(Model model) {
        List<Application> listapplication = service.listAll();
        model.addAttribute("listapplication", listapplication);
        return "student";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("theapplication", new Application());
        return "new";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        List<Application> listapplication = service.listAll();
        model.addAttribute("listapplication", listapplication);
        System.out.print("Get /");
        return "admin";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        return "edit";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
            Model model) {
        if (validateLogin(username, password)) {
            return "redirect:/admin";
        } else {
            model.addAttribute("loginError", true);
            return "login";
        }
    }

    private boolean validateLogin(String username, String password) {
        try {
            String sql = "SELECT COUNT(*) FROM admin WHERE username = ? AND password = ?";
            int count = jdbcTemplate.queryForObject(sql, Integer.class, username, password);
            return count == 1;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
    
    @PostMapping("/admin")
    public String approval(String checkid) {
    	try {
    		String query1 = "UPDATE application set process='Approved' where id=?";
    		String query2 = "UPDATE application set process='Rejected' where id=?";
    	} catch (EmptyResultDataAccessException e) {
    		return "";
    	}
    	return "admin";
    }
    
    @GetMapping("/success")
    public String success(Model model) {
        return "success";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveApplication(@ModelAttribute("theapplication") Application app) {
    	app.setProcess("Processing");
        service.save(app);
        return "redirect:/success";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editApplication(@ModelAttribute("theapplication") Application app) {
        service.save(app);
        return "redirect:/admin";
    }
    

    @RequestMapping("/edit/{applicationid}")
    public ModelAndView showEditApplicationPage(@PathVariable(name = "applicationid") int applicationid) {
        ModelAndView mav = new ModelAndView("edit");
        Application app = service.get(applicationid);
        mav.addObject("theapplication", app);
        return mav;
    }
    
    @RequestMapping("/approval/{applicationid}")
    public ModelAndView showApproveApplicationPage(@PathVariable(name = "applicationid") int applicationid) {
        ModelAndView mav = new ModelAndView("approval");
        Application app = service.get(applicationid);
        mav.addObject("theapplication", app);
        return mav;
    }

    @RequestMapping("/delete/{applicationid}")
    public String deleteApplication(@PathVariable(name = "applicationid") int applicationid) {
        service.delete(applicationid);
        return "redirect:/admin";
    }
}