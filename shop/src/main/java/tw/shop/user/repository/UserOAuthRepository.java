package tw.shop.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.shop.user.model.UserOAuth;

import java.util.Optional;

public interface UserOAuthRepository extends JpaRepository<UserOAuth, Long> {
    Optional<UserOAuth> findByProviderUserId(String providerUserId);
}
