package edu.ib.technologiesieciowe.service;

import org.springframework.stereotype.Service;

import edu.ib.technologiesieciowe.exception.EntityNotFoundException;
import edu.ib.technologiesieciowe.model.Review;
import edu.ib.technologiesieciowe.repository.ReviewRepository;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Iterable<Review> getAll() {
        return reviewRepository.findAll();
    }

    public Review getOne(int reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow(EntityNotFoundException::create);
    }

    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    public void delete(int reviewId) {
        if (!reviewRepository.existsById(reviewId)) {
            throw EntityNotFoundException.create();
        }
        reviewRepository.deleteById(reviewId);
    }
}
