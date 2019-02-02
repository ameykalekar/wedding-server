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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

@RestController
public class StateCityController {

	List<LinkedTreeMap<String, String>> stateList;
	Set<String> states ;
	Map<String, List<String>> stateCityMap;

	List<StateCity> stateCityList = new ArrayList<>();
	public StateCityController() {
		try {
			String content = new String(Files
					.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("StateCity.json").toURI())));
			Gson gson = new Gson();
			stateList = gson.fromJson(content, List.class);

			stateList.forEach(x -> {
				StateCity stateCity = new StateCity();
				x.entrySet().stream().forEach(y -> {
					if (y.getKey().equals("id") ) {
						stateCity.setId(y.getValue());
					}
					if (y.getKey().equals("state")) {
						stateCity.setState(y.getValue());
					}
					if (y.getKey().equals("name")) {
						stateCity.setName(y.getValue());
					}
				});
				stateCityList.add(stateCity);
			});
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		states = new HashSet<>();
		stateCityList.stream().forEach(x-> states.add(x.getState()));
		stateCityList.stream().forEach(x-> System.out.println(x.getName()+ "-" + x.getState() ));
		cityByState = stateCityList.stream().collect(Collectors.groupingBy(StateCity::getState));
		
	}

	Map<String, List<StateCity>>  cityByState;
	public static class StateCity {
		private String id;
		private String name;
		private String state;

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

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}
	}

	String states1 = "[ {\"code\": \"AN\",\"name\": \"Andaman and Nicobar Islands\"}, "
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

	@RequestMapping("/api/states")
	public ResponseEntity<Set<String>> getAllStates() {
		return new ResponseEntity<Set<String>>(this.states, HttpStatus.OK);
	}

	
	  @RequestMapping("/api/states/{state}") public
	  ResponseEntity<List> getCityForState(@PathVariable("state") String state){
	  return new ResponseEntity<List>(this.cityByState.get(state),HttpStatus.OK);
	  }
	 

}
