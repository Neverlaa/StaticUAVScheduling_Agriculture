import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo07 {
    static int X = Tool.length;
    static int Y = Tool.length;
    static int visited[] = new int[Tool.length*Tool.length*Tool.length];
    static int count =0 ; // 用于计数


    public static void main(String[] args) {
        int n = Tool.length;  //N*N数组
        int[][] chessBoard = new int[X][Y]; //插入的数组
        double[] r = {5.0};

        //喷洒之前  数组初始化，随机生成的[0,100)之间的double数
        System.out.println("产生"+Tool.length*Tool.length+"个正态分布的随机数：");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessBoard[i][j] = (int)MapGenerator.randZT(2.0,3.5,r,12.0);
                System.out.print(chessBoard[i][j]+"  ");
            }
            System.out.println();
        }

        System.out.print("请输入(无人机)起始位置(先行数后列数)：");
        int row, column;
        Scanner sc = new Scanner(System.in);
        do{
            row = sc.nextInt();
            column = sc.nextInt();
        }while(row <= 0 || row > Y || column <= 0 || column>X);

        //喷洒之中
        int []res = new int[Tool.length*Tool.length*Tool.length];
        res = traversalChessBoard2(chessBoard,row-1,column-1,0);
       for(int i=0;i<count;i++){

           System.out.print((res[i]+1)+"-->");
           if((i+1)%(Tool.length)==0){
               System.out.println();
           }
       }
        System.out.println();
       //喷洒之后
        System.out.println("喷洒完之后的农田缺药分布如下：（负号表示过量）");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(chessBoard[i][j]+"  ");
            }
            System.out.println();
        }
        sc.close();
    }

    public static int[] traversalChessBoard2(int [][] chessBoard,int row,int column,int step){
        visited[step]=row * X + column;
        count++;
        chessBoard[row][column]--;// 此位置已访问一次
        ArrayList<Point> ps = UavFlightRules.next(new Point(column,row)); // 由当前位置得到下一次所有位置的集合
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            if (chessBoard[p.y][p.x]>0) { // 这个位置没有访问，那么就从这个位置开始进行下一次访问
                traversalChessBoard2(chessBoard, p.y, p.x,step+1);
            }
        }
       return visited;
    }


}
