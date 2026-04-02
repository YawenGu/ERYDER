public class feedback {
   
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

   
    public feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

   
    private StringBuilder feedbackUsingStringBuilder(String s1, String s2, String s3, String s4, String s5) {
        StringBuilder sb = new StringBuilder();
        sb.append(s1).append(" ").append(s2).append(" ").append(s3).append(" ").append(s4).append(" ").append(s5);
        return sb;
    }

    
    private String feedbackUsingConcatenation(String s1, String s2, String s3, String s4, String s5) {
        String concatenatedFeedback = s1 + " " + s2 + " " + s3 + " " + s4 + " " + s5;
        return concatenatedFeedback;
    }

    
    private boolean checkFeedbackLength(String completeFeedback) {
        this.longFeedback = completeFeedback.length() > 500;
        return this.longFeedback;
    }

  
    private void createReviewID(String firstName, String lastName, String completeFeedback) {
       
        String namePart = (firstName + lastName).substring(2, 6).toUpperCase();
       
        String feedbackPart = completeFeedback.substring(10, 15).toLowerCase();
       
        String tempID = namePart + feedbackPart + completeFeedback.length() + "_" + System.currentTimeMillis();
       
        this.reviewID = tempID.replace(" ", "");
    }

   
    public void analyseFeedback(boolean isConcatenation, String s1, String s2, String s3, String s4, String s5) {
        if (isConcatenation) {
            this.completeFeedback = feedbackUsingConcatenation(s1, s2, s3, s4, s5);
        } else {
            StringBuilder sb = feedbackUsingStringBuilder(s1, s2, s3, s4, s5);
            this.completeFeedback = sb.toString();
        }
        checkFeedbackLength(this.completeFeedback);
        createReviewID(this.firstName, this.lastName, this.completeFeedback);
    }

   
    @Override
    public String toString() {
        return "First Name: " + firstName + "\n" +
               "Last Name: " + lastName + "\n" +
               "Email: " + email + "\n" +
               "Complete Feedback: " + completeFeedback + "\n" +
               "Is Long Feedback: " + longFeedback + "\n" +
               "Review ID: " + reviewID;
    }

   
    public static void main(String[] args) {
       
        String s1 = "I was very satisfied with the service.";
        String s2 = "The e-Bike is quite comfortable to ride.";
        String s3 = "The battery life of the e-Bike is impressive.";
        String s4 = "The customer support was helpful and responsive.";
        String s5 = "I would recommend this e-Bike to my friends and family.";

        feedback feedback = new feedback("John", "Doe", "john.doe@example.com");
        
        feedback.analyseFeedback(false, s1, s2, s3, s4, s5);
       
        System.out.println(feedback);
    }
}