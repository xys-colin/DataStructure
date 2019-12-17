package cn.qmulin.recursion;

/**
 * 迷宫问题
 */
public class MiGong {
    public static void main(String[] args) {
        //1.创建一个二维数组,模拟迷宫
        int[][] map=new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        setWay(map,1,1);
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }

    /**
     *  当map[i][j]为0表示该点没有走过,当为1表示墙,2表示通路可以走,3表示该点已经走过,走不通
     * @param map 表示地图
     * @param i 从那个位置开始找
     * @param j
     * @return 如果找到通道,返回为true,否则为false
     */
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5]==2){
            return true;
        }else{
            //如果当前这个点还没有走过
            if (map[i][j]==0){
                //按照策略 下->右->上->左 走
                map[i][j]=2;
                if (setWay(map,i+1,j)){//向下走
                    return true;
                }else if (setWay(map,i,j+1)){//向右走
                    return true;
                }else if (setWay(map,i-1,j)){//向上走
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
