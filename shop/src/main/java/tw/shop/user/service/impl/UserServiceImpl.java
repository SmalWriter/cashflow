package tw.shop.user.service.impl;

import tw.shop.user.dto.UserDto;
import tw.shop.user.model.User;
import tw.shop.user.repository.UserRepository;
import tw.shop.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setPasswordHash(passwordEncoder.encode(userDto.getPassword()));
        user = userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        modelMapper.map(userDto, user);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
