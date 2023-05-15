package session14;

public class InvalidGradeException extends  Exception{
    private float invalidGrade;

    public InvalidGradeException() {
    }

    public InvalidGradeException(String message, float invalidGrade) {
        super(message);
        this.invalidGrade = invalidGrade;
    }

    public float getInvalidGrade() {
        return invalidGrade;
    }
}
