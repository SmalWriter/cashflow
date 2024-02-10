package tw.shop.user.service;

import tw.shop.user.dto.UserActivityLogDto;

public interface UserActivityLogService {
    UserActivityLogDto logActivity(UserActivityLogDto logDto);
    // Additional methods can be added as needed
}
