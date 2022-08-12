import java.util.Scanner;

public class overTimeCount{
    static Scanner scanner = new Scanner(System.in);
    static String employeeID, employeeName;
    static int basicSalary;
    final static double normalOvertime = 1.25;
    final static double weekEndOvertime = 1.50;
    final static double publicOvertime = 2.00;
    final static double housingAllowance = 0.36;
    final static int transportAllowance = 30;
    static double normalHours, weekdayHours, publicHours, weekEndHours;
    static double totalWeekDay, totalWeekEnd, totalPublic;
    static int workingHours;
    public static void main(String[] args) {
        boolean bool1 = true;


        while (bool1){
        clearConsole();
        System.out.println("___________________________________________________");
        System.out.println("Welcome to my personal overtime database.");
        System.out.println("This program will count your overtime.");
        System.out.println("If im not so lazy I will link this to those who are rota 3/1");
        System.out.println("___________________________________________________");
        // System.out.println("Please read the follow instruction.");

        System.out.print("\n\nEnter your employee ID: ");
        employeeID = scanner.nextLine();
        System.out.print("Enter your name: ");
        employeeName = scanner.nextLine();
        clearConsole();
        intro();

        System.out.print("Enter your basic salary: ");
        basicSalary = scanner.nextInt();
        clearConsole();
        
        normalHours = (double)(basicSalary/26)/8;
        weekdayHours = normalHours * normalOvertime;
        weekEndHours = normalHours * weekEndOvertime;
        publicHours = normalHours * publicOvertime;

        vConsole1(employeeID, employeeName, basicSalary, normalHours);
        vConsole2();
        vConsole3();
        System.out.println("\n\n\n");
        System.out.print("Do you want to start again?\n 'Y' for yes and anykey to exit: ");
        char userChoose = scanner.next().charAt(0);
        scanner.nextLine();
        if(userChoose == 'Y' || userChoose == 'y'){
        }else{
            bool1 = false;
            System.exit(1);
        }

        }
        scanner.close();


    }

    public static void intro() {
        System.out.println("Name: " + employeeName + "\nEmployee ID: " + employeeID + "\n\n");
    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
    }

    public static double weekdayOT(double x, int basicSalary, int hoursSpent){
        int y;
        y = ((basicSalary/26)/8);
        x = y * normalOvertime;
        return x;
    }

    public static void vConsole1(String employeeID, String employeeName,int basicSalary, double normalHours){
        System.out.println("\n\n\t\t|-----------------------------------------------|");
        System.out.println("\t\t\tName: " + employeeName);
        System.out.println("\t\t\tID: " + employeeID);
        System.out.println("\t\t|-----------------------------------------------|");
        System.out.println("\t\t| Basic overtime per hour: " + " KWD " + normalHours + "\t\t|");
        System.out.println("\t\t| Weekday overtime per hour: " + " KWD " +  typeCast(weekdayHours) + "\t\t|");
        System.out.println("\t\t| Weekend overtime per hour: " + " KWD " + typeCast(weekEndHours) + "\t\t|");
        System.out.println("\t\t| Public overtime per hour: " + " KWD " + typeCast(publicHours) + "\t\t|");
        System.out.println("\t\t|-----------------------------------------------|");
    }   
    public static double typeCast (double x){
        int p =(int) (x*100);
        return p/100.00;
    }



    public static void vConsole2 (){
        System.out.print("\n\n\t\tEnter your weekday working hour: ");
        workingHours = scanner.nextInt();
        totalWeekDay = otConvert(workingHours,normalHours);
        System.out.println("\t\tWeekday total is: KWD " + totalWeekDay);

        System.out.print("\n\n\t\tEnter your weekend working hour: ");
        workingHours = scanner.nextInt();
        totalWeekEnd = otConvert(workingHours, weekdayHours);
        System.out.println("\t\tWeekday total is: KWD " + totalWeekEnd);
  
        System.out.print("\n\n\t\tEnter your public working hour - \n\t\tZero if none: ");
        workingHours = scanner.nextInt();
        totalPublic = otConvert(workingHours, publicHours);
        if (totalPublic <= 0) {
            System.out.println("\t\tNo Public holiday eh, sucks...");
            
        }else{
            System.out.println("\t\tWeekday total is: KWD " + totalPublic);
        }
        
    }

    public static void vConsole3(){
        System.out.println("\n\t\tYour total salary for next month is : " + typeCast(totalWeekDay + totalWeekEnd + totalPublic + (basicSalary * housingAllowance) + transportAllowance + basicSalary));
        System.out.println("\t\tBreakdown is as below: ");
        System.out.println("\t\t1) Basic Salary: KWD "  + basicSalary);
        System.out.println("\t\t2) Housing allowance: KWD " + (basicSalary*housingAllowance));
        System.out.println("\t\t3) Transportation allowance: KWD " + transportAllowance);
        System.out.println("\t\t4) Normal hours OT: KWD " + totalWeekDay);
        System.out.println("\t\t5) Weekend hours OT: KWD " + totalWeekEnd);
        if (totalPublic > 0) {
            System.out.println("\t\t6)Public hours OT: KWD "  + totalPublic);
        }else{
            System.out.println("\t\tNo Public Overtime recorded.");
        }

    }

    public static double otConvert(int workingHours, double normalOvertime) {
        double temp = workingHours * normalOvertime;
        return temp;
    }
}