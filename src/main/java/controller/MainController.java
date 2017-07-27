package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import model.EncryptData;
import service.VaultService;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

	@Autowired
	private VaultService vaultService;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String getView(@CookieValue(value="iPlanetDirectoryPro", required=false) String iPlanetDirectoryPro) {
		System.out.println("Processing redirect request...");
		if(iPlanetDirectoryPro != null){
			System.out.println("iPlanetDirectoryPro is:" + iPlanetDirectoryPro);
			vaultService.setToken(iPlanetDirectoryPro);
		}
		else {
			System.out.println("iPlanetDirectoryPro is missing!");
		}
		
		System.out.println("Returning main view");
		return "main";
	}
	
	//@RequestMapping(value = "/encrypt", method = RequestMethod.POST)
	@RequestMapping(value="/encrypt",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String encryptData(@RequestBody EncryptData data) {
		System.out.println("Encrypting...:"+data.getData());
		
		vaultService.encrypt();
		
		return "[true]";
	}
	
	@RequestMapping(value="/settoken",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String setToken(@RequestBody String token) {
		System.out.println("Setting token...:"+token);
		
		vaultService.setToken(token);
		
		return "[true]";
	}

}
