import java.util.ArrayList;

/**
 * Aaron Muir
 * CS 309
 * LP Project
 */

/**
 * Matrix containing an original bfs and multiple constraints
 */
public class Matrix
{

    AugRow bfs;
    AugRow auxiliary;
    ArrayList<AugRow> constraints;

    // slack count
    int slackCount;

    Matrix()
    {
        constraints = new ArrayList<AugRow>();
        int slackCount = 0;
    }

    /**
     * adds a slack variable to the specified constraint
     *
     * @param constraint a constraint that exists in the matrix
     */
    public void addSlack(AugRow constraint)
    {
        assert constraints.indexOf(constraint)!=-1:"Constraint does not exist - can't add slack var";

        slackCount++;
        // add zero to all other elements
        bfs.insertA(0.0);

        for(int i = 0; i < constraints.size();i++)
        {
            if(constraints.get(i).equals(constraint))
            {
                // insert new xi slack var to constraint
                constraints.get(i).insertA(1.0);
            }
            else
            {
                // insert zero at xi
                constraints.get(i).insertA(0.0);
            }
        }
    }

    /**
     * Return the matrix in string format
     *
     * @return string formatted matrix
     */
    public String toString()
    {
        String result = "";
        result += bfs.toString();
        result += "------------";
        for(int i=0; i < constraints.size();i++)
        {
            result += constraints.get(i).toString();
        }
        return result;
    }
}