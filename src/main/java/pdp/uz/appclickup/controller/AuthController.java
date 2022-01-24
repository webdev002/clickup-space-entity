package pdp.uz.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appclickup.payload.LoginDto;
import pdp.uz.appclickup.entity.User;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.RegisterDto;
import pdp.uz.appclickup.security.JwtProvider;
import pdp.uz.appclickup.service.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public HttpEntity<?> register(@Valid @RequestBody RegisterDto registerDto){
        ApiResponse apiResponse = authService.register(registerDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:401).body(apiResponse);
    }

    @PostMapping("/login")
    public HttpEntity<?> login(@Valid @RequestBody LoginDto loginDto){
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
            User user =(User)authenticate.getPrincipal();
            String token = jwtProvider.generateToken(user.getEmail());
            return ResponseEntity.ok(token);
        }catch (Exception e){
            return ResponseEntity.ok(new ApiResponse("Parol yoki login xato",false));
        }

    }

    @PutMapping("/verifyEmail")
    public HttpEntity<?> login(@RequestParam String email,@RequestParam String emailCode){
        ApiResponse apiResponse = authService.verifyEmail(email, emailCode);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
