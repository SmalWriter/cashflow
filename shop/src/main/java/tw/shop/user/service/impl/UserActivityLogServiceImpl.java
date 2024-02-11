package tw.shop.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.shop.user.dto.UserActivityLogDto;
import tw.shop.user.dto.UserDto;
import tw.shop.user.model.User;
import tw.shop.user.model.UserActivityLog;
import tw.shop.user.repository.UserActivityLogRepository;
import tw.shop.user.service.UserActivityLogService;
import tw.shop.user.service.UserService;

@Service
public class UserActivityLogServiceImpl implements UserActivityLogService {

    private final UserActivityLogRepository logRepository;
    private final UserService userService; // 引用UserService

    @Autowired
    public UserActivityLogServiceImpl(UserActivityLogRepository logRepository, UserService userService) {
        this.logRepository = logRepository;
        this.userService = userService;
    }

    @Override
    public UserActivityLogDto logActivity(UserActivityLogDto logDto) {
        UserActivityLog log = new UserActivityLog();

        // 使用UserService获取UserDto
        UserDto userDto = userService.getUserById(logDto.getUserId());
        if (userDto == null) {
            throw new IllegalArgumentException("User with ID " + logDto.getUserId() + " not found.");
        }

        // 由于UserActivityLog需要关联到User实体，我们假设有方法将UserDto转换为User实体或至少创建一个具有正确ID的User代理实体
        User user = new User(); // 创建一个新的User实体或代理实体
        user.setUserId(userDto.getUserId()); // 假设UserDto包含getUserId方法

        log.setUser(user);
        log.setActivityType(logDto.getActivityType());
        log.setActivityDate(logDto.getActivityDate());
        log.setLogDescription(logDto.getDescription());

        log = logRepository.save(log);

        logDto.setLogId(log.getUserActivityLogId());
        return logDto;
    }
}
