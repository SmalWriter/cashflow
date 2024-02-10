package tw.shop.user.service.impl;

import tw.shop.user.dto.UserOAuthDto;
import tw.shop.user.model.User;
import tw.shop.user.model.UserOAuth;
import tw.shop.user.repository.UserOAuthRepository;
import tw.shop.user.service.UserOAuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserOAuthServiceImpl implements UserOAuthService {
    
	
    private final UserOAuthRepository userOAuthRepository;

    @Autowired
    public UserOAuthServiceImpl(UserOAuthRepository userOAuthRepository) {
        this.userOAuthRepository = userOAuthRepository;
    }
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserOAuthDto findByProviderUserId(String providerUserId) {
        UserOAuth userOAuth = userOAuthRepository.findByProviderUserId(providerUserId)
                .orElseThrow(() -> new RuntimeException("UserOAuth not found"));
        return new UserOAuthDto(userOAuth.getUserOAuthId(), userOAuth.getUser().getUserId(), userOAuth.getProviderName(), userOAuth.getProviderUserId());
    }

    @Override
    public UserOAuthDto saveUserOAuth(UserOAuthDto userOAuthDto) {
        UserOAuth userOAuth = new UserOAuth(/* Construct UserOAuth from DTO */);
        // 设置 userOAuth 属性
        userOAuth = userOAuthRepository.save(userOAuth);
        return new UserOAuthDto(userOAuth.getUserOAuthId(), userOAuth.getUser().getUserId(), userOAuth.getProviderName(), userOAuth.getProviderUserId());
    }

    // 实现其他方法
}
