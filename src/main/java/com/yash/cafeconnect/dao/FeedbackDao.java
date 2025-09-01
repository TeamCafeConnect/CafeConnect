package com.yash.cafeconnect.dao;

import com.yash.cafeconnect.entity.Feedback;
import java.util.List;

/**
 * The FeedbackDao interface defines the standard operations to be performed on Feedback entity.
 */
public interface FeedbackDao {
    // Saves a new Feedback
    void saveFeedback(Feedback feedback);

    /**
     * Retrieves Feedback based on feedbackId.
     * @param feedbackId
     * @return Feedback object
     */
    Feedback getFeedback(int feedbackId);

    // Update Feedback (matched by Id)
    void updateFeedback(Feedback feedback);

    // Delete Feedback by Id
    void deleteFeedback(int feedbackId);

    List<Feedback> getFeedbacks();
}

