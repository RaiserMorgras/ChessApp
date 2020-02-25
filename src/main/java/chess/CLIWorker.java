package chess;

public class CLIWorker extends IOStreamUIWorker {
    public CLIWorker() {
        super(System.in, System.out, System.err);
    }
}
