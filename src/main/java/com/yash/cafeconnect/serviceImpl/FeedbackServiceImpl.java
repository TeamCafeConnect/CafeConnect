package com.yash.cafeconnect.serviceImpl;

import com.yash.cafeconnect.entity.Feedback;
import com.yash.cafeconnect.dao.FeedbackDao;
import com.yash.cafeconnect.daoImpl.FeedbackDaoImpl;
import com.yash.cafeconnect.service.FeedbackService;
import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private FeedbackDao feedbackDao = new FeedbackDaoImpl();
    public void addFeedback(Feedback feedback) {
        if(feedbackDao.getFeedback(feedback.getFeedbackId()) != null){
            throw new IllegalStateException("Feedback with this Id already exists");
        }
        feedbackDao.saveFeedback(feedback);
    }
    public Feedback getFeedbackById(int feedbackId) {
        return feedbackDao.getFeedback(feedbackId);
    }
    public void updateFeedback(Feedback feedback) {
        if(feedbackDao.getFeedback(feedback.getFeedbackId()) == null){
            throw new IllegalStateException("Feedback with this Id does not exist");
        }
        feedbackDao.updateFeedback(feedback);

    }
    public void removeFeedback(int feedbackId) {
        if(feedbackDao.getFeedback(feedbackId) == null){
            throw new IllegalStateException("Feedback with this Id does not exist");
        }
        feedbackDao.deleteFeedback(feedbackId);
    }
    public List<Feedback> getFeedbacks() {
        return feedbackDao.getFeedbacks();
    }
}
