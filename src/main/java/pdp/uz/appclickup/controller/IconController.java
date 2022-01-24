package pdp.uz.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.IconDTO;
import pdp.uz.appclickup.service.IconService;

@RestController
@RequestMapping("/api/icon")
public class IconController {
    @Autowired
    IconService iconService;

    @PostMapping
    public HttpEntity<?> addIcon(@RequestBody IconDTO iconDTO){
        ApiResponse apiResponse = iconService.addIcon(iconDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteIcon(@PathVariable Integer id){
        ApiResponse apiResponse = iconService.deleteIcon(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:403).body(apiResponse);
    }
}
