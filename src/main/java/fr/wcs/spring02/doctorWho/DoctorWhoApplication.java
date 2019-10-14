package fr.wcs.spring02.doctorWho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class DoctorWhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorWhoApplication.class, args);
	}

	@RequestMapping("/doctor/{id}")
	@ResponseBody
	public String showDoctor(@PathVariable int id) {
			
		String result = "";
		
		
		if (id < 9) {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "");
		}
		if (id > 13) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + id);
		}
			
			switch (id) {
			case 9:
				result = "number : " + id + " name : Christopher Eccleston";
				break;
			case 10:
				result = "number : " + id + " name : David Tennant";
				break;
			case 11:
				result = "number : " + id + " name : Matt Smith";
				break;
			case 12:
				result = "number : " + id + " name : Peter Capaldi";
				break;
			case 13:
				result = "number : " + id + " name : Jodie Whittaker";
				break;

			default:
				break;
			}
		

		return result;
	}

}
