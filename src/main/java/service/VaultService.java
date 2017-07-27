package service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

@Service("VaultService")
public class VaultService {
	
	private String iPlanetDirectoryPro;
	private String token;
	private String baseUrl = "http://127.0.0.1:8200/v1/";
	private String encryptUrl = "auth/openam/encrypt";
	static String charset = "UTF-8"; 
	
	public VaultService() {
		
	}
	
	public void setToken(String iPlanetDirectoryPro) {
		this.iPlanetDirectoryPro = iPlanetDirectoryPro;
	}
	public String getToken() {
		return this.iPlanetDirectoryPro;
	}
	
	public List<String> encrypt() throws Exception{
		System.out.println("Encrypting using token:"+iPlanetDirectoryPro);
		//curl -X POST -H "X-OpenAM-Token: AQIC5wM2LY4SfcyMDyxuZAhv2A7Pp9HthOPJB4qtO7WFV5c.*AAJTSQACMDEAAlNLABQtNzk3OTIxNDc0MDk1NjQ4MzY1MQACUzEAAA..*" -H "rootToken: 4dd598a9-78f6-b8e1-436d-2ed16ba547fb" 
		//http://127.0.0.1:8200/v1/auth/openam/encrypt
		
		String url = baseUrl + encryptUrl;

	try {
			   
			URL urlObj = new URL(url);
			 
            //String encoded = new sun.misc.BASE64Encoder().encode (loginPassword.getBytes());
			HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept-Charset", charset);
			con.setRequestProperty ("X-OpenAM-Token", iPlanetDirectoryPro);
			con.setRequestProperty ("rootToken", token);
			con.setDoOutput(true);

			//try (OutputStream output = con.getOutputStream()) {
			//    output.write(query.getBytes(charset));
			//}
			
			int responseCode = con.getResponseCode();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			List<String> out = new ArrayList<String>();
			while ((inputLine = in.readLine()) != null) {
			    System.out.println(inputLine);
				out.add(inputLine);
			}

			in.close();
			if(responseCode >= 300) {
            	throw new Exception(out.toString());
            }
			
			return out;
		} catch (Exception ex) {
          throw ex;
		}
	}

	public String getiPlanetDirectoryPro() {
		return iPlanetDirectoryPro;
	}

	public void setiPlanetDirectoryPro(String iPlanetDirectoryPro) {
		this.iPlanetDirectoryPro = iPlanetDirectoryPro;
	}

}
