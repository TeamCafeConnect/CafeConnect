package com.yash.cafeconnect.service;

import com.yash.cafeconnect.entity.Feedback;
import java.util.List;

/**
 * Service interface for Feedback entity.
 */
public interface FeedbackService {
    // Add new Feedback
    void addFeedback(Feedback feedback);
    // Get Feedback by Id
    Feedback getFeedbackById(int feedbackId);
    // Update Feedback details
    void updateFeedback(Feedback feedback);
    // Remove Feedback by Id
    void removeFeedback(int feedbackId);
    // Get list of all Feedbacks
    List<Feedback> getFeedbacks();
}
