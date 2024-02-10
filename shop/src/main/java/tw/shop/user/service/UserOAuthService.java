package tw.shop.user.service;

import tw.shop.user.dto.UserOAuthDto;

public interface UserOAuthService {
	UserOAuthDto findByProviderUserId(String providerUserId);
	UserOAuthDto saveUserOAuth(UserOAuthDto userOAuthDto);
	// 其他需要的方法
}
