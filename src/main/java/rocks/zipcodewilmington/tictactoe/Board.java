package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    private Character winner=' ';
    public Board(Character[][] matrix) {
        Character checker=' ';
        checker=checkRows(matrix);
        if(checker!=' ') winner=checker;
        checker=checkColumns(matrix);
        if(checker!=' ') winner=checker;
        checker = checkDiagonals(matrix);
        if(checker!=' ') winner=checker;
    }

    public Boolean isInFavorOfX() { return winner == 'X';}

    public Boolean isInFavorOfO() {
        return winner == 'O';
    }

    public Boolean isTie() {
        return winner == ' ';
    }

    public String getWinner() {
        if (winner == ' ') return "";
        return winner.toString();
    }

    public char checkColumn(Character[][] matrix,Integer colNumber){
        if(matrix[0][colNumber]==matrix[1][colNumber]&&matrix[0][colNumber]==matrix[2][colNumber]) {
            return matrix[0][colNumber];
        }
        return ' ';
    }

    public char checkRow(Character[][] matrix,Integer rowNumber) {
        if (matrix[rowNumber][0] == matrix[rowNumber][1] && matrix[rowNumber][0] == matrix[rowNumber][2]) {
            return matrix[rowNumber][0];
        }
        return ' ';
    }

    public char checkColumns(Character[][] matrix){
        char checker=' ';
        for (int i=0;i<3;i++){
            checker = checkColumn(matrix,i);
            if (checker!=' ') return checker;
        }
        return ' ';
    }

    public char checkRows(Character[][] matrix){
        char checker=' ';
        for (int i=0;i<3;i++){
            checker = checkRow(matrix,i);
            if (checker!=' ') return checker;
        }
        return ' ';
    }

    public char checkDiagonals(Character[][] matrix){
        if (matrix[1][1]==' ') return ' ';
        if((matrix[0][0]==matrix[1][1] && matrix[1][1]==matrix[2][2])||
                (matrix[0][2]==matrix[1][1] && matrix[1][1]==matrix[2][0]))
                return matrix[1][1];
        return ' ';
    }
}
