package pdp.uz.appclickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pdp.uz.appclickup.entity.User;
import pdp.uz.appclickup.entity.enums.SystemRoleName;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.RegisterDto;
import pdp.uz.appclickup.repository.UserRepository;

import java.util.Optional;
import java.util.Random;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    @Lazy
    PasswordEncoder passwordEncoder;

    @Autowired
    @Lazy
    JavaMailSender javaMailSender;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));

    }

    public ApiResponse register(RegisterDto registerDto) {
        boolean exists = userRepository.existsByEmail(registerDto.getEmail());
        if (exists){
            return new ApiResponse("Bunday user mavjud",false);
        }

        User user = new User(
                registerDto.getFullName(),
                registerDto.getEmail(),
                passwordEncoder.encode(registerDto.getPassword()),
                SystemRoleName.SYSTEM_USER
        );
        int code = new Random().nextInt(999999);
        user.setEmailCode(String.valueOf(code).substring(0,4));
        userRepository.save(user);
        //EMAILGA XABAR YUBORISH
        sendEmail(user.getEmail(), user.getEmailCode());
        return new ApiResponse("User saqlandi",true);

    }


    public Boolean sendEmail(String sendingEmail, String emailCode) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("Test@pdp.com");
            mailMessage.setTo(sendingEmail);
            mailMessage.setSubject("Akkountni tasdiqlash");
            mailMessage.setText(emailCode);
            javaMailSender.send(mailMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ApiResponse verifyEmail(String email, String emailCode) {

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            if (emailCode.equals(user.getEmailCode())){
                user.setEnabled(true);
                userRepository.save(user);
                return new ApiResponse("Akkount Aktivlashtirildi",true);
            }
            return new ApiResponse("Kod xato",false);
        }
        return new ApiResponse("Buday user mavjud emas",false);
    }

//    public ApiResponse verifyEmail(String email, String emailCode) {
//        Optional<User> optionalUser = userRepository.findByEmail(email);
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            if (emailCode.equals(user.getEmailCode())) {
//                user.setEnabled(true);
//                userRepository.save(user);
//                return new ApiResponse("Acount aktivlashtirildi", true);
//            }
//            return new ApiResponse("Kod xato", false);
//        }
//        return new ApiResponse("Bunday user mavjud emas", false);
//    }
}
