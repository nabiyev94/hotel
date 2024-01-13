package net.javaguides.springboot.backend.model;

public class ReviewUpdateRequest {

    private String reviewTxt;

    public ReviewUpdateRequest() {
    }

    public ReviewUpdateRequest(String reviewTxt) {
        this.reviewTxt = reviewTxt;
    }

    public String getReviewTxt() {
        return reviewTxt;
    }

    public void setReviewTxt(String reviewTxt) {
        this.reviewTxt = reviewTxt;
    }
}
