/**
 * Hr department will contain 4 methods of return type String and will not accept any parameter
 *                i)  departmentName
 *               ii)  getTodaysWork
 *               iii) getWorkDeadline
 *               iv) doActivity
 *
 * departmentName will return “ Hr Department “
 * getTodaysWork will return  “ Fill today’s worksheet and mark your attendance”
 * getWorkDeadline will return “ Complete by EOD “
 * doActivity “team Lunch”
 */
package AssignmentFOP1;

public class HRDepartment extends SuperDepartment{

    String departmentName() {
        return " Hr Department ";
    }
    String getTodaysWork() {
        return  " Fill today’s worksheet and mark your attendance";
    }
    String getWorkDeadline(){
        return " Complete by EOD ";
    }
    String doActivity(){
        return "team Lunch";
    }
}
