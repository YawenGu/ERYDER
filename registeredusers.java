public class RegisteredUsers {
    private String name;
    private String emailAddress;
    private String dateOfBirth;
    private String cardNumber;
    private String cardProvider;
    private String cardExpiryDate;
    private String cvv;
    private String userType;
    private String[] lastThreeTrips;

    public RegisteredUsers() {}

    public RegisteredUsers(String name, String emailAddress, String dateOfBirth,
                           String cardNumber, String cardProvider,
                           String cardExpiryDate, String cvv,
                           String userType, String[] lastThreeTrips) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
        this.cardProvider = cardProvider;
        this.cardExpiryDate = cardExpiryDate;
        this.cvv = cvv;
        this.userType = userType;
        this.lastThreeTrips = lastThreeTrips;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardProvider() {
        return cardProvider;
    }

    public void setCardProvider(String cardProvider) {
        this.cardProvider = cardProvider;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String[] getLastThreeTrips() {
        return lastThreeTrips;
    }

    public void setLastThreeTrips(String[] lastThreeTrips) {
        this.lastThreeTrips = lastThreeTrips;
    }
}