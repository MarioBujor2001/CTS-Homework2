
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        try{
            double result = Calculator.calculateXPow5PlusYPow7();
            System.out.println("Rezultatul este: " + result);
        }catch (IOException e){
            System.out.println("Error occured");
        }

        MatrixDataHandler mH = new MatrixDataHandler(5, 7, "matrix.txt");
        mH.modifyValueAndUpdateFile(3, 4, 345);
    }
}
