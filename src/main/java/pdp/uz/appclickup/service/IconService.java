package pdp.uz.appclickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.appclickup.entity.Icons;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.IconDTO;
import pdp.uz.appclickup.repository.AttachmentRepository;
import pdp.uz.appclickup.repository.IconRepository;

@Service
public class IconService {
    @Autowired
    IconRepository iconRepository;

    @Autowired
    AttachmentRepository attachmentRepository;


    public ApiResponse addIcon(IconDTO iconDTO) {
        Icons icons  = new Icons();
        icons.setName(iconDTO.getName());
        icons.setColor(iconDTO.getColor());
        icons.setAttachment(attachmentRepository.getById(iconDTO.getAttachment()));
        iconRepository.save(icons);
        return new ApiResponse("Icons saqlandi",true);
    }

    public ApiResponse deleteIcon(Integer id) {
        iconRepository.deleteById(id);
        return new ApiResponse("Icon ochirildi",true);
    }
}
