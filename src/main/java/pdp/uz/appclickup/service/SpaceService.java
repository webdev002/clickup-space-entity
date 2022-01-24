package pdp.uz.appclickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.appclickup.entity.*;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.SpaceDTO;
import pdp.uz.appclickup.repository.*;

import java.util.List;

@Service
public class SpaceService {
    @Autowired
    SpaceRepository spaceRepository;

    @Autowired
    IconRepository iconRepository;

    @Autowired
    WorkSpaceRepository workSpaceRepository;

    @Autowired
    SpaceUserRepository spaceUserRepository;

    @Autowired
    SpaceClickAppsRepository spaceClickAppsRepository;

    @Autowired
    ClickAppsRepository clickAppsRepository;

    public List<Space> getSpace() {
        List<Space> spaceList = spaceRepository.findAll();
        return spaceList;
    }

    public ApiResponse addSpace(SpaceDTO spaceDTO, User user) {
        boolean exists = spaceRepository.existsByOwnerIdAndName(user.getId(), spaceDTO.getName());
        if (exists){
            return new ApiResponse("Bu ownerda bunday namelik space mavjud",false);
        }
        Space space = new Space();
        space.setName(spaceDTO.getName());
        space.setColor(spaceDTO.getColor());
        space.setIcons(iconRepository.getById(spaceDTO.getIcons()));
        space.setAttachment(null);
        space.setWorkSpace(workSpaceRepository.getById(spaceDTO.getWorkSpace()));
        space.setAccessType("IT");
        spaceRepository.save(space);

        //space_user tableni yozamiz
        SpaceUser spaceUser = new SpaceUser(
                space,
                user
        );
        spaceUserRepository.save(spaceUser);

        //space_click_apps
        SpaceClickApps spaceClickApps = new SpaceClickApps(
                clickAppsRepository.getById(space.getId()),
                space
        );
        spaceClickAppsRepository.save(spaceClickApps);

        return new ApiResponse("SpaceUser saqlandi",true);
    }


    public ApiResponse editSpace(Integer id, SpaceDTO spaceDTO, User user) {
        boolean exists = spaceRepository.existsByNameAndIdNot(spaceDTO.getName(), id);
        if (exists){
            return new ApiResponse("Bunday space mavjud",false);
        }
        Space space = spaceRepository.getById(id);
        space.setName(spaceDTO.getName());
        space.setColor(spaceDTO.getColor());
        space.setIcons(iconRepository.getById(spaceDTO.getIcons()));
        space.setAttachment(null);
        space.setWorkSpace(workSpaceRepository.getById(spaceDTO.getWorkSpace()));
        space.setAccessType("IT");
        spaceRepository.save(space);

        //space_user tahrirlandi
        SpaceUser spaceUser = new SpaceUser(
                space,
                user
        );
        spaceUserRepository.save(spaceUser);

        //space_click_apps tahrirlandi
        SpaceClickApps spaceClickApps = new SpaceClickApps(
                clickAppsRepository.getById(space.getId()),
                space
        );
        spaceClickAppsRepository.save(spaceClickApps);

        return new ApiResponse("Space Tahrirlandi",true);
    }

    public ApiResponse deleteSpace(Integer id) {
        spaceRepository.deleteById(id);
        return new ApiResponse("Space Ochirildi",true);
    }

    public ApiResponse deleteSpaceUser(Integer id) {
        spaceUserRepository.deleteById(id);
        return new ApiResponse("SpaceUser ochirildi",true);
    }
}
