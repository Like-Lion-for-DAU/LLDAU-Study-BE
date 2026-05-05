package policy;

public class AdminHomeworkPolicy implements HomeworkPolicy {
    @Override
    public Boolean isSubmittable() {
        return false;
    }
}
