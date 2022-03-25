/**
 * Dear Learner,
 *
 *
 *
 * Please find the below problem statement for the OOPs assessment
 *
 *
 *
 * Problem Statement - Graded Assessment - 1.docx
 *
 *
 *
 * This is an individual assignment.
 *
 *
 *
 * Solution Submission Instructions :
 *
 * Create a git repository name it as {yourName OOPsAssignmentSolution}, make it public
 * Push your solution to the repository
 * Submit the git URL link in the text entry box.
 * Notes
 *
 * Refer the Problem Statement document thoroughly before working on your project.
 * Total Score of the project is 50.
 * Complete the assessment before the deadline.
 *
 *
 * Regards
 *
 * Program Office
 *
 *
 * → Driver class Main will be used to create objects of HrDepartment, TechDepartment, AdminDepartment
 * → Each department will display all its functionalities.
 * → Each department  will display whether today is a holiday or not with the help of the Super Department.
 * (SuperDepartment will act as a super class for all the departments)
 */

package AssignmentFOP1;

public class Main {
    public static void main(String[] args) {
        SuperDepartment supDept = new SuperDepartment();//somehow adding this, did not want to miss the super class functionalities
        SuperDepartment HRdept = new HRDepartment();
        SuperDepartment TechDept = new TechDepartment();
        SuperDepartment AdminDept = new AdminDepartment();

        /*

        //I would use these below code to create the classes, but as I watched in the videos
        //and the problem statement mentioned to go through the Super , I am using the above statements
        //to create my classes.

        HRDepartment HRdept = new HRDepartment();
        TechDepartment TechDept = new TechDepartment();
        AdminDepartment AdminDept = new AdminDepartment();
         */

        // Admin Department functionalities
        System.out.println("-------Admin Department------");
        System.out.println("----------------------------");
        System.out.println(" Welcome to"+AdminDept.departmentName());
        System.out.println(AdminDept.getTodaysWork());
        System.out.println(AdminDept.getWorkDeadline());
        System.out.println(AdminDept.isTodayAHoliday());
        System.out.println("----------------------------");
        System.out.println();


        // HR Department functionalities
        System.out.println("-------HR Department------");
        System.out.println("----------------------------");
        System.out.println(" Welcome to"+HRdept.departmentName());
        System.out.println(HRdept.getTodaysWork());
        System.out.println(HRdept.getWorkDeadline());
        System.out.println(((HRDepartment) HRdept).doActivity());
        System.out.println(HRdept.isTodayAHoliday());
        System.out.println("----------------------------");
        System.out.println();

        // Tech Department functionalities
        System.out.println("------Tech Department------");
        System.out.println("----------------------------");
        System.out.println(" Welcome to"+TechDept.departmentName());
        System.out.println(TechDept.getTodaysWork());
        System.out.println(TechDept.getWorkDeadline());
        System.out.println(((TechDepartment) TechDept).getTechStackInformation());
        System.out.println(TechDept.isTodayAHoliday());
        System.out.println("----------------------------");
        System.out.println();

        // Super Department functionalities..adding this also to not miss the funtionalities of the super class
        //also to show that the printed messages are from the subclass except the one method which was not overridden
        System.out.println("-------Super Department------");
        System.out.println("----------------------------");
        System.out.println(" Welcome to"+supDept.departmentName());
        System.out.println(supDept.getTodaysWork());
        System.out.println(supDept.getWorkDeadline());
        System.out.println(supDept.isTodayAHoliday());//NOT Overridden
        System.out.println("----------------------------");

    }
}
