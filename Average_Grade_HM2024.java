public class Average_Grade_HM2024{

    public static void main(String[] args){

        int student = 20; // I assigned students to 20 which is also the number of the rows but we can change it to any positive integer.

        int[][] scoreArray = new int[student][3];
        System.out.println("Exams :      q  m  f");
        initiateScoreArray(student, 3, scoreArray);
        System.out.print("----------------------------------------"); // This print code is for an aesthetic look for the clients.
        System.out.printf("Average of quiz is %.2f ",calculateAverages(student, scoreArray)[0]);
        System.out.printf("Average of midterm is %.2f ",calculateAverages(student, scoreArray)[1]);
        System.out.printf("Average of final is %.2f ",calculateAverages(student, scoreArray)[2]);
        System.out.println();
        System.out.println("----------------------------------------"); // This print code is for an aesthetic look for the clients.
        for(int i=0;i<student;i++){
            System.out.printf("Student %d's average is %.2f\n",i+1,calculateOverallGrade(student, scoreArray)[i][0]);
        }
        System.out.println("----------------------------------------"); // This print code is for an aesthetic look for the clients.
        for(int i=0;i<student;i++){
            System.out.printf("Student %d's letter grade is %s\n",i+1,calculateLetterGrade(student, scoreArray)[i][0]);
        }
    }
    // This method returns a one dimensional array that holds the average quiz,midterm and final grades.
    public static double[] calculateAverages(int row,int[][] array){
        System.out.println();
        double total_quiz=0;
        for(int i=0;i<row;i++){
            total_quiz += array[i][0]; // array[i][0] is for the i. student's quiz grade.
        } 
        double average_quiz = total_quiz/row;

        double total_midterm=0;
        for(int i=0;i<row;i++){
            total_midterm += array[i][1]; // array[i][1] is for the i. student's midterm grade.
        } 
        double average_midterm = total_midterm/row;

        double total_final=0;
        for(int i=0;i<row;i++){
            total_final += array[i][2]; // array[i][2] is for the i. student's final grade.
        } 
        double average_final = total_final/row;

        double[] averagesarr = new double[3]; // I created one dimensional array to store the average grades in it.
        averagesarr[0]=average_quiz;
        averagesarr[1]=average_midterm;
        averagesarr[2]=average_final;
        return averagesarr;
    }
    // This method doesn't return anything. It prints all the grades that students get in the exam whenever it's called.
    public static void initiateScoreArray(int row,int col,int[][] array){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                array[i][j] = (int)(Math.random()*101);
            }
        }
        for(int i=0;i<row;i++){
            System.out.printf("Student %d : ",i+1);
            for(int j=0;j<col;j++){
                int x = array[i][j];
                System.out.printf("%02d ",x);
            }
            System.out.println();
        } 
    }
    //This method returns the overall grade of the each student.
    public static double[][] calculateOverallGrade(int student,int[][] array){
        // I created a 2-dimensional array for the overallGrade, I assigned it's column to 1 because we are going to return
        // one value for each student. 
        double[][] overallGrade = new double[student][1];
        for(int i=0;i<student;i++){ 
            // array[i][0] is for the each student's quiz grades ; array[i][1] is for the each student's midterm grades
            // array[i][2] is for the each student's final grades.
            double grade = array[i][0] * 0.2 + array[i][1] * 0.3 + array[i][2] * 0.5;
            overallGrade[i][0] = grade;
        }
        return overallGrade;   
    }
    public static String[][] calculateLetterGrade(int student,int[][] array){
        // I created a 2-dimensional array for the letterGrade, I assigned it's column to 1 again because we are going to return
        // one value for each student.
        String[][] letterGrade = new String[student][1];
        String letter; // I declared a String named "letter" before the loop so I don't have to declare it for every "if" state.
        // I created a "for loop" to assign grade letters for each student's grade.
        for(int i=0;i<student;i++){
            if(calculateOverallGrade(student, array)[i][0]>=85 && calculateOverallGrade(student, array)[i][0]<=100){
            letter = "A";
            letterGrade[i][0] = letter;}
            else if(calculateOverallGrade(student, array)[i][0]>=65 && calculateOverallGrade(student, array)[i][0]<=84){
            letter = "B";
            letterGrade[i][0] = letter;}
            else if(calculateOverallGrade(student, array)[i][0]>=50 && calculateOverallGrade(student, array)[i][0]<=64){
            letter = "C";
            letterGrade[i][0] = letter;}
            else{
            letter = "F";
            letterGrade[i][0] = letter;}
        }
        return letterGrade;
    }
}