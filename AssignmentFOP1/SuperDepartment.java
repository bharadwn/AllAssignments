/**
 * → The assignment will contain 4 departments as four different object classes
 *                 i) Super Department
 *                ii) Admin Department
 *                iii) Hr Department
 *                iv) Tech Department
 *
 * → Super Department class will be the superclass and all other departments must extend it.
 *
 * → Super department will contain 4 methods of return type String and will not accept any parameter
 *                i)  departmentName
 *               ii)  getTodaysWork
 *               iii) getWorkDeadline
 *               iv) isTodayAHoliday
 *
 * departmentName will return “ Super Department “
 * getTodaysWork will return  “ No Work as of now”
 * getWorkDeadline will return “ Nil “
 * isTodayAHoliday will return “ Today is not a holiday”
 */
package AssignmentFOP1;

public class SuperDepartment {

   String departmentName() {
       return " Super Department ";
    }
    String getTodaysWork() {
        return " No Work as of now";
    }
    String getWorkDeadline() {
        return " Nil ";
    }
    String isTodayAHoliday() {
       return " Today is not a holiday";
    }
}
