package pdp.uz.appclickup.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pdp.uz.appclickup.entity.Attachment;
import pdp.uz.appclickup.entity.User;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkSpaceDTO {

    @NotNull(message = "name bosh bolmasin")
    private String name;

    @NotNull(message = "color bosh bolmasin")
    private String color;

    private Integer avatarId;

}
