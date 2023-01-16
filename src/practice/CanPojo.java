package practice;

public class CanPojo {

    /*Create 4 objects by using Can class(
            private String season;
            private String courseName;
            private int averageScore;
            private int numberOfStudents;
            ) */
//Add them into a list
//Check if all average scores are less than 98
//Check if all course names contain "Day" word
//Check if any number of students is 154
//Check if any season is Winter
//Check if no number of students is 100
//Sort the elements in natural order according to the average score
//Sort the elements in reverse order according to the number of students
//Sort the elements in reverse order according to the course name

    private String season;
    private String courseName;
    private int averageScore;
    private int numberOfStudents;

    public CanPojo(String season, String courseName, int averageScore, int numberOfStudents) {
        this.season = season;
        this.courseName = courseName;
        this.averageScore = averageScore;
        this.numberOfStudents = numberOfStudents;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public String toString() {
        return "Can{" +
                "season='" + season + '\'' +
                ", courseName='" + courseName + '\'' +
                ", averageScore=" + averageScore +
                ", numberOfStudents=" + numberOfStudents +
                '}';
    }
}
