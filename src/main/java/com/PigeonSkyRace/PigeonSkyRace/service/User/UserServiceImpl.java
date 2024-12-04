package com.PigeonSkyRace.PigeonSkyRace.service.User;

import com.PigeonSkyRace.PigeonSkyRace.Mapper.UserMapper;
import com.PigeonSkyRace.PigeonSkyRace.dto.Request.RegisterUserRequestDto;
import com.PigeonSkyRace.PigeonSkyRace.dto.Response.RegisterUserResponseDto;
import com.PigeonSkyRace.PigeonSkyRace.enums.UserRoles;
import com.PigeonSkyRace.PigeonSkyRace.model.User;
import com.PigeonSkyRace.PigeonSkyRace.repository.UserRepository;
import com.PigeonSkyRace.PigeonSkyRace.security.PasswordEncoder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    @Override
    public RegisterUserResponseDto Register(RegisterUserRequestDto user) {
        User userToStore = User.builder().username(user.username()).password(passwordEncoder.encode(user.password())).role(UserRoles.ROLE_USER).build();
        userToStore = userRepository.save(userToStore);
        return userMapper.toRegisterUserResponseDto(userToStore);
    }
}
