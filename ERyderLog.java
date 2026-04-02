

import java.time.LocalDateTime;

public class ERyderLog {
    private String action;
    private String userEmail;
    private LocalDateTime timestamp;

    public ERyderLog(String action, String userEmail) {
        this.action = action;
        this.userEmail = userEmail;
        this.timestamp = LocalDateTime.now();
    }

    public String getAction() {
        return action;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + action + " | User: " + userEmail;
    }
}