public class BikeRequest {
    private String userEmail;
    private String location;

    public BikeRequest(String userEmail, String location) {
        this.userEmail = userEmail;
        this.location = location;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "BikeRequest{" +
                "userEmail='" + userEmail + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}