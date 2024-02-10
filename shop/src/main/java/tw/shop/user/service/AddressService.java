package tw.shop.user.service;

import java.util.List;

import tw.shop.user.dto.AddressDto;

public interface AddressService {
    AddressDto createAddress(AddressDto addressDto);
    List<AddressDto> findByUserId(Long userId);
    // Additional methods as needed
}
