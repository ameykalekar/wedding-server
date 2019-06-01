package com.main.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

@RestController
public class ReligionCasteController {

	List<LinkedTreeMap<String, String>> religionList;
	Set<String> religion ;
	Map<String, List<String>> religionCasteMap;

	List<ReligionCaste> religionCasteList = new ArrayList<>();
	public ReligionCasteController() {
		try {
			String content = new String(Files
					.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("ReligionCaste.json").toURI())));
			Gson gson = new Gson();
			religionList = gson.fromJson(content, List.class);

			religionList.forEach(x -> {
				ReligionCaste religionCaste = new ReligionCaste();
				x.entrySet().stream().forEach(y -> {
					if (y.getKey().equals("id") ) {
						religionCaste.setId(y.getValue());
					}
					if (y.getKey().equals("religion")) {
						religionCaste.setReligion(y.getValue());
					}
					if (y.getKey().equals("name")) {
						religionCaste.setName(y.getValue());
					}
				});
				religionCasteList.add(religionCaste);
			});
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		religion = new HashSet<>();
		religionCasteList.stream().forEach(x-> religion.add(x.getReligion()));
		religionCasteList.stream().forEach(x-> System.out.println(x.getName()+ "-" + x.getReligion() ));
		casteByReligion = religionCasteList.stream().collect(Collectors.groupingBy(ReligionCaste::getReligion));
		
	}

	Map<String, List<ReligionCaste>>  casteByReligion;
	public static class ReligionCaste {
		private String id;
		private String name;
		private String religion;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getReligion() {
			return religion;
		}

		public void setReligion(String religion) {
			this.religion = religion;
		}
	}

	String religions1 = "[ {\"code\": \"AN\",\"name\": \"Andaman and Nicobar Islands\"}, "
			+ " {\"code\": \"AP\",\"name\": \"Andhra Pradesh\"}, "
			+ " {\"code\": \"AR\",\"name\": \"Arunachal Pradesh\"}, " + " {\"code\": \"AS\",\"name\": \"Assam\"}, "
			+ " {\"code\": \"BR\",\"name\": \"Bihar\"}, " + " {\"code\": \"CG\",\"name\": \"Chandigarh\"}, "
			+ " {\"code\": \"CH\",\"name\": \"Chhattisgarh\"}, "
			+ " {\"code\": \"DH\",\"name\": \"Dadra and Nagar Haveli\"}, "
			+ " {\"code\": \"DD\",\"name\": \"Daman and Diu\"}, " + " {\"code\": \"DL\",\"name\": \"Delhi\"}, "
			+ " {\"code\": \"GA\",\"name\": \"Goa\"}, " + " {\"code\": \"GJ\",\"name\": \"Gujarat\"}, "
			+ " {\"code\": \"HR\",\"name\": \"Haryana\"}, " + " {\"code\": \"HP\",\"name\": \"Himachal Pradesh\"}, "
			+ " {\"code\": \"JK\",\"name\": \"Jammu and Kashmir\"}, " + " {\"code\": \"JH\",\"name\": \"Jharkhand\"}, "
			+ " {\"code\": \"KA\",\"name\": \"Karnataka\"}, " + " {\"code\": \"KL\",\"name\": \"Kerala\"}, "
			+ " {\"code\": \"LD\",\"name\": \"Lakshadweep\"}, " + " {\"code\": \"MP\",\"name\": \"Madhya Pradesh\"}, "
			+ " {\"code\": \"MH\",\"name\": \"Maharashtra\"}, " + " {\"code\": \"MN\",\"name\": \"Manipur\"}, "
			+ " {\"code\": \"ML\",\"name\": \"Meghalaya\"}, " + " {\"code\": \"MZ\",\"name\": \"Mizoram\"}, "
			+ " {\"code\": \"NL\",\"name\": \"Nagaland\"}, " + " {\"code\": \"OR\",\"name\": \"Odisha\"}, "
			+ " {\"code\": \"PY\",\"name\": \"Puducherry\"}, " + " {\"code\": \"PB\",\"name\": \"Punjab\"}, "
			+ " {\"code\": \"RJ\",\"name\": \"Rajasthan\"}, " + " {\"code\": \"SK\",\"name\": \"Sikkim\"}, "
			+ " {\"code\": \"TN\",\"name\": \"Tamil Nadu\"}, " + " {\"code\": \"TS\",\"name\": \"Telangana\"}, "
			+ " {\"code\": \"TR\",\"name\": \"Tripura\"}, " + " {\"code\": \"UK\",\"name\": \"Uttarakhand\"}, "
			+ " {\"code\": \"UP\",\"name\": \"Uttar Pradesh\"}, " + " {\"code\": \"WB\",\"name\": \"West Bengal\"}]";

	@RequestMapping("/api/religions")
	public ResponseEntity<Set<String>> getAllReligions() {
		return new ResponseEntity<Set<String>>(this.religion, HttpStatus.OK);
	}

	
	  @RequestMapping("/api/religions/{religion}") public
	  ResponseEntity<List> getCasteForReligion(@PathVariable("religion") String religion){
	  return new ResponseEntity<List>(this.casteByReligion.get(religion),HttpStatus.OK);
	  }
	 
	  
	  @GetMapping("/api/caste/castes") 
	  public ResponseEntity<List<String>> getAllCities(){
		  List<ReligionCaste> religionCaste = this.casteByReligion.entrySet().stream().flatMap(x->x.getValue().stream()).collect(Collectors.toList());
		   return new ResponseEntity<List<String>>(religionCaste.stream().map(x->x.name).collect(Collectors.toList()),HttpStatus.OK);
	  }

}
