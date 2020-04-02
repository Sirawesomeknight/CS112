import java.util.ArrayList;

public class SkyscraperSolver implements Solver {

    private Spot[] savedSpots;
    private int[] top;
    private int[] right;
    private int[] bottom;
    private int[] left;
    private int rowLength;

    public SkyscraperSolver(int rowLength, int[] top, int[] right, int[] bottom, int[] left){
        this.top = top;
        this.right = right;
        this.left = left;
        this.bottom = bottom;
        this.rowLength = rowLength;
    }

    @Override
    public int checkConstraints(Spot[] spots) {
        boolean isTopDone = TestSide(top,getValues(spots),false, false);
        boolean isRightDone = TestSide(right,getValues(spots),true, true);
        boolean isBottomDone = TestSide(bottom,getValues(spots),false, true);
        boolean isLeftDone = TestSide(left,getValues(spots),true, false);

        for(int i = 0; i < rowLength; i++) {
            int[] row = getRow(i * rowLength, getValues(spots));
            for (int j = 0; j < row.length; j++) {
                if (2 <= checkOccurrences(row, j) && row[j] != 0) {
                    return 0;
                }
                if(row[j] == 0){
                    return 1;
                }
            }
            if(getNumSeen(row) != left[i] || getNumSeen(reverseArray(row)) != right[i]){
                return 0;
            }
            int[] col = getCol(i,getValues(spots));
            for (int j = 0; j < row.length; j++) {
                if (2 <= checkOccurrences(col, j) && col[j] != 0) {
                    return 0;
                }
                if(col[j] == 0){
                    return 1;
                }
            }
            if(getNumSeen(col) != top[i] || getNumSeen(reverseArray(col)) != bottom[i]){
                return 0;
            }
        }

        if(isTopDone == true && isRightDone == true && isBottomDone == true && isLeftDone == true){
            return 2;
        }else{
            return 1;
        }

    }

    private int[] reverseArray(int[] anArray){
        int[] originalArray = anArray.clone();
        for(int i = 0; i < anArray.length; i++){
            anArray[i] = originalArray[anArray.length - 1 - i];
        }
        return anArray;
    }

    private boolean TestSide(int[] sideArray, int[] values, boolean isRow, boolean shouldReverse){
        int howManyDone = 0;
        for(int i = 0; i < rowLength; i++){
            int[] side;
            if(isRow){
                side = getRow(i * rowLength,values);
            }else{
                side = getCol(i,values);
            }
            if(shouldReverse){
                side = reverseArray(side);
            }
            if(getNumSeen(side) == sideArray[i]){
                howManyDone++;
            }
        }
        if(howManyDone == rowLength){
            return true;
        }else{
            return false;
        }
    }

    private int getNumSeen(int[] anArray){
        int currentTallest = 0;
        int numSeen = 0;
        String arrayString = "";
        for(int i = 0; i < anArray.length; i++){
            arrayString = arrayString + anArray[i] + ",";
        }
        for(int i = 0; i < anArray.length; i++){
            if(anArray[i] > currentTallest){
                currentTallest = anArray[i];
                numSeen++;
            }
        }
        return numSeen;
    }

    private int checkOccurrences(int[] anArray, int num){
        int occurrences = 0;
        for(int i = 0; i < anArray.length; i++){
            if(anArray[num] == anArray[i] && anArray[num] != 0){
                occurrences++;
            }
        }
        return occurrences;
    }

    private int checkOccurrencesOfNum(int[] anArray, int num){
        int occurrences = 0;
        for(int i = 0; i < anArray.length; i++){
            if(num == anArray[i]){
                occurrences++;
            }
        }
        return occurrences;
    }

    @Override
    public boolean trySolveTree(Spot[] spots) {
        int checked = checkConstraints(spots.clone());
        if(checked == 0){
            return false;
        }else if(checked == 1){
            for(int i = 0; i < spots.length; i++){
                if(spots[i].getBtnValue() == 0) {
                    int[] getPossibilities = getPossibilities(i, getValues(spots));
                    if(getPossibilities.length == 0){
                        return false;
                    }
                    for (int j = 0; j < getPossibilities.length; j++) {
                        Spot[] spots1 = new Spot[spots.length];
                        for (int x = 0; x < spots1.length; x++) {
                            if (i == x) {
                                spots1[x] = new Spot(getPossibilities[j]);
                            } else {
                                spots1[x] = new Spot(spots[x].getBtnValue());
                            }
                        }
                        if (trySolveTree(spots1)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }else{
            savedSpots = spots;
            return true;
        }
    }

    @Override
    public int[] getValues(Spot[] spots) {
        int[] nValues = new int[spots.length];
        for(int i = 0; i < nValues.length; i++){
            nValues[i] = spots[i].getBtnValue();
        }
        return nValues;
    }

    @Override
    public Spot[] getSavedSpots() {
        return savedSpots;
    }

    @Override
    public boolean initialSolver(Spot[] spots) {
        int[] reverse = new int[rowLength];
        for(int i = 0; i < rowLength; i++){
            reverse[i] = rowLength - i;
        }
        for (int i = 0; i < rowLength; i++) {
            if(right[i] == 1){
                spots[(rowLength - 1) + rowLength * i].selectBtn();
                spots[(rowLength - 1) + rowLength * i].setBtnValue(rowLength);
                spots[i * rowLength].selectBtn();
                spots[i * rowLength].setBtnValue(reverse[left[i] - 1]);
            }
            if(left[i] == 1){
                spots[i * rowLength].selectBtn();
                spots[i * rowLength].setBtnValue(rowLength);
                spots[(rowLength - 1) + rowLength * i].selectBtn();
                spots[(rowLength - 1) + rowLength * i].setBtnValue(reverse[right[i] - 1]);
            }
            if(top[i] == 1){
                spots[i].selectBtn();
                spots[i].setBtnValue(rowLength);
                spots[spots.length - rowLength + i].selectBtn();
                spots[spots.length - rowLength + i].setBtnValue(reverse[bottom[i] - 1]);
            }
            if(bottom[i] == 1){
                spots[spots.length - rowLength + i].selectBtn();
                spots[spots.length - rowLength + i].setBtnValue(rowLength);
                spots[i].selectBtn();
                spots[i].setBtnValue(reverse[top[i] - 1]);
            }
            if(top[i] == rowLength && bottom[i] == 1){
                for(int j = rowLength - 1; j >= 0; j--){
                    spots[j * rowLength + i].selectBtn();
                    spots[j * rowLength + i].setBtnValue(j + 1);
                }
            }
            if(top[i] == 1 && bottom[i] == rowLength){
                for(int j = 0; j < rowLength; j++){
                    spots[j * rowLength + i].selectBtn();
                    spots[j * rowLength + i].setBtnValue(j + 1);
                }
            }
            if(right[i] == rowLength && left[i] == 1){
                for(int j = 0; j < rowLength; j++){
                    spots[i * rowLength + j].selectBtn();
                    spots[i * rowLength + j].setBtnValue(j + 1);
                }
            }
            if(right[i] == 1 && left[i] == rowLength){
                for(int j = rowLength - 1; j >= 0; j--){
                    spots[i * rowLength + j].selectBtn();
                    spots[i * rowLength + j].setBtnValue(j + 1);
                }
            }
        }
        return trySolveTree(spots.clone());
    }

    private int[] getPossibilities(int btn, int[] values){
        ArrayList<Integer> possibilities = new ArrayList<>();
        int[] row = getRow(btn,values.clone());
        int[] col = getCol(btn,values.clone());
        for(int i = 1; i <= rowLength; i++){
            if(values[btn] == 0 && checkOccurrencesOfNum(row,i) == 0 && checkOccurrencesOfNum(col,i) == 0){
                possibilities.add(i);
            }
        }
        int[] theArray = new int[possibilities.size()];
        for(int i = 0; i < theArray.length; i++){
            theArray[i] = possibilities.get(i);
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
}
