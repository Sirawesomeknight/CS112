import java.util.ArrayList;

public class KakurasuSolver implements Solver {

    private int[] rowMatches;
    private int[] colMatches;
    private int rowLength;

    public Spot[] savedSpots;

    public KakurasuSolver(int rowLength, int[] setRows, int[] setCols){
        rowMatches = setRows;
        colMatches = setCols;
        this.rowLength = rowLength;
    }

    @Override
    public int checkConstraints(Spot[] spots) {

        int rowsDone = 0;
        int colsDone = 0;
        for (int i = 0; i < rowLength; i++) {
            int[] row = getRow(i * rowLength, getValues(spots));
            int rowTotal = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) {
                    rowTotal = rowTotal + j + 1;
                }
            }
            if (rowTotal == rowMatches[i]) {
                rowsDone++;
            } else if (rowTotal >= rowMatches[i]) {
                return 0;
            }
        }
        for(int i = 0; i < rowLength; i++) {
            int[] col = getCol(i, getValues(spots));
            int colTotal = 0;
            for (int j = 0; j < col.length; j++) {
                if (col[j] == 0) {
                    colTotal = colTotal + j + 1;
                }
            }
            if (colTotal == colMatches[i]) {
                colsDone++;
            } else if (colTotal >= colMatches[i]) {
                return 0;
            }
        }

        if(rowsDone == rowLength && colsDone == rowLength){
            return 2;
        }else{
            return 1;
        }
    }

    public boolean trySolveTree(Spot[] spots) {
        int checked = checkConstraints(spots.clone());
        if(checked == 0){
            return false;
        }else if(checked == 1){
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
            return false;
        }else{
            savedSpots = spots;
            return true;
        }
    }

    public boolean initialSolver(Spot[] spots){
        for (int i = 0; i < rowMatches.length; i++) {
            if (rowMatches[i] == 1) {
                spots[0].selectBtn();
                for(int j = 0; j < rowLength; j++){
                    spots[j].setBtnValue(-1);
                }
            }
            if(colMatches[i] == 1){
                spots[0].selectBtn();
                for(int j = 0; j < rowLength; j++){
                    spots[j * rowLength].setBtnValue(-1);
                }
            }
            if (rowMatches[i] == 2) {
                for(int j = 0; j < rowLength; j++){
                    spots[i * rowLength + j].setBtnValue(-1);
                }
                spots[1 + (rowLength * i)].selectBtn();
            }
            if (colMatches[i] == 2) {
                for(int j = 0; j < rowLength; j++){
                    spots[getRowStart(rowLength) + j].setBtnValue(-1);
                }
                spots[i + rowLength].selectBtn();
            }
            if (rowMatches[i] == 15) {
                for (int j = 0; j < rowLength; j++) {
                    spots[j + (rowLength * i)].selectBtn();
                }
            }
            if (colMatches[i] == 15) {
                for (int j = 0; j < rowLength; j++) {
                    spots[j * rowLength].selectBtn();
                }
            }
        }
        return trySolveTree(spots.clone());
}

    @Override
    public int[] getValues(Spot[] spots) {
        int[] nValues = new int[spots.length];
        for(int i = 0; i < nValues.length; i++){
            nValues[i] = spots[i].getBtnValue();
        }
        return nValues;
    }

    private int[] getProblemsInRow(int rownum, int[] values){
        ArrayList<Integer> problems = new ArrayList<>();
        int[] row = getRow(rownum * rowLength,values);
        for(int j = 0; j < row.length; j++) {
            if(row[j] > 0) {
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
            if(col[j] > 0) {
                problems.add(colnum + (col.length * j));
            }
        }
        int[] theArray = new int[problems.size()];
        for(int i = 0; i < theArray.length; i++){
            theArray[i] = problems.get(i);
        }
        return theArray;
    }

    @Override
    public Spot[] getSavedSpots() {
        return savedSpots;
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
