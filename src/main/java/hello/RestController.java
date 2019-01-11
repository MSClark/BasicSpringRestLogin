package hello;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestController {
	
	@RequestMapping(value="/api/user/login", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public String jsonTest(@RequestBody Login login, HttpServletRequest request) throws JSONException { 
		//requestBody is mapping a json obj to a login obj, creates and passes in at same time
		JSONObject status = new JSONObject();
		
		try {
			request.login(login.getUsername(), login.getPassword());
			status.put("success", true);
		} catch(Exception e) {
			status.put("success", false);
			status.put("error", e.toString());
		}
		
		return status.toString();
	}
}
