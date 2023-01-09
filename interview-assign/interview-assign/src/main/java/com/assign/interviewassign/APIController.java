package com.assign.interviewassign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class APIController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private APIServiceImpl apiService;

    @GetMapping("/categories")
    public List<ResultDTO> getCategories(@RequestParam String category) {
        String url = String.format("https://api.publicapis.org/entries?category=%s", category);
        ResponseEntity<Map> apiResponse = restTemplate.getForEntity(url, Map.class);
        List<APIEntity> entries = (List<APIEntity>) apiResponse.getBody().get("entries");
        List<ResultDTO> list = new ArrayList<>();
		for(APIEntity entry:entries) {
				list.add(new ResultDTO(entry.getTitle(), entry.getDescription()));
		}
        return list;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveEntries(@RequestBody APIEntity apiEntity){
        try{
            apiService.saveAPIEntry(apiEntity);
            String message = "Entry Saved";
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        }catch (Exception e){
            String message = "Invalid Input";
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}