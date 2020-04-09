import java.util.Vector;

public class FeedbackVector
{
    private Vector<Feedback> feedbackVector = new Vector<>();

    public FeedbackVector(){
        feedbackVector.add(new Feedback("User1","user@user1","Comment 1"));
        feedbackVector.add(new Feedback("User2","user@user2","Comment 2"));
        feedbackVector.add(new Feedback("User3","user@user3","Comment 3"));

    }

    public void addFeedback(String name, String email, String comment){
        Feedback fb = new Feedback(name,email,comment);
        feedbackVector.add(fb);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Feedback fb: feedbackVector) {
            sb.append(fb.toString());
        }
        return sb.toString();
    }

    public class Feedback{
        String name;
        String email;
        String comment;

        public Feedback(String name, String email, String comment){
            this.name = name;
            this.email = email;
            this.comment = comment;
        }

        @Override
        public String toString() {
            return "<p><b>"+name+" ("+email+")</b></p>"+comment+"<br><br>";
        }
    }
}
