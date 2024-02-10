package tw.shop.product.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.shop.product.dto.ReviewDto;
import tw.shop.product.model.Review;
import tw.shop.product.repository.ReviewRepository;
import tw.shop.product.service.ReviewService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        Review review = modelMapper.map(reviewDto, Review.class);
        review = reviewRepository.save(review);
        return modelMapper.map(review, ReviewDto.class);
    }

    @Override
    public List<ReviewDto> findByProductId(Long productId) {
        return reviewRepository.findByProductId(productId).stream()
                .map(review -> modelMapper.map(review, ReviewDto.class))
                .collect(Collectors.toList());
    }
}
