/**
 * Admin department will contain 3 methods of return type String and will not accept any parameter
 *                i)  departmentName
 *               ii)  getTodaysWork
 *               iii) getWorkDeadline
 *
 * departmentName will return “ Admin Department “
 * getTodaysWork will return “Complete your documents Submission”
 * getWorkDeadline will return “ Complete by EOD “
 */
package AssignmentFOP1;

public class AdminDepartment  extends SuperDepartment{
    String departmentName(){
        return " Admin Department ";
    }
    String getTodaysWork(){
        return "Complete your documents Submission";
    }
    String getWorkDeadline(){
        return " Complete by EOD " ;
    }
}
