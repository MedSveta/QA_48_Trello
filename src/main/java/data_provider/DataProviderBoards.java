package data_provider;

import dto.Board;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderBoards {
    @DataProvider
    public Board[] newBoardDP(){
        Board board1 = Board.builder().boardTitle("Polly123").build();
        Board board2 = Board.builder().boardTitle("Polly124").build();
        Board board3 = Board.builder().boardTitle("Polly125").build();
        return new Board[]{board1, board2, board3};
    }

    @DataProvider
    public Iterator<Board> newBoardDPFromFile(){
        List<Board> boardList = new ArrayList<>();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader
                    ("src/main/resources/BoardTitle4.csv"));
            String line = bufferedReader.readLine();
            while (line!= null){
                boardList.add(Board.builder().boardTitle(line).build());
                line = bufferedReader.readLine();
            }
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
        return boardList.listIterator();
    }

}
