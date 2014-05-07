package ua.yandex.shad.socnet.domain.student;

/**
 *
 * @author Amdrii
 */
public class Student {
    private Integer studentID;
    private String studentName;
    private Integer studentYear;

    public Student(){
    }
    
    public Student(String studentName, Integer studentYear) {
        this.studentName = studentName;
        this.studentYear = studentYear;
    }    

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(Integer studentYear) {
        this.studentYear = studentYear;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.studentName != null ? this.studentName.hashCode() : 0);
        hash = 13 * hash + (this.studentYear != null ? this.studentYear.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if ((this.studentName == null) ? (other.studentName != null) : !this.studentName.equals(other.studentName)) {
            return false;
        }
        if (this.studentYear != other.studentYear && (this.studentYear == null || !this.studentYear.equals(other.studentYear))) {
            return false;
        }
        return true;
    }    
    
    @Override
    public String toString() {
        return "Student{" + "sudentID=" + studentID + ", studenName=" + studentName + ", studentYear=" + studentYear + '}'+"\n";
    }    
}
