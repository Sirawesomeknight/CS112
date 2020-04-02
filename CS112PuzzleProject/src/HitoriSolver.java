import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class HitoriSolver implements Solver{

    private int rowLength;

    private int[] testValues;

    public Spot[] savedSpots;

    public HitoriSolver(int rowLength){
        this.rowLength = rowLength;

    }

    private boolean checkOccurrences(int[] anArray, int num){
        int occurrences = 0;
        for(int i = 0; i < anArray.length; i++){
            if(anArray[num] == anArray[i] && anArray[num] != 0){
                occurrences++;
            }
            if(occurrences >= 2) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int checkConstraints(Spot[] spots) {
        int[] values = getValues(spots);

        int point = chooseSpot(values);
        int yp = getRowStart(point);
        int xp = getColStart(point);

        for(int i = 0; i < values.length; i++){
            testValues = getValues(spots);
            if(values[i] > 0){
                if(!moveToSquare(i,xp,yp)){
                    return 0;
                }
            }
        }

        for(int i = 0; i < rowLength; i++){
            if(getProblemsInRow(i,getValues(spots)).length != 0 || getProblemsInCol(i,getValues(spots)).length != 0){
                return 1;
            }
        }

        return 2;
    }

    private boolean moveToSquare(int num,int xp, int yp){
        if(testValues[num] == 0){
            return false;
        }
        if(testValues[num] == -1){
            return true;
        }
        if(testValues[num] == -2){
            return false;
        }

        int tx = getColStart(num);
        int ty = getRowStart(num);

        testValues[num] = -2;

        if(xp == tx && yp == ty){
            testValues[num] = -1;
            return true;
        }

        if(tx != 0 && moveToSquare(num - 1,xp,yp) && testValues[num - 1] != - 2){
            testValues[num] = -1;
            return true;
        }

        if(ty != 0 && moveToSquare(num - rowLength,xp,yp) && testValues[num - rowLength] != -2){
            testValues[num] = -1;
            return true;
        }

        if(tx != rowLength - 1 && moveToSquare(num + 1,xp,yp)){
            testValues[num] = -1;
            return true;
        }


        if(ty != rowLength - 1 && moveToSquare(num + rowLength,xp,yp)){
            testValues[num] = -1;
            return true;
        }

        return false;

    }

    private int chooseSpot(int[] values){
        int chosen = (int) Math.floor(Math.random() * values.length);
        if(values[chosen] == 0){
            return chooseSpot(values);
        }else{
            return chosen;
        }
    }

    @Override
    public boolean trySolveTree(Spot[] spots) {
        int checked = checkConstraints(spots.clone());
        if(checked == 0){
            return false;
        }else if(checked == 1){
            for(int i = 0; i < rowLength; i++){
                int[] getRowProblems = getProblemsInRow(i,getValues(spots));
                for(int j = 0; j < getRowProblems.length; j++){
                    Spot[] spots1 = new Spot[spots.length];
                    for(int x = 0; x < spots1.length; x++) {
                        if (getRowProblems[j] == x) {
                            spots1[x] = new Spot(0);
                        } else {
                            spots1[x] = new Spot(spots[x].getBtnValue());
                        }
                    }
                    if(trySolveTree(spots1)){
                        return true;
                    }else{
                        spots[getRowProblems[j]].setBtnValue(1);
                    }
                }
            }
            for(int i = 0; i < rowLength; i++){
                int[] getColProblems = getProblemsInCol(i,getValues(spots));
                for(int j = 0; j < getColProblems.length; j++){
                    Spot[] spots1 = new Spot[spots.length];
                    for(int x = 0; x < spots1.length; x++) {
                        if (getColProblems[j] == x) {
                            spots1[x] = new Spot(0);
                        } else {
                            spots1[x] = new Spot(spots[x].getBtnValue());
                        }
                    }
                    if(trySolveTree(spots1)){
                        return true;
                    }else{
                        spots[getColProblems[j]].setBtnValue(1);
                    }
                }
            }
            return false;
        }else{
            savedSpots = spots;
            return true;
        }
    }

    public boolean initialSolver(Spot[] spots){
        return trySolveTree(spots.clone());
    }

    private int[] getProblemsInRow(int rownum, int[] values){
        ArrayList<Integer> problems = new ArrayList<>();
        int[] row = getRow(rownum * rowLength,values);
        for(int j = 0; j < row.length; j++) {
            if(!checkOccurrences(row,j)){
                problems.add((rownum * rowLength) + j);
            }
        }
        int[] theArray = new int[problems.size()];
        for(int i = 0; i < theArray.length; i++){
            theArray[i] = problems.get(i);
        }
        return theArray;
    }

    private int[] getProblemsInCol(int colnum, int[] values){
        ArrayList<Integer> problems = new ArrayList<>();
        int[] col = getCol(colnum,values);
        for(int j = 0; j < col.length; j++) {
            if(!checkOccurrences(col,j)){
                problems.add(colnum + (col.length * j));
            }
        }
        int[] theArray = new int[problems.size()];
        for(int i = 0; i < theArray.length; i++){
            theArray[i] = problems.get(i);
        }
        return theArray;
    }

    private int getRowStart(int btn){
        return (int) Math.floor(btn / rowLength);
    }

    private int getColStart(int btn){
        return (btn % rowLength);
    }

    private int[] getRow(int btn,int[] values){
        int[] row = new int[rowLength];
        for(int i = 0; i < row.length; i++){
            row[i] = values[getRowStart(btn) * rowLength + i];
        }
        return row;
    }

    private int[] getCol(int btn,int values[]){
        int[] col = new int[rowLength];
        for(int i = 0; i < col.length; i++){
            col[i] = values[getColStart(btn) + (col.length * i)];
        }
        return col;
    }

    public int[] getValues(Spot[] spots){
        int[] nValues = new int[spots.length];
        for(int i = 0; i < nValues.length; i++){
            nValues[i] = spots[i].getBtnValue();
        }
        return nValues;
    }

    public Spot[] getSavedSpots(){
        return savedSpots;
    }
}
