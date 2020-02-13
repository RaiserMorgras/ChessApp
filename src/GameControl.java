public class GameControl {
    private CLIWorker cliWorker;
    private BoardModel boardModel;
    private CommandParser commandParser;
    private CommandValidation commandValidation;

    public GameControl() {
        cliWorker = new CLIWorker();
        boardModel = new BoardModel();
        commandParser = new CommandParser();
        commandValidation = new CommandValidation();

        boardModel.setup();
    }
    public void start() {

    }
}
