package pdp.uz.appclickup.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pdp.uz.appclickup.entity.User;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {



    @NotNull(message = "fullName bosh bolmasin")
    private String fullName;

    @NotNull(message = "email bosh bolmasin")
    private String email;

    @NotNull(message = "password bosh bolmasin")
    private String password;
}
