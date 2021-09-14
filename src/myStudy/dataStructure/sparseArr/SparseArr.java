package myStudy.dataStructure.sparseArr;

public class SparseArr {
    public static void main(String[] args) {
        //假设原始数组大小为11*11
        //1表示黑子，2表示蓝子，0表示无子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        //输出原始数组
        showArr(chessArr);
        //转化为稀疏数组

        //1.得到非0数据个数
        int sum = 0;
        for (int i=0; i<11; i++) {
            for (int j=0; j<11; j++) {
                if (chessArr[i][j]!=0) {
                    sum++;
                }
            }
        }
       //2.创建稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2]= sum;
       //3.获取非零数据以及位置
        int count = 0;//用于记录第几个非0数据
        for (int i=0; i<11; i++) {
            for (int j=0; j<11; j++) {
                if (chessArr[i][j]!=0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];

                }
            }
        }
        //4.输出稀疏矩阵
        showArr(sparseArr);
        //结束
        //接下来，通过稀疏数组恢复原始数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i=0; i<sparseArr[0][2];i++){
            chessArr2[sparseArr[i+1][0]][sparseArr[i+1][1]] = sparseArr[i+1][2];
        }
        showArr(chessArr2);
    }
    public static void showArr(int[][] arr){
        for (int [] row: arr){
            for(int data: row){
                System.out.print(data+" ");
            }
            System.out.println("");
        }
    }

}
