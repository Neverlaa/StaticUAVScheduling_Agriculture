package Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Assignment { //一台UAV一趟灌溉方案
	
	int uavID; //UAV ID
	ArrayList<Integer> chessID;//无人机扫描经过的棋格的ID序列，按照先后次序排列
	int[][] distance; // 距离参数矩阵
	int bestLength; // 最佳长度
	int[] bestTour; // 最佳路径
	int firstArea;//起飞位置
	int error;//灌溉误差

}
