package haagahelia.fi.mobileDatabase.web;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import haagahelia.fi.mobileDatabase.domain.Mobile;
import haagahelia.fi.mobileDatabase.domain.MobileRepository;
import haagahelia.fi.mobileDatabase.domain.TypeRepository;

@Controller
public class MobileController {
	@Autowired
	private MobileRepository repository; 

	@Autowired
	private TypeRepository drepository; 
	
	//Show all device
    @RequestMapping("/mobilelist")
    public String showMobile(Model model) {	
        model.addAttribute("mobiles", repository.findAll());
        return "mobilelist";
    }
    
    //Add new device
    @RequestMapping(value = "/add")
    public String addMobile(Model model){
    	model.addAttribute("mobile", new Mobile());
    	model.addAttribute("types", drepository.findAll());
        return "addmobile";
    } 
    
    
    //Edit device
	@GetMapping(value = "/edit/{id}")
	public String editMobile(@PathVariable("id") Long id, Model model) {
		model.addAttribute("mobile", repository.findById(id));
		model.addAttribute("types", drepository.findAll());
		return "editmobile";
	}
	
    
    //Save device
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Mobile mobile){
        repository.save(mobile);
        return "redirect:mobilelist";
    }
    
    //Delete device
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteMobile(@PathVariable("id") Long mobileId, Model model) {
    	repository.deleteById(mobileId);
        return "redirect:../mobilelist";
    }
    
    @GetMapping("/index")
    public String hello() {
      return "uploader";
    }

    @PostMapping("/upload") 
    public ResponseEntity<?> handleFileUpload( @RequestParam("file") MultipartFile file ) {

      String fileName = file.getOriginalFilename();
      try {
        file.transferTo( new File("C:\\upload\\" + fileName));
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      } 
      return ResponseEntity.ok("File uploaded successfully.");
    }
}
