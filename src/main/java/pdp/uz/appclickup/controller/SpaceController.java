package pdp.uz.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appclickup.entity.Space;
import pdp.uz.appclickup.entity.User;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.SpaceDTO;
import pdp.uz.appclickup.security.CurrentUser;
import pdp.uz.appclickup.service.SpaceService;

import java.util.List;

@RestController
@RequestMapping("/api/space")
public class SpaceController {
    @Autowired
    SpaceService spaceService;

    @GetMapping
    public HttpEntity<?> getSpace(){
        List<Space> space = spaceService.getSpace();
        return ResponseEntity.ok(space);
    }

    @PostMapping
    public HttpEntity<?> addSpace(@RequestBody SpaceDTO spaceDTO, @CurrentUser User user){
        ApiResponse apiResponse = spaceService.addSpace(spaceDTO, user);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editSpace(@PathVariable Integer id,@RequestBody SpaceDTO spaceDTO,@CurrentUser User user){
        ApiResponse apiResponse = spaceService.editSpace(id, spaceDTO, user);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteSpace(@PathVariable Integer id){
        ApiResponse apiResponse = spaceService.deleteSpace(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/spaceUser/{id}")
    public HttpEntity<?> deleteSpaceUser(@PathVariable Integer id){
        ApiResponse apiResponse = spaceService.deleteSpaceUser(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

}
