import java.util.ArrayList;

public interface Solver {
    int checkConstraints(Spot[] spots);
    boolean trySolveTree(Spot[] spots);
    int[] getValues(Spot[] spots);
    Spot[] getSavedSpots();
    boolean initialSolver(Spot[] spots);
}
