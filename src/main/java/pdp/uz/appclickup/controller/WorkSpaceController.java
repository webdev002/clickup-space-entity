package pdp.uz.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appclickup.entity.User;
import pdp.uz.appclickup.entity.WorkSpace;
import pdp.uz.appclickup.entity.WorkSpaceRole;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.MemberDto;
import pdp.uz.appclickup.payload.WorkSpaceDTO;
import pdp.uz.appclickup.security.CurrentUser;
import pdp.uz.appclickup.service.WorkSpaceService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/workSpace")
public class WorkSpaceController {
    @Autowired
    WorkSpaceService workSpaceService;

    @PostMapping
    public HttpEntity<?> addWorkSpace(@Valid @RequestBody WorkSpaceDTO workSpaceDTO, @CurrentUser User user){
        ApiResponse apiResponse = workSpaceService.addWorkSpace(workSpaceDTO,user);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editWorkSpace(@PathVariable Integer id, @RequestBody WorkSpaceDTO workSpaceDTO,@CurrentUser User user){
        ApiResponse apiResponse = workSpaceService.editWorkSpace(id,workSpaceDTO,user);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/change/{id}")
    public HttpEntity<?> editOwnerWorkSpace(@PathVariable Integer id, @RequestParam Integer ownerId){
        ApiResponse apiResponse = workSpaceService.editOwnerWorkSpace(id,ownerId);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteWorkSpace(@Valid @PathVariable Integer id){
        ApiResponse apiResponse = workSpaceService.deleteWorkSpace(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }


    @PostMapping("/addOrEditOrRemove/{id}")
    public HttpEntity<?> addOrEditOrRemoveWorkSpace(@PathVariable Integer id,@RequestBody MemberDto memberDto){
        ApiResponse apiResponse = workSpaceService.addOrEditOrRemoveWorkSpace(id, memberDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/joinWorkSpace")
    public HttpEntity<?> joinWorkSpace(@RequestParam Integer id,@CurrentUser User user){
        ApiResponse apiResponse = workSpaceService.joinWorkSpace(id, user);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/getWorkSpaceMembersAndGuest")
    public HttpEntity<?> getWorkSpaceMembersAndGuest(){
        List<WorkSpaceRole> workSpaceMembersAndGuest = workSpaceService.getWorkSpaceMembersAndGuest();
        return ResponseEntity.ok(workSpaceMembersAndGuest);
    }
    @GetMapping()
    public HttpEntity<?> getWorkSpace(){
        List<WorkSpace> workSpace = workSpaceService.getWorkSpace();
        return ResponseEntity.ok(workSpace);
    }


}
