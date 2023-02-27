import java.io.*;
import java.util.regex.PatternSyntaxException;

public class MatrixDataHandler {
    private int[][] matrix;
    private int height;
    private int width;
    private final String filename;
    public MatrixDataHandler(int height, int width, String filename) {
        this.height = height;
        this.width = width;
        this.filename = filename;
        allocateMatrix();
        saveMatrixToFile();
    }
    public int getValueFromPosition(int posH, int posW) {
        try {
            readMatrixFromFile();
            return matrix[posH][posW];
        } catch (IndexOutOfBoundsException exception) {
            System.out.println(exception.getMessage());
            return -1;
        }
    }
    public void modifyValueAndUpdateFile(int posHeight, int posWidth, int newValue) {
        try {
            readMatrixFromFile();
            matrix[posHeight][posWidth] = newValue;
            saveMatrixToFile();
        } catch (IndexOutOfBoundsException exception) {
            System.out.println(exception.getMessage());
        }
    }

    // modified part of code:
    public void saveMatrixToFile(){
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(height + " " + width + "\n");
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    fw.write(matrix[i][j] + " ");
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void readMatrixFromFile(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            height = Integer.parseInt(line.split(" ")[0]);
            width = Integer.parseInt(line.split(" ")[1]);

            for (int i = 0; i < height; i++) {
                line = br.readLine();
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = Integer.parseInt(line.split(" ")[j]);
                }
            }
            br.close();
        }catch (IOException | NumberFormatException | PatternSyntaxException | IndexOutOfBoundsException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void allocateMatrix(){
        matrix = new int[height][];
        for (int i = 0; i < height; i++) {
            matrix[i] = new int[width];
        }
    }
}


