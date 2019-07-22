import java.io.*;

public class TextReader {
    public static void main(String[] args) throws IOException {
        int n = Tool.length;  //N*N数组
        int[][] arr = new int[n][n]; //插入的数组
        int[][] arr2 = new int[n][n];;  //读取出的数组
        double[] r = {5.0};
        //数组初始化，随机生成的[0,100)之间的double数
        System.out.println("产生"+n*n+"个正态分布的随机数：");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = (int)MapGenerator.randZT(2.0,3.5,r,12.0);

            }
        }

        File file = new File("C:\\Users\\Asus\\Desktop\\array.txt");  //存放数组数据的文件

        FileWriter out = new FileWriter(file);  //文件写入流

        //将数组中的数据写入到文件中。每行各数据之间TAB间隔
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                out.write(arr[i][j]+"\t");
            }
            out.write("\r\n");
        }
        out.close();

        BufferedReader in = new BufferedReader(new FileReader(file));  //
        String line;  //一行数据
        int row=0;
        //逐行读取，并将每个数组放入到数组中
        while((line = in.readLine()) != null){
            String[] temp = line.split("\t");
            for(int j=0;j<temp.length;j++){
                arr2[row][j] = Integer.parseInt(temp[j]);
            }
            row++;
        }
        in.close();

        //显示读取出的数组
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr2[i][j]+"\t");
            }
            System.out.println();
        }
    }
}