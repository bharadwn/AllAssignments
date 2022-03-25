/**
 * Tech department will contain 4 methods of return type String and will not accept any parameter
 *                i)  departmentName
 *               ii)  getTodaysWork
 *               iii) getWorkDeadline
 *               iv) getTechStackInformation
 *
 * departmentName will return “ Tech Department “
 * getTodaysWork will return  “ Complete coding of module 1”
 * getWorkDeadline will return “ Complete by EOD “
 * getTechStackInformation will return “core Java”
 */
package AssignmentFOP1;

public class TechDepartment extends SuperDepartment{
    String departmentName(){
        return " Tech Department ";
    }
    String getTodaysWork(){
        return  " Complete coding of module 1";
    }
    String getWorkDeadline(){
        return " Complete by EOD ";
    }
    String getTechStackInformation(){
        return "core Java";
    }
}
